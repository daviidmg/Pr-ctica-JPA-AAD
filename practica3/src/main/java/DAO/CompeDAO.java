package DAO;

import entidades.Competicion;
/**
 * Clase DAO para la entidad Competicion.
 * Se encarga de las operaciones de acceso a datos relacionadas con las competiciones.
 *
 *@author David
 */
public class CompeDAO extends GenericDAOImpl<Competicion>{
   
	public CompeDAO() {
        super(Competicion.class);
    }
	
}
