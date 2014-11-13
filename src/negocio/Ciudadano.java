package negocio;

import javax.persistence.Entity;

import hbt.dao.PersistentObject;

@Entity
public class Ciudadano extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
	private String dni;
	
	
	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(String nombre, String apellido, String direccion,
			String telefono, String email, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
}
