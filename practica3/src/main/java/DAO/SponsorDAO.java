package DAO;

import java.util.List;
import java.util.Map;
import java.util.Set;

import dataSource.DataSourceSponsor;
import entidades.Sponsor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class SponsorDAO extends GenericDAOImpl<Sponsor> {
	
    public SponsorDAO() {
        super(Sponsor.class);
    }
	
}

//	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperLiga");

  /*  public static void insertarSponsor(Sponsor sponsor) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(sponsor);
            transaction.commit();
            System.out.println("Sponsor insertado en la base de datos: " + sponsor.getNombre());
        }catch (EntityExistsException entityExists) {
        	System.err.println("ERROR al persistir la entidad: "+sponsor.getNombre()+" - "+entityExists.getLocalizedMessage()+"\nCause by: "+entityExists.getCause());
    	}catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }*/
