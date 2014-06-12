package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

import org.joda.time.*;


public class Partido extends Observable{
	
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
	
	public void agregarJugador(Jugador jugador, int pos) throws Exception {		

		if(!this.confirmado() && !this.estaInscripto(jugador)) {
			this.inscriptos.add(pos, jugador);
			if(this.confirmado()) this.setChanged();
			if(this.countObservers()>0) this.notifyObservers();
		}
		else throw new Exception("No se pudo inscribir a " + jugador);
	}
	
	public boolean confirmado(){
		Iterator<Jugador> it = this.inscriptos.iterator();
		int confirmadosEstandar = 0;
		while(it.hasNext()){
			
			Jugador jug = it.next();
			if(jug.getModoDeInscripcion().prioridad == 1){
				confirmadosEstandar ++;
			}
		}
		if (confirmadosEstandar == 10) return true;
		else return false;
	}

	public void darDeBaja(Jugador jugador) {
		this.inscriptos.remove(jugador);
		if(!this.confirmado()) this.setChanged();
		if(this.countObservers()>0) this.notifyObservers();
	}

	public boolean estaInscripto(Jugador jugador) {
		return this.inscriptos.contains(jugador);
	}
	
	public String toString() {
		return this.fechaHora + "(" + this.confirmado() + ")";
	}
}
