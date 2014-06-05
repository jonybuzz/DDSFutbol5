package negocio;

import java.util.ArrayList;
//import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import org.joda.time.*;

public class Partido{
	
	public DateTime fechaHora;
	public LinkedList<Jugador> inscriptos;
	public ArrayList<Jugador> equipoA;
	public ArrayList<Jugador> equipoB;


	public Partido(int anio, int mes, int dia, int hora, int minutos) throws Exception{
		
		DateTime nuevaFechaHora = new DateTime(anio, mes, dia, hora, minutos);
		if (nuevaFechaHora.isBeforeNow())
			throw new Exception("Partido futuro!");
		
		fechaHora = nuevaFechaHora;
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

	public boolean estaInscripto(Jugador jugador) {
		return this.inscriptos.contains(jugador);
	}

	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
