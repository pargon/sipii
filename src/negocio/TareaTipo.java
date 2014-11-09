package negocio;

import hbt.dao.PersistentObject;

public class TareaTipo extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String desc;
	private int dias;
	
	public TareaTipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	
}
