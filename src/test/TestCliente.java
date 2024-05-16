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

import negocio.ClienteABM;

public class TestCliente {
	static ClienteABM abm = ClienteABM.getInstance();

	public static void main(String[] args) {
		System.out.println("UC 1 y 2 - agregar cliente sin eventos y traer por id");
		
		try {
			System.out.println((abm.traer(abm.agregar("Sinatra", "Frank",123475,LocalDate.now(), false))));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
