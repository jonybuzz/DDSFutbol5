package ordenamiento;

import java.util.ArrayList;

import utils.FutbolException;
import negocio.Jugador;

public abstract class DivisionEquipos {
		
	protected ArrayList<Jugador> lista;
	protected ArrayList<Integer> posA = new ArrayList<Integer>(5);
	protected ArrayList<Integer> posB = new ArrayList<Integer>(5);

	
	public DivisionEquipos(ArrayList<Jugador> lista) throws FutbolException{
		if (lista.size()>=10){
							//toma los primeros 10 de la lista
			this.lista = new ArrayList<Jugador>(lista.subList(0, 10));
		}
		else throw new FutbolException("No hay 10 jugadores para armar equipoS");
	}
	
	
	public ArrayList<Jugador> generarEquipoA() {
		return this.generarEquipo(posA);
	}

	public ArrayList<Jugador> generarEquipoB() {
		return this.generarEquipo(posB);
	}

	//metodo generico//
	protected ArrayList<Jugador> generarEquipo(ArrayList<Integer> posiciones) {
		ArrayList<Jugador> equipo = new ArrayList<Jugador>();
		
		for(Integer num : posiciones){
			equipo.add(this.lista.get(num-1));
		}
		return equipo;
	}

}
