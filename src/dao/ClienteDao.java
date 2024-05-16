package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cliente;

/*COMPLETE
 * 
 */

public class ClienteDao {
	private static Session session;
	private static Transaction tx;

	private static void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de datos: " + he);
	}

	// ------- ABM -----
	public long agregar(Cliente c) {
		long id = 0;
		try {
			iniciaOperacion();
			id = (long) session.save(c);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Cliente c) {
		try {
			iniciaOperacion();
			session.update(c);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(Cliente c) {
		try {
			iniciaOperacion();
			session.delete(c);
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// ------- Consultas -----
	public Cliente traer(long id) {
		Cliente c;
		try {
			iniciaOperacion();
			c = session.createQuery("from Cliente c where c.idCliente = :IDCliente", Cliente.class)
					.setParameter("IDCliente", id).uniqueResult();
		} finally {
			session.close();
		}
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c;
		try {
			iniciaOperacion();
			c = session.createQuery("from Cliente c where c.dni = :dniClie", Cliente.class).setParameter("dniClie", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return c;
	}

	public List<Cliente> traer() {
		List<Cliente> lista;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Cliente c order by c.idCliente", Cliente.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Cliente traerConEventos(long idCliente) {
		Cliente c = null;
		try {
			iniciaOperacion();
			c = session.createQuery("from Cliente c left join fetch c.eventos e where c.idCliente = :idCliente",
					Cliente.class).setParameter("idCliente", idCliente).uniqueResult();
		} finally {
			session.close();
		}
		return c;

	}

}
