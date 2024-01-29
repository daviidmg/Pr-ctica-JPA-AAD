package DAO;

import java.util.List;

import entidades.Equipo;


public class EquipoDAO extends GenericDAOImpl<Equipo> {
	
    public EquipoDAO() {
        super(Equipo.class);
    }
    
	 @Override
	 protected Class<Equipo> getEntityClass() {
	     return Equipo.class;
	 } 
	
}


/* */


/*	public static Equipo findEquipoByName(String nombre) {
	        EntityManager em = getEmf().createEntityManager();

	        try {
	            Query query = em.createQuery("SELECT s FROM Equipo s WHERE s.nombre = :nombre");
	            query.setParameter("nombre", nombre);

	            List<Equipo> equipos = query.getResultList();

	            return equipos.isEmpty() ? null : equipos.get(0);
	        } finally {
	            em.close();
	        }
	    }*/

  
	//private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperLiga");

	 /*   public static void insertarEquipo(Equipo equipo) {
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();

	        try {
	            transaction.begin();
	            em.persist(equipo);
	            transaction.commit();
	            System.out.println("Equipo insertado en la base de datos: " + equipo.getNombre());
	        }catch (EntityExistsException entityExists) {
	        	System.err.println("ERROR al persistir la entidad: "+equipo.getNombre()+" - "+entityExists.getLocalizedMessage()+"\nCause by: "+entityExists.getCause());
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
	    } */

