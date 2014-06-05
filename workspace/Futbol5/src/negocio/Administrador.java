package negocio;

public class Administrador extends Jugador{

	public Administrador(String nombre, int anio, int mes, int dia) throws Exception {
		super(nombre, anio, mes, dia);
	}
	
	public Partido organizarNuevoPartido(int anio, int mes, int dia, int hora, int minutos) throws Exception{
		return new Partido(anio, mes, dia, hora, minutos);
	}

}
