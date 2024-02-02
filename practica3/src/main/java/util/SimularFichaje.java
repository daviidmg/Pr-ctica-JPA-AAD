package util;

import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.EquipoDAO;
import DAO.JugadorDAO;
import entidades.Equipo;
import entidades.Jugador;


public class SimularFichaje {
    private static final Logger logger = LogManager.getLogger(SimularFichaje.class);
    private static EquipoDAO equipoDAO = new EquipoDAO();
    private static JugadorDAO jugadorDAO = new JugadorDAO();

    public static void simularVentanaFichajes() {
    	logger.info("###### INICIO DEL MERCADO DE FICHAJES");
    	Equipo barca = equipoDAO.findByNombre("Barça Esports");

    	//Bajas 
    	Jugador antonio = jugadorDAO.findByNombre("Th3Antonio");
    	Equipo giantX = antonio.getEquipo();
    	
    	giantX.baja(antonio);
    	
    	
    	//Fichajes
    	Equipo losHeretics = equipoDAO.findByNombre("Los Heretics");
    	Jugador whiteKnight = jugadorDAO.findByNombre("WhiteKnight");   	
    	losHeretics.ficharJugador(whiteKnight);
    	
    	Jugador dreedy = jugadorDAO.findByNombre("Dreedy");
    	giantX.ficharJugador(dreedy);
    	
    	Jugador r4ven = jugadorDAO.findByNombre("R4ven");
    	barca.ficharJugador(r4ven);
    	
    	Jugador hylissang = new Jugador("Hylissang", "Bulgaro", LocalDate.of(1995, 4, 30), "Support");
    	barca.ficharJugador(hylissang);
    	
    	
    	//Altas
    	Jugador caps = new Jugador("Caps", "Danés", LocalDate.of(1999,11,17), "Mid");
    	Equipo movistarKoi = equipoDAO.findByNombre("Movistar KOI");
    	movistarKoi.altaJugadorNuevo(caps);
    	
    	Jugador brokenBlade = new Jugador("BrokenBlade", "Alemán", LocalDate.of(2000, 1, 19), "Top");
    	Equipo rebels = equipoDAO.findByNombre("Rebels");
    	rebels.altaJugadorNuevo(brokenBlade);
    	
    	logger.info("###### FINAL DEL MERCADO DE FICHAJES");

    }
    


 
}



/*   // Método para simular la ventana de fichajes al final de la temporada
public static void simularVentanaFichajes() {
    List<Equipo> equipos = equipoDAO.findAll();

    // Iterar sobre cada equipo y realizar fichajes
    for (Equipo equipo : equipos) {
        realizarFichajes(equipo);
    }
}

private static void realizarFichajes(Equipo equipo) {
    // Obtener la lista de jugadores disponibles en el mercado
    List<Jugador> jugadoresDisponibles = obtenerJugadoresDisponibles();

    // Iterar sobre la lista de jugadores disponibles y realizar fichajes
    for (Jugador jugador : jugadoresDisponibles) {
        // Simular la decisión de fichar al jugador (puedes ajustar la lógica según tus necesidades)
        if (Math.random() < 0.5) {
            // Cargar el jugador nuevamente desde la base de datos para evitar problemas de fusión
            Jugador jugadorDesdeDB = jugadorDAO.findById(jugador.getId());

            // Fichar al jugador
            equipo.fichar(jugadorDesdeDB, equipoDAO, jugadorDAO);
        }
    }
}

// Método para obtener la lista de jugadores disponibles en el mercado
private static List<Jugador> obtenerJugadoresDisponibles() {
	
    return jugadorDAO.findAll(); 
}*/