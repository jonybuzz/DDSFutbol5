package negocio;

import org.joda.time.DateTime;

public class Infraccion {

	private DateTime fecha;
	private String motivo;

	public Infraccion(DateTime fecha, String motivo) {
		this.fecha = fecha;
		this.motivo = motivo;
	}
}
