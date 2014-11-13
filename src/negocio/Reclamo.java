package negocio;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

import hbt.dao.HibernateDAO;
import hbt.dao.PersistentObject;

@Entity
public class Reclamo extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum est{abierto, cerrado}
	

	@ManyToOne(cascade=CascadeType.ALL)
	private Ciudadano ciudadano;
	private String Descripcion;
	private Date m_Fecha;

	@OneToOne(cascade=CascadeType.ALL)
	private OrdendeServicio m_OrdendeServicio;
	
	private est Estado;

	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario tecnico;
	private int diasVto;
	
	
	public Reclamo(Ciudadano ciu, String desc){
		ciudadano = ciu;
		Descripcion = desc;
		Estado = est.abierto;
	}

	public Reclamo() {
		// TODO Auto-generated constructor stub
	}

	public void cerrarReclamo(){
		Estado = est.cerrado;
	}
	
	public void finalize() throws Throwable {

	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getDesc() {
		return Descripcion;
	}

	public void setDesc(String desc) {
		Descripcion = desc;
	}

	public Date getM_Fecha() {
		return m_Fecha;
	}

	public void setM_Fecha(Date m_Fecha) {
		this.m_Fecha = m_Fecha;
	}

	public OrdendeServicio getM_OrdendeServicio() {
		return m_OrdendeServicio;
	}

	public void setM_OrdendeServicio(OrdendeServicio m_OrdendeServicio) {
		this.m_OrdendeServicio = m_OrdendeServicio;
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	public int getDiasVto() {
		return diasVto;
	}

	public void setDiasVto(int diasVto) {
		this.diasVto = diasVto;
	}
}//end Reclamo