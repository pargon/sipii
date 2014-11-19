package controlador;

import java.util.Date;
import java.util.List;

import negocio.Usuario;
import hbt.dao.HibernateDAO;

public class GestionUsuario {

	public boolean usuarioExiste(String user){
		String sql = "from Usuario where nombreUsuario = :usu";
		List<Usuario> u = (List<Usuario>) HibernateDAO.getInstancia().parametros(sql, "usu", user) ;
		
		return (u.size() > 0);
	}
	
	public boolean usuarioContrOk(String user, String pass){
		String sql = "from Usuario where nombreUsuario = :usu";
		List<Usuario> lu = (List<Usuario>) HibernateDAO.getInstancia().parametros(sql, "usu", user) ;
		
		Usuario u = lu.get(0); 
		return (pass.equals(u.getClave()));
	}
	
	public void crearSesion(String user, String ter){
		String sql = "from Usuario where nombreUsuario = :usu";
		List<Usuario> lu = (List<Usuario>) HibernateDAO.getInstancia().parametros(sql, "usu", user) ;
		Usuario u = lu.get(0);
		
		//busca terminal
		Terminal t= new Terminal();
		t.setTer(ter);
		t = (Terminal) HibernateDAO.getInstancia().get(Terminal.class, t.getTer());
		//la crea si no existe
		if(t == null){
			t = new Terminal();
			t.setTer(ter);
			HibernateDAO.getInstancia().persistir(t);
		}
		 
		// crea sesion con terminal y usuario
		Sesion ses = new Sesion(new Date(), u, t);
		
		HibernateDAO.getInstancia().persistir(ses);
	}
}
