package negocio;

public class Calificacion {

	private int idPartido;
	private Jugador jugador;
	private String comentario;
	private int nota;

	public Calificacion(Jugador j, int n, String com, int id){
		idPartido = id;
		jugador = j;
		comentario = com;
		nota = n;
	}
	
	public int getIdPartido() {
		return idPartido;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public String getComentario() {
		return comentario;
	}

	public int getNota() {
		return nota;
	}
	
	public String toString(){
		return
				"Partido #" + idPartido
				+ "Jugador: " + jugador + ".\""
				+ comentario + "\". Calificacion: "
				+ nota;
	}
}
