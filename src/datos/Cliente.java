package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Cliente {
private long idCliente;
private String apellido;
private String nombre;
private long dni;
private LocalDate fechaDeNacimiento;
private boolean baja;
private Set<Evento> eventos;


public Cliente() {
	super();
}


public Cliente(String apellido, String nombre, long dni, LocalDate fechaDeNacimiento, boolean baja, Set<Evento> eventos) {
	super();
	this.apellido = apellido;
	this.nombre = nombre;
	this.dni = dni;
	this.fechaDeNacimiento = fechaDeNacimiento;
	this.baja = baja;
	this.eventos = eventos;
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
	return Objects.hash(apellido, baja, dni, eventos, fechaDeNacimiento, idCliente, nombre);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!(obj instanceof Cliente))
		return false;
	Cliente other = (Cliente) obj;
	return Objects.equals(apellido, other.apellido) && baja == other.baja && dni == other.dni
			&& Objects.equals(eventos, other.eventos) && Objects.equals(fechaDeNacimiento, other.fechaDeNacimiento)
			&& idCliente == other.idCliente && Objects.equals(nombre, other.nombre);
}


@Override
public String toString() {
	return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
			+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", baja=" + baja + ", evento=" + eventos + "]";
}



}
