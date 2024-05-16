package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Evento {
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private LocalTime hora;
	private Set<Cliente> clientes;

	public Evento() {
		super();
	}

	public Evento(String evento, LocalDate fecha, LocalTime hora, Set<Cliente> clientes) {
		super();
		this.evento = evento;
		this.fecha = fecha;
		this.hora = hora;
		this.clientes = clientes;
	}

	public long getIdEvento() {
		return idEvento;
	}

	private void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientes, evento, fecha, hora, idEvento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		return Objects.equals(clientes, other.clientes) && Objects.equals(evento, other.evento)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora) && idEvento == other.idEvento;
	}

	public boolean agregar(Cliente c) {
		boolean result = false;
		if (!getClientes().contains(c))
			result = getClientes().add(c);
		return result;
	}

	public boolean eliminar(Cliente c) {
		boolean result = false;
		Iterator<Cliente> it = getClientes().iterator();
		while (it.hasNext() && !result) {
			Cliente cliente = it.next();
			if (cliente.equals(c))
				result = getClientes().remove(c);
		}
		return result;
	}

	public boolean actualizar(Cliente c) {
		boolean result = eliminar(c);
		if (result)
			result = agregar(c);
		return result;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", evento=" + evento + ", fecha=" + fecha + ", hora=" + hora + "]\n";
	}

}
