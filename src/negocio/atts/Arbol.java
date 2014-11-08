package negocio.atts;

import negocio.ppal.Espacio;
import negocio.ppal.OrdendeServicio;


/**
 * @author gon
 * @version 1.0
 * @created 04-nov-2014 08:27:09 p.m.
 */
public class Arbol extends Espacio {

	public OrdendeServicio m_OrdendeServicio;
	public Id m_Id;
	public Epifitas m_Epifitas;
	public Fructificaciones m_Fructificaciones;
	public Tocones m_Tocones;
	public CavidadBasal m_CavidadBasal;
	public CavidadMedia m_CavidadMedia;
	public CavidadAlta m_CavidadAlta;
	public Codominancia m_Codominancia;
	public Abultamientos m_Abultamientos;
	public Desgarrado m_Desgarrado;
	public Descortezamiento m_Descortezamiento;
	public Rajaduras m_Rajaduras;
	public Chorreados m_Chorreados;
	public CubXEnredadera m_CubXEnredadera;
	public DestrucIntenc m_DestrucIntenc;
	public Interferencia m_Interferencia;
	public DensFollaje m_DensFollaje;
	public ColorFollaje m_ColorFollaje;
	public Estado m_Estado;
	public Inclinacion m_Inclinacion;
	public OrientInclinac m_OrientInclinac;
	public CortezIncluida m_CortezIncluida;
	public Cruzadas m_Cruzadas;
	public MalInsertadas m_MalInsertadas;
	public Secas m_Secas;
	public MuerteRegr m_MuerteRegr;
	public Fisuradas m_Fisuradas;
	public Cavidades m_Cavidades;
	public Excesivas m_Excesivas;
	public Bajas m_Bajas;
	public Interferencias m_Interferencias;
	public DanosIntenc m_DanosIntenc;
	public CuelloVisible m_CuelloVisible;
	public RaicesSuperf m_RaicesSuperf;
	public RaicesEspiral m_RaicesEspiral;
	public RaicesDanadas m_RaicesDanadas;
	public DanosRaizAProp m_DanosRaizAProp;
	public SupDanosXRaizAProp m_SupDanosXRaizAProp;

	public Arbol(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Arbol