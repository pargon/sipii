package negocio;

import javax.persistence.Entity;

import hbt.dao.PersistentObject;

@Entity
public class TareaTipo extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descripcion;
	private int dias;
	
	public TareaTipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TareaTipo(String desc, int dias) {
		super();
		this.descripcion = desc;
		this.dias = dias;
	}

	public String getDesc() {
		return descripcion;
	}

	public void setDesc(String desc) {
		this.descripcion = desc;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}
	
	
	
}
