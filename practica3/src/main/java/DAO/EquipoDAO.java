package DAO;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
/**
 * Clase DAO para la entidad Equipo.
 * Se encarga de las operaciones de acceso a datos relacionadas con los equipos.
 *
 *@author David
 */
public class EquipoDAO extends GenericDAOImpl<Equipo> {
    private static final Logger LOGGER = LogManager.getLogger(EquipoDAO.class);	

    public EquipoDAO() {
        super(Equipo.class);
    }
    
	 @Override
	 protected Class<Equipo> getEntityClass() {
	     return Equipo.class;
	 } 
	
	    public Equipo findById(Long id) {
	        EntityManager entityManager = getEmf().createEntityManager();
	        try {
	            return entityManager.find(Equipo.class, id);
	        } catch (Exception e) {
	            LOGGER.error("Error al buscar equipo por ID: {}", e.getMessage());
	            throw e; // Puedes manejar la excepción según tus necesidades
	        } finally {
	            entityManager.close();
	        }
	    }
	    
	    public Equipo findByNombre(String nombre) {
	        EntityManager entityManager = getEmf().createEntityManager();
	        try {
	            String jpql = "SELECT e FROM Equipo e LEFT JOIN FETCH e.listaJugadores WHERE e.nombre = :nombre";
	            TypedQuery<Equipo> query = entityManager.createQuery(jpql, Equipo.class);
	            query.setParameter("nombre", nombre);
	            return query.getSingleResult();
	        } catch (NoResultException e) {
	            LOGGER.warn("No se encontró ningún equipo con el nombre: {}", nombre);
	            return null;
	        } finally {
	            entityManager.close();
	        }
	    }
	    
	    public List<Equipo> obtenerClasificacion() {
	        EntityManager entityManager = null;

	        try  {
	            entityManager = getEmf().createEntityManager();
	            entityManager.getTransaction().begin();

	            // Consulta JPQL para obtener la clasificación de los equipos
	            String jpql = "SELECT e FROM Equipo e ORDER BY e.victorias DESC";
	            TypedQuery<Equipo> query = entityManager.createQuery(jpql, Equipo.class);
	            List<Equipo> clasificacion = query.getResultList();

	            entityManager.getTransaction().commit();

	            return clasificacion;

	        } catch (Exception e) {
	            if (entityManager != null && entityManager.getTransaction().isActive()) {
	                entityManager.getTransaction().rollback();
	            }
	            LOGGER.error("Error al obtener la clasificación de los equipos", e);
	        } finally {
	            if (entityManager != null) {
	                entityManager.close();
	            }
	        }

	        return Collections.emptyList();
	    }
	    
	    public List<Equipo> findAllOrderedByPoints(int limit, boolean ascending) {
	        EntityManager entityManager = null;

	        try  {
	            entityManager = getEmf().createEntityManager();
	            entityManager.getTransaction().begin();
	            String jpql = "SELECT e FROM Equipo e ORDER BY e.victorias " + (ascending ? "ASC" : "DESC");
	            TypedQuery<Equipo> query = entityManager.createQuery(jpql, Equipo.class);
	            query.setMaxResults(limit);
	            
	            return query.getResultList();
	        } catch (Exception e) {
	            if (entityManager != null && entityManager.getTransaction().isActive()) {
	                entityManager.getTransaction().rollback();
	            }
	            LOGGER.error("Error al obtener la clasificación de los equipos", e);
	            throw e;
	        } finally {
	            if (entityManager != null) {
	                entityManager.close();
	            }
	        }
	    }
}