package utils;

import java.util.Comparator;

import negocio.Jugador;

public class JugadorComparator implements Comparator<Jugador> {

	public JugadorComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Jugador arg0, Jugador arg1) {
        if( arg0 == null || arg1 == null ){
            if( arg0 == arg1 ) return 0;
            else if( arg1 == null) return +1;
                else return -1;
        }

		int inscripcion = arg0.getModoDeInscripcion().prioridad - arg1.getModoDeInscripcion().prioridad;  //0:igual  pos:mayor  neg:menor
		return inscripcion != 0? inscripcion : 0;
	
	}

}
