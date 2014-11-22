package negocio.inscripcion;


public class Condicional extends TipoInscripcion {
	
	private String condicion;
	
	public Condicional(String condicion) {
		this.prioridad = 2;
		this.condicion = condicion;
	}

	public String getCondicion() {
		return condicion;
	}
	
	public String toString (){
		return "C";
	}

}
