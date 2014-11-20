
package controlador;

import hbt.dao.HibernateDAO;

import java.util.ArrayList;
import java.util.List;

import Beans.bEspacio;
import Beans.bOrdendeServicio;
import Beans.bReclamo;
import negocio.Copa;
import negocio.Copa.ColorFollaje;
import negocio.Copa.DensidadFollaje;
import negocio.Copa.EstadoCopa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.Mantenimiento;
import negocio.OrdendeServicio;
import negocio.Rama;
import negocio.Reclamo;
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
	public int crearArbol(int esp, String ar_alt,int ar_est, float ar_per,String ar_incl,String ar_ori,String co_dF, String co_cF, String co_Est,
			String tr_cB, String tr_cM, String tr_cA,String tr_dest,String tr_interf,
		 String ra_dest, String ra_interf, String [] Atributos){
						
		boolean ar_s =false;
		boolean tr_co = false;
		boolean tr_ab =false;
		boolean tr_desg=false;
		boolean tr_desc=false;
		boolean tr_raj=false;
		boolean tr_fr=false;
		boolean tr_ch=false;
		boolean tr_en=false;
		boolean ra_co=false;
		boolean ra_cr=false;
		boolean ra_mI=false;
		boolean ra_s=false;
		boolean ra_mR=false;
		boolean ra_f=false;
		boolean ra_c=false;
		boolean ra_ex=false;
	    boolean ra_b=false;
	    boolean ra_ep=false;
	    boolean ra_fr=false;
	    boolean ra_t=false;
		
				
		for( String att: Atributos){
			 if( att.equals("ar_s"))
				 ar_s = true;
			 if(att.equals("tr_co"))
				 tr_co = true;
			 if(att.equals("tr_ab"))
				 tr_ab= true;
			 if(att.equals("tr_desg"))
				 tr_desg= true;
			 if(att.equals("tr_desc"))
				 tr_desc= true;
			 if(att.equals("tr_raj"))
				 tr_raj= true;
			 if(att.equals("tr_fr"))
				 tr_fr= true;
			 if(att.equals("tr_ch"))
				 tr_ch= true;
			 if(att.equals("tr_en"))
				 tr_en = true;
			 if(att.equals("ra_co"))
				 ra_co= true;
			 if(att.equals("ra_cr"))
				 ra_cr= true;
			 if(att.equals("ra_mI"))
				 ra_mI= true;
			 if(att.equals("ra_s"))
				 ra_s= true;
			 if(att.equals("ra_mR"))
				 ra_mR= true;
			 if(att.equals("ra_f"))
				 ra_f= true;
			 if(att.equals("ra_c"))
				 ra_c= true;
			 if(att.equals("ra_ex"))
				 ra_ex= true;	
			 if(att.equals("ra_b"))
				 ra_b= true;
			 if(att.equals("ra_ep"))
				 ra_ep= true;
			 if(att.equals("ra_fr"))
				 ra_fr= true;
			 if(att.equals("ra_t"))
				 ra_t= true;
			   			 
		}
		
		
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
	
	public void modificarEspacio3(String dir,String chapaCat,String e_t,String ar_alt,int ar_est, float ar_per,String ar_incl,
			String ar_ori,String co_dF, String co_cF, String co_Est,String tr_cB, String tr_cM, String tr_cA,
			String tr_dest,String tr_interf, String ra_dest, String ra_interf, String []atributos){
		
		boolean ar_s =false;
		boolean tr_co = false;
		boolean tr_ab =false;
		boolean tr_desg=false;
		boolean tr_desc=false;
		boolean tr_raj=false;
		boolean tr_fr=false;
		boolean tr_ch=false;
		boolean tr_en=false;
		boolean ra_co=false;
		boolean ra_cr=false;
		boolean ra_mI=false;
		boolean ra_s=false;
		boolean ra_mR=false;
		boolean ra_f=false;
		boolean ra_c=false;
		boolean ra_ex=false;
	    boolean ra_b=false;
	    boolean ra_ep=false;
	    boolean ra_fr=false;
	    boolean ra_t=false;
		
				
		for( String att: atributos){
			 if( att.equals("ar_s"))
				 ar_s = true;
			 if(att.equals("tr_co"))
				 tr_co = true;
			 if(att.equals("tr_ab"))
				 tr_ab= true;
			 if(att.equals("tr_desg"))
				 tr_desg= true;
			 if(att.equals("tr_desc"))
				 tr_desc= true;
			 if(att.equals("tr_raj"))
				 tr_raj= true;
			 if(att.equals("tr_fr"))
				 tr_fr= true;
			 if(att.equals("tr_ch"))
				 tr_ch= true;
			 if(att.equals("tr_en"))
				 tr_en = true;
			 if(att.equals("ra_co"))
				 ra_co= true;
			 if(att.equals("ra_cr"))
				 ra_cr= true;
			 if(att.equals("ra_mI"))
				 ra_mI= true;
			 if(att.equals("ra_s"))
				 ra_s= true;
			 if(att.equals("ra_mR"))
				 ra_mR= true;
			 if(att.equals("ra_f"))
				 ra_f= true;
			 if(att.equals("ra_c"))
				 ra_c= true;
			 if(att.equals("ra_ex"))
				 ra_ex= true;	
			 if(att.equals("ra_b"))
				 ra_b= true;
			 if(att.equals("ra_ep"))
				 ra_ep= true;
			 if(att.equals("ra_fr"))
				 ra_fr= true;
			 if(att.equals("ra_t"))
				 ra_t= true;
		}
		
		Espacio e = buscarEspacio(dir,chapaCat);
		e= (Espacio) HibernateDAO.getInstancia().get(Espacio.class, e.getId());
		
				Tipo ti = Tipo.valueOf(e_t);
							
				e.setTipo(ti);
				e.getArbol().setPerimetro(ar_per);
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
				Destrucciones dest = Destrucciones.valueOf(tr_dest);
				Interferencia interf = Interferencia.valueOf(tr_interf);
				e.getArbol().getTronco().setDest(dest);
				e.getArbol().getTronco().setInterf(interf);
				DestruccionesRama r_dest = DestruccionesRama.valueOf(ra_dest);
				InterferenciaRama r_interf = InterferenciaRama.valueOf(ra_interf);
				e.getArbol().getRama().setDest(r_dest);
				e.getArbol().getRama().setInterf(r_interf);
				
				e.getArbol().setSeco(ar_s);
				e.getArbol().getTronco().setCodominancia(tr_co);
				e.getArbol().getTronco().setAbultamientos(tr_ab);
				e.getArbol().getTronco().setDesgarrado(tr_desg);
				e.getArbol().getTronco().setDescortezamiento(tr_desc);
				e.getArbol().getTronco().setRajaduras(tr_raj);
				e.getArbol().getTronco().setFructificaciones(tr_fr);
				e.getArbol().getTronco().setChorreados(tr_ch);
				e.getArbol().getTronco().setEnredadera(tr_en);
				e.getArbol().getRama().setCorteza(ra_co);
				e.getArbol().getRama().setMalInsertadas(ra_mI);
				e.getArbol().getRama().setSecas(ra_s);
				e.getArbol().getRama().setMuerteRegresiva(ra_mR);
				e.getArbol().getRama().setFisuradas(ra_f);
				e.getArbol().getRama().setCavidades(ra_c);
				e.getArbol().getRama().setExcesivas(ra_ex);
				e.getArbol().getRama().setBajas(ra_b);
				e.getArbol().getRama().setEpifitas(ra_ep);
				e.getArbol().getRama().setFructificaciones(ra_fr);
				e.getArbol().getRama().setTocones(ra_t);
				e.getArbol().getRama().setCruzadas(ra_cr);
				
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
	
	public int crearEspacio(String dir,String chapaCat, String tipoCat, String lat, String longi,
			float anchoP, float largoP, String tipo, boolean canteroE)
			{
				Espacio e = buscarEspacio(dir,chapaCat);
				if(e==null){
				TipoCatastral tC = TipoCatastral.valueOf(tipoCat);
				Tipo ti = Tipo.valueOf(tipo);
				Cuadra c = buscaCuadra(dir, chapaCat);
				//Cuadra c = new Cuadra();
				//c.setId(cua);
				//c = (Cuadra) HibernateDAO.getInstancia().get(Cuadra.class, c.getId());
				e = new Espacio(chapaCat, tC, c,lat, longi,anchoP,largoP,ti,canteroE);
				
				HibernateDAO.getInstancia().persistir(e);
				
				}else						
				{
						System.out.println("Existe el Espacio");
						
				}
				return e.getId();
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

	public int crearArbol() {
		// TODO Auto-generated method stub
		Arbol a = new Arbol();
		HibernateDAO.getInstancia().persistir(a);
		return a.getId();
	}

	private Cuadra buscaCuadra(String dir, String chapaCat) {
        String sql = "select cua "
                        + " from Cuadra as cua "
                        + " join cua.calle as cal "
                        + " where cal.nombre =:calle "
                        + " and cua.alturaDesde <= :chapa "
                        + " and cua.alturaHasta >= :chapa "        ;
        List<Cuadra> lc = (List<Cuadra>) HibernateDAO.getInstancia().parametros2(sql, "calle", dir, "chapa", Integer.valueOf(chapaCat));
        
        for(Cuadra c: lc)
                return c;
        return null;
         
}
	
	public bEspacio buscarBEspacio(String dir, String chapa){
		String sql = "select e from Espacio e join e.cuadra c join c.calle d "
				+ " where e.chapaCatastral = :chap "
				+ " and d.nombre = :dir";
		@SuppressWarnings("unchecked")
		List<Espacio> le = (List<Espacio>) HibernateDAO.getInstancia().parametros2(sql, "chap", chapa, "dir", dir);
		
		
		for (Espacio e: le){
			bEspacio be =new bEspacio(e.getId(),
					e.getTipo(),
					e.getCuadra().getCalle(),	
					e.getChapaCatastral(),
					e.getEst(), 
					e.getTipoCat(),
					e.getCuadra().getId(),
					e.getLatitud(),
					e.getLongitud(),
					e.getAnchoPlantera(), 
					e.getLargoPlantera(),
					e.isCanteroElevado(),
					e.getArbol().getEspecie(),
					e.getArbol().getAltura(),
					e.getArbol().getEstado(),
					e.getArbol().getPerimetro(),
					e.getArbol().getIncl(),
					e.getArbol().getOrient(),
					e.getArbol().getCopa().getDf(),
					e.getArbol().getCopa().getCf(),
					e.getArbol().getCopa().getEstado(),
					e.getArbol().getTronco().getCb(),
					e.getArbol().getTronco().getCm(),
					e.getArbol().getTronco().getCa(),
					e.getArbol().getTronco().getDest(),
					e.getArbol().getTronco().getInterf(),
					e.getArbol().getRama().getDest(),
					e.getArbol().getRama().getInterf(),
					e.getArbol().isSeco(),
					e.getArbol().getTronco().isCodominancia(),
					e.getArbol().getTronco().isAbultamientos(),
					e.getArbol().getTronco().isDesgarrado(),
					e.getArbol().getTronco().isDescortezamiento(),
					e.getArbol().getTronco().isRajaduras(),
					e.getArbol().getTronco().isFructificaciones(),
					e.getArbol().getTronco().isChorreados(),
					e.getArbol().getTronco().isEnredadera(),
					e.getArbol().getRama().isCorteza(),
					e.getArbol().getRama().isCruzadas(),
					e.getArbol().getRama().isMalInsertadas(),
					e.getArbol().getRama().isSecas(),
					e.getArbol().getRama().isMuerteRegresiva(),
					e.getArbol().getRama().isFisuradas(),
					e.getArbol().getRama().isCavidades(),
					e.getArbol().getRama().isExcesivas(),
					e.getArbol().getRama().isBajas(),
					e.getArbol().getRama().isEpifitas(),
					e.getArbol().getRama().isFructificaciones(),
					e.getArbol().getTronco().isRajaduras());	
					}
					
		return be;
		
		
	}
	
	public List<bReclamo> mostrarRec() {
		List<bReclamo> lbo = new ArrayList<>();
		
		List<Reclamo> los = (List<Reclamo>) HibernateDAO.getInstancia().getlista("from Reclamo") ;
			
		for(Reclamo os:los){
			OrdendeServicio ods = os.getM_OrdendeServicio();
			
			Usuario tec = os.getTecnico();
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