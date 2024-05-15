/* Consultas:
 * ¿ se debe agregar un constructor privado para ocultar el constructor publico implicito?
 */

package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		try {
			if (sessionFactory == null) {
				StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
				Metadata metaData = new MetadataSources().buildMetadata(standardRegistry);
				sessionFactory = metaData.buildSessionFactory();
			}
		} catch (HibernateException he) {
			System.err.println("ERROR en la inicialización de la SessionFactory: " + he);
			throw new ExceptionInInitializerError(he);
		}

		return sessionFactory;
	}
}
