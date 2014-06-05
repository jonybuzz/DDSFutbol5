package negocio;

import negocio.inscripcion.*;

import org.joda.time.*;

public class Jugador {
	
	public DateTime nacimiento;
	private Inscripcion modo;

	public Jugador(String nombre, int anio, int mes, int dia) throws Exception{
		DateTime nac = new DateTime(anio, mes, dia, 0, 0);
		if (nac.isAfterNow())
			throw new Exception("Nacimiento Invalido!");
		else
			this.nacimiento = nac;
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

}
