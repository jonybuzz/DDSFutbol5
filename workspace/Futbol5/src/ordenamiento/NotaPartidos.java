package ordenamiento;

import negocio.Jugador;

public class NotaPartidos extends Criterio{
	
	public int cantidad;
	private Stack<Calificacion> auxiliar;
	
	public NotaPartidos(int cantidad){
		this.cantidad = cantidad;
	}

	public int valuarJugador(Jugador j) throws FutbolException {
		int i = 0;
		int cant = 0;
		int total = 0;
		
		califAnterior = j.calificaciones.peek.getIdPartido; //revisar si se rompe si no hay calificaciones
		for(Calificacion calif : j.calificaciones){
			
			if(calif.getIdPartido == califAnterior && i < cantidad){
				total += calif.getNota();
				cant++;
			}else{
				i++;
				califAnterior == calif.getIdPartido;
			}
		}
		if(cant != 0)
			return total / cant;
		else throw new FutbolException("No recibio calificaciones aun.");
	}

}
