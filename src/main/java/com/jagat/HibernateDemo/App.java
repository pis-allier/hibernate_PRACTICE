package com.jagat.HibernateDemo;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// insert into databse

		HibernateStudnetDemo st = new HibernateStudnetDemo();
		st.setId(35);
		st.setName("freeman");
		st.setLastname("shwshank redemption");
		Configuration con = new Configuration().configure().addAnnotatedClass(HibernateStudnetDemo.class);
		ServiceRegistry reg  =  new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		tx.commit();

// ---------------------------------------------------------------------------------------------------------------------		

		// to fetch data from databse
		HibernateStudnetDemo s = new HibernateStudnetDemo();
		Configuration con1 = new Configuration().configure().addAnnotatedClass(HibernateStudnetDemo.class);
		ServiceRegistry reg1 = new ServiceRegistryBuilder().applySettings(con1.getProperties()).buildServiceRegistry();
		SessionFactory sf1 = con.buildSessionFactory(reg1);
		Session session1 = sf1.openSession();
		Transaction tx1 = session.beginTransaction();
		s = (HibernateStudnetDemo) session1.get(HibernateStudnetDemo.class, 333);
		tx1.commit();
		System.out.println(s + "object retrieved from database ");
//---------------------------------------------------------------------------------------------------------------------------
		// save embedded objects

		AlienName a = new AlienName();
		a.setfName("jagat kumar prithvirajj");
		a.setmName("chattrapati");
		a.setlName("vishvavijayi");

		Alien an = new Alien();
		an.setId(555);
		an.setColor("black");
		an.setName(a);

		Configuration con2 = new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg2 = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf2 = con.buildSessionFactory(reg);
		Session session2 = sf.openSession();
		Transaction tx2 = session.beginTransaction();
		session2.save(an);
		tx2.commit();
		System.out.println("tarnsaction completed for embedded obnjectsavibng to databse ");

//------------------------------------------------------------------------------------------------------------------------

		Configuration con3 = new Configuration().configure().addAnnotatedClass(HibernateStudnetDemo.class);
		ServiceRegistry reg3 = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf3 = con.buildSessionFactory(reg);
		Session session3 = sf.openSession();
		Transaction tx3 = session.beginTransaction();

		// below code was added just to insert 50 values in tabl
//		Random rm = new Random();
//		for (int i = 1; i < 50; i++) {
//
//			HibernateStudnetDemo st = new HibernateStudnetDemo();
//			st.setId(i);
//			st.setName("name" + i);
//			st.setLastname("lastname " + rm.nextInt(100));
//			session.save(st);
//		}

		// for hql create query object then just give from clause with entity name it
		// will give all records
		Query q = session.createQuery("from HibernateStudnetDemo");
		// now to fetch value use q.list();
		List<HibernateStudnetDemo> listOfAllREcords = q.list();

		listOfAllREcords.stream().forEach(System.out::println);

		// list of records id> 45
		Query q2 = session.createQuery("from HibernateStudnetDemo where id > 45");
		List<HibernateStudnetDemo> listOfGreaterThna45 = q2.list();
		listOfGreaterThna45.stream().forEach(System.out::println);

		// for fetching unique result
		Query q3 = session.createQuery("from HibernateStudnetDemo where id=45");
		HibernateStudnetDemo uniqueResult = (HibernateStudnetDemo) q3.uniqueResult();
		System.out.println("unique result query result ==========>" + uniqueResult.toString());

		// if want to use select clausae in querry then type case it with object[]

		Query q4 = session.createQuery("select lastname, name from HibernateStudnetDemo where id=45");
		Object[] objResult = (Object[]) q4.uniqueResult();
		for (Object o : objResult) {
			System.out.println(o + "results");
		}

		// lets use native sql query with hibernate HQLgive actual table name in query
		System.out.println("--------------------------------");
		SQLQuery q5 = session.createSQLQuery("select * from demo_hibernate where id>48");
		q5.addEntity(HibernateStudnetDemo.class);
		List<HibernateStudnetDemo> listOfStudent = q5.list();
		for (HibernateStudnetDemo sr : listOfStudent) {
			System.out.println(sr);
		}

		tx.commit();

	}
}
