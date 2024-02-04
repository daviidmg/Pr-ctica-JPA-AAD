package demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.EquipoDAO;
import DAO.GenericDAOImpl;
import DAO.JugadorDAO;
import DAO.SponsorDAO;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Sponsor;
/*** Esta clase realiza y gestiona consultas relacionadas con la competición.
* 
* @author David
*/
public class ConsultasCompeticion {
    private static EquipoDAO equipoDAO = new EquipoDAO();
    private static JugadorDAO jugadorDAO = new JugadorDAO();
    private static SponsorDAO sponsorDAO = new SponsorDAO();
    private static final Logger logger = LogManager.getLogger(ConsultasCompeticion.class);

    public static void obtenerCaracteristicasCompeticion() {
        EntityManager entityManager = null;

        try {
            entityManager = GenericDAOImpl.getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            // Consulta para obtener las características de la competición
            String sqlQuery = "SELECT * FROM competition";
            Query query = entityManager.createNativeQuery(sqlQuery);
            List<Object[]> resultados = query.getResultList();

            // Mostrar resultados
            logger.info("## 1. Características de la competición ##");
            for (Object[] resultado : resultados) {
                logger.info("Número de jornadas: {}, Número de equipos: {}, Fecha de creación: {}, Nombre: {}", resultado[0], resultado[1], resultado[2], resultado[3]);
            }
            logger.info("##################### FIN Consulta 1 #################################");

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            logger.error("Error al obtener las características de la competición", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public static void obtenerEquiposParticipantes() {
        try {
            // Obtener todos los equipos participantes
            List<Equipo> equipos = equipoDAO.findAll();

            // Mostrar resultados
            logger.info("## 2. Equipos participantes en la competición ##");
            for (Equipo equipo : equipos) {
                logger.info("ID: {}, Nombre: {}", equipo.getId(), equipo.getNombre());
            }
            logger.info("##################### FIN Consulta 2 #################################");
        } catch (Exception e) {
            logger.error("Error al obtener equipos participantes", e);
        }
    }
    
    public static void obtenerJugadoresPorEquipo(long equipoId) {
        try {
            Equipo equipo = equipoDAO.findById(equipoId);

            // Verificar si el equipo existe
            if (equipo != null) {
                // Obtener la lista de jugadores del equipo específico
                List<Jugador> jugadores = jugadorDAO.findJugadoresByEquipo(equipoId);

                // Mostrar resultados
                logger.info("## 3. Jugadores del equipo {} ##", equipo.getNombre());
                for (Jugador jugador : jugadores) {
                    int edad = Jugador.calcularEdad(jugador.getFechaNacimiento());
                    logger.info("Nombre: {}, Nacionalidad: {}, Posicion: {}, Edad: {}", 
                    		jugador.getNombre(), jugador.getNacionalidad(), 
                    		jugador.getPosicion(), edad);
                }
                logger.info("##################### FIN Consulta 3 #################################");
            } else {
                logger.error("El equipo con ID {} no existe.", equipoId);
            }
        } catch (Exception e) {
            logger.error("Error al obtener jugadores por equipo", e);
        }
    }
    
    public static void obtenerPatrocinadoresPorEquipo(long equipoId) {
        EntityManager entityManager = null;

        try {
            entityManager = GenericDAOImpl.getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            Equipo equipo = equipoDAO.findById(equipoId);

            if (equipo != null) {
                List<Sponsor> patrocinadores = sponsorDAO.findPatrocinadoresByEquipo(equipo);

                // Mostrar resultados
                logger.info("## 4. Patrocinadores del equipo: " + equipo.getNombre() + " ##");
                for (Sponsor patrocinador : patrocinadores) {
                    logger.info("Nombre del patrocinador: {}", patrocinador.getNombre());
                }
                logger.info("##################### FIN Consulta 4 #################################");
            } else {
                logger.error("No se encontró un equipo con ID: {}", equipoId);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            logger.error("Error al obtener patrocinadores del equipo", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public static void obtenerJugadoresYPatrocinadoresPorEquipo(long equipoId) {
        EntityManager entityManager = null;

        try {
            entityManager = GenericDAOImpl.getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            // Obtener jugadores por equipo
            List<Jugador> jugadores = jugadorDAO.findJugadoresByEquipo(equipoId);

            Equipo equipo = equipoDAO.findById(equipoId);

            // Obtener patrocinadores por equipo
            List<Sponsor> patrocinadores = sponsorDAO.findPatrocinadoresByEquipo(equipo);

            // Mostrar resultados
            logger.info("## 5. Jugadores y Patrocinadores vinculados al equipo: " + equipo.getNombre() + " ##");
            logger.info("Jugadores:");
            for (Jugador jugador : jugadores) {
                int edad = Jugador.calcularEdad(jugador.getFechaNacimiento());
                logger.info("Nombre: {}, Nacionalidad: {}, Edad: {}", jugador.getNombre(), jugador.getNacionalidad(), edad);
            }
            logger.info("Patrocinadores:");
            for (Sponsor patrocinador : patrocinadores) {
                logger.info("Nombre: {}", patrocinador.getNombre());
            }
            logger.info("##################### FIN Consulta 5 #################################");

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            logger.error("Error al obtener jugadores y patrocinadores vinculados al equipo", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public static void calcularEdadPromedioJugadoresPorEquipo(long equipoId) {
        EntityManager entityManager = null;
        Equipo equipo = equipoDAO.findById(equipoId);

        try {
            entityManager = GenericDAOImpl.getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            Double edadPromedio = jugadorDAO.calcularEdadPromedioJugadoresByEquipo(equipoId);

            // Mostrar resultados
            logger.info("## 6. Edad promedio de jugadores del equipo: " + equipo.getNombre() + " ##");
            logger.info("Edad promedio: {}", edadPromedio);
            logger.info("##################### FIN Consulta 6 #################################");

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            logger.error("Error al calcular la edad promedio de jugadores por equipo", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public static void contarDeportistasMayoresVeintitresPorNacionalidad(String nacionalidad) {
    	int edad = 23;
        try {
            Long cantidadDeportistas = new JugadorDAO().contarJugadoresMayoresPorNacionalidad(nacionalidad, edad);

            // Mostrar resultados
            logger.info("## 7. Deportistas mayores de 23 años por nacionalidad ##");
            logger.info("Nacionalidad: {}, Cantidad de jugadores mayores de 23 años: {}", nacionalidad, cantidadDeportistas);
            logger.info("##################### FIN Consulta 7 #################################");

        } catch (Exception e) {
            logger.error("Error al contar jugadores mayores de 23 años por nacionalidad", e.getMessage());
        }
    }
    
    
    public static void visualizarClasificacion(String momento) {
        try {
            List<Equipo> clasificacion = new EquipoDAO().obtenerClasificacion();

            // Mostrar resultados
            logger.info("## Clasificación al {} ##", momento);
            for (int i = 0; i < clasificacion.size(); i++) {
                Equipo equipo = clasificacion.get(i);
                logger.info("Posición {}: {} (Victorias: {}, Derrotas: {})", i + 1, equipo.getNombre(), equipo.getVictorias(), equipo.getDerrotas());
            }
            logger.info("##################### FIN Consulta Clasificación #################################");

        } catch (Exception e) {
            logger.error("Error al obtener la clasificación de los equipos", e.getMessage());
        }
    }

    public static void mostrarEquiposConMasYMenosPuntos() {
        EntityManager entityManager = null;

        try {
            entityManager = GenericDAOImpl.getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            // Consulta para obtener los tres equipos con más puntos
            List<Equipo> equiposMasPuntos = equipoDAO.findAllOrderedByPoints(3, false);

            // Consulta para obtener los tres equipos con menos puntos
            List<Equipo> equiposMenosPuntos = equipoDAO.findAllOrderedByPoints(3, true);

            // Mostrar resultados
            logger.info("## 9. 3 Equipos con más puntos ##");
            for (Equipo equipo : equiposMasPuntos) {
                logger.info("Equipo: {}, Puntos: {}", equipo.getNombre(), equipo.getVictorias());
            }

            logger.info("## 3 Equipos con menos puntos ##");
            for (Equipo equipo : equiposMenosPuntos) {
                logger.info("Equipo: {}, Puntos: {}", equipo.getNombre(), equipo.getVictorias());
            }
            logger.info("##################### FIN Consulta 9 #################################");

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            logger.error("Error al obtener equipos con más y menos puntos", e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public static void mostrarNuevasIncorporaciones() {
        JugadorDAO jugadorDAO = new JugadorDAO();
        List<Jugador> nuevasIncorporaciones = jugadorDAO.findNuevasIncorporaciones();

    	logger.info("## 10. Nuevas incorporaciones");
        for (Jugador jugador : nuevasIncorporaciones) {
        	logger.info("Nombre: " + jugador.getNombre() + ", Equipo: " + jugador.getEquipo().getNombre());
        }
    	logger.info("##################### FIN Consulta 10 #################################");

    }
    
    public static void mostrarJugadoresFichados() {
        List<Jugador> jugadoresFichados = jugadorDAO.findJugadoresFichados();

        logger.info("## 11. Jugadores Fichados ##");
        for (Jugador jugador : jugadoresFichados) {
            logger.info("Nombre Jugador: " + jugador.getNombre() + ", Equipo: " + jugador.getEquipo().getNombre());
        }
        logger.info("########################### FIN Consulta 11 #################################");
    }

    
    public static void contarTotalJugadores() {
        JugadorDAO jugadorDAO = new JugadorDAO();

        try {
            long totalJugadores = jugadorDAO.countTotalJugadores();
            logger.info("## 12. Recuento total de jugadores ##");
            logger.info("Total de jugadores en la competición: {}", totalJugadores);
            logger.info("##################### FIN Consulta 12 #################################");
        } catch (Exception e) {
            logger.error("Error al contar el total de jugadores", e.getMessage());
        }
    }
    
    public static void mostrarPatrocinadoresComunesEntreEquipos(String equipo1, String equipo2) {
        SponsorDAO sponsorDAO = new SponsorDAO();

        try {
            List<Sponsor> patrocinadoresComunes = sponsorDAO.findPatrocinadoresComunes(equipo1, equipo2);

            logger.info("## 12. Recuento total de patrocinadores comunes ##");
            logger.info("Patrocinadores comunes entre {} y {}: {}", equipo1, equipo2, patrocinadoresComunes.toString());
            logger.info("##################### FIN Consulta 13 #################################");

        } catch (Exception e) {
            logger.error("Error al obtener patrocinadores comunes entre equipos: {}", e.getMessage());
        }
    }
    
    public static void ejecutarEjemplosCriteriaQuery() {
    	
    	Map<String, Object> criteriaMap = new HashMap<>();
    	criteriaMap.put("nacionalidad", "español");
    	criteriaMap.put("posicion", "top");

    	List<Jugador> jugadores = jugadorDAO.findJugadoresByCriteria(criteriaMap, true);
    	mostrarResultadosConsulta(jugadores, "Ejemplo CriteriaQuery nacionalidad: español, posición: top ");
    
    	Map<String, Object> criteriaMap2 = new HashMap<>();
    	criteriaMap2.put("equipo", "Los Heretics");
    	criteriaMap2.put("posicion", "Mid");

    	List<Jugador> jugadores2 = jugadorDAO.findJugadoresByCriteria(criteriaMap2, true);
    	mostrarResultadosConsulta(jugadores2, "Ejemplo CriteriaQuery equipo: Los Heretics, posicion: mid ");   
    	
    	Map<String, Object> criteriaMap3 = new HashMap<>();
    	criteriaMap3.put("fichaje", true);
    	criteriaMap3.put("equipo", "Barça Esports");

    	List<Jugador> jugadores3 = jugadorDAO.findJugadoresByCriteria(criteriaMap3, true);
    	mostrarResultadosConsulta(jugadores3, "Ejemplo CriteriaQuery fichajes del Barça ");
    
    }
    
    private static void mostrarResultadosConsulta(List<Jugador> jugadores, String nombreConsulta) {
        Logger logger = LogManager.getLogger(ConsultasCompeticion.class);

        logger.info("Resultados de la consulta '{}':", nombreConsulta);
        for (Jugador jugador : jugadores) {
        	 if (jugador != null && jugador.getEquipo() != null) {
                 int edad = Jugador.calcularEdad(jugador.getFechaNacimiento());
                 logger.info("Nombre: {}, Edad: {}, Equipo: {}", jugador.getNombre(), edad, jugador.getEquipo().getNombre());
             }       	 
        }
        logger.info("##################### FIN {} #################################", nombreConsulta);
    }

}