package negocio.ppal;

import negocio.atts.Anotaciones;
import negocio.atts.DiasVencimiento;
import negocio.atts.Estado;
import negocio.atts.FechaAlta;
import negocio.atts.Id;
import negocio.atts.IdEspacio;
import negocio.atts.IdManetimiento;
import negocio.atts.IdReclamo;
import negocio.atts.TareaTipo;
import negocio.atts.UsuarioAlta;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:19 p.m.
 */
public class OrdendeServicio {

	public Estado m_Estado;
	public IdEspacio m_IdEspacio;
	public FechaAlta m_FechaAlta;
	public DiasVencimiento m_DiasVencimiento;
	public Id m_Id;
	public Anotaciones m_Anotaciones;
	public UsuarioAlta m_UsuarioAlta;
	public IdReclamo m_IdReclamo;
	public TareaTipo m_TareaTipo;
	public IdManetimiento m_IdManetimiento;

	public OrdendeServicio(){

	}

	public void finalize() throws Throwable {

	}
}//end OrdendeServicio