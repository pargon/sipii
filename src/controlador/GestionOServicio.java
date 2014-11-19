package controlador;

import hbt.dao.HibernateDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xpath.internal.operations.Bool;

import Beans.bOrdendeServicio;
import Beans.bReclamo;
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
		rec.setDiasVto(60);
		
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
	
	public int crearODS(String ter, int tar, String anot) {
				
		TareaTipo t = new TareaTipo();
		t.setId(tar);		
		t = (TareaTipo) HibernateDAO.getInstancia().get(TareaTipo.class, t.getId());
		
		OrdendeServicio os = new OrdendeServicio(anot, t );
		os.setAnotaciones(anot);
		
		Usuario usu = obtenerUsuarioLog(ter);
		os.setUsuarioAlta(usu);
		
		// persiste os
		HibernateDAO.getInstancia().persistir(os);
		
		return os.getId();
	}

	private Usuario obtenerUsuarioLog(String ter) {
		
		String sql = "select s from Sesion as s where "
				+ " s.fecha >= (select max(s2.fecha) from Sesion as s2 where s2.terminal.ter = :term)"
				+ " and s.terminal.ter = :term";
		List<Sesion> ls = (List<Sesion>) HibernateDAO.getInstancia().parametros(sql, "term", ter);
		
		return ls.get(0).getUsuario();
		
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
		// busca un tecnico q no esté en algun reclamo abierto
		String sql = "from Usuario as tec "
				+ " where tec.id not in(select rec.tecnico.id "
				+ " 					from Reclamo as rec "
				+ "  					where rec.Estado = :recest)";
				 
		List<Usuario> lt = (List<Usuario>) HibernateDAO.getInstancia().parametObj(sql, "recest", Reclamo.est.abierto ) ;
		
//		String sql = "from Usuario"; 
//		List<Usuario> lt = (List<Usuario>) HibernateDAO.getInstancia().getlista(sql);

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
				
			Mantenimiento ma = os.getMantenimiento();
			String mant = "";
			if(ma != null)
				mant = ma.getRazonSocial();
				
			bOrdendeServicio bos = new bOrdendeServicio(
					os.getId(),
					os.getAnotaciones(),
					os.getEstado().toString(),
					calle,
					chapa, 
					os.getFechaAlta(),
					os.getTareaTipo().getDesc(),
					mant);
			lbo.add(bos);
		}
		return lbo;
	}

	public List<bReclamo> mostrarRec() {
		List<bReclamo> lbo = new ArrayList<>();
		
		List<Reclamo> los = (List<Reclamo>) HibernateDAO.getInstancia().getlista("from Reclamo") ;
			
		for(Reclamo os:los){
			OrdendeServicio ods = os.getM_OrdendeServicio();
			int idODS = 0;
			if(ods != null)
				idODS = ods.getId();
			Usuario tec = os.getTecnico();
			String ntec = "";
			if(tec!=null)
				ntec = tec.getNombreComp();
			
			bReclamo bos = new bReclamo(					
					os.getId(),
					os.getEstado().toString() ,
					os.getCiudadano().getDni(),
					os.getCiudadano().getNombre() + " " + os.getCiudadano().getApellido(),
					os.getDesc(),
					os.getM_Fecha(), 
					idODS,
					ntec,
					os.getDiasVto() );
			lbo.add(bos);
		}
		return lbo;
	}


}
