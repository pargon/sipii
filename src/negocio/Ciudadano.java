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
	
	
}
