package negocio;

import org.joda.time.*;

public class Jugador {
	
	public DateTime nacimiento;
	private Period edad;
	private String comentarioActual;

	public Jugador(String nombre, int anio, int mes, int dia){
		this.nacimiento = new DateTime(anio, mes, dia, 0, 0);
		this.edad = new Interval(nacimiento, DateTime.now()).toPeriod();  //con meses, dias, seg etc		
	}
	
	public int edad(){                                                                                                                                                                         

		return this.edad.toPeriod().getYears();
	}

	public void inscribirme(Partido partido, int modo, String comentario) throws Exception{
		partido.agregarJugador(this, modo);
		this.comentarioActual = comentario;
	}
	
	public void inscribirme(Partido partido, int modo) throws Exception{
		partido.agregarJugador(this, modo);
	}

	public String getComentarioActual() {
		return comentarioActual;
	}


}
