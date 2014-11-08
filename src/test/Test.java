package test;


import negocio.Copa;
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
		
		co = new Copa(Copa.DensidadFollaje.Anormal, Copa.ColorFollaje.Normal, Copa.Estado.Descopada);
		HibernateDAO.getInstancia().persistir(co);
		
		co = new Copa(Copa.DensidadFollaje.Normal, Copa.ColorFollaje.Normal, Copa.Estado.Equilibrada);
		HibernateDAO.getInstancia().persistir(co);
		
		System.out.println("aqui va el alta de datos");
		
	}
}


