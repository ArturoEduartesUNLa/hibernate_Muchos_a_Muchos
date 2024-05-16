/*
 * Testear los métodos para cada clase:
a. agregar.
b. traer por id.
c. traer por id con la información de la lista relacionada.
d. traer todos.
e. actualizar.
f. elimina
 */
package test;

import java.time.LocalDate;
import java.time.LocalTime;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;

public class TestCliente {
	static ClienteABM abm = ClienteABM.getInstance();

	public static void main(String[] args) {
		System.out.println("UC a y b - agregar cliente y traer por id");
		
		try {
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank",123475,LocalDate.now(), false)))); // COMPLETE a y b
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank",123476,LocalDate.now(), false))));
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank",123477,LocalDate.now(), false))));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("UC c - traer por id con la información de la lista relacionada"); // COMPLETE c
		// previamente se debe agregar un evento al cliente
		Cliente c = null;
		try {
			c = abm.traerConEventos(abm.traer(123475).getIdCliente());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// agregar un evento a la lista y actualizar cliente
		c.agregar(new Evento("Importante Evento",LocalDate.now(), LocalTime.now(),null));
		abm.modificar(c);
		
		System.out.print(c);
		System.out.println(abm.traerConEventos(c.getIdCliente()).getEventos());

		System.out.println("UC d - traer todos"); 
		System.out.println(abm.traer());
	}

}
