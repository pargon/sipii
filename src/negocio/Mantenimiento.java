package negocio;

import hbt.dao.PersistentObject;

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
	
	
}
