package datos;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* COMPLETE
 * 
 */

public class Cliente {
	private long idCliente;
	private String apellido;
	private String nombre;
	private long dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	private Set<Evento> eventos;

	public Cliente() {
	}

	public Cliente(long idCliente, String apellido, String nombre, long dni, LocalDate fechaDeNacimiento,
			boolean baja) {
		super();
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = baja;
	}

	public long getIdCliente() {
		return idCliente;
	}

	private void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Set<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	public boolean agregar(Evento ev) {
		/*
		 * COMMENT forma alternativa sin condicion if y sin crear una variable de
		 * resultado return getEventos().add(ev); si lo añade devuelve true otro caso
		 * false
		 */
		boolean resultado = false;
		if (!getEventos().contains(ev))
			resultado = getEventos().add(ev);

		return resultado;
	}

	public boolean eliminar(Evento ev) {
		/*
		 * forma alternativa return getEventos().remove(ev);
		 */
		boolean result = false;
		Iterator<Evento> it = getEventos().iterator();

		while (it.hasNext() && result == false) {
			Evento evento = (Evento) it.next();
			if (ev.equals(evento))
				result = getEventos().remove(evento);
		}
		return result;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", baja=" + baja + ", evento=" + eventos + "]";
	}

}
