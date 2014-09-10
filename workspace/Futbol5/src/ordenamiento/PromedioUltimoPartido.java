package ordenamiento;

import utils.FutbolException;
import negocio.Calificacion;
import negocio.Jugador;

public class PromedioUltimoPartido extends Criterio{
	
	public PromedioUltimoPartido(){
	}

	public int valuarJugador(Jugador j) throws FutbolException {
		int cant = 0;
		int total = 0;
		int size = j.calificaciones.size();
		int ultimoPartido;
		
		if(size > 0){
			ultimoPartido = j.calificaciones.get(size-1).getIdPartido(); //revisar si se rompe si no hay calificaciones
	
			for(Calificacion calif : j.calificaciones){
				
				if(calif.getIdPartido() == ultimoPartido){
					total += calif.getNota();
					cant++;
				}
			}
			return total / cant;
		}
		else throw new FutbolException("No recibio calificaciones aun.");
	}

}
