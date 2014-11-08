package ppal;


public class Especie {

	private int id;
	private String nombreCorriente;
	private String nombreCientifico;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCorriente() {
		return nombreCorriente;
	}
	public void setNombreCorriente(String nombreCorriente) {
		this.nombreCorriente = nombreCorriente;
	}
	public String getNombreCientifico() {
		return nombreCientifico;
	}
	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}
	
	public Especie(int id, String nombreCorriente, String nombreCientifico) {
		super();
		this.id = id;
		this.nombreCorriente = nombreCorriente;
		this.nombreCientifico = nombreCientifico;
	}
	
}