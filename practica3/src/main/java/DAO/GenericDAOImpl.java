package DAO;

import java.util.List;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class GenericDAOImpl<T> implements GenericDAO<T> {
    private final Class<T> entityClass;
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperLiga");
	
    
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
                System.out.println("Entidad insertada en la base de datos: ");
            } catch (EntityExistsException entityExists) {
                System.err.println("ERROR al persistir la entidad: " + " - " + entityExists.getLocalizedMessage() + "\nCause by: " + entityExists.getCause());
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
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
            } catch (Exception e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }

	
	public void delete(T entity) {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction transaction = em.getTransaction();
            try {
	           transaction.begin();
	           em.remove(entity);
	           transaction.commit();
	           System.out.println("Equipo insertado en la base de datos: " + entity.toString());
            
            }catch (EntityExistsException entityExists) {
       	
            	System.err.println("ERROR al persistir la entidad: "+entity.toString()+" - "+entityExists.getLocalizedMessage()+"\nCause by: "+entityExists.getCause());
   	
            }catch (Exception e) {
            	if (transaction != null && transaction.isActive()) {
            		transaction.rollback();
            	}
            	e.printStackTrace();   
            }			
        }
	}

	public List<T> findAll() {
		  
		try (EntityManager em = emf.createEntityManager()) {
			
			String queryString = "SELECT e FROM " + getEntityClass().getSimpleName() + " e";
			TypedQuery<T> query = em.createQuery(queryString, getEntityClass());
			return query.getResultList();
			
	        }
	}
}


