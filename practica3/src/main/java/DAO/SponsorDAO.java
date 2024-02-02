package DAO;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entidades.Equipo;
import entidades.Sponsor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
/**
 * Clase DAO para la entidad Sponsor.
 * Se encarga de las operaciones de acceso a datos relacionadas con los sponsors.
 *
 *@author David
 */
public class SponsorDAO extends GenericDAOImpl<Sponsor> {
    private static EquipoDAO equipoDAO = new EquipoDAO();
    private static final Logger LOGGER = LogManager.getLogger(JugadorDAO.class);	

    public SponsorDAO() {
        super(Sponsor.class);
    }
    
    public List<Sponsor> findPatrocinadoresByEquipo(Equipo equipo) {
        EntityManager entityManager = getEmf().createEntityManager();
        try {
        	String jpql = "SELECT p FROM Sponsor p JOIN p.equiposPatrocinados e WHERE e.id = :equipoId";
        	TypedQuery<Sponsor> query = entityManager.createQuery(jpql, Sponsor.class);
        	query.setParameter("equipoId", equipo.getId()); 

            return query.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    
    public List<Sponsor> findPatrocinadoresComunes(String nombreEquipo1, String nombreEquipo2) {
        EntityManager entityManager = getEmf().createEntityManager();

        try {
            Equipo equipo1 = equipoDAO.findByNombre(nombreEquipo1);
            Equipo equipo2 = equipoDAO.findByNombre(nombreEquipo2);
            
            String jpql = "SELECT s FROM Sponsor s WHERE :equipo1 MEMBER OF s.equiposPatrocinados AND :equipo2 MEMBER OF s.equiposPatrocinados";
            TypedQuery<Sponsor> query = entityManager.createQuery(jpql, Sponsor.class);
            query.setParameter("equipo1", equipo1);
            query.setParameter("equipo2", equipo2);

            return query.getResultList();
        } catch (Exception e) {
            LOGGER.error("Error al obtener patrocinadores comunes entre equipos: {}", e.getMessage());
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
  /*  public List<Sponsor> findPatrocinadoresPorEquipo(Equipo equipo) {
        EntityManager entityManager = null;
        List<Sponsor> patrocinadores = null;

        try {
            entityManager = getEmf().createEntityManager();
            entityManager.getTransaction().begin();

            // Consulta JPQL para obtener los patrocinadores de un equipo específico
            String jpql = "SELECT p FROM Equipo e JOIN e.patrocinadores p WHERE e = :equipo";
            TypedQuery<Sponsor> query = entityManager.createQuery(jpql, Sponsor.class);
            query.setParameter("equipo", equipo);
            patrocinadores = query.getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            // Manejo de excepciones
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return patrocinadores;
    }*/


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
