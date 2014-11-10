package test;


import negocio.Arbol;
import negocio.Calle;
import negocio.Copa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.Especie;
import negocio.Rama;
import negocio.Tronco;
import hbt.dao.HibernateDAO;

public class Test {
	
	public Test() {
	}	
	
	public static void main(String[] args) {
		AltaDatos();
		
		System.exit(0);
	}
	
	public static void persistirObj(Object c){
		HibernateDAO.getInstancia().persistir(c);
	}

	private static void AltaDatos() {
		  
		Copa co;
		Tronco tr;
		Rama ram; 
		
		Calle ca;
		Cuadra cuad;
		Espacio es;
		Arbol ar;
		Especie esp;
		
		ca = new Calle("calle 1", 1, 1000);
		HibernateDAO.getInstancia().persistir(ca);
		
		cuad = new Cuadra(ca, 1, 100, 10, Cuadra.UsoSuelo.baldio, Cuadra.TipoEdificacion.media);
		HibernateDAO.getInstancia().persistir(cuad);
		
		esp = new Especie("arbol corriente", "arbol cient 1");
		HibernateDAO.getInstancia().persistir(esp);
		
		co = new Copa(Copa.DensidadFollaje.Anormal, Copa.ColorFollaje.Normal, Copa.Estado.Descopada);				
		tr = new Tronco(Tronco.CavidadBasal.Chica,
				Tronco.CavidadMedia.Grande,
				Tronco.CavidadAlta.Grande,
				true, false, true, false, true, false, true, false, 
				Tronco.Destrucciones.Anillos,
				Tronco.Interferencia.Cordon);
		ram = new Rama(false, true, false, true, false, true, false, true, false, true, false, true, Rama.Destrucciones.Clavaduras, Rama.Interferencia.Vereda);
		ar = new Arbol(esp, co, tr, ram, false, "2", 0, 23, Arbol.Inclinacion.mas45, Arbol.Orientacion.mas45);
		HibernateDAO.getInstancia().persistir(ar);
		
		es = new Espacio("2345", Espacio.TipoCatastral.Ascendente, cuad, "2345", "3838383", 1, 2, Espacio.Tipo.Arbol, true, ar);
		HibernateDAO.getInstancia().persistir(es);
		
		System.out.println("alta de datos");
		
	}
}


