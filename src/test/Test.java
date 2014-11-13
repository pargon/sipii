package test;


import controlador.GestionOServicio;
import negocio.Arbol;
import negocio.Calle;
import negocio.Copa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.Especie;
import negocio.Mantenimiento;
import negocio.OrdendeServicio;
import negocio.Rama;
import negocio.TareaTipo;
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
		
		Mantenimiento man;
		TareaTipo t;
		GestionOServicio gs;
		
		ca = new Calle("calle 1", 1, 1000);
		//HibernateDAO.getInstancia().persistir(ca);
		
		cuad = new Cuadra(ca, 1, 100, 10, Cuadra.UsoSuelo.baldio, Cuadra.TipoEdificacion.media);
		//HibernateDAO.getInstancia().persistir(cuad);
		
		esp = new Especie("arbol corriente", "arbol cient 1");
		//HibernateDAO.getInstancia().persistir(esp);
		
		co = new Copa(Copa.DensidadFollaje.Anormal, Copa.ColorFollaje.Normal, Copa.Estado.Descopada);				
		tr = new Tronco(Tronco.CavidadBasal.Chica,
				Tronco.CavidadMedia.Grande,
				Tronco.CavidadAlta.Grande,
				true, false, true, false, true, false, true, false, 
				Tronco.Destrucciones.Anillos,
				Tronco.Interferencia.Cordon);
		ram = new Rama(false, true, false, true, false, true, false, true, false, true, false, true, Rama.Destrucciones.Clavaduras, Rama.Interferencia.Vereda);
		ar = new Arbol(esp, co, tr, ram, false, "2", 0, 23, Arbol.Inclinacion.mas45, Arbol.Orientacion.mas45);
		//HibernateDAO.getInstancia().persistir(ar);
		
		es = new Espacio("2345", Espacio.TipoCatastral.Ascendente, cuad, "2345", "3838383", 1, 2, Espacio.Tipo.Arbol, true, ar);
		HibernateDAO.getInstancia().persistir(es);
		
		
		t = new TareaTipo("tarea 1",2);
		HibernateDAO.getInstancia().persistir(t);
		
		man = new Mantenimiento("manten1");
		HibernateDAO.getInstancia().persistir(man);
		
		
		gs = new GestionOServicio();
		
		int idRec = gs.crearReclamo("1234455", "gonzalo", "parra", "calle 1 2345", "33445566", "mail@algo.com", "se cayo un arbol sobre mi casa");
		int idOds = gs.crearODSMan(1, "hola hola");
		
		gs.asignarMantODS(idOds, man.getId());
		gs.asignarReclamoODS(idOds, idRec);
		gs.asignarEspacioODS(idOds, "calle 1", "2345");
//		gs.asignarTecODS(idOds, tec);
		
		idOds = gs.crearODSEsp("calle 1", "2345", "problema con arbol");
		gs.asignarMantODS(idOds, man.getId());
		gs.asignarReclamoODS(idOds, idRec);
		
		System.out.println("alta de datos");
		
	}
}


