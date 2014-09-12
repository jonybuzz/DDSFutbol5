package ordenamiento;

import java.util.ArrayList;

import utils.FutbolException;
import negocio.Jugador;

public class Division1 extends DivisionEquipos{
	
	public Division1(ArrayList<Jugador> lista) throws FutbolException{
		super(lista);
		
		posA.add(1);	posB.add(2);
		posA.add(3);	posB.add(4);
		posA.add(5);	posB.add(6);
		posA.add(7);	posB.add(8);
		posA.add(9);	posB.add(10);
	}

}
