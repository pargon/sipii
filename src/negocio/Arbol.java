package negocio;

enum Inclinacion{
	
}

enum Orientacion{
	
}

public class Arbol {
	
	private int id;
	private Especie especie;
	private Copa copa;
	private Tronco tronco;
	private Rama rama;
	private boolean seco;
	private char altura; 
	private int estado;
	private float perimetro;
	private Inclinacion incl;
	private Orientacion orient;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public char getAltura() {
		return altura;
	}
	public void setAltura(char altura) {
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
	
	public Arbol(int id, Especie especie, Copa copa, Tronco tronco, Rama rama,
			boolean seco, char altura, int estado, float perimetro,
			Inclinacion incl, Orientacion orient) {
		super();
		this.id = id;
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
	

}
