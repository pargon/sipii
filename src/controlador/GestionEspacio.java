package controlador;

import hbt.dao.HibernateDAO;

import java.util.List;

import negocio.Copa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.Rama;
import negocio.Tronco;
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
			
	public void crearEspacio(String dir,String chapaCat, TipoCatastral tipoCat, Cuadra cua, String lat, String longi,
			float anchoP, float largoP, Tipo tipo, boolean canteroE,Arbol a )
	{			
				Espacio e = buscarEspacio(dir,chapaCat);
				
				if (e==null){
					e = new Espacio(chapaCat, tipoCat,cua,lat, longi,anchoP,largoP,tipo,canteroE,a);
					int k=calcularEstado(a);
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
	
	
}
