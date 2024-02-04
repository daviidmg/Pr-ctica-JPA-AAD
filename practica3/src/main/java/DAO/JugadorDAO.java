package DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entidades.Jugador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
/**
 * Clase DAO para la entidad Jugador.
 * Se encarga de las operaciones de acceso a datos relacionadas con los jugadores.
 *
 *@author David
 */
public class JugadorDAO extends GenericDAOImpl<Jugador>{
    private static final Logger LOGGER = LogManager.getLogger(JugadorDAO.class);	

    public JugadorDAO() {
        super(Jugador.class);
    }
    
    public Jugador findById(Long id) {
    	Jugador jugador = null;
    	
        EntityManager entityManager = getEmf().createEntityManager();
        try {
            return entityManager.find(Jugador.class, id);
        } catch (Exception e) {
            LOGGER.error("Error al buscar jugador por ID: {}", e.getMessage());
        } finally {
            entityManager.close();
        }
        return jugador;
    }
    
    public Jugador findByNombre(String nombre) {
    	Jugador jugador = null;

        EntityManager entityManager = null;

        try {
            entityManager = getEmf().createEntityManager();
            String jpql = "SELECT j FROM Jugador j WHERE j.nombre = :nombre";
            TypedQuery<Jugador> query = entityManager.createQuery(jpql, Jugador.class);
            query.setParameter("nombre", nombre);
            List<Jugador> resultados = query.getResultList();

            return resultados.isEmpty() ? null : resultados.get(0);
        } catch (Exception e) {
            LOGGER.error("Error al buscar jugador por nombre: {}", e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return jugador;
    }
    
    public List<Jugador> findJugadoresByEquipo(long equipoId) {
        EntityManager entityManager = null;
        List<Jugador> jugadores = null;

        try {
            entityManager = getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            // Consulta JPQL para obtener la lista de deportistas de un equipo específico
            String jpql = "SELECT j FROM Jugador j WHERE j.equipo.id = :equipoId";
            TypedQuery<Jugador> query = entityManager.createQuery(jpql, Jugador.class);
            query.setParameter("equipoId", equipoId);
            jugadores = query.getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            LOGGER.error("Error al buscar jugadores por equipo", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return jugadores;
    }
    
    public Double calcularEdadPromedioJugadoresByEquipo(long equipoId) {
    	Double edadMedia = null;
        EntityManager entityManager = null;

        try {
            entityManager = getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            // Consulta JPQL para calcular la edad promedio de los deportistas de un equipo
            String jpql = "SELECT AVG(DATEDIFF(CURRENT_DATE(), j.fechaNacimiento) / 365) FROM Jugador j WHERE j.equipo.id = :equipoId";
            TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
            query.setParameter("equipoId", equipoId);
            return query.getSingleResult();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            LOGGER.error("Error al calcular la edad promedio de los jugadores por equipo", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return edadMedia;
    }
    
    public Long contarJugadoresMayoresPorNacionalidad(String nacionalidad, int edad) {
        EntityManager entityManager = null;

        try {
            entityManager = getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            String jpql = "SELECT COUNT(j) FROM Jugador j WHERE DATEDIFF(CURRENT_DATE(), j.fechaNacimiento) / 365 > :edad AND j.nacionalidad = :nacionalidad";
            TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
            query.setParameter("edad", edad);
            query.setParameter("nacionalidad", nacionalidad);
            return query.getSingleResult();

        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            LOGGER.error("Error al contar jugadores mayores de {} años por nacionalidad", edad, e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return 0L;
    }
    
    public long countTotalJugadores() {
        EntityManager entityManager = null;

        try {
            entityManager = getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            String jpql = "SELECT COUNT(j) FROM Jugador j";
            TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
            long totalDeportistas = query.getSingleResult();

            entityManager.getTransaction().commit();

            return totalDeportistas;
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            LOGGER.error("Error al contar el total de jugadores", e);
            throw e; 
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    

    public List<Jugador> findNuevasIncorporaciones() {
        EntityManager entityManager = getEmf().createEntityManager();
        try {
            TypedQuery<Jugador> query = entityManager.createNamedQuery("Jugador.findNuevasIncorporaciones", Jugador.class);
            return query.getResultList();
        } finally {
        	entityManager.close();
        }
    }
    
    public List<Jugador> findJugadoresFichados() {
        EntityManager entityManager = getEmf().createEntityManager();
        try {
            TypedQuery<Jugador> query = entityManager.createQuery(
                    "SELECT j FROM Jugador j WHERE j.fichaje = true", Jugador.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    
    public List<Jugador> findJugadoresByCriteria(Map<String, Object> criteriaMap, boolean orderByDesc) {
        EntityManager entityManager = null;
        List<Jugador> jugadores = null;

        try {
            entityManager = getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Jugador> query = criteriaBuilder.createQuery(Jugador.class);
            Root<Jugador> root = query.from(Jugador.class);

            List<Predicate> predicates = new ArrayList<>();

            for (Map.Entry<String, Object> entry : criteriaMap.entrySet()) {
                String attribute = entry.getKey();
                Object value = entry.getValue();

                if ("edad".equals(attribute)) {
                    int edadBuscada = (int) value;
                    Path<LocalDate> fechaNacimientoPath = root.get("fechaNacimiento");

                    Expression<Integer> edadExpression = criteriaBuilder.function(
                            "YEAR",
                            Integer.class,
                            fechaNacimientoPath
                    );

                    Predicate edadPredicate = criteriaBuilder.equal(
                            edadExpression,
                            edadBuscada
                    );

                    predicates.add(edadPredicate);
                } else if ("equipo".equals(attribute)) {
                    predicates.add(criteriaBuilder.equal(root.get("equipo").get("nombre"), value));
                } else {
                    predicates.add(criteriaBuilder.equal(root.get(attribute), value));
                } 
            }

            query.select(root).where(predicates.toArray(new Predicate[0]));

            // Añadir orden por edad
            if (orderByDesc) {
                query.orderBy(criteriaBuilder.desc(
                        criteriaBuilder.function(
                                "YEAR",
                                Integer.class,
                                root.get("fechaNacimiento")
                        )
                ));
            } else {
                query.orderBy(criteriaBuilder.asc(
                        criteriaBuilder.function(
                                "YEAR",
                                Integer.class,
                                root.get("fechaNacimiento")
                        )
                ));
            }

            return entityManager.createQuery(query).getResultList();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            LOGGER.error("Error en la búsqueda de jugadores por criterios", e);
        } finally {
            if (entityManager != null) {
                entityManager.getTransaction().commit();
                entityManager.close();
            }
        }

        return jugadores;
    }

}
