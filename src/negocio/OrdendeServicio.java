package negocio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import hbt.dao.PersistentObject;

@Entity
public class OrdendeServicio extends PersistentObject{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum est{
		Abierta, Cerrada
	}
	
	public est estado;
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Espacio espacio;
	
	public Date fechaAlta;
	public int diasVencimiento;
	
	public String anotaciones;

	@ManyToOne(cascade=CascadeType.ALL)
	public Usuario usuarioAlta;

	@ManyToOne(cascade=CascadeType.ALL)
	public Reclamo reclamo;

	@ManyToOne(cascade=CascadeType.ALL)
	public TareaTipo tareaTipo;

	@ManyToOne(cascade=CascadeType.ALL)
	public Mantenimiento mantenimiento;
	


	public OrdendeServicio(String anotaciones, TareaTipo tareaTipo) {
		super();
		this.anotaciones = anotaciones;
		this.tareaTipo = tareaTipo;
		
		estado = est.Abierta;
		fechaAlta = new Date();
		diasVencimiento = tareaTipo.getDias();
		//usuarioAlta =		
	}
	
	public OrdendeServicio() {
		super();
		estado = est.Abierta;
		fechaAlta = new Date();
		diasVencimiento = 10;// no se si depende de una tarea
	}



	public est getEstado() {
		return estado;
	}



	public void setEstado(est estado) {
		this.estado = estado;
	}



	public Espacio getEspacio() {
		return espacio;
	}



	public void setEspacio(Espacio espacio) {
		this.espacio = espacio;
	}



	public Date getFechaAlta() {
		return fechaAlta;
	}



	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}



	public int getDiasVencimiento() {
		return diasVencimiento;
	}



	public void setDiasVencimiento(int diasVencimiento) {
		this.diasVencimiento = diasVencimiento;
	}



	public String getAnotaciones() {
		return anotaciones;
	}



	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}



	public Usuario getUsuarioAlta() {
		return usuarioAlta;
	}



	public void setUsuarioAlta(Usuario usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}



	public Reclamo getReclamo() {
		return reclamo;
	}



	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
	}



	public TareaTipo getTareaTipo() {
		return tareaTipo;
	}



	public void setTareaTipo(TareaTipo tareaTipo) {
		this.tareaTipo = tareaTipo;
	}



	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}



	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}



	public void finalize() throws Throwable {

	}
}//end OrdendeServicio