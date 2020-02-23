package org.studyeasy.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class App {

  public static void main(String[] args) {
	  
	  SessionFactory factory = new Configuration()
			                   .configure("hibernate.cfg.xml")
			                   .addAnnotatedClass(Users.class)
			                   .buildSessionFactory();
	  
	  Session session = factory.getCurrentSession();
	  
	  try {
		  // Start transaction
		  session.beginTransaction();
		  
		  List<Users> users = session.createQuery("from users where firstName = 'salim'"
		  		+ "OR last_name like '%a%n%'") // burada olduğu gibi querymizi yazabiliyoruz buradaki table isimlerimiz entity classımızdaki isimler de olabilir columnun gerçek isimleri de olabilir o işi hibernate hallediyor
				  .getResultList();
		  
		  for (Users temp : users) {
			System.out.println(temp);
		}
	
	} finally {
		session.close();
		factory.close();
	}
	
}
}






