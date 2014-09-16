package ordenamiento;

import negocio.Jugador;

public class CritHandicap extends Criterio{

	public double valuarJugador(Jugador j) {

		return (double) j.handicap;
	}

}
