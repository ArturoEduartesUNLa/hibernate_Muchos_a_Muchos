package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;

public class TestCliente {
	static ClienteABM abm = ClienteABM.getInstance();

	public static void main(String[] args) {

		try {
			System.out.println("UC a y b - agregar cliente y traer por id");
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank", 123475, LocalDate.now(), false)))); // COMPLETE
																												// a y b
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank", 123476, LocalDate.now(), false))));
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank", 123477, LocalDate.now(), false))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("UC c - traer por id con la información de la lista relacionada"); // COMPLETE c
		// previamente se debe agregar un evento al cliente
		Cliente c = null;
		try {
			c = abm.traerConEventos(abm.traer(123475).getIdCliente());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// agregar un evento a la lista y actualizar cliente
		c.agregar(new Evento("Importante Evento", LocalDate.now(), LocalTime.now(), null));
		c.setApellido("Mozart");
		abm.modificar(c); // COMPLETE e actualizar cliente y añadido un evento

		System.out.print(c);
		System.out.println(abm.traerConEventos(c.getIdCliente()).getEventos());

		System.out.println("UC d - traer todos"); // COMPLETE d
		System.out.println(abm.traer());

		try {
			c = abm.traer(123476); // sin eventos asociados
			System.out.println("UC f - eliminar cliente sin eventos asociados:" + c); // COMPLETE d
			abm.eliminar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			c = abm.traer(123475); // traer sin eventos asociados
			/*
			 * COMMENT elimina el cliente y la entrada en la tabla intermedia aunque el
			 * evento no se elimina de la tabla evento
			 */
			System.out.println("UC f - eliminar cliente con eventos asociados:" + c); // COMPLETE f
			abm.eliminar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("UC g - traer todos los clientes y eventos:"); // COMPLETE f

		abm.traerTodosClientesyEventos().forEach(t -> System.out.println(t + "" + t.getEventos()));

	}

}
