package negocio;


import java.io.Serializable;

import hbt.dao.PersistentObject;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Embeddable
public class Tronco implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public enum CavidadBasal{
	No, Chica, Mediana, Grande
}
public enum CavidadMedia{
	No, Chica, Mediana, Grande
}
public enum CavidadAlta{
	No, Chica, Mediana, Grande
}
public enum Destrucciones{
	Clavaduras, Quemaduras, Agujeros, Anillos
}
public enum Interferencia{
	Cordon, Cantera, Vereda
}
	
	private CavidadBasal cb;
	private CavidadMedia cm;
	private CavidadAlta ca;
	private boolean tr_codominancia;
	private boolean tr_abultamientos;
	private boolean tr_desgarrado;
	private boolean tr_descortezamiento;
	private boolean tr_rajaduras;
	private boolean tr_fructificaciones;
	private boolean tr_chorreados;
	private boolean tr_enredadera;
	private Destrucciones tr_dest;
	private Interferencia tr_interf;
	
	public CavidadBasal getCb() {
		return cb;
	}
	public void setCb(CavidadBasal cb) {
		this.cb = cb;
	}
	public CavidadMedia getCm() {
		return cm;
	}
	public void setCm(CavidadMedia cm) {
		this.cm = cm;
	}
	public CavidadAlta getCa() {
		return ca;
	}
	public void setCa(CavidadAlta ca) {
		this.ca = ca;
	}
	public boolean isCodominancia() {
		return tr_codominancia;
	}
	public void setCodominancia(boolean codominancia) {
		this.tr_codominancia = codominancia;
	}
	public boolean isAbultamientos() {
		return tr_abultamientos;
	}
	public void setAbultamientos(boolean abultamientos) {
		this.tr_abultamientos = abultamientos;
	}
	public boolean isDesgarrado() {
		return tr_desgarrado;
	}
	public void setDesgarrado(boolean desgarrado) {
		this.tr_desgarrado = desgarrado;
	}
	public boolean isDescortezamiento() {
		return tr_descortezamiento;
	}
	public void setDescortezamiento(boolean descortezamiento) {
		this.tr_descortezamiento = descortezamiento;
	}
	public boolean isRajaduras() {
		return tr_rajaduras;
	}
	public void setRajaduras(boolean rajaduras) {
		this.tr_rajaduras = rajaduras;
	}
	public boolean isFructificaciones() {
		return tr_fructificaciones;
	}
	public void setFructificaciones(boolean fructificaciones) {
		this.tr_fructificaciones = fructificaciones;
	}
	public boolean isChorreados() {
		return tr_chorreados;
	}
	public void setChorreados(boolean chorreados) {
		this.tr_chorreados = chorreados;
	}
	public boolean isEnredadera() {
		return tr_enredadera;
	}
	public void setEnredadera(boolean enredadera) {
		this.tr_enredadera = enredadera;
	}
	public Destrucciones getDest() {
		return tr_dest;
	}
	public void setDest(Destrucciones dest) {
		this.tr_dest = dest;
	}
	public Interferencia getInterf() {
		return tr_interf;
	}
	public void setInterf(Interferencia interf) {
		this.tr_interf = interf;
	}
	
	public Tronco() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tronco(CavidadBasal cb, CavidadMedia cm, CavidadAlta ca,
			boolean tr_codominancia, boolean tr_abultamientos,
			boolean tr_desgarrado, boolean tr_descortezamiento,
			boolean tr_rajaduras, boolean tr_fructificaciones,
			boolean tr_chorreados, boolean tr_enredadera,
			Destrucciones tr_dest, Interferencia tr_interf) {
		super();
		this.cb = cb;
		this.cm = cm;
		this.ca = ca;
		this.tr_codominancia = tr_codominancia;
		this.tr_abultamientos = tr_abultamientos;
		this.tr_desgarrado = tr_desgarrado;
		this.tr_descortezamiento = tr_descortezamiento;
		this.tr_rajaduras = tr_rajaduras;
		this.tr_fructificaciones = tr_fructificaciones;
		this.tr_chorreados = tr_chorreados;
		this.tr_enredadera = tr_enredadera;
		this.tr_dest = tr_dest;
		this.tr_interf = tr_interf;
	}
	
}
