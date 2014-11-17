package negocio;

import hbt.dao.PersistentObject;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Cuadra extends PersistentObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public enum UsoSuelo{
		comercial,residencial, industrial, baldio
	}

	public enum TipoEdificacion{
		baldio,alta,media,baja
	}
	

	@ManyToOne(cascade=CascadeType.ALL)
	private Calle calle;
	
	private int alturaDesde;
	private int alturaHasta;
	private float anchoVereda;
	private UsoSuelo usoSuelo;
	private TipoEdificacion tipoedif;
	
	public Calle getCalle() {
		return calle;
	}
	public void setCalle(Calle calle) {
		this.calle = calle;
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
	public float getAnchoVereda() {
		return anchoVereda;
	}
	public void setAnchoVereda(float anchoVereda) {
		this.anchoVereda = anchoVereda;
	}
	public UsoSuelo getUsoSuelo() {
		return usoSuelo;
	}
	public void setUsoSuelo(UsoSuelo usoSuelo) {
		this.usoSuelo = usoSuelo;
	}
	public TipoEdificacion getTipoedif() {
		return tipoedif;
	}
	public void setTipoedif(TipoEdificacion tipoedif) {
		this.tipoedif = tipoedif;
	}

	
	
	public Cuadra(Calle calle, int alturaDesde, int alturaHasta,
			float anchoVereda, UsoSuelo usoSuelo, TipoEdificacion tipoedif) {
		super();
		this.calle = calle;
		this.alturaDesde = alturaDesde;
		this.alturaHasta = alturaHasta;
		this.anchoVereda = anchoVereda;
		this.usoSuelo = usoSuelo;
		this.tipoedif = tipoedif;
	}
	public Cuadra() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
