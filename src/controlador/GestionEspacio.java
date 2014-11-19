
package controlador;

import hbt.dao.HibernateDAO;

import java.util.List;

import negocio.Copa;
import negocio.Copa.ColorFollaje;
import negocio.Copa.DensidadFollaje;
import negocio.Copa.EstadoCopa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.OrdendeServicio;
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
import negocio.Espacio.Estado;
import negocio.Referencia;;


public class GestionEspacio {
	
	private Estado estado;
			
	
	public int crearArbol(int esp,boolean ar_s, String ar_alt,int ar_est, float ar_per,String ar_incl,String ar_ori,String co_dF, String co_cF, String co_Est,String tr_cB, String tr_cM, String tr_cA, boolean tr_co ,boolean tr_ab,
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
		
		Especie es= new Especie();
		es.setId(esp);
		
		es = (Especie) HibernateDAO.getInstancia().get(Especie.class, es.getId());
		
		
		Copa co = new Copa(dF,cF,est);
		Tronco tr = new Tronco(cB,cM,cA,tr_co ,tr_ab,tr_desg, tr_desc,tr_raj,tr_fr, tr_ch, tr_en,dest,interf);
		Rama ram = new Rama (ra_co, ra_cr,ra_mI,ra_s,ra_mR,ra_f,ra_c, ra_ex,ra_b,ra_ep,ra_fr,ra_t,r_dest,r_interf);
			
		Arbol ar = new Arbol(es, co, tr, ram, ar_s, ar_alt, ar_est, ar_per, incl, ori);
		
		HibernateDAO.getInstancia().persistir(ar);
			
		return ar.getId();		
		
	}
	
	public void asignarArbolEspacio(int idArbol, int idEspacio) {
		
		Espacio e = new Espacio();
		e.setId(idEspacio);
		e= (Espacio) HibernateDAO.getInstancia().get(Espacio.class, e.getId());
		
		Arbol a = new Arbol();
		a.setId(idArbol);
		a= (Arbol) HibernateDAO.getInstancia().get(Arbol.class, a.getId());

		e.setArbol(a);
				
		HibernateDAO.getInstancia().guardar(e);

	}
	
	public int modificarEspacio(String dir,String chapaCat,String e_tC,String e_lat,String e_long,
			float e_aP,float e_lP,String e_t,boolean e_cE){
		Espacio e = buscarEspacio(dir,chapaCat);
		if (e!=null){
				
					Tipo ti = Tipo.valueOf(e_t);
					TipoCatastral tC = TipoCatastral.valueOf(e_tC);
					e.setTipoCat(tC);
					e.setLatitud(e_lat);
					e.setLongitud(e_long);
					e.setAnchoPlantera(e_aP);
					e.setLargoPlantera(e_lP);
					e.setTipo(ti);
					e.setCanteroElevado(e_cE);
					HibernateDAO.getInstancia().update(e);
					return e.getId();
					
				}
		else{
			System.out.println("No Existe el Espacio");
			return 0;
		}
		
	}
	
	public int modificarArbol(String idArbol,int a_esp,boolean ar_s, String ar_alt,int ar_est, float ar_per,String ar_incl,String ar_ori,String co_dF, String co_cF, String co_Est,String tr_cB, String tr_cM, String tr_cA, boolean tr_co ,boolean tr_ab,
			boolean tr_desg,boolean tr_desc,boolean tr_raj,boolean tr_fr,boolean tr_ch,boolean tr_en,String tr_dest,String tr_interf, boolean ra_co,boolean ra_cr,
			boolean ra_mI,boolean ra_s,boolean ra_mR,boolean ra_f,boolean ra_c,boolean ra_ex,boolean ra_b,boolean ra_ep,
			boolean ra_fr,boolean ra_t, String ra_dest, String ra_interf){
		
		Arbol a = buscarArbol(idArbol);
		Especie esp = new Especie();
		esp.setId(a_esp);
		
		a.setSeco(ar_s);
		a.setAltura(ar_alt);
		a.setEstado(ar_est);
		a.setPerimetro(ar_per);
		Inclinacion incl = Inclinacion.valueOf(ar_incl);
		Orientacion ori = Orientacion.valueOf(ar_ori);
		a.setIncl(incl);
		a.setOrient(ori);
		DensidadFollaje dF = DensidadFollaje.valueOf(co_dF);
		ColorFollaje cF = ColorFollaje.valueOf(co_cF);		
		EstadoCopa est = EstadoCopa.valueOf(co_Est);
		a.getCopa().setDf(dF);
		a.getCopa().setCf(cF);
		a.getCopa().setEstadoCopa(est);
		CavidadBasal cB = CavidadBasal.valueOf(tr_cB);
		CavidadMedia cM = CavidadMedia.valueOf(tr_cM);
		CavidadAlta cA = CavidadAlta.valueOf(tr_cA);
		a.getTronco().setCb(cB);
		a.getTronco().setCm(cM);;
		a.getTronco().setCa(cA);
		a.getTronco().setCodominancia(ra_co);
		a.getTronco().setAbultamientos(tr_ab);
		a.getTronco().setDesgarrado(tr_desg);
		a.getTronco().setDescortezamiento(tr_desc);
		a.getTronco().setRajaduras(tr_raj);
		a.getTronco().setFructificaciones(tr_fr);
		a.getTronco().setChorreados(tr_ch);
		a.getTronco().setEnredadera(tr_en);
		Destrucciones dest = Destrucciones.valueOf(tr_dest);
		Interferencia interf = Interferencia.valueOf(tr_interf);
		a.getTronco().setDest(dest);
		a.getTronco().setInterf(interf);
		a.getRama().setCorteza(ra_co);
		a.getRama().setCruzadas(ra_cr);
		a.getRama().setMuerteRegresiva(ra_mI);
		a.getRama().setSecas(ra_s);
		a.getRama().setMuerteRegresiva(ra_mR);
		a.getRama().setFisuradas(ra_f);
		a.getRama().setCavidades(ra_c);
		a.getRama().setExcesivas(ra_ex);
		a.getRama().setBajas(ra_b);
		a.getRama().setEpifitas(ra_ep);
		a.getRama().setFructificaciones(ra_fr);
		a.getRama().setTocones(ra_t);
		DestruccionesRama r_dest = DestruccionesRama.valueOf(ra_dest);
		InterferenciaRama r_interf = InterferenciaRama.valueOf(ra_interf);
		a.getRama().setDest(r_dest);
		a.getRama().setInterf(r_interf);
		
		HibernateDAO.getInstancia().update(a);
		return a.getId();				
		
		
	}
	
	
	
	public void modificarEspacio2(String dir,String chapaCat,String e_tC,String e_lat,String e_long,
			float e_aP,float e_lP,String e_t,boolean e_cE, int a_esp,boolean a_seco,String ar_alt,int ar_est, float ar_per,String ar_incl,String ar_ori,String co_dF, String co_cF, String co_Est,String tr_cB, String tr_cM, String tr_cA, boolean tr_co ,boolean tr_ab,
			boolean tr_desg,boolean tr_desc,boolean tr_raj,boolean tr_fr,boolean tr_ch,boolean tr_en,String tr_dest,String tr_interf, boolean ra_co,boolean ra_cr,
			boolean ra_mI,boolean ra_s,boolean ra_mR,boolean ra_f,boolean ra_c,boolean ra_ex,boolean ra_b,boolean ra_ep,
			boolean ra_fr,boolean ra_t, String ra_dest, String ra_interf){
		
		Espacio e = buscarEspacio(dir,chapaCat);
		if (e!=null){
			if(e.getTipo().toString()=="Arbol"){
				
				Tipo ti = Tipo.valueOf(e_t);
				TipoCatastral tC = TipoCatastral.valueOf(e_tC);
				
				Especie esp = new Especie();
				esp.setId(a_esp);
								
				e.setTipoCat(tC);
				e.setLatitud(e_lat);
				e.setLongitud(e_long);
				e.setAnchoPlantera(e_aP);
				e.setLargoPlantera(e_lP);
				e.setTipo(ti);
				e.setCanteroElevado(e_cE);
				e.getArbol().setSeco(a_seco);
				e.getArbol().setAltura(ar_alt);
				e.getArbol().setEstado(ar_est);
				e.getArbol().setPerimetro(ar_per);
				Inclinacion incl = Inclinacion.valueOf(ar_incl);
				Orientacion ori = Orientacion.valueOf(ar_ori);
				e.getArbol().setIncl(incl);
				e.getArbol().setOrient(ori);
				DensidadFollaje dF = DensidadFollaje.valueOf(co_dF);
				ColorFollaje cF = ColorFollaje.valueOf(co_cF);		
				EstadoCopa est = EstadoCopa.valueOf(co_Est);
				e.getArbol().getCopa().setDf(dF);
				e.getArbol().getCopa().setCf(cF);
				e.getArbol().getCopa().setEstadoCopa(est);
				CavidadBasal cB = CavidadBasal.valueOf(tr_cB);
				CavidadMedia cM = CavidadMedia.valueOf(tr_cM);
				CavidadAlta cA = CavidadAlta.valueOf(tr_cA);
				e.getArbol().getTronco().setCb(cB);
				e.getArbol().getTronco().setCm(cM);;
				e.getArbol().getTronco().setCa(cA);
				e.getArbol().getTronco().setCodominancia(ra_co);
				e.getArbol().getTronco().setAbultamientos(tr_ab);
				e.getArbol().getTronco().setDesgarrado(tr_desg);
				e.getArbol().getTronco().setDescortezamiento(tr_desc);
				e.getArbol().getTronco().setRajaduras(tr_raj);
				e.getArbol().getTronco().setFructificaciones(tr_fr);
				e.getArbol().getTronco().setChorreados(tr_ch);
				e.getArbol().getTronco().setEnredadera(tr_en);
				Destrucciones dest = Destrucciones.valueOf(tr_dest);
				Interferencia interf = Interferencia.valueOf(tr_interf);
				e.getArbol().getTronco().setDest(dest);
				e.getArbol().getTronco().setInterf(interf);
				e.getArbol().getRama().setCorteza(ra_co);
				e.getArbol().getRama().setCruzadas(ra_cr);
				e.getArbol().getRama().setMuerteRegresiva(ra_mI);
				e.getArbol().getRama().setSecas(ra_s);
				e.getArbol().getRama().setMuerteRegresiva(ra_mR);
				e.getArbol().getRama().setFisuradas(ra_f);
				e.getArbol().getRama().setCavidades(ra_c);
				e.getArbol().getRama().setExcesivas(ra_ex);
				e.getArbol().getRama().setBajas(ra_b);
				e.getArbol().getRama().setEpifitas(ra_ep);
				e.getArbol().getRama().setFructificaciones(ra_fr);
				e.getArbol().getRama().setTocones(ra_t);
				DestruccionesRama r_dest = DestruccionesRama.valueOf(ra_dest);
				InterferenciaRama r_interf = InterferenciaRama.valueOf(ra_interf);
				e.getArbol().getRama().setDest(r_dest);
				e.getArbol().getRama().setInterf(r_interf);
				
				int k = calcularEstado(e.getArbol());
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
			else{
				e.setChapaCatastral("5000");
				HibernateDAO.getInstancia().update(e);
			}
		}
			else{
			System.out.println("No Existe el Espacio");
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
	
	public Arbol buscarArbol(String idArbol){
		String sql = "select a from Arbol a join a.especie e"
				+ " where a.id = :idArbol ";
				@SuppressWarnings("unchecked")
		List<Arbol> ar = (List<Arbol>) HibernateDAO.getInstancia().parametros(sql, "idArbol", idArbol);
		for (Arbol a: ar)
			return a;
		return null;
		
	}
	
	public int calcularEstado(Arbol a){
		int k=0;
		
		
		if (a.isSeco()==Referencia.arbol_seco)
			k=20;
		// Falta Calcular
		
		return k;
	}
	
	public int crearEspacio(String dir,String chapaCat, String tipoCat,int cua, String lat, String longi,
			float anchoP, float largoP, String tipo, boolean canteroE)
			{
				Espacio e = buscarEspacio(dir,chapaCat);
				if(e==null){
				TipoCatastral tC = TipoCatastral.valueOf(tipoCat);
				Tipo ti = Tipo.valueOf(tipo);
				
				Cuadra c = new Cuadra();
				c.setId(cua);
				c = (Cuadra) HibernateDAO.getInstancia().get(Cuadra.class, c.getId());
				e = new Espacio(chapaCat, tC, c,lat, longi,anchoP,largoP,ti,canteroE);
				
				HibernateDAO.getInstancia().persistir(e);
				
				}else						
				{
						System.out.println("Existe el Espacio");
						
				}
				return e.getId();
				}	
	
}