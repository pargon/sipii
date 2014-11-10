package negocio;

import java.io.Serializable;

import hbt.dao.PersistentObject;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Rama implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum Destrucciones{
		Clavaduras, Quemaduras, Agujeros, Anillos
	}
	public enum Interferencia{
		Cordon, Cantera, Vereda
	}
	
	private boolean corteza;
	private boolean cruzadas;
	private boolean malInsertadas;
	private boolean secas;
	private boolean muerteRegresiva;
	private boolean fisuradas;
	private boolean cavidades;
	private boolean excesivas;
	private boolean bajas;
	private boolean epifitas;
	private boolean fructificaciones;
	private boolean tocones;	
	private Destrucciones dest;
	private Interferencia interf;
	
	public boolean isCorteza() {
		return corteza;
	}
	public void setCorteza(boolean corteza) {
		this.corteza = corteza;
	}
	public boolean isCruzadas() {
		return cruzadas;
	}
	public void setCruzadas(boolean cruzadas) {
		this.cruzadas = cruzadas;
	}
	public boolean isMalInsertadas() {
		return malInsertadas;
	}
	public void setMalInsertadas(boolean malInsertadas) {
		this.malInsertadas = malInsertadas;
	}
	public boolean isSecas() {
		return secas;
	}
	public void setSecas(boolean secas) {
		this.secas = secas;
	}
	public boolean isMuerteRegresiva() {
		return muerteRegresiva;
	}
	public void setMuerteRegresiva(boolean muerteRegresiva) {
		this.muerteRegresiva = muerteRegresiva;
	}
	public boolean isFisuradas() {
		return fisuradas;
	}
	public void setFisuradas(boolean fisuradas) {
		this.fisuradas = fisuradas;
	}
	public boolean isCavidades() {
		return cavidades;
	}
	public void setCavidades(boolean cavidades) {
		this.cavidades = cavidades;
	}
	public boolean isExcesivas() {
		return excesivas;
	}
	public void setExcesivas(boolean excesivas) {
		this.excesivas = excesivas;
	}
	public boolean isBajas() {
		return bajas;
	}
	public void setBajas(boolean bajas) {
		this.bajas = bajas;
	}
	public boolean isEpifitas() {
		return epifitas;
	}
	public void setEpifitas(boolean epifitas) {
		this.epifitas = epifitas;
	}
	public boolean isFructificaciones() {
		return fructificaciones;
	}
	public void setFructificaciones(boolean fructificaciones) {
		this.fructificaciones = fructificaciones;
	}
	public boolean isTocones() {
		return tocones;
	}
	public void setTocones(boolean tocones) {
		this.tocones = tocones;
	}
	public Destrucciones getDest() {
		return dest;
	}
	public void setDest(Destrucciones dest) {
		this.dest = dest;
	}
	public Interferencia getInterf() {
		return interf;
	}
	public void setInterf(Interferencia interf) {
		this.interf = interf;
	}
	
	
	public Rama() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rama(boolean corteza, boolean cruzadas, boolean malInsertadas,
			boolean secas, boolean muerteRegresiva, boolean fisuradas,
			boolean cavidades, boolean excesivas, boolean bajas,
			boolean epifitas, boolean fructificaciones, boolean tocones,
			Destrucciones dest, Interferencia interf) {
		super();
		this.corteza = corteza;
		this.cruzadas = cruzadas;
		this.malInsertadas = malInsertadas;
		this.secas = secas;
		this.muerteRegresiva = muerteRegresiva;
		this.fisuradas = fisuradas;
		this.cavidades = cavidades;
		this.excesivas = excesivas;
		this.bajas = bajas;
		this.epifitas = epifitas;
		this.fructificaciones = fructificaciones;
		this.tocones = tocones;
		this.dest = dest;
		this.interf = interf;
	}

	
}
