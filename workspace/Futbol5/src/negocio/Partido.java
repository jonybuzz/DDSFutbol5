package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

import negocio.inscripcion.*;

import org.joda.time.*;
import org.joda.time.format.*;

public class Partido extends Observable implements Comparable<Partido>{
	
	public DateTime fechaHora;
	public LinkedList<Jugador> inscriptos;
	public ArrayList<Jugador> equipoA;
	public ArrayList<Jugador> equipoB;
	private Administrador administrador;
	private EstadoPartido estado;
	
	public Partido(Administrador administrador, int anio, int mes, int dia, int hora, int minutos) throws Exception{
		DateTime nuevaFechaHora = new DateTime(anio, mes, dia, hora, minutos);
		if (nuevaFechaHora.isBeforeNow())
			throw new Exception("Partido futuro!");
		
		fechaHora = nuevaFechaHora;
		inscriptos = new LinkedList<Jugador>();
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

	public void agregarJugador(Jugador jugador, int pos) throws Exception {	
		estado.agregarJugador(jugador, pos);
	}
	
	public void notificarAdministrador() {
		this.administrador.updateFromPartido(this.estado.mailDeNotificacion());
	}

	public void darDeBaja(Jugador jugador) throws Exception {
		estado.darDeBaja(jugador);
	}

	public boolean estaInscripto(Jugador jugador) {
		return this.inscriptos.contains(jugador);
	}
		
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd 'de' MMMM, yyyy 'a las' kk:mm");
		String fechaFormateada = fmt.print(this.fechaHora);

		return "Partido del "+ fechaFormateada + "(" + this.completo() + ")";
	}

	public int compareTo(Partido otro){
		if (otro.fechaHora.isAfter(this.fechaHora)){
			return -1;
		}
		if (otro.fechaHora.isBefore(this.fechaHora)){
			return 1;
		}
		else return 0;
	}
}
