package dataSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entidades.Equipo;

public class DataSourceEquipo {
	
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
        return null;
    }

    public static List<Equipo> getEquipos() {
        return equipos;
    }

}
