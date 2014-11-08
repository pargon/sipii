package negocio;

import hbt.dao.PersistentObject;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Copa")
public class Copa extends PersistentObject{

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
	private Estado estado;
	
	
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
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public Copa(DensidadFollaje df, ColorFollaje cf, Estado estado) {
		super();
		this.df = df;
		this.cf = cf;
		this.estado = estado;
	}
	
	
}
