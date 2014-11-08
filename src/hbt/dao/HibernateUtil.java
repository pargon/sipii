package hbt.dao;


import negocio.Calle;
import negocio.Copa;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



@SuppressWarnings("deprecation")
public class HibernateUtil
{
	private static final SessionFactory sessionFactory;

	static
	{
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Copa.class);
			
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
