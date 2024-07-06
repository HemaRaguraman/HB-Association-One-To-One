package com.model;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Test {

	public static void main(String[] args)
	{
		Transaction tr=null;
		
		
		try(Session ses=HBUtil.getSesFactory().openSession())
		{
			tr=ses.beginTransaction();
			Employee e=new Employee();
			e.setName("Santhosh");
			e.setEmail("kumar@gmail.com");
			Address a=new Address("MKCE","Salem road","Karur","TamilNadu",639002);
			e.setAddr(a);
			a.setE(e);
			ses.merge(e);
			
			tr.commit();
			ses.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	

	
}
