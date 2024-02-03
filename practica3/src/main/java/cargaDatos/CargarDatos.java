package cargaDatos;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.CoachDAO;
import DAO.CompeDAO;
import DAO.EquipoDAO;
import DAO.JugadorDAO;
import DAO.SponsorDAO;
import dataSource.DataSourceEquipo;
import dataSource.DataSourceJugador;
import dataSource.DataSourceSponsor;
import entidades.Coach;
import entidades.Competicion;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Sponsor;
/**
 * Clase encargada de cargar datos (equipos, jugadores y sponsors) en la base de datos.
 * Se utiliza para inicializar la base de datos con información predeterminada.
 *
 * @author David
 */
public class CargarDatos {	 
    private static final Logger LOGGER = LogManager.getLogger(CargarDatos.class.getName());

    public static void cargarEquiposEnDB() {
        LOGGER.info("Iniciando carga de datos en la base de datos...");

    	List<Equipo> equipos = DataSourceEquipo.getEquipos();
    	Map<String, Set<Jugador>> jugadoresPorEquipo = DataSourceJugador.getJugadoresPorEquipo();
    	Map<String, Coach> coachesPorEquipo = DataSourceJugador.getCoachesPorEquipo();
    	Map<String, Set<Sponsor>> sponsorsPorEquipo = DataSourceSponsor.getSponsorsPorEquipo();
    	EquipoDAO equipoDAO = new EquipoDAO();
    	JugadorDAO jugadorDAO = new JugadorDAO(); 
    	CoachDAO coachDAO = new CoachDAO();
    	SponsorDAO sponsorDAO = new SponsorDAO();
		CompeDAO compeDAO = new CompeDAO();
    	
        Competicion superLiga = new Competicion("SuperLiga", "01/02/2012", 9, 10);
        compeDAO.save(superLiga);
    	
    	for (Equipo equipo : equipos) {
            LOGGER.info("Insertando equipo en la base de datos: " + equipo.getNombre());
			// Insertar equipo
    		equipoDAO.save(equipo);
    		
    		//Obtener jugadores por equipo
    		Set<Jugador> jugadores = jugadoresPorEquipo.get(equipo.getNombre());
    		
    	    // Obtener entrenador por equipo
    	    Coach coach = coachesPorEquipo.get(equipo.getNombre());
    		
    		//Obtener sponsors por equipo
    		Set<Sponsor> sponsors = sponsorsPorEquipo.get(equipo.getNombre());
    		
    		//Insertar Jugadores
    		for (Jugador jugador : jugadores) { 
                LOGGER.info("Insertando jugador en la base de datos: " + jugador.getNombre());
    			jugador.setEquipo(equipo);
    			equipo.agregarJugador(jugador);

    			if (jugador.getId() != null) {
                    jugadorDAO.update(jugador);
                    
                } else {
                    jugadorDAO.save(jugador);                
                }
    		} 
    		
            // Insertar Coach
            if (coach != null) {
                LOGGER.info("Insertando entrenador en la base de datos: " + coach.getNick());
                coach.setEquipo(equipo);
                equipo.setCoach(coach);
                coachDAO.save(coach);
            }
    		
    		for (Sponsor sponsor : sponsors) {   	
                LOGGER.info("Insertando sponsor en la base de datos: " + sponsor.getNombre());
    			sponsor.agregarEquipoPatrocinado(equipo);
    			equipo.agregarPatrocinador(sponsor);

                // Si el sponsor ya está en la base de datos, actualizar en lugar de guardar
                if (sponsor.getId() != null) {
                    sponsorDAO.update(sponsor);
                    
                } else {
                    sponsorDAO.save(sponsor);                    
                }            			
    		}    	
    		
    		equipoDAO.update(equipo);
    	}   	
    	
        LOGGER.info("Carga de datos completada con éxito.");
    }
}