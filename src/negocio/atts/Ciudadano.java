package negocio.atts;

import negocio.ppal.Reclamo;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:09 p.m.
 */
public class Ciudadano {

	public Nombre m_Nombre;
	public Domicilio m_Domicilio;
	public Tel m_Tel;
	public DNI m_DNI;
	public Apellido m_Apellido;
	public Reclamo m_Reclamo;
	public Mail m_Mail;

	public Ciudadano(){

	}

	public void finalize() throws Throwable {

	}
}//end Ciudadano