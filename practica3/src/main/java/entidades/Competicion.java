package entidades;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static final Logger logger = LogManager.getLogger(Competicion.class);
	
	@Id
    @Column (name = "name")
    private String nombre;
	
    
	@Column (name = "creation_date")
    private String fechaCreacion;
	
	@Column (name = "journeys")
    private int numeroJornadas;
	
	@Column (name = "number_of_teams")
    private int numeroEquipos;
		    
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
	
    public Competicion(String nombre, String fechaCreacion, int numeroJornadas, int numeroEquipos) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.numeroJornadas = numeroJornadas;
        this.numeroEquipos = numeroEquipos;
    }
    
    
    public static void actualizarResultados(Equipo ganador, Equipo perdedor) {
        EquipoDAO equipoDAO = new EquipoDAO();

        // Incrementar las victorias y partidos jugados del ganador
        if (ganador != null) {
            ganador.incrementarVictorias();
            ganador.incrementarPartidosJugados();
            equipoDAO.update(ganador);
            logger.info("Actualizadas estadísticas del equipo ganador: {}", ganador);
        }

        // Incrementar las derrotas y partidos jugados del equipo perdedor
        perdedor.incrementarDerrotas();
        perdedor.incrementarPartidosJugados();
        equipoDAO.update(perdedor);
        logger.info("Actualizadas estadísticas del equipo perdedor: {}", perdedor);
    }
        
    @Override
	public String toString() {
		return "Competicion [nombre= " + nombre + ", numero de equipos= " + numeroEquipos + " fecha de creacion= " + fechaCreacion
				+ ", numero de jornadas= " + numeroJornadas + "]";
	}
}
