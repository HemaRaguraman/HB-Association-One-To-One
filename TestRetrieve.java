package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestRetrieve {

	public static void main(String[] args)
	{
		Transaction tr=null;
		
		
		try(Session ses=HBUtil.getSesFactory().openSession())
		{
			tr=ses.beginTransaction();
			Query<Employee> qry=ses.createQuery("from Employee",Employee.class);
			List<Employee> li=qry.list();
			for(Employee e:li)
			{
				System.out.println(e.getEmpId()+"\t"+e.getName()+"\t"+e.getEmail()+"\t");
				Address ad=e.getAddr();
				System.out.println("Address is"+" "+ad.getLine1()+","+ad.getLine2()+","+ad.getCity()+","+ad.getState()+","+ad.getPin());
			}
			
			tr.commit();
			ses.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
}
