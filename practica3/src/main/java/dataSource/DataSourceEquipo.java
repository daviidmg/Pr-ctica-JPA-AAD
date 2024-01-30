package dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entidades.Equipo;
/**
 * Esta clase proporciona datos de equipos para la aplicación.
 * Permite obtener un equipo por su nombre y obtener la lista de todos los equipos.
 * 
 * @author David
 */
public class DataSourceEquipo {
    private static final Logger logger = LogManager.getLogger(DataSourceEquipo.class);

	private static List<Equipo> equipos = new ArrayList<Equipo>(Arrays.asList(
			new Equipo("Case Esports"),
		    new Equipo("Barça Esports"),
		    new Equipo("Ramboot"),
		    new Equipo("Rebels"),
		    new Equipo("Guasones"),
		    new Equipo("UCAM"),
		    new Equipo("Los Heretics"),
		    new Equipo("GiantX"),
		    new Equipo("Movistar KOI"),
		    new Equipo("ZETA")
			));
	
    public static Equipo getEquipoByName(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;
            }
        }
        logger.warn("No se encontró ningún equipo con el nombre: {}", nombre);
        return null;
    }

    public static List<Equipo> getEquipos() {
        return equipos;
    }

}
