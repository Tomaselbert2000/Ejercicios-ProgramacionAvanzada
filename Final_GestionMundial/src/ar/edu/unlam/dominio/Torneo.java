package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import ar.edu.unlam.enums.LetraGrupo;
import ar.edu.unlam.enums.NombreSeleccion;
import ar.edu.unlam.enums.ResultadoPartidoEnum;
import ar.edu.unlam.exceptions.EquipoDuplicadoException;
import ar.edu.unlam.exceptions.PartidoJugadoException;

public class Torneo {

	private ArrayList<Grupo> listaDeGrupos;
	private ArrayList<Equipo> listaDeEquiposParticipantes;
	private HashSet<Partido> listaPartidos;
	private HashSet<ResultadoPartido> listaResultados;

	public Torneo() {
		// dentro del constructor de la clase de gestion inicializamos todos los objetos
		// necesarios
		this.listaDeEquiposParticipantes = new ArrayList<>();
		this.listaDeGrupos = new ArrayList<>();
		this.listaPartidos = new HashSet<>();
		this.listaResultados = new HashSet<>();
		// llamamos a los metodos y cargamos las instancias de grupos y equipos
		inicializarEquipos(); // se crean los equipos
		crearGrupos(); // creamos los grupos vacios
		sortearGrupo(); // para cada grupo cargamos 4 equipos al azar
	}

	private void sortearGrupo() {
		@SuppressWarnings("unchecked")
		ArrayList<Equipo> listaAuxiliar = (ArrayList<Equipo>) this.listaDeEquiposParticipantes.clone(); // creamos una
																										// instancia
																										// auxiliar de
																										// la lista para
																										// trabajar
		for (Grupo grupo : this.listaDeGrupos) { // iteramos los grupos
			int i = 0;
			while (i < 4) { // abrimos un while que cicle sobre los cuatro posibles equipos del grupo
				Equipo equipoParaSortear = this.equipoAlAzar(listaAuxiliar); // le pasamos nuestra lista auxiliar al
																				// metodo que elige un equipo al azar
				if (!grupo.getEquipos().contains(equipoParaSortear) && listaAuxiliar.contains(equipoParaSortear)) { // si
																													// el
																													// equipo
																													// no
																													// se
																													// uso
																													// en
																													// ningun
																													// grupo
																													// y
																													// se
																													// encuentra
																													// en
																													// la
																													// lista,
																													// se
																													// agrega
					grupo.agregarEquipo(equipoParaSortear); // en esta linea lo añadimos
					listaAuxiliar.remove(equipoParaSortear); // y lo eliminamos de la lista auxiliar, de modo que en la
																// proxima pasada el metodo que elige el equipo al azar
																// no lo toma en cuenta
					i++;
				} else {
					continue;
				}
			}
		}
	}

	private Equipo equipoAlAzar(ArrayList<Equipo> listaAuxiliar) {
		Random random = new Random();
		return listaAuxiliar.get(random.nextInt(listaAuxiliar.size()));
	}

	private void inicializarEquipos() {
		for (NombreSeleccion seleccion : NombreSeleccion.values()) { // se itera sobre los enums con los nombres de las
																		// selecciones participantes
			this.listaDeEquiposParticipantes.add(new Equipo(seleccion)); // para cada nombre creamos un nuevo equipo con
																			// ese nombre asignado
		}
	}

	private void crearGrupos() {
		for (LetraGrupo letra : LetraGrupo.values()) { // iteramos sobre cada letra de grupo del enum
			this.listaDeGrupos.add(new Grupo(letra)); // y creamos un grupo por cada una de ellas
		}
	}

	public Integer getCantidadEquiposActual() {
		return this.listaDeEquiposParticipantes.size();
	}

	public Integer getCantidadGruposActual() {
		return this.listaDeGrupos.size();
	}

	public Grupo getGrupoPorLetra(LetraGrupo grupoBuscado) {
		for (Grupo grupo : this.listaDeGrupos) {
			if (grupo.getLetra().equals(grupoBuscado)) {
				return grupo;
			}
		}
		return null;
	}

	public Boolean registrarPartido(Partido nuevoPartido) throws EquipoDuplicadoException, PartidoJugadoException {
		if (this.listaPartidos.contains(nuevoPartido)) {
			throw new PartidoJugadoException();
		} else if (nuevoPartido.getEquipoLocal().equals(nuevoPartido.getEquipoVisitante())) {
			throw new EquipoDuplicadoException();
		} else {
			return this.listaPartidos.add(nuevoPartido);
		}
	}

	public Boolean registrarResultado(ResultadoPartido resultado) {
		this.actualizarPuntajes(resultado);
		this.actualizarGolesAFavorYenContra(resultado);
		return this.listaResultados.add(resultado);
	}

	private void actualizarGolesAFavorYenContra(ResultadoPartido resultado) {
		Partido partidoAsociadoAlResultado = this.obtenerPartido(resultado.getId());
		Equipo local = partidoAsociadoAlResultado.getEquipoLocal();
		Equipo visitante = partidoAsociadoAlResultado.getEquipoVisitante();
		local.actualizarGolesAfavorYenContra(resultado.getGolesAnotadosLocal(), resultado.getGolesAnotadosVisitante());
		visitante.actualizarGolesAfavorYenContra(resultado.getGolesAnotadosVisitante(),
				resultado.getGolesAnotadosLocal());
	}

	private void actualizarPuntajes(ResultadoPartido resultado) {
		Partido partidoAsociadoAlResultado = this.obtenerPartido(resultado.getId());
		if (resultado.getPenalesConvertidosLocal() == null && resultado.getPenalesConvertidosVisitante() == null) {
			if (resultado.getResultado().equals(ResultadoPartidoEnum.GANA_LOCAL)) {
				partidoAsociadoAlResultado.getEquipoLocal().sumarVictoria();
			} else if (resultado.getResultado().equals(ResultadoPartidoEnum.GANA_VISITANTE)) {
				partidoAsociadoAlResultado.getEquipoVisitante().sumarVictoria();
			} else {
				partidoAsociadoAlResultado.getEquipoLocal().sumarEmpate();
				partidoAsociadoAlResultado.getEquipoVisitante().sumarEmpate();
			}
		} else {

		}
	}

	private Partido obtenerPartido(Integer id) {
		for (Partido partido : this.listaPartidos) {
			if (partido.getId().equals(id)) {
				return partido;
			}
		}
		return null;
	}

	public ResultadoPartidoEnum obtenerResultadoPartido(Integer idBuscado) {
		for (ResultadoPartido resultado : this.listaResultados) {
			if (resultado.getId().equals(idBuscado)) {
				return resultado.getResultado();
			}
		}
		return null;
	}
}
