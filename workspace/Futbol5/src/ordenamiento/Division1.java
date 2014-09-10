package ordenamiento;

import java.util.ArrayList;

import negocio.Jugador;

public class Division1 implements DivisionEquipos{
	
	private ArrayList<Jugador> lista;
	private ArrayList<Integer> posA = new ArrayList<Integer>(5);
	private ArrayList<Integer> posB = new ArrayList<Integer>(5);

	public Division1(ArrayList<Jugador> lista){
		this.lista = lista;
		
		posA.add(1);	posB.add(2);
		posA.add(3);	posB.add(4);
		posA.add(5);	posB.add(6);
		posA.add(7);	posB.add(8);
		posA.add(9);	posB.add(10);

	}

	public ArrayList<Jugador> generarEquipoA() {
		return this.generarEquipo(posA);
	}

	public ArrayList<Jugador> generarEquipoB() {
		return this.generarEquipo(posB);
	}

	//metodo generico//
	public ArrayList<Jugador> generarEquipo(ArrayList<Integer> posiciones) {
		
		ArrayList<Jugador> equipo = new ArrayList<Jugador>();
		
		for(Integer num : posiciones){
			equipo.add(this.lista.get(num-1));
		}
		return equipo;
	}


}
