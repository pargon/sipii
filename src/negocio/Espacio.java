package negocio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import hbt.dao.PersistentObject;

@Entity
public class Espacio extends PersistentObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TipoCatastral{
		Normal, Descendente, Ascendente
	}

	public enum Tipo{
		Arbol, CanteraVacia, Arbusto, CanteraPotencial
	}

	
	private String chapaCatastral;
	private TipoCatastral tipoCat;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Cuadra cuadra;
	
	private String latitud;
	private String longitud;
	private float anchoPlantera;
	private float largoPlantera;
	private Tipo tipo;
	private boolean canteroElevado;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Arbol arbol;
	
	
	public String getChapaCatastral() {
		return chapaCatastral;
	}
	public void setChapaCatastral(String chapaCatastral) {
		this.chapaCatastral = chapaCatastral;
	}
	public TipoCatastral getTipoCat() {
		return tipoCat;
	}
	public void setTipoCat(TipoCatastral tipoCat) {
		this.tipoCat = tipoCat;
	}
	public Cuadra getCuadra() {
		return cuadra;
	}
	public void setCuadra(Cuadra cuadra) {
		this.cuadra = cuadra;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public float getAnchoPlantera() {
		return anchoPlantera;
	}
	public void setAnchoPlantera(float anchoPlantera) {
		this.anchoPlantera = anchoPlantera;
	}
	public float getLargoPlantera() {
		return largoPlantera;
	}
	public void setLargoPlantera(float largoPlantera) {
		this.largoPlantera = largoPlantera;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public boolean isCanteroElevado() {
		return canteroElevado;
	}
	public void setCanteroElevado(boolean canteroElevado) {
		this.canteroElevado = canteroElevado;
	}
	public Arbol getArbol() {
		return arbol;
	}
	public void setArbol(Arbol arbol) {
		this.arbol = arbol;
	}
	
	public Espacio(String chapaCatastral, TipoCatastral tipoCat,
			Cuadra cuadra, String latitud, String longitud,
			float anchoPlantera, float largoPlantera, Tipo tipo,
			boolean canteroElevado, Arbol arbol) {
		super();
		
		this.chapaCatastral = chapaCatastral;
		this.tipoCat = tipoCat;
		this.cuadra = cuadra;
		this.latitud = latitud;
		this.longitud = longitud;
		this.anchoPlantera = anchoPlantera;
		this.largoPlantera = largoPlantera;
		this.tipo = tipo;
		this.canteroElevado = canteroElevado;
		this.arbol = arbol;
	}
	
	
	
	
	
}