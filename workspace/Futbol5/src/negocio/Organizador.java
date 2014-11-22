package negocio;

import java.util.SortedSet;

public class Organizador {  // SINGLETON
    private static Organizador INSTANCE = new Organizador();
    
    public SortedSet<Partido> partidos;
 
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase) 
    private Organizador() {}
 
    public static Organizador getInstance() {
        return INSTANCE;
    }
    
}
