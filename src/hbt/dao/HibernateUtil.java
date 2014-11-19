package hbt.dao;


import negocio.Arbol;
import negocio.Calle;
import negocio.Ciudadano;
import negocio.Copa;
import negocio.Cuadra;
import negocio.Espacio;
import negocio.Especie;
import negocio.Mantenimiento;
import negocio.OrdendeServicio;
import negocio.Reclamo;
import negocio.TareaTipo;
import negocio.Tronco;
import negocio.Rama;
import negocio.Usuario;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import controlador.GestionOServicio;
import controlador.Sesion;



@SuppressWarnings("deprecation")
public class HibernateUtil
{
	private static final SessionFactory sessionFactory;

	static
	{
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Arbol.class);
			config.addAnnotatedClass(Calle.class);
			config.addAnnotatedClass(Ciudadano.class);
			config.addAnnotatedClass(Cuadra.class);
			config.addAnnotatedClass(Espacio.class);
			config.addAnnotatedClass(Especie.class);
			config.addAnnotatedClass(Mantenimiento.class);
			config.addAnnotatedClass(OrdendeServicio.class);
			config.addAnnotatedClass(Reclamo.class);
			config.addAnnotatedClass(TareaTipo.class);
			config.addAnnotatedClass(Usuario.class);
			config.addAnnotatedClass(Sesion.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
