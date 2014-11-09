package negocio;

import hbt.dao.HibernateDAO;
import java.util.List;

public class GestionOServicio {

	
	public void crearReclamo(String dni, String nom, String ape, String dir, String tel, String mail, String desc){
		Ciudadano ciu = buscarCiudadano(dni);
		if (ciu == null )
			ciu = new Ciudadano(nom, ape, dir, tel, mail, dni);
	
		Reclamo rec = new Reclamo(ciu, desc);
		
		// busca tecnico para asignar
		List<Usuario> lt = buscaTecnicosPend();
		for (Usuario tec: lt){
			
			// asigna el primer disponible
			rec.setTecnico(tec);
			break;
		}
	}
	
	public List<Espacio> buscarEspacio(String dir, String chapa){
		return null;
	}
	
	public int crearODS(int tarea, String desc){
		return 0;
	}
	
	public List<Usuario> getListaTecnicosDisp(){
		return null;
	}
	
	public void asignarTecODS(int idODS, int tec){
		List<OrdendeServicio> lo = (List<OrdendeServicio>) HibernateDAO.getInstancia().parametros( "from ordendeservicio", "id", String.valueOf(idODS));
		OrdendeServicio os = lo.get(0);
		
		// no se cual es el tecnico
	}
	
	public void asignarReclamoODS(int idODS, int rec){
		List<OrdendeServicio> lo = (List<OrdendeServicio>) HibernateDAO.getInstancia().parametros( "from ordendeservicio", "id", String.valueOf(idODS));
		OrdendeServicio os = lo.get(0);
		
		List<Reclamo> lr = (List<Reclamo>) HibernateDAO.getInstancia().parametros( "from reclamo", "id", String.valueOf(rec));
		Reclamo r = lr.get(0);
		
		// asigna reclamo a ods
		os.setReclamo(r);
		
	}
	
	public void asignarMantODS(int idODS, int man){
		List<OrdendeServicio> lo = (List<OrdendeServicio>) HibernateDAO.getInstancia().parametros( "from ordendeservicio", "id", String.valueOf(idODS));
		OrdendeServicio os = lo.get(0);
		
		List<Mantenimiento> lm = (List<Mantenimiento>) HibernateDAO.getInstancia().parametros( "from mantenimiento", "id", String.valueOf(man));
		Mantenimiento m = lm.get(0);
		
		// asigna empresa mantenimiento a ods
		os.setMantenimiento(m);		
	}
	private Ciudadano buscarCiudadano(String dni){
		List<Ciudadano> lc = (List<Ciudadano>) HibernateDAO.getInstancia().parametros( "from ciudadano", "dni", dni);
		if (lc.isEmpty())
			return null;
		else
			return lc.get(0);
	}

	private List<Usuario> buscaTecnicosPend(){
		String sql = "from usuario tec where tec.id <> some (select usu.id from reclamo where estado <> '" + Reclamo.est.abierto + "')"; 
		List<Usuario> lt = (List<Usuario>) HibernateDAO.getInstancia().getlista(sql);
		return lt;
	}
}
