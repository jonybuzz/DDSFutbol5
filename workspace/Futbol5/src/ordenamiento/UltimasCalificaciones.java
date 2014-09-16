package ordenamiento;

import utils.FutbolException;
import negocio.Calificacion;
import negocio.Jugador;

public class UltimasCalificaciones extends Criterio{
	
	public int cantidad;
	
	public UltimasCalificaciones(int cantidad){
		this.cantidad = cantidad;
	}

	public double valuarJugador(Jugador j) throws FutbolException {

		int total = 0;
		int size = j.calificaciones.size();
		
		if(size > 0){

			for(int i=0; i < cantidad; i++){
				
				Calificacion c = j.calificaciones.get(size-i-1);
				total += c.getNota();		
			}

			return (double) total / cantidad;
		}
		else throw new FutbolException("No recibio calificaciones aun.");
	}

}
