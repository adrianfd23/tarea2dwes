package modelo;

import java.time.LocalDateTime;

public class Mensaje {
	public Mensaje(int id, String mensaje, LocalDateTime fechahora) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.fechahora = fechahora;
	}
	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", mensaje=" + mensaje + ", fechahora=" + fechahora + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getFechahora() {
		return fechahora;
	}
	public void setFechahora(LocalDateTime fechahora) {
		this.fechahora = fechahora;
	}
	private int id;
	private String mensaje;
	private LocalDateTime fechahora;
}
