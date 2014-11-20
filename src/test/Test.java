package test;


import java.util.List;

import controlador.GestionOServicio;
import controlador.GestionEspacio;
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
		Especie esp;
		
		Mantenimiento man;
		GestionOServicio gs;
		GestionEspacio ge;
		
		TareaTipo tarTip; 
		/*		
		ca = new Calle("calle 1", 1, 1000);
		//HibernateDAO.getInstancia().persistir(ca);
		
		cuad = new Cuadra(ca, 1, 100, 10, Cuadra.UsoSuelo.baldio, Cuadra.TipoEdificacion.media);
		HibernateDAO.getInstancia().persistir(cuad);
		
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
		HibernateDAO.getInstancia().persistir(ar);
		
		es = new Espacio("2345", Espacio.TipoCatastral.Ascendente, cuad, "2345", "3838383", 1, 2, Espacio.Tipo.Arbol, true, ar);
		//HibernateDAO.getInstancia().persistir(es);
				
		man = new Mantenimiento("manten1");
		HibernateDAO.getInstancia().persistir(man);
		
		tarTip = new TareaTipo("tarea 1", 10);
		HibernateDAO.getInstancia().persistir(tarTip);
		tarTip = new TareaTipo("tarea 2", 30);
		HibernateDAO.getInstancia().persistir(tarTip);
		tarTip = new TareaTipo("tarea 3", 60);
		HibernateDAO.getInstancia().persistir(tarTip);
		
		
		gs = new GestionOServicio();
		int idRec = gs.crearReclamo("1234455", "gonzalo", "parra", "calle 1 2345", "33445566", "mail@algo.com", "se cayo un arbol sobre mi casa");
		int idOds = gs.crearODS(2, "problema con arbol");
		
		gs.asignarMantODS(idOds, man.getId());
		gs.asignarReclamoODS(idOds, idRec);
		gs.asignarEspacioODS(idOds, "calle 1", "2345");
//		gs.asignarTecODS(idOds, tec);
		
	
		
				
		System.out.println("Lista Espacios x estado");
		List<Espacio> espXest = gs.buscarEspacioXEstado();
		for(Espacio itEsp: espXest)
			System.out.println("espacio: " 
						+itEsp.getId() 
						+" en: " 
						+itEsp.getCuadra().getCalle().getNombre() 
						+ " N: "
						+itEsp.getChapaCatastral()  );
		
		
		System.out.println("Lista Tareas por hacer");
		List<TareaTipo> ltar = gs.buscarTareas();
		for(TareaTipo tt: ltar)
			System.out.println("Tarea: " +tt.getDesc() + " dias:"+ tt.getDias());
		
		idOds = gs.crearODSMan(1, "calle 1", "2345", "Problema de altura");
		gs.asignarMantODS(idOds, man.getId());
//		gs.asignarTecODS(idOds, tec);
		*/
	
		//Gestion Espacio
		ca = new Calle("calle 1", 1, 1000);
		cuad = new Cuadra(ca, 1, 100, 10, Cuadra.UsoSuelo.baldio, Cuadra.TipoEdificacion.media);
		HibernateDAO.getInstancia().persistir(cuad);
		
		
		esp = new Especie("arbol corriente", "arbol cient 1");
		HibernateDAO.getInstancia().persistir(esp);
		
		ge = new GestionEspacio();
		int idEspacio = ge.crearEspacio("Calle 1", "300", "Normal","20","21",4,4,"Arbol",true);
		
		Espacio e = new Espacio();
		e.setId(idEspacio);
		e= (Espacio) HibernateDAO.getInstancia().get(Espacio.class, e.getId());
		String []atributos = {"tr_ab"};
		
		if (e.getTipo().toString()=="Arbol"){
			int idArbol = ge.crearArbol(1,"2",1,4,"NA","NA","Normal", "Normal","Equilibrada",
					"Chica","Chica","Chica","Anillos","Vereda","Quemaduras","Cantera", atributos);
			ge.asignarArbolEspacio(idArbol, idEspacio);
		}else{
			int idArbol = ge.crearArbol();
			ge.asignarArbolEspacio(idArbol, idEspacio);
		}
		
		
		
		
		System.out.println("Lista Espacios");
		List<Espacio> espge = ge.buscarEspacioTodos();
		for(Espacio itEsp: espge)
			System.out.println("espacio: " 
						+itEsp.getId() 
						+ " N: "
						+itEsp.getChapaCatastral()
						+ " TipoCatastral: "
						+itEsp.getTipoCat()						
						+ " Estado: "
						+itEsp.getArbol().getIncl()
						+ " Tipo: "
						+itEsp.getTipo()
						+ " Bolean abul: "
						+itEsp.getArbol().getTronco().isAbultamientos()
						+ " Bolean cruz: "
						+itEsp.getArbol().getRama().isCruzadas());
						
								
						
		System.out.println("alta de datos");
		
		Espacio eM =  ge.buscarEspacio("Calle 1","300");
		
		//mostrar
		if (eM!=null){
				String []atributos2= {"ra_cr"};
				ge.modificarEspacio3("Calle 1", "300","Arbol","2", 1, 1, "mas45","NA", "Normal", "Normal", "Equilibrada",
						"Chica", "Chica","Chica", "Anillos", "Vereda", "Quemaduras","Cantera",atributos2);
			}else{
				System.out.println("No Existe el Espacio");
			}
		
	
		
		System.out.println("Lista Espacios");
		List<Espacio> espge2 = ge.buscarEspacioTodos();
		for(Espacio itEsp: espge2)
			System.out.println("espacio: " 
						+itEsp.getId() 
						+ " N: "
						+itEsp.getChapaCatastral()
						+ " TipoCatastral: "
						+itEsp.getTipoCat()						
						+ " Estado: "
						+itEsp.getArbol().getIncl()
						+ " Tipo: "
						+itEsp.getTipo()
						+ " Bolean abul: "
						+itEsp.getArbol().getTronco().isAbultamientos()
						+ " Bolean cruz: "
						+itEsp.getArbol().getRama().isCruzadas()
						);
				
		
	}
}


