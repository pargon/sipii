package negocio;

import javax.persistence.Entity;

import hbt.dao.PersistentObject;

@Entity
public class Mantenimiento extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String RazonSocial;
	
	public Mantenimiento(String razonSocial) {
		super();
		RazonSocial = razonSocial;
	}

	public Mantenimiento() {
		// TODO Auto-generated constructor stub
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	
	
}
