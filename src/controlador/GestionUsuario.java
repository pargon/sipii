package controlador;

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
}
