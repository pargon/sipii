package ppal;

enum DensidadFollaje{
	Normal, Anormal
}

enum ColorFollaje{
	Normal, Anormal
}
enum Estado{
	Equilibrada, Descopada,Brotada
}

public class Copa {
	
	private DensidadFollaje df;
	private ColorFollaje cf;
	private Estado estado;
	
	
	public DensidadFollaje getDf() {
		return df;
	}
	public void setDf(DensidadFollaje df) {
		this.df = df;
	}
	public ColorFollaje getCf() {
		return cf;
	}
	public void setCf(ColorFollaje cf) {
		this.cf = cf;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public Copa(DensidadFollaje df, ColorFollaje cf, Estado estado) {
		super();
		this.df = df;
		this.cf = cf;
		this.estado = estado;
	}
	
	
}
