package negocio.ppal;

import negocio.atts.Ancho;
import negocio.atts.Calle;
import negocio.atts.ChapaCatastral;
import negocio.atts.Elevado;
import negocio.atts.Largo;
import negocio.atts.Latitud;
import negocio.atts.Longitud;
import negocio.atts.TipoChapa;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:10 p.m.
 */
public class Espacio {

	public ChapaCatastral m_ChapaCatastral;
	public Ancho m_Ancho;
	public Calle m_Calle;
	public TipoChapa m_TipoChapa;
	public Longitud m_Longitud;
	public Largo m_Largo;
	public Latitud m_Latitud;
	public Elevado m_Elevado;

	public Espacio(){

	}

	public void finalize() throws Throwable {

	}
}//end Espacio