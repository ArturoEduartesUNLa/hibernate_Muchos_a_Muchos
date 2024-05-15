package test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;

public class TestHBM {

	//COMPLETE
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(tx.getStatus());
		session.close();
		System.out.println("Ok connection");
		

	}

}
