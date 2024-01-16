package DAO;

import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EquipoDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperLiga");

	    public void insertarEquipo(Equipo equipo) {
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();

	        try {
	            transaction.begin();
	            em.persist(equipo);
	            transaction.commit();
	            System.out.println("Equipo insertado en la base de datos: " + equipo.getNombre());
	        } catch (Exception e) {
	            if (transaction != null && transaction.isActive()) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            if (em != null) {
	                em.close();
	            }
	        }
	    }
}
