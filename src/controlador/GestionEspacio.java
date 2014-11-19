package controlador;

import hbt.dao.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import Beans.bEspacio;
import negocio.Copa;
import negocio.Copa.ColorFollaje;
import negocio.Copa.DensidadFollaje;
import negocio.Copa.EstadoCopa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.Rama;
import negocio.Rama.DestruccionesRama;
import negocio.Rama.InterferenciaRama;
import negocio.Tronco;
import negocio.Tronco.CavidadAlta;
import negocio.Tronco.CavidadBasal;
import negocio.Tronco.CavidadMedia;
import negocio.Tronco.Destrucciones;
import negocio.Tronco.Interferencia;
import negocio.Usuario;
import negocio.Arbol.Inclinacion;
import negocio.Arbol.Orientacion;
import negocio.Espacio.Tipo;
import negocio.Espacio.TipoCatastral;
import negocio.Especie;
import negocio.Arbol;
import negocio.Espacio.Estado;;


public class GestionEspacio {
	
	private Estado estado;
			
	public GestionEspacio() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void crearEspacio2(String dir,String chapaCat, String tipoCat,String lat, String longi,
			float anchoP, float largoP, String tipo, boolean canteroE, boolean ar_s, String ar_alt,int ar_est, float ar_per,String ar_incl,String ar_ori,String co_dF, String co_cF, String co_Est,String tr_cB, String tr_cM, String tr_cA, boolean tr_co ,boolean tr_ab,
			boolean tr_desg,boolean tr_desc,boolean tr_raj,boolean tr_fr,boolean tr_ch,boolean tr_en,String tr_dest,String tr_interf, boolean ra_co,boolean ra_cr,
			boolean ra_mI,boolean ra_s,boolean ra_mR,boolean ra_f,boolean ra_c,boolean ra_ex,boolean ra_b,boolean ra_ep,
			boolean ra_fr,boolean ra_t, String ra_dest, String ra_interf)
			{
				Espacio e = buscarEspacio(dir,chapaCat);
				TipoCatastral tC = TipoCatastral.valueOf(tipoCat);
				Tipo ti = Tipo.valueOf(tipo);
				Cuadra c = new Cuadra();
				c = (Cuadra) HibernateDAO.getInstancia().get(Cuadra.class, c.getId());
				Arbol ar = crearArbol(ar_s, ar_alt, ar_est, ar_per, ar_incl, ar_ori, co_dF, co_cF, co_Est, tr_cB, tr_cM, tr_cA,tr_co , tr_ab,
						 tr_desg, tr_desc, tr_raj, tr_fr, tr_ch, tr_en, tr_dest, tr_interf, ra_co, ra_cr,
						 ra_mI, ra_s, ra_mR, ra_f, ra_c, ra_ex, ra_b, ra_ep, ra_fr, ra_t, ra_dest, ra_interf);
				
							
				if (e==null){
					e = new Espacio(chapaCat, tC, c,lat, longi,anchoP,largoP,ti,canteroE,ar);
					int k=calcularEstado(ar);
					if ((k>0)&&(k<6)){	
						e.setEst(estado.B);	
					}else
						if (k>=6){
							e.setEst(estado.C);		
					}else{
						e.setEst(estado.A);
					}
					HibernateDAO.getInstancia().persistir(e);
				}
		}		
	
	
	public Arbol crearArbol(boolean ar_s, String ar_alt,int ar_est, float ar_per,String ar_incl,String ar_ori,String co_dF, String co_cF, String co_Est,String tr_cB, String tr_cM, String tr_cA, boolean tr_co ,boolean tr_ab,
			boolean tr_desg,boolean tr_desc,boolean tr_raj,boolean tr_fr,boolean tr_ch,boolean tr_en,String tr_dest,String tr_interf, boolean ra_co,boolean ra_cr,
			boolean ra_mI,boolean ra_s,boolean ra_mR,boolean ra_f,boolean ra_c,boolean ra_ex,boolean ra_b,boolean ra_ep,
			boolean ra_fr,boolean ra_t, String ra_dest, String ra_interf){
		
		
		Inclinacion incl = Inclinacion.valueOf(ar_incl);
		Orientacion ori = Orientacion.valueOf(ar_ori);
		DensidadFollaje dF = DensidadFollaje.valueOf(co_dF);
		ColorFollaje cF = ColorFollaje.valueOf(co_cF);		
		EstadoCopa est = EstadoCopa.valueOf(co_Est);
		CavidadBasal cB = CavidadBasal.valueOf(tr_cB);
		CavidadMedia cM = CavidadMedia.valueOf(tr_cM);
		CavidadAlta cA = CavidadAlta.valueOf(tr_cA);
		Destrucciones dest = Destrucciones.valueOf(tr_dest);
		Interferencia interf = Interferencia.valueOf(tr_interf);
		DestruccionesRama r_dest = DestruccionesRama.valueOf(ra_dest);
		InterferenciaRama r_interf = InterferenciaRama.valueOf(ra_interf);
		
		Copa co = new Copa(dF,cF,est);
		Especie esp = new Especie();
		Tronco tr = new Tronco(cB,cM,cA,tr_co ,tr_ab,tr_desg, tr_desc,tr_raj,tr_fr, tr_ch, tr_en,dest,interf);
		Rama ram = new Rama (ra_co, ra_cr,ra_mI,ra_s,ra_mR,ra_f,ra_c, ra_ex,ra_b,ra_ep,ra_fr,ra_t,r_dest,r_interf);
			
		Arbol ar = new Arbol(esp, co, tr, ram, ar_s, ar_alt, ar_est, ar_per, incl, ori);
			
		return ar;		
		
	}
	/*
	public void crearEspacio(String dir,String chapaCat, String tipoCat,int cua, String lat, String longi,
			float anchoP, float largoP, String tipo, boolean canteroE,int a )
	{			
				Espacio e = buscarEspacio(dir,chapaCat);
				TipoCatastral tC = TipoCatastral.valueOf(tipoCat);
				Tipo ti = Tipo.valueOf(tipo);
				Cuadra c = new Cuadra();
				c.setId(cua);
				c = (Cuadra) HibernateDAO.getInstancia().get(Cuadra.class, c.getId());
				Arbol ar = crearArbol();
				
				
				ar.setId(a);
				ar = (Arbol) HibernateDAO.getInstancia().get(Arbol.class, ar.getId());
				
				if (e==null){
					e = new Espacio(chapaCat, tC, c,lat, longi,anchoP,largoP,ti,canteroE,ar);
					int k=calcularEstado(ar);
					if ((k>0)&&(k<6)){	
						e.setEst(estado.B);	
					}else
						if (k>=6){
							e.setEst(estado.C);		
					}else{
						e.setEst(estado.A);
					}
					HibernateDAO.getInstancia().persistir(e);
				}
		}
	*/
	public void modificarEspacio(String dir,String chapaCat){
		Espacio e = buscarEspacio(dir,chapaCat);
		if (e!=null){
		e.getArbol().getAltura();
		e.setChapaCatastral("2360");
		int k=calcularEstado(e.getArbol());
		if ((k>0)&&(k<6)){	
			e.setEst(estado.B);	
		}else
			if (k>=6){
				e.setEst(estado.C);		
		}else{
			e.setEst(estado.A);
		}
	
		HibernateDAO.getInstancia().update(e);
		}
		
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

	public List<Especie> buscarEspecie(){
		String sql = "from Especie";
		List<Especie> l_esp = (List<Especie>) HibernateDAO.getInstancia().getlista(sql);
		return l_esp;
	}
	
	public List<Espacio> buscarEspacioTodos(){
		String sql = "from Espacio";
		List<Espacio> le = (List<Espacio>) HibernateDAO.getInstancia().getlista(sql);
		return le;
		
	}
	
	public int calcularEstado(Arbol a){
		int k=0;
	
		// Falta Calcular
		
		return k;
	}

	public List<bEspacio> buscarEspacioXEstado(){
		String sql = "from Espacio order by estado desc";
		List<Espacio> le = (List<Espacio>) HibernateDAO.getInstancia().getlista(sql);
		
		List<bEspacio> lbe = new ArrayList<>();
		for(Espacio es: le){
			bEspacio be = new bEspacio(
					es.getId(),
					es.getTipo().toString(),
					es.getCuadra().getCalle().getNombre(),
					es.getChapaCatastral(),
					es.getEst().toString());
			
			lbe.add(be);
		}
		return lbe;
	}
}
