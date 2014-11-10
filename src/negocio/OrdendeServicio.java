package negocio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import hbt.dao.PersistentObject;

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



	public Reclamo getReclamo() {
		return reclamo;
	}



	public void setReclamo(Reclamo reclamo) {
		this.reclamo = reclamo;
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