package com.model;

	import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
    

	public class HBUtil {
	
	private static SessionFactory sesFactory;
	public static SessionFactory getSesFactory()
	{
		if(sesFactory==null)
		{
			try
			{
				StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				Metadata md=new MetadataSources(sr).buildMetadata();
				
				sesFactory = md.buildSessionFactory();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			
				
			}
						
			
		

	}
		return sesFactory;
	}
}





