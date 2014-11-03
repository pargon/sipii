package negocio;


/**
 * @author gon
 * @version 1.0
 * @created 02-nov-2014 06:32:34 p.m.
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