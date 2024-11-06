package modelo;

import java.time.LocalDate;

public class Planta {
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombrecientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public Planta(String codigo, String nombreComun, String nombreCientifico) {
		super();
		this.codigo = codigo;
		this.nombreComun = nombreComun;
		this.nombreCientifico = nombreCientifico;
	}

	private String codigo;
	private String nombreComun;
	private String nombreCientifico;

	@Override
	public String toString() {
		return "Planta [codigo=" + codigo + ", nombrecomun=" + nombreComun + ", nombrecientifico=" + nombreCientifico
				+ "]";
	}
}
