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
			
	public void crearEspacio(String dir, String chapaCat, TipoCatastral tipoCat, Cuadra cua, String lat, String longi,
			float anchoP, float largoP, Tipo tipo, boolean canteroE,Copa co, Tronco tr, Rama ra,
			boolean seco, String alt, int est, float perim,	Inclinacion incl, Orientacion orient )
	{			
				List<Especie> listesp = buscarEspecie();
				Espacio e = buscarEspacio(dir,chapaCat);
				
				if (e==null){
					Especie esp = (Especie) listesp;
					Arbol a = new Arbol(esp, co, tr ,ra, seco, alt, est, perim,incl, orient);
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
				}
		}
	
	public Espacio buscarEspacio(String dir, String chapa){
		String sql = "from espacio e join cuadra c join calle d "
				+ " where e.chapaCatastral := chap "
				+ " and d.nombre := dir";
		List<Espacio> le = (List<Espacio>) HibernateDAO.getInstancia().parametros2(sql, "chap", chapa, "dir", dir);
		return le.get(0);	
	}

	public List<Especie> buscarEspecie(){
		String sql = "from Especie";
		List<Especie> l_esp = (List<Especie>) HibernateDAO.getInstancia().getlista(sql);
		return l_esp;
	}
	
	public int calcularEstado(Arbol a){
		int k=0;
	
		// Falta Calcular
		
		return k;
	}
	
	
}
