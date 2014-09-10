package ordenamiento;

import negocio.Jugador;

public class CritHandicap extends Criterio{

	public int valuarJugador(Jugador j) {

		return j.handicap;
	}

}
