package DAO;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
/**
 * Implementación genérica de un DAO.
 * Proporciona métodos comunes para realizar operaciones CRUD en la base de datos.
 *
 * @param <T> Tipo de la entidad JPA.
 * @author David
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {
    private final Class<T> entityClass;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperLiga");
    private static final Logger LOGGER = LogManager.getLogger(GenericDAOImpl.class);	
    
	public static EntityManagerFactory getEmf() {
		return emf;
	}
	
    protected Class<T> getEntityClass() {
		return entityClass;
	}
    
    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public void save(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.persist(entity);
                transaction.commit();
                LOGGER.info("Entidad insertada en la base de datos: " + entity.toString());
            } catch (EntityExistsException entityExists) {
                LOGGER.error("ERROR al persistir la entidad: " + entity.toString() + " - " + entityExists.getLocalizedMessage() + "\nCause by: " + entityExists.getCause());
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                LOGGER.error("Error desconocido al persistir la entidad: " + entity.toString(), e);
            }
        }
    }

    public void update(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.merge(entity);
                transaction.commit();
                LOGGER.info("Entidad actualizada en la base de datos: " + entity.toString());
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                LOGGER.error("Error al actualizar la entidad: " + entity.toString(), e);
            }
        }
    }

	
    public void delete(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                
                // Si la entidad no está en el contexto de persistencia, realiza merge
                T mergedEntity = em.contains(entity) ? entity : em.merge(entity);
                
                em.remove(mergedEntity);
                transaction.commit();
                
                LOGGER.info("Entidad eliminada de la base de datos: " + mergedEntity.toString());
            } catch (EntityExistsException entityExists) {
                LOGGER.error("ERROR al eliminar la entidad: " + entity.toString() + " - " + entityExists.getLocalizedMessage() + "\nCause by: " + entityExists.getCause());
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                LOGGER.error("Error desconocido al eliminar la entidad: " + entity.toString(), e);
            }
        }
    }

	public List<T> findAll() {
		  
		try (EntityManager em = emf.createEntityManager()) {
			
			String queryString = "SELECT e FROM " + getEntityClass().getSimpleName() + " e";
			TypedQuery<T> query = em.createQuery(queryString, getEntityClass());
            List<T> resultList = query.getResultList();
            LOGGER.info("Se obtuvieron todos los elementos de la entidad " + getEntityClass().getSimpleName());
            return resultList;
            
	        }catch (Exception e) {
	            LOGGER.error("Error al obtener todos los elementos de la entidad " + getEntityClass().getSimpleName(), e);
	            throw e;
	        }
	}
}


