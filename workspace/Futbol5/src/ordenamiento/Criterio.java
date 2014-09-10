package ordenamiento;

import java.util.Comparator;

import utils.FutbolException;
import negocio.Jugador;


public abstract class Criterio {

	public abstract int valuarJugador(Jugador j) throws FutbolException;	//metodo a impl por cada criterio
	
	
///////////////////comparator para ordenar/////////////////////////
	
	public static Comparator<Jugador> JugadorComparator 
    = new Comparator<Jugador>() {

		public int compare(Jugador jug1, Jugador jug2) {
				
			if(jug1.valorDeOrdenamiento>jug2.valorDeOrdenamiento)
				return -1;
			if(jug1.valorDeOrdenamiento<jug2.valorDeOrdenamiento)
				return 1;
			else return 0;
		}
	};
	
}
