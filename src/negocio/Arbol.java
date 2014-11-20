package negocio;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import hbt.dao.PersistentObject;


@Entity
public class Arbol extends PersistentObject{
	
	public enum Inclinacion{
		NA, mas45, menos45
	}

	public enum Orientacion{
		NA, mas45, menos45
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Especie especie;
	
	@Embedded
	private Copa copa;
	
	@Embedded
	private Tronco tronco;
	
	@Embedded
	private Rama rama;
	
	private boolean seco;
	private String altura; 
	private int estado;
	private float perimetro;
	private Inclinacion incl;
	private Orientacion orient;
	
	
	public Especie getEspecie() {
		return especie;
	}
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	public Copa getCopa() {
		return copa;
	}
	public void setCopa(Copa copa) {
		this.copa = copa;
	}
	public Tronco getTronco() {
		return tronco;
	}
	public void setTronco(Tronco tronco) {
		this.tronco = tronco;
	}
	public Rama getRama() {
		return rama;
	}
	public void setRama(Rama rama) {
		this.rama = rama;
	}
	public boolean isSeco() {
		return seco;
	}
	public void setSeco(boolean seco) {
		this.seco = seco;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public float getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(float perimetro) {
		this.perimetro = perimetro;
	}
	public Inclinacion getIncl() {
		return incl;
	}
	public void setIncl(Inclinacion incl) {
		this.incl = incl;
	}
	public Orientacion getOrient() {
		return orient;
	}
	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}
	
	public Arbol(Especie especie, Copa copa, Tronco tronco, Rama rama,
			boolean seco, String altura, int estado, float perimetro,
			Inclinacion incl, Orientacion orient) {
		super();
		this.especie = especie;
		this.copa = copa;
		this.tronco = tronco;
		this.rama = rama;
		this.seco = seco;
		this.altura = altura;
		this.estado = estado;
		this.perimetro = perimetro;
		this.incl = incl;
		this.orient = orient;
	}
	public Arbol() {
		especie = new Especie();
		copa = new Copa();
		tronco = new Tronco();
		rama = new Rama();
	}
	

}
