package negocio;

public class Calle {
	
	private int id ;
	private String nombre;
	private int alturaDesde;
	private int alturaHasta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public Calle(int id, String nombre, int alturaDesde, int alturaHasta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.alturaDesde = alturaDesde;
		this.alturaHasta = alturaHasta;
	}
	
	


}
