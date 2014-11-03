package negocio;


/**
 * @author gon
 * @version 1.0
 * @created 02-nov-2014 06:32:41 p.m.
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