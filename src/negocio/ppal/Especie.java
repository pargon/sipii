package negocio.ppal;

import negocio.atts.Arbol;
import negocio.atts.ArbolSeco;
import negocio.atts.Id;
import negocio.atts.Nombre;
import negocio.atts.NombreCient;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:10 p.m.
 */
public class Especie {

	public ArbolSeco m_ArbolSeco;
	public Arbol m_Arbol;
	public Id m_Id;
	public NombreCient m_NombreCient;
	public Nombre m_Nombre;

	public Especie(){

	}

	public void finalize() throws Throwable {

	}
}//end Especie