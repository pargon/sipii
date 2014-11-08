package negocio;


enum UsoSuelo{
	comercial,residencial, industrial, baldio
}

enum TipoEdificacion{
	baldio,alta,media,baja
}

public class Cuadra {
	
	private int id ;
	private Calle calle;
	private int alturaDesde;
	private int alturaHasta;
	private float anchoVereda;
	private UsoSuelo usoSuelo;
	private TipoEdificacion tipoedif;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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

	
	
	public Cuadra(int id, Calle calle, int alturaDesde, int alturaHasta,
			float anchoVereda, UsoSuelo usoSuelo, TipoEdificacion tipoedif) {
		super();
		this.id = id;
		this.calle = calle;
		this.alturaDesde = alturaDesde;
		this.alturaHasta = alturaHasta;
		this.anchoVereda = anchoVereda;
		this.usoSuelo = usoSuelo;
		this.tipoedif = tipoedif;
	}
	
	
}
