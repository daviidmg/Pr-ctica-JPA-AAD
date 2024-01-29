package cargaDatos;

import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO.CompeDAO;
import DAO.EquipoDAO;
import DAO.JugadorDAO;
import DAO.SponsorDAO;
import dataSource.DataSourceEquipo;
import dataSource.DataSourceJugador;
import dataSource.DataSourceSponsor;
import entidades.Competicion;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Sponsor;
import jakarta.persistence.EntityManager;

public class CargarDatos {
		
    public CargarDatos() {
    
    }
    
    public static void cargarEquiposEnDB() {
    	List<Equipo> equipos = DataSourceEquipo.getEquipos();
    	Map<String, Set<Jugador>> jugadoresPorEquipo = DataSourceJugador.getJugadoresPorEquipo();
    	Map<String, Set<Sponsor>> sponsorsPorEquipo = DataSourceSponsor.getSponsorsPorEquipo();
    	EquipoDAO equipoDAO = new EquipoDAO();
    	JugadorDAO jugadorDAO = new JugadorDAO();    
    	SponsorDAO sponsorDAO = new SponsorDAO();
		CompeDAO compeDAO = new CompeDAO();
    	
        Competicion superLiga = new Competicion("SuperLiga", "01/02/2012", 9, 10);
        compeDAO.save(superLiga);
    	
    	for (Equipo equipo : equipos) {
			// Insertar equipo
    		equipoDAO.save(equipo);
    		
    		//Obtener jugadores por equipo
    		Set<Jugador> jugadores = jugadoresPorEquipo.get(equipo.getNombre());
    		
    		//Obtener jugadores por equipo
    		Set<Sponsor> sponsors = sponsorsPorEquipo.get(equipo.getNombre());
    		
    		//Insertar Jugadores
    		for (Jugador jugador : jugadores) {
    			
    			jugador.setEquipo(equipo);
    			equipo.agregarJugador(jugador);

    			if (jugador.getId() != null) {
                    jugadorDAO.update(jugador);
                    
                } else {
                    jugadorDAO.save(jugador);
                 
                }

    			/*	jugadorDAO.save(jugador);
    			equipo.agregarJugador(jugador);*/
    		}
    		
    		for (Sponsor sponsor : sponsors) {
    			
    			sponsor.agregarEquipoPatrocinado(equipo);
    			equipo.agregarPatrocinador(sponsor);


                // Si el sponsor ya está en la base de datos, actualizar en lugar de guardar
                if (sponsor.getId() != null) {
                    sponsorDAO.update(sponsor);
                    
                } else {
                    sponsorDAO.save(sponsor);
                    
                }

                
    		
                /*sponsorDAO.save(sponsor);
    			sponsor.agregarEquipoPatrocinado(equipo);
    			equipo.agregarPatrocinador(sponsor);*/
    			
    		}
    	}
    	
    }
}
 /*       List<Equipo> equipos = DataSourceEquipo.getEquipos();
        List<Sponsor> sponsorsComunes= DataSourceSponsor.getSponsorsRepetidos();
        
        for(Sponsor patrocinador: DataSourceSponsor.getSponsorsRepetidos()) {
        	SponsorDAO.insertarSponsor(patrocinador);
        }

        for (Equipo equipo : equipos) {
        	switch (equipo.getNombre()) {
			case "Case Esports":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresCase());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsCase());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(1));
				break;
			
			case "Barça Esports":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresBarca());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsBarca());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(0));
				break;
			
			case "Ramboot":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresRamboot());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsRamboot());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(2));
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(3));
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
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(0));
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(1));
				break;
				
			case "Los Heretics":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresLosHeretics());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsLosHeretics());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(2));
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(4));
				break;
				
			case "GiantX":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresGiantX());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsGiantX());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(3));
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(5));
				break;
				
			case "Movistar KOI":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresMovistarKoi());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsMovistarKOI());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(4));
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(5));
				break;
				
			case "ZETA":
				equipo.setListaJugadores(DataSourceJugador.getJugadoresZeta());
				equipo.setPatrocinadores(DataSourceSponsor.getSponsorsZETA());
			//	equipo.agregarPatrocinadorEspecifico(DataSourceSponsor.getSponsorsRepetidos().get(3));
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
            
        	EquipoDAO.insertarEquipo(equipo);
            
            
        }  */  
