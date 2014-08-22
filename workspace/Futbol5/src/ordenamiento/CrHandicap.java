package ordenamiento;

import negocio.Jugador;

public class CrHandicap extends Criterio{

	public int valuarJugador(Jugador j) {

		return j.handicap;
	}

}
