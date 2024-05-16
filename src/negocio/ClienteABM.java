package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	private static ClienteDao dao;
	private static ClienteABM clienteABM;

	private ClienteABM() {
	}

	public static ClienteABM getInstance() {
		getInstanceDao();
		if (clienteABM == null)
			clienteABM = new ClienteABM();

		return clienteABM;
	}

	public static void getInstanceDao() {
		if (dao == null)
			dao = new ClienteDao();
	}

	// ---- traer varios ----
	public Cliente traer(long idCliente) throws Exception {
		if (idCliente == 0)
			throw new Exception("ID no puede ser 0");
		return dao.traer(idCliente);
	}

	public Cliente traer(int dni) throws Exception {
		if (dni == 0)
			throw new Exception("DNI no puede ser 0");
		return dao.traer(dni);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}

	public Cliente traerConEventos(long idCliente)
	{
		return dao.traerConEventos(idCliente);
	}
	// -------- ABM ---------
	public long agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento, boolean baja)
			throws Exception {
		if (traer(dni) != null)
			throw new Exception("Existe DNI: " + dni);
		return dao.agregar(new Cliente(apellido, nombre, dni, fechaDeNacimiento, baja));
	}

	public void modificar(Cliente c) {
		dao.actualizar(c);
	}

	public void eliminar(Cliente c) {
		dao.eliminar(c);
	}
}
