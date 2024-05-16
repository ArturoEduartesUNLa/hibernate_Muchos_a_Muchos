package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Evento;

public class EventoDao {
	private static Session session;
	private static Transaction tx;
	private static EventoDao eventoDao;

	private EventoDao() {

	}

	public static EventoDao getInstance() {
		if (eventoDao == null)
			eventoDao = new EventoDao();
		return eventoDao;
	}

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de datos " + he);

	}

	// ------------ ABM ----------

	public long agregar(Evento e) {
		long id = 0;
		try {
			iniciaOperacion();
			id = (long) session.save(e);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;

	}

	public void actualizar(Evento e) {
		try {
			iniciaOperacion();
			session.update(e);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}

	}

	public void eliminar(Evento e) {
		try {
			iniciaOperacion();
			session.delete(e);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// --------- Querys DB ------

	public Evento traer(long idEvento) {
		Evento e = null;
		try {
			e = session.createNamedQuery("from Evento e where e.idEvento = :idEvento", Evento.class)
					.setParameter("idEvento", idEvento).uniqueResult();
		} finally {
			session.close();
		}
		return e;
	}

	public Evento traerConClientes(long idEvento) {
		Evento e = null;
		try {
			iniciaOperacion();
			e = session.createQuery("from Evento e left join fetch e.clientes c where e.idEvento = :idEvento",
					Evento.class).setParameter("idevento", idEvento).uniqueResult();

		} finally {
			session.close();
		}
		return e;

	}
}
