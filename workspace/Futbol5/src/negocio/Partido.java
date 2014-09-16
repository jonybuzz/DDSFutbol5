package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import negocio.inscripcion.*;
import ordenamiento.Criterio;

import org.joda.time.*;
import org.joda.time.format.*;

import utils.FutbolException;

public class Partido extends Observable implements Comparable<Partido>{
	
	public DateTime fechaHora;
	public ArrayList<Jugador> inscriptos;
	public ArrayList<Jugador> equipoA;
	public ArrayList<Jugador> equipoB;
	private Administrador administrador;
	private EstadoPartido estado;
	public int id;
	
	public Partido(Administrador administrador, int anio, int mes, int dia, int hora, int minutos) throws FutbolException{
		DateTime nuevaFechaHora = new DateTime(anio, mes, dia, hora, minutos);
		if (nuevaFechaHora.isBeforeNow())
			throw new FutbolException("Partido futuro!");
		
		fechaHora = nuevaFechaHora;
		inscriptos = new ArrayList<Jugador>();
		this.administrador = administrador;
		this.estado = new Abierto(this);
		
		equipoA = new ArrayList<Jugador>(5);
		equipoB = new ArrayList<Jugador>(5);
	}
	
	public EstadoPartido getEstado() {return estado;}
	public void setEstado(EstadoPartido estado) {this.estado = estado;}

	public boolean completo(){
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

	public void agregarJugador(Jugador jugador, int pos) throws FutbolException {	
		estado.agregarJugador(jugador, pos);
	}
	
	public void notificarAdministrador() {
		this.administrador.updateFromPartido(this.estado.mailDeNotificacion());
	}

	public void darDeBaja(Jugador jugador) throws FutbolException {
		estado.darDeBaja(jugador);
	}

	public boolean estaInscripto(Jugador jugador) {
		return this.inscriptos.contains(jugador);
	}
		
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd '/' MM '/' yyyy 'a las' kk:mm");
		String fechaFormateada = fmt.print(this.fechaHora);

		return "Partido del "+ fechaFormateada + " (#" + this.id + ")";
	}

	public int compareTo(Partido otro){
		if (otro.fechaHora.isAfter(this.fechaHora)) return -1;
		if (otro.fechaHora.isBefore(this.fechaHora)) return 1;
		else return 0;
	}

	public void calificar(Jugador jugador, Jugador calificado, int nota, String comentario) throws FutbolException {
		estado.calificar(jugador, calificado, nota, comentario);
	}

	public void ordenar(Criterio[] criterios) throws FutbolException {

		for (Jugador j : inscriptos){
			
			double valor = 0;
			
			for (Criterio algoritmo : criterios){
				valor += algoritmo.valuarJugador(j);		//por cada criterio suma el puntaje
			}
			valor /= criterios.length;						//promedia
						
			j.valorDeOrdenamiento = valor;					//asigna un valor al jugador
		}
				
		inscriptos.sort(Criterio.JugadorComparator);		
	}

	public void setEquipos(ArrayList<Jugador> equipoA, ArrayList<Jugador> equipoB) throws FutbolException {

		estado.setEquipos(equipoA, equipoB);	//delega en el estado (State Pattern)
												//Si ya esta confirmado tira una excepcion
	}

}
