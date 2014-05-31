package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.joda.time.*;

public class Partido {
	
	public DateTime fechaHora;
	public LinkedList<Jugador> inscriptos;
//	public LinkedListConTope<Jugador> inscriptosEstandar;
//	public LinkedList<Jugador> inscriptosSolidario;
//	public LinkedList<Jugador> inscriptosCondicional;
	public boolean completo;
	public ArrayList<Jugador> equipoA;
	public ArrayList<Jugador> equipoB;


	public Partido(int anio, int mes, int dia, int hora, int minutos){
		
		this.fechaHora = new DateTime(anio, mes, dia, hora, minutos);
		this.completo = false;
		inscriptos = new LinkedList<Jugador>();
		
		equipoA = new ArrayList<Jugador>(5);
		equipoB = new ArrayList<Jugador>(5);
	}
	
	
	public void agregarJugador(Jugador jugador) throws Exception{
		
		this.inscriptos.addLast(jugador);
					
	}
	
	public boolean estaCompleto(){
		
		Iterator<Jugador> it = this.inscriptos.iterator();
		int confirmadosEstandar = 0;
		while(it.hasNext()){
			
			Jugador jug = it.next();
			if(jug.getModoDeInscripcion().prioridad == 1){
				confirmadosEstandar ++;
			}
		}
		if (confirmadosEstandar == 10)
			return true;
		else return false;
	}


	public void borrar(Jugador jugador) {
		this.inscriptos.remove(jugador);
	}

}
