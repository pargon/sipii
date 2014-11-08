package negocio.atts;

import negocio.ppal.Espacio;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:09 p.m.
 */
public class ArbolSeco extends Espacio {

	public IdEspecie m_IdEspecie;
	public Altura m_Altura;
	public Perimetro m_Perimetro;

	public ArbolSeco(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end ArbolSeco