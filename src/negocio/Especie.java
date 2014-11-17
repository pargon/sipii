package negocio;

import hbt.dao.PersistentObject;

import javax.persistence.Entity;

@Entity
public class Especie extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreCorriente;
	private String nombreCientifico;
	public String getNombreCorriente() {
		return nombreCorriente;
	}
	public void setNombreCorriente(String nombreCorriente) {
		this.nombreCorriente = nombreCorriente;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	
	public Especie(String nombreCorriente, String nombreCientifico) {
		super();
		this.nombreCorriente = nombreCorriente;
		this.nombreCientifico = nombreCientifico;
	}
	public Especie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}