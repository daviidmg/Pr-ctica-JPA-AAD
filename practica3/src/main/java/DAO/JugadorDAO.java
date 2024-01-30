package DAO;

import entidades.Jugador;
/**
 * Clase DAO para la entidad Jugador.
 * Se encarga de las operaciones de acceso a datos relacionadas con los jugadores.
 *
 *@author David
 */
public class JugadorDAO extends GenericDAOImpl<Jugador>{

    public JugadorDAO() {
        super(Jugador.class);
    }
    
}
