package negocio;


import hbt.dao.PersistentObject;
import javax.persistence.Entity;
import javax.persistence.Table;

enum CavidadBasal{
	No, Chica, Mediana, Grande
}
enum CavidadMedia{
	No, Chica, Mediana, Grande
}
enum CavidadAlta{
	No, Chica, Mediana, Grande
}
enum Destrucciones{
	Clavaduras, Quemaduras, Agujeros, Anillos
}

enum Interferencia{
	Cordon, Cantera, Vereda
}


@Entity
@Table(name="Tronco")
public class Tronco extends PersistentObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CavidadBasal cb;
	private CavidadMedia cm;
	private CavidadAlta ca;
	private boolean codominancia;
	private boolean abultamientos;
	private boolean desgarrado;
	private boolean descortezamiento;
	private boolean rajaduras;
	private boolean fructificaciones;
	private boolean chorreados;
	private boolean enredadera;
	private Destrucciones dest;
	private Interferencia interf;
	
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
		return codominancia;
	}
	public void setCodominancia(boolean codominancia) {
		this.codominancia = codominancia;
	}
	public boolean isAbultamientos() {
		return abultamientos;
	}
	public void setAbultamientos(boolean abultamientos) {
		this.abultamientos = abultamientos;
	}
	public boolean isDesgarrado() {
		return desgarrado;
	}
	public void setDesgarrado(boolean desgarrado) {
		this.desgarrado = desgarrado;
	}
	public boolean isDescortezamiento() {
		return descortezamiento;
	}
	public void setDescortezamiento(boolean descortezamiento) {
		this.descortezamiento = descortezamiento;
	}
	public boolean isRajaduras() {
		return rajaduras;
	}
	public void setRajaduras(boolean rajaduras) {
		this.rajaduras = rajaduras;
	}
	public boolean isFructificaciones() {
		return fructificaciones;
	}
	public void setFructificaciones(boolean fructificaciones) {
		this.fructificaciones = fructificaciones;
	}
	public boolean isChorreados() {
		return chorreados;
	}
	public void setChorreados(boolean chorreados) {
		this.chorreados = chorreados;
	}
	public boolean isEnredadera() {
		return enredadera;
	}
	public void setEnredadera(boolean enredadera) {
		this.enredadera = enredadera;
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
	
	public Tronco(CavidadBasal cb, CavidadMedia cm, CavidadAlta ca,
			boolean codominancia, boolean abultamientos, boolean desgarrado,
			boolean descortezamiento, boolean rajaduras,
			boolean fructificaciones, boolean chorreados, boolean enredadera,
			Destrucciones dest, Interferencia interf) {
		super();
		this.cb = cb;
		this.cm = cm;
		this.ca = ca;
		this.codominancia = codominancia;
		this.abultamientos = abultamientos;
		this.desgarrado = desgarrado;
		this.descortezamiento = descortezamiento;
		this.rajaduras = rajaduras;
		this.fructificaciones = fructificaciones;
		this.chorreados = chorreados;
		this.enredadera = enredadera;
		this.dest = dest;
		this.interf = interf;
	}
	
}
