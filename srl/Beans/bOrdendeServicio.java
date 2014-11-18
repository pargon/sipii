package Beans;

import java.util.Date;

public class bOrdendeServicio {

	private int id;
	private String anot;
	private String estado;
	private String calle;
	private String chapa;
	private Date fecha;
	private String tarea;
	private String mant;
	
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnot() {
		return anot;
	}
	public void setAnot(String anot) {
		this.anot = anot;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMant() {
		return mant;
	}
	public void setMant(String mant) {
		this.mant = mant;
	}
	
	public bOrdendeServicio(int id, String anot, String estado, String calle,
			String chapa, Date fecha, String tarea, String mant) {
		super();
		this.id = id;
		this.anot = anot;
		this.estado = estado;
		this.calle = calle;
		this.chapa = chapa;
		this.fecha = fecha;
		this.tarea = tarea;
		this.mant = mant;
	}
	
	
	
}
