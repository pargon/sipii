package negocio.ppal;

import negocio.atts.Codigo;
import negocio.atts.Contrasena;
import negocio.atts.Nombre;
import negocio.atts.NombreCompleto;
import negocio.atts.Perfil;
import negocio.atts.UltAcceso;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:20 p.m.
 */
public class Usuario {

	public NombreCompleto m_NombreCompleto;
	public Perfil m_Perfil;
	public OrdendeServicio m_OrdendeServicio;
	public Codigo m_Codigo;
	public Nombre m_Nombre;
	public UltAcceso m_UltAcceso;
	public Contrasena m_Contrasena;

	public Usuario(){

	}

	public void finalize() throws Throwable {

	}
}//end Usuario