package negocio;

public class Administrador {

	public Administrador() {
	
	}
	
	public Partido crearPartido(int anio, int mes, int dia, int hora, int minutos){
		return new Partido(anio, mes, dia, hora, minutos);
	}

}
