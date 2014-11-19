package Beans;

public class bEspacio {

	private int id;
	private String tipo;
	private String calle;
	private String chapa;
	private String estado;
	public bEspacio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bEspacio(int id, String tipo, String calle, String chapa,
			String estado) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.calle = calle;
		this.chapa = chapa;
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getChapa() {
		return chapa;
	}
	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
