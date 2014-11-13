package negocio;

import java.util.Date;

import hbt.dao.PersistentObject;

import javax.persistence.Entity;


@Entity
public class Usuario extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombreUsuario;
	public String nombreComp;
	public String clave;
	public String mail;
	public Date ultAcceso;
	
	
	public Usuario(){

	}
	
	public Usuario(String nombreUsuario, String nombreComp, String clave,
			String mail) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombreComp = nombreComp;
		this.clave = clave;
		this.mail = mail;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreComp() {
		return nombreComp;
	}

	public void setNombreComp(String nombreComp) {
		this.nombreComp = nombreComp;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getUltAcceso() {
		return ultAcceso;
	}

	public void setUltAcceso(Date ultAcceso) {
		this.ultAcceso = ultAcceso;
	}

	public void finalize() throws Throwable {

	}
}//end Usuario