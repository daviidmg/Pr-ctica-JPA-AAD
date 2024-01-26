package entidades;

import java.util.ArrayList;
import java.util.List;

import DAO.EquipoDAO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Esta clase representa la competición.
 *
 * @author David
 */

@Entity
@Table(name = "competition")
public class Competicion {
	
	@Id
    @Column (name = "name")
    private String nombre;
    
	@Column (name = "creation_date")
    private String fechaCreacion;
	
	@Column (name = "journeys")
    private int numeroJornadas;
	
	@Column (name = "number_of_teams")
    private int numeroEquipos;
	
//	private List<Equipo> equipos;
	
//	private List<Partido> partidos;
    
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getNumeroJornadas() {
		return numeroJornadas;
	}
	public void setNumeroJornadas(int numeroJornadas) {
		this.numeroJornadas = numeroJornadas;
	}
	public int getNumeroEquipos() {
		return numeroEquipos;
	}
	public void setNumeroEquipos(int numeroEquipos) {
		this.numeroEquipos = numeroEquipos;
	}
    
	public Competicion() {
	}
	
	/*public Competicion(List<Equipo> equipos) {
		this.equipos = equipos;
	}*/
	
    public Competicion(String nombre, String fechaCreacion, int numeroJornadas, int numeroEquipos) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.numeroJornadas = numeroJornadas;
        this.numeroEquipos = numeroEquipos;
    }
    
 /*   private List<Partido> generarPartidos() {
    	List<Partido> partidosGenerados = new ArrayList<>();
    	
    	for (int i = 0; i < equipos.size(); i++) {
    		for (int j = i + 1; j < equipos.size(); j++) {
    			partidosGenerados.add(new Partido(equipos.get(i), equipos.get(j)));
    			partidosGenerados.add(new Partido(equipos.get(j), equipos.get(i)));
    		}
    	}
    	
    	return partidosGenerados;
    }*/
    
    /*public void simularJornada() {
        for (Partido partido : partidos) {
            Equipo ganador = partido.simularPartido();
            actualizarResultados(ganador, partido.getEquipoLocal(), partido.getEquipoVisitante());
        }
    }*/
    
    private void actualizarResultados(Equipo ganador, Equipo equipoLocal, Equipo equipoVisitante) {
        EquipoDAO equipoDAO = new EquipoDAO();

        ganador.incrementarVictorias();
        ganador.incrementarPartidosJugados();
        equipoDAO.update(ganador);

        equipoLocal.incrementarDerrotas();
        equipoLocal.incrementarPartidosJugados();
        equipoDAO.update(equipoLocal);

        equipoVisitante.incrementarDerrotas();
        equipoVisitante.incrementarPartidosJugados();
        equipoDAO.update(equipoVisitante);
    }
    
  /*  private void actualizarResultados(Equipo ganador, Equipo perdedor) {
    	EquipoDAO equipoDAO = new EquipoDAO();
    	
    	if (ganador != null) {
    		ganador.incrementarVictorias();
    		ganador.incrementarPartidosJugados();
    		equipoDAO.update(ganador);
    	}
    	
    	if (perdedor != null) {
    		perdedor.incrementarDerrotas();
    		perdedor.incrementarPartidosJugados();
    		equipoDAO.update(perdedor);
    	}
    }*/
    
    @Override
	public String toString() {
		return "Competicion [nombre= " + nombre + ", numero de equipos= " + numeroEquipos + " fecha de creacion= " + fechaCreacion
				+ ", numero de jornadas= " + numeroJornadas + "]";
	}
}
