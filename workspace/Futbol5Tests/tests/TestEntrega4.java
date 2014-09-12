package tests;

//import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Random;
import ordenamiento.*;
import org.junit.Test;
import utils.FutbolException;
import negocio.*;
import negocio.inscripcion.*;
import fixture.BD;

public class TestEntrega4 {
	
	public static Partido p = null;
		
	@Test
	public void ordenarPorHandicap() throws FutbolException {
		BD.init();
		crearPartido();
		Partido partido = BD.getPartido(0);
		Administrador admin = BD.administrador();
		
		ArrayList<Jugador> lista = partido.inscriptos;
		System.out.print("\nLista inscriptos: " + lista);

		System.out.print("\nLista de Handic: ");
		for(Jugador jug : lista){
			Random rnd = new Random();			//generacion de
			int nota = rnd.nextInt(10)+1;		//num aleatorio [1;10]
			admin.setHandicap(jug, nota);
			System.out.print(jug + " " + nota + "* ");
		}
		
		admin.ordenar(lista, new CritHandicap());
		System.out.print("\nLista ordenada:  " + lista);

		admin.generarEquipos(partido, new Division1(lista));
		System.out.print("\nEquipo A1: " + BD.getPartido(0).equipoA);
		System.out.print("\nEquipo B1: " + BD.getPartido(0).equipoB);
		
		admin.generarEquipos(partido, new Division2(lista));
		System.out.print("\nEquipo A2: " + BD.getPartido(0).equipoA);
		System.out.print("\nEquipo B2: " + BD.getPartido(0).equipoB);

		admin.confirmarPartido(partido);
		//admin.generarEquipos(partido, new Division2(lista));  //Esto da EXCEPCION como debe ser
	}

	
	@Test
	public void ordenarPorUltimas2Calificaciones() throws FutbolException {
	}
	
	
	@Test
	public void ordenarPorCalificacionesUltimoPartido() throws FutbolException {
	}
	
	
	private void crearPartido() throws FutbolException {
		BD.administrador().organizarNuevoPartido(2015, 1, 3, 14, 30);
		BD.get("Jose").modoDeInscrpcion(new Solidaria());
		BD.get("Jose").inscribirme(BD.getPartido(0));
		BD.get("Lucas").inscribirme(BD.getPartido(0));
		BD.get("Luis").inscribirme(BD.getPartido(0));
		BD.get("Bender").inscribirme(BD.getPartido(0));
		BD.get("Ale").modoDeInscrpcion(new Solidaria());
		BD.get("Ale").inscribirme(BD.getPartido(0));
		BD.get("Juan").inscribirme(BD.getPartido(0));
		BD.get("Esteban").inscribirme(BD.getPartido(0));
		BD.get("Diego").inscribirme(BD.getPartido(0));
		BD.get("Ana").inscribirme(BD.getPartido(0));
		BD.get("Pepe").inscribirme(BD.getPartido(0));
	}
		
}
