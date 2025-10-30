package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import ar.edu.unlam.comparators.ComparadorCostosTotales;
import ar.edu.unlam.dominio.abstractClasses.VirtualMachine;
import ar.edu.unlam.exceptions.CantidadDeEscriturasSuperadaException;
import ar.edu.unlam.exceptions.CantidadDeHorasDeUsoExcedidaException;
import ar.edu.unlam.exceptions.CantidadLecturasSuperadaException;
import ar.edu.unlam.exceptions.UsuarioDuplicadoException;
import ar.edu.unlam.subClasses.VMAlmacenamientoDeImagenes;
import ar.edu.unlam.subClasses.VMBaseDeDatos;

public class GestionSistema {

	private HashSet<Usuario> hashSetUsuarios;
	private HashSet<VirtualMachine> hashSetVMs;
	
	public GestionSistema() {
		this.hashSetUsuarios = new HashSet<>();
		this.hashSetVMs = new HashSet<>();
	}

	public Boolean registrarNuevoUsuario(Usuario nuevoUsuario) throws UsuarioDuplicadoException{
		if(!this.hashSetUsuarios.contains(nuevoUsuario)) {
			return this.hashSetUsuarios.add(nuevoUsuario);
		}else {
			throw new UsuarioDuplicadoException();
		}
	}

	public Boolean registrarNuevaVirtualMachine(VirtualMachine nuevaVirtualMachine) {
		return this.usuarioAsociadoRegistrado(nuevaVirtualMachine) && this.hashSetVMs.add(nuevaVirtualMachine);
	}

	private Boolean usuarioAsociadoRegistrado(VirtualMachine nuevaVirtualMachine) {
		for(Usuario usr : this.hashSetUsuarios) {
			if(usr.getDni().equals(nuevaVirtualMachine.getDniUsuarioAsociado())) {
				return true;
			}
		}
		return false;
	}

	public void registrarHorasEnVM(VMBaseDeDatos vmBD, Double cantidadDeHorasQueUseLaVM) throws CantidadDeHorasDeUsoExcedidaException{
		if(this.hashSetVMs.contains(vmBD) && vmBD.getHorasRestanteHastaLimite() >= cantidadDeHorasQueUseLaVM) {
				vmBD.registrarHorasDeUso(cantidadDeHorasQueUseLaVM);
		}else {
			throw new CantidadDeHorasDeUsoExcedidaException();
		}
	}

	public void registrarGBsEnVM(VMBaseDeDatos vmBD, Double gbUsados) {
		if(this.hashSetVMs.contains(vmBD)) {
			vmBD.usarAlmacenamiento(gbUsados);
		}
	}

	public Double obtenerCostoExtraDeLaVM(Integer id) {
		for(VirtualMachine vm : this.hashSetVMs) {
			if(vm instanceof VMBaseDeDatos) {
				if(vm.getId().equals(id)) {
					return ((VMBaseDeDatos) vm).obtenerCostosExtra();
				}
			}else if(vm instanceof VMAlmacenamientoDeImagenes) {
				if(vm.getId().equals(id)) {
					return ((VMAlmacenamientoDeImagenes) vm).obtenerCostosExtra();
				}
			}
		}
		return 0.0;
	}

	public void registrarEscriturasEnVM(VMAlmacenamientoDeImagenes vmImg, Integer operacionesDeEscrituraRealizadas) throws CantidadDeEscriturasSuperadaException {
		if(this.hashSetVMs.contains(vmImg) && vmImg.obtenerEscriturasRestantes() >= operacionesDeEscrituraRealizadas) {
			vmImg.registrarOperacionesDeEscritura(operacionesDeEscrituraRealizadas);
		}else {
			throw new CantidadDeEscriturasSuperadaException();
		}
	}

	public void registrarLecturasEnVM(VMAlmacenamientoDeImagenes vmImg, Integer operacionesDeLecturaRealizadas) throws CantidadLecturasSuperadaException {
		if(this.hashSetVMs.contains(vmImg) && vmImg.obtenerLecturasRestantes() >= operacionesDeLecturaRealizadas) {
			vmImg.registrarOperacionesDeLectura(operacionesDeLecturaRealizadas);
		}else {
			throw new CantidadLecturasSuperadaException();
		}
	}

	public TreeMap<Usuario, TreeSet<Double>> reporteCostosOrdenados() {
		TreeMap<Usuario, TreeSet<Double>> reporteCostos = new TreeMap<>();
		for(Usuario usr : this.hashSetUsuarios) {
			TreeSet<Double> coleccionCostosTotalesDeUsr = new TreeSet<>(new ComparadorCostosTotales());
			for(VirtualMachine vm : this.hashSetVMs) {
				if(vm instanceof VMBaseDeDatos && usr.getDni().equals(vm.getDniUsuarioAsociado())) {
					coleccionCostosTotalesDeUsr.add(((VMBaseDeDatos) vm).obtenerCostosExtra());
				}else if(vm instanceof VMAlmacenamientoDeImagenes && usr.getDni().equals(vm.getDniUsuarioAsociado())) {
					coleccionCostosTotalesDeUsr.add(((VMAlmacenamientoDeImagenes) vm).obtenerCostosExtra());
				}
			}
			reporteCostos.put(usr, coleccionCostosTotalesDeUsr);
		}
		return reporteCostos;
	}
}