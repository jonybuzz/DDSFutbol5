package ordenamiento;

import java.util.ArrayList;

import utils.FutbolException;
import negocio.Jugador;

public class Division2 extends DivisionEquipos{
	
	public Division2(ArrayList<Jugador> lista) throws FutbolException{
		super(lista);

		posA.add(1);	posB.add(2);
		posA.add(4);	posB.add(3);
		posA.add(5);	posB.add(6);
		posA.add(8);	posB.add(7);
		posA.add(9);	posB.add(10);
	}

}
