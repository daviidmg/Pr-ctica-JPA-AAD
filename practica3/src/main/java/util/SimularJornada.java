package util;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.CompeDAO;
import DAO.EquipoDAO;
import entidades.Competicion;
import entidades.Equipo;
/**
 * Esta clase se encarga de simular las jornadas de un campeonato.
 * Utiliza métodos para simular el desarrollo de partidos y actualizar los resultados en la competición.
 *
 * @author David
 */
public class SimularJornada {
    private static final Logger logger = LogManager.getLogger(SimularJornada.class);

	public static void simularCampeonato() {	
        logger.info("Iniciando simulación del campeonato.");

		EquipoDAO equipoDAO = new EquipoDAO();
		CompeDAO compeDAO = new CompeDAO();
		Competicion competicion = compeDAO.findAll().get(0);

		// Simular jornadas
		for (int jornada = 1; jornada <= competicion.getNumeroJornadas(); jornada++) {
            logger.info("Simulando jornada {}", jornada);

            // Barajar aleatoriamente la lista de equipos
            List<Equipo> equiposBarajados = equipoDAO.findAll();
            Collections.shuffle(equiposBarajados);

            // Crear y simular partidos
            for (int i = 0; i < equiposBarajados.size(); i += 2) {
                Equipo equipoLocal = equiposBarajados.get(i);
                Equipo equipoVisitante = equiposBarajados.get(i + 1);

                // Simular el partido
                Equipo ganador = (Math.random() < 0.5) ? equipoLocal : equipoVisitante;
                Equipo perdedor = (ganador.equals(equipoLocal)) ? equipoVisitante : equipoLocal;

                // Imprimir resultados
                logger.info("Partido: {} vs {} - Resultado: Ganador: {}", equipoLocal.getNombre(), equipoVisitante.getNombre(), ganador.getNombre());
                Competicion.actualizarResultados(ganador, perdedor);
            }
        }
        logger.info("Temporada simulada con éxito.");
    }
}
