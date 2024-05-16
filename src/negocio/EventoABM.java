package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import dao.EventoDao;
import datos.Cliente;
import datos.Evento;

public class EventoABM {
	private static EventoDao dao;
	private static EventoABM eventoABM;

	private EventoABM() {

	}

	public static EventoABM getInstance() {
		getInstanceDao();
		if (eventoABM == null)
			eventoABM = new EventoABM();

		return eventoABM;

	}

	private static void getInstanceDao() {
		if (dao == null)
			dao = new EventoDao();
	}

	// ------ Querys to DB ------

	public Evento traer(long idEvento) {
		return dao.traer(idEvento);
	}

	public Evento traerConCliente(long idEvento) {
		return dao.traerConClientes(idEvento);
	}

	public List<Evento> traer() {
		return dao.traer();
	}

	public List<Evento> traerTodosConCliente() {
		return dao.traerAllWithClients();
	}

	// --------- ABM ------------
	public long agregar(String evento, LocalDate fecha, LocalTime hora, Set<Cliente> clientes) {
		long idEvento = 0;
		/*
		 * primero guardamos el evento y luego que tenemos el idEvento los clientes
		 * contenidos en el set
		 * 
		 */
		idEvento = dao.agregar(new Evento(evento, fecha, hora, null));
		if (idEvento != 0 && clientes != null) {
			// recuperamos Evento recien guardado
			Evento e = traer(idEvento);
			for (Cliente cliente : clientes) {
				cliente.agregar(e);
			}
			e.setClientes(clientes);
			actualizar(e);
		}
		return idEvento;
	}

	public void actualizar(Evento e) {
		dao.actualizar(e);
	}

	public void eliminar(Evento e) {
		dao.eliminar(e);
	}
}
