package negocio;

import java.util.LinkedList;

import org.joda.time.*;

public class Partido {
	
	public DateTime momento;
	public LinkedListConTope<Jugador> inscriptosEstandar;
	public LinkedList<Jugador> inscriptosSolidario;
	public LinkedList<Jugador> inscriptosCondicional;
	private boolean listo;


	public Partido(int anio, int mes, int dia, int hora, int minutos){
		
		this.momento = new DateTime(anio, mes, dia, hora, minutos);
		this.listo = false;
		inscriptosEstandar    = new LinkedListConTope<Jugador>(10);
		inscriptosSolidario   = new LinkedList<Jugador>();
		inscriptosCondicional = new LinkedList<Jugador>();		
	}
	
	
	public boolean agregarJugador(Jugador jugador, int modo) throws Exception{
		
		if (modo<4 && modo>0)
		{
			switch(modo)
			{
				case 1: inscriptosEstandar.agregar(jugador); //si ya tiene 10 tira excepcion
					if (inscriptosEstandar.size()==10)
						listo = true;
					return true;
				case 2: return inscriptosSolidario.add(jugador);
				case 3: return inscriptosCondicional.add(jugador);
				default: return false;
			}

		}else throw new Exception("Modo (1,2,3) invalido");
					
	}

	public boolean listo() {
		return this.listo;
	}


	public int cantInscriptosEstandar() {
		return inscriptosEstandar.size();
	}

	public int cantInscriptosSolidario() {
		return inscriptosSolidario.size();
	}

	public int cantInscriptosCondicional() {
		return inscriptosCondicional.size();
	}


}
