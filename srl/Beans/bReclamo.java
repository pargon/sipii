package Beans;

import java.util.Date;


public class bReclamo {

	private int id;
	private String estado;
	private String dni;
	private String nomape;
	private String Descripcion;
	private Date m_Fecha;
	private int idOds;
	private String tecnico;
	private int diasVto;
	
	public bReclamo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bReclamo(int id, String estado, String dni, String nomape,
			String descripcion, Date m_Fecha, int idOds, String tecnico,
			int diasVto) {
		super();
		this.id = id;
		this.estado = estado;
		this.dni = dni;
		this.nomape = nomape;
		Descripcion = descripcion;
		this.m_Fecha = m_Fecha;
		this.idOds = idOds;
		this.tecnico = tecnico;
		this.diasVto = diasVto;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNomape() {
		return nomape;
	}
	public void setNomape(String nomape) {
		this.nomape = nomape;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getM_Fecha() {
		return m_Fecha;
	}
	public void setM_Fecha(Date m_Fecha) {
		this.m_Fecha = m_Fecha;
	}
	public int getIdOds() {
		return idOds;
	}
	public void setIdOds(int idOds) {
		this.idOds = idOds;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public int getDiasVto() {
		return diasVto;
	}
	public void setDiasVto(int diasVto) {
		this.diasVto = diasVto;
	}

	
}
