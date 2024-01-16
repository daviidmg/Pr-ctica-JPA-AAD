package util;

import java.util.List;

import DAO.EquipoDAO;
import entidades.Equipo;

public class CargarDatos {
    private DataSourceEquipo dataSourceEquipo;
    private EquipoDAO equipoDAO;

    public void cargarEquiposEnDB() {
        List<Equipo> equipos = dataSourceEquipo.getEquipos();
        for (Equipo equipo : equipos) {
        	switch (equipo.getNombre()) {
			case "Case Esports":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresCase()); 
				break;
			
			case "Barça Esports":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresBarca());

			default:
				break;
			}
            equipoDAO.insertarEquipo(equipo);
        }
    }
    
    
}