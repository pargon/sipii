package negocio;

import java.io.Serializable;

import hbt.dao.PersistentObject;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Copa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public enum DensidadFollaje{
		Normal, Anormal
	}

	public enum ColorFollaje{
		Normal, Anormal
	}
	
	public enum Estado{
		Equilibrada, Descopada,Brotada
	}

	
	private DensidadFollaje df;
	private ColorFollaje cf;
	private Estado cp_estado;
	
	
	public DensidadFollaje getDf() {
		return df;
	}
	public void setDf(DensidadFollaje df) {
		this.df = df;
	}
	public ColorFollaje getCf() {
		return cf;
	}
	public void setCf(ColorFollaje cf) {
		this.cf = cf;
	}
	public Estado getEstado() {
		return cp_estado;
	}
	public void setEstado(Estado estado) {
		this.cp_estado = estado;
	}
	
	
	public Copa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Copa(DensidadFollaje df, ColorFollaje cf, Estado estado) {
		super();
		this.df = df;
		this.cf = cf;
		this.cp_estado = estado;
	}
	
	
}
