package negocio.ppal;

import negocio.atts.DNICiudadano;
import negocio.atts.Fecha;
import negocio.atts.Id;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:20 p.m.
 */
public class Reclamo {

	public Id m_Id;
	public DNICiudadano m_DNICiudadano;
	public Fecha m_Fecha;
	public OrdendeServicio m_OrdendeServicio;

	public Reclamo(){

	}

	public void finalize() throws Throwable {

	}
}//end Reclamo