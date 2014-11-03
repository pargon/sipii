package negocio;


/**
 * @author gon
 * @version 1.0
 * @created 02-nov-2014 06:32:34 p.m.
 */
public class Ciudadano extends ERD_Entity1 implements Interface1 {

	public Nombre m_Nombre;
	public Domicilio m_Domicilio;
	public ERD_naryAssociation1 m_ERD_naryAssociation1;
	public Tel m_Tel;
	public DNI m_DNI;
	public Apellido m_Apellido;
	public Reclamo m_Reclamo;
	public Mail m_Mail;

	public Ciudadano(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Ciudadano