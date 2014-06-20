package negocio;

import org.joda.time.DateTime;

public class Infraccion {

	private DateTime fecha;
	private String motivo;

	public Infraccion(DateTime fecha, String motivo) {
		this.setFecha(fecha);
		this.setMotivo(motivo);
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public DateTime getFecha() {
		return fecha;
	}

	public void setFecha(DateTime fecha) {
		this.fecha = fecha;
	}
}
