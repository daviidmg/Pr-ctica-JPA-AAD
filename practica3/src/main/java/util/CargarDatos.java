package util;

import java.util.List;

import DAO.EquipoDAO;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Sponsor;

public class CargarDatos {
    private static DataSourceEquipo dataSourceEquipo;

    public CargarDatos(DataSourceEquipo dataSourceEquipo) {
        CargarDatos.dataSourceEquipo = dataSourceEquipo;
    }
    
    public void cargarEquiposEnDB(EquipoDAO equipoDAO) {
        List<Equipo> equipos = dataSourceEquipo.getEquipos();
        for (Equipo equipo : equipos) {
        	switch (equipo.getNombre()) {
			case "Case Esports":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresCase());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsCase());
				break;
			
			case "Barça. Esports":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresBarca());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsBarca());
				break;
			
			case "Ramboot":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresRamboot());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsRamboot());
				break;

			case "Rebels":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresRebels());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsRebels());
				break;
				
			case "Guasones":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresGuasones());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsGuasones());
				break;
				
			case "UCAM":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresUCAM());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsUCAM());
				break;
				
			case "Los Heretics":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresLosHeretics());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsLosHeretics());
				break;
				
			case "GiantX":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresGiantX());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsGiantX());
				break;
				
			case "Movistar KOI":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresMovistarKoi());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsMovistarKOI());
				break;
				
			case "ZETA":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresZeta());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsZETA());
				break;
				
			default:
				break;
			}
        	
        	//Asignar jugadores a su equipo
            for (Jugador jugador : equipo.getListaJugadores()) {
                jugador.setEquipo(equipo);
                equipo.agregarJugador(jugador);
            }
            
            for (Sponsor sponsor : equipo.getPatrocinadores()) {
            	sponsor.agregarEquipoPatrocinado(equipo);
            	equipo.agregarPatrocinador(sponsor);
            }
            
            equipoDAO.insertarEquipo(equipo);
            
        }    
    }
    
}