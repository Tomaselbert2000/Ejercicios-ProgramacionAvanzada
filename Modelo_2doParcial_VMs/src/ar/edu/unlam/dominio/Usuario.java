package ar.edu.unlam.dominio;

import java.util.Objects;

public class Usuario implements Comparable<Usuario>{
	
	private Integer dni;
	private String correoUsuario;
	private String password;

	public Usuario(Integer dniUsuario, String correoUsuario, String password) {
		this.dni = dniUsuario;
		this.correoUsuario = correoUsuario;
		this.password = password;
	}
	
	public Integer getDni() {
		return this.dni;
	}
	
	public String getCorreo() {
		return this.correoUsuario;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(correoUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(correoUsuario, other.correoUsuario);
	}

	@Override
	public int compareTo(Usuario o) {
		return this.correoUsuario.compareTo(o.correoUsuario);
	}
}
