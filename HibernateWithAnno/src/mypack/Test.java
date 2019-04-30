package mypack;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Test {

	public static void main(String[] args) {
		Emp e = new Emp();
		e.setDname("vikash   ");
		e.setCmpname("zoho");
	Session s =	new AnnotationConfiguration().configure("mypack/hibernate.cfg.xml").buildSessionFactory().openSession();
	Transaction t =	s.beginTransaction();
	int i =(Integer)s.save(e);
	/*t.commit();
	if(i>0)
		System.out.println("Data Inseted");
	else
		System.out.println("Data Not inserted");*/
	  Query query	= s.createQuery("select id,dname,cmpname from Emp");
	  List list = query.list();
	  Iterator itr = list.iterator();
	  int i1=0;
	  while(itr.hasNext()) {
		 Object emp[]= (Object[])itr.next();
		 for(i1=0;i1<3;i1++)
		 {
			 System.out.println(emp[i1]);
		 }
	  }
		
	}

}
