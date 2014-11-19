package controlador;

import java.util.Date;

import hbt.dao.PersistentObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import negocio.Usuario;

@Entity
public class Sesion extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date fecha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Usuario usuario;
	@ManyToOne(cascade=CascadeType.ALL)
	private Terminal terminal;
	
	public Sesion() {
		// TODO Auto-generated constructor stub
	}

	public Sesion(Date fecha, Usuario usuario, Terminal terminal) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.terminal = terminal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}

	
}
