package negocio.atts;

import negocio.ppal.OrdendeServicio;
import negocio.ppal.Usuario;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:19 p.m.
 */
public class Municipio {

	public Posee m_Posee;
	public Arbol m_Arbol;
	public OrdendeServicio m_OrdendeServicio;
	public Nombre m_Nombre;
	public Id m_Id;
	public Usuario m_Usuario;

	public Municipio(){

	}

	public void finalize() throws Throwable {

	}
}//end Municipio