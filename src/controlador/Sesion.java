package controlador;

import java.util.Date;

import hbt.dao.PersistentObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import negocio.Usuario;

@Entity
public class Sesion extends PersistentObject{

	private Date fecha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	private String terminal;
	
	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	public Sesion(Date fecha, Usuario usuario, String terminal) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.terminal = terminal;
	}
	

}
