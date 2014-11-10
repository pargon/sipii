package negocio;

import javax.persistence.Entity;

import hbt.dao.PersistentObject;

@Entity
public class Calle extends PersistentObject{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int alturaDesde;
	private int alturaHasta;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAlturaDesde() {
		return alturaDesde;
	}
	public void setAlturaDesde(int alturaDesde) {
		this.alturaDesde = alturaDesde;
	}
	public int getAlturaHasta() {
		return alturaHasta;
	}
	public void setAlturaHasta(int alturaHasta) {
		this.alturaHasta = alturaHasta;
	}
	
	public Calle(String nombre, int alturaDesde, int alturaHasta) {
		super();
		
		this.nombre = nombre;
		this.alturaDesde = alturaDesde;
		this.alturaHasta = alturaHasta;
	}
	
	


}
