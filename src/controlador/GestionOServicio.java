package controlador;

import hbt.dao.HibernateDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Beans.bOrdendeServicio;
import negocio.Ciudadano;
import negocio.Espacio;
import negocio.Mantenimiento;
import negocio.OrdendeServicio;
import negocio.Reclamo;
import negocio.TareaTipo;
import negocio.Usuario;

public class GestionOServicio {

	
	public int crearReclamo(String dni, String nom, String ape, String dir, String tel, String mail, String desc){
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
		
		rec.setM_Fecha(new Date());
		
		// persiste reclamo 
		HibernateDAO.getInstancia().persistir(rec);
		
		return rec.getId();
	}
	
	public Espacio buscarEspacio(String dir, String chapa){
		String sql = "select e from Espacio e join e.cuadra c join c.calle d "
				+ " where e.chapaCatastral = :chap "
				+ " and d.nombre = :dir";
		@SuppressWarnings("unchecked")
		List<Espacio> le = (List<Espacio>) HibernateDAO.getInstancia().parametros2(sql, "chap", chapa, "dir", dir);
		for (Espacio e: le)
			return e;
		return null;
		
	}
	
	public List<Espacio> buscarEspacioXEstado(){
		String sql = "from Espacio order by estado desc";
		List<Espacio> le = (List<Espacio>) HibernateDAO.getInstancia().getlista(sql);
		return le;
		
	}
	
	public int crearODS(int tar, String anot) {
				
		TareaTipo t = new TareaTipo();
		t.setId(tar);		
		t = (TareaTipo) HibernateDAO.getInstancia().get(TareaTipo.class, t.getId());
		
		OrdendeServicio os = new OrdendeServicio(anot, t );
		os.setAnotaciones(anot);
		
		// persiste os
		HibernateDAO.getInstancia().persistir(os);
		
		return os.getId();
	}

	public void asignarEspacioODS(int idOds, String calle, String chapa) {
		// TODO Auto-generated method stub
		Espacio es = buscarEspacio(calle, chapa);

		OrdendeServicio os = new OrdendeServicio();
		os.setId(idOds);		
		os = (OrdendeServicio) HibernateDAO.getInstancia().get(OrdendeServicio.class, os.getId());

		os.setEspacio(es);
		
		// guarda os
		HibernateDAO.getInstancia().guardar(os);

	}

	
	public int crearODSMan(int tar, String dir, String chapa, String anot){
		
		Espacio es = buscarEspacio(dir, chapa);
		
		TareaTipo t = new TareaTipo();
		t.setId(tar);		
		t = (TareaTipo) HibernateDAO.getInstancia().get(TareaTipo.class, t.getId());
		
		OrdendeServicio os = new OrdendeServicio(anot, t);
		
		os.setEspacio(es);
		
		// persiste os
		HibernateDAO.getInstancia().persistir(os);
		
		return os.getId();
	}
	
	public List<Usuario> getListaTecnicosDisp(){
		return null;
	}
	
	public void asignarTecODS(int idODS, int tec){
		OrdendeServicio os = new OrdendeServicio();
		os.setId(idODS);		
		os = (OrdendeServicio) HibernateDAO.getInstancia().get(OrdendeServicio.class, os.getId());
		
		
		// no se cual es el tecnico
	}
	
	public void asignarReclamoODS(int idODS, int rec){
		OrdendeServicio os = new OrdendeServicio();
		os.setId(idODS);		
		os = (OrdendeServicio) HibernateDAO.getInstancia().get(OrdendeServicio.class, os.getId());
		
		Reclamo r = new Reclamo();
		r.setId(rec);		
		r = (Reclamo) HibernateDAO.getInstancia().get(Reclamo.class, r.getId());
		
		// asigna reclamo a ods
		os.setReclamo(r);
		
		HibernateDAO.getInstancia().guardar(os);
		
	}
	
	public void asignarMantODS(int idODS, int man){
		OrdendeServicio os = new OrdendeServicio();
		os.setId(idODS);		
		os = (OrdendeServicio) HibernateDAO.getInstancia().get(OrdendeServicio.class, os.getId());
		
		Mantenimiento m = new Mantenimiento();
		m.setId(man);
		m = (Mantenimiento) HibernateDAO.getInstancia().get(Mantenimiento.class, m.getId());
		
		// asigna empresa mantenimiento a ods
		os.setMantenimiento(m);		
		
		HibernateDAO.getInstancia().guardar(os);
	}
	private Ciudadano buscarCiudadano(String dni){
		@SuppressWarnings("unchecked")
		List<Ciudadano> lc = (List<Ciudadano>) HibernateDAO.getInstancia().parametros( "from Ciudadano where dni=:pdni", "pdni", dni);
		if (lc.isEmpty())
			return null;
		else
			return lc.get(0);
	}

	private List<Usuario> buscaTecnicosPend(){
		//		String sql = "from usuario tec where tec.id <> some (select tecnico from reclamo where estado <> :recest"; 
		//List<Usuario> lt = (List<Usuario>) HibernateDAO.getInstancia().parametros(sql, "recest", String.valueOf(Reclamo.est.abierto));
		
		String sql = "from Usuario"; 
		List<Usuario> lt = (List<Usuario>) HibernateDAO.getInstancia().getlista(sql);
		
		return lt;
	}

	public List<TareaTipo> buscarTareas() {
		String sql = "from TareaTipo"; 
		List<TareaTipo> lt = (List<TareaTipo>) HibernateDAO.getInstancia().getlista(sql);
		
		return lt;
	}

	public List<bOrdendeServicio> mostrarODS() {
		List<bOrdendeServicio> lbo = new ArrayList<>();
		
		List<OrdendeServicio> los = (List<OrdendeServicio>) HibernateDAO.getInstancia().getlista("from OrdendeServicio") ;
		
		for(OrdendeServicio os:los){
			Espacio es= os.getEspacio();
			String calle = "";
			String chapa = "";
			if(es != null){
				calle = es.getCuadra().getCalle().getNombre();
				chapa = es.getChapaCatastral();
			}	
				
			bOrdendeServicio bos = new bOrdendeServicio(
					os.getId(),
					os.getAnotaciones(),
					os.getEstado().toString(),
					calle,
					chapa,
					os.getFechaAlta(),
					os.getTareaTipo().getDesc());
			lbo.add(bos);
		}
		return lbo;
	}


}
