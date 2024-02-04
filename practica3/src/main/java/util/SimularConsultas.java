package util;

import demo.ConsultasCompeticion;
/*** Esta clase proporciona métodos para simular consultas en la competición.
* 
* @author David
*/
public class SimularConsultas {

	public static void lanzarConsultas() {
        ConsultasCompeticion.obtenerCaracteristicasCompeticion();
        ConsultasCompeticion.obtenerEquiposParticipantes();
        ConsultasCompeticion.obtenerJugadoresPorEquipo(3);
        ConsultasCompeticion.obtenerPatrocinadoresPorEquipo(2);
        ConsultasCompeticion.obtenerJugadoresYPatrocinadoresPorEquipo(5);
        ConsultasCompeticion.calcularEdadPromedioJugadoresPorEquipo(7);
        ConsultasCompeticion.contarDeportistasMayoresVeintitresPorNacionalidad("Portugués");
        ConsultasCompeticion.mostrarEquiposConMasYMenosPuntos();
        ConsultasCompeticion.mostrarNuevasIncorporaciones();
        ConsultasCompeticion.mostrarJugadoresFichados();
        ConsultasCompeticion.contarTotalJugadores();
        ConsultasCompeticion.mostrarPatrocinadoresComunesEntreEquipos("UCAM", "ZETA");
        ConsultasCompeticion.ejecutarEjemplosCriteriaQuery();
	}
}
