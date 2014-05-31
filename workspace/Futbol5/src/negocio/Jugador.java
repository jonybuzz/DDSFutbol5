package negocio;

import negocio.inscripcion.*;

import org.joda.time.*;

public class Jugador {
	
	public DateTime nacimiento;
	private String condicion;
	private Inscripcion modo;

	public Jugador(String nombre, int anio, int mes, int dia){
		this.nacimiento = new DateTime(anio, mes, dia, 0, 0);
		this.modo = new Estandar();
	}
	
	public int edad(){
		return new Interval(nacimiento, DateTime.now()).toPeriod().getYears();
	}
	
	public Inscripcion getModoDeInscripcion() {
		return modo;
	}

	public void modoDeInscrpcion(Inscripcion modo) {
		this.modo = modo;
	}

	public void inscribirme(Partido partido) throws Exception{		
		this.modo.inscribir(this, partido);
	}

	public String getCondicion() {
		return condicion;
	}


}
