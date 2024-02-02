package entidades;

import java.time.LocalDate;
import java.time.Period;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 * Esta clase representa un jugador en la competición.
 *
 * @author David
 */

@Entity
@NamedQuery(
	    name = "Jugador.findNuevasIncorporaciones",
	    query = "SELECT j FROM Jugador j WHERE j.nuevaIncorporacion = true"
	)
@Table(name = "player")
public class Jugador {
    private static final Logger logger = LogManager.getLogger(Jugador.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String nombre;

    @Column(name = "nationality")
    private String nacionalidad;

    @Column(name = "birth_date")
    private LocalDate fechaNacimiento;
    
    @Column(nullable = false, name = "is_transfer")
    private boolean fichaje; 
    
    @Column(nullable = false, name = "is_new_player")
    private boolean nuevaIncorporacion; 

    @Column(name = "position")
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "team_id_fk") // nombre de la columna en la tabla 'player' que referencia a 'team'
    private Equipo equipo; // relación Many-to-One con la entidad Equipo


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	

    public boolean isNuevaIncorporacion() {
		return nuevaIncorporacion;
	}

	public void setNuevaIncorporacion(boolean nuevaIncorporacion) {
		this.nuevaIncorporacion = nuevaIncorporacion;
	}

	public boolean isFichaje() {
		return fichaje;
	}

	public void setFichaje(boolean fichaje) {
		this.fichaje = fichaje;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Jugador() {

    }

	public Jugador(String nombre, String nacionalidad, LocalDate fechaNacimiento, String posicion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.posicion = posicion;
    //    this.fichaje = false;
	}

	@Override
		public String toString() {
			return "Jugador con ID: " + id + "[Nombre: " + nombre + ", nacionalidad: " + nacionalidad 
					+ ", nacido en: " + fechaNacimiento + ", juega en: " + equipo + " de: " + posicion;
		}
	
    public void logJugadorInfo() {
        logger.info("Jugador creado - ID: {}, Nombre: {}, Nacionalidad: {}, Fecha de Nacimiento: {}, Posición: {}, Equipo: {}",
                id, nombre, nacionalidad, fechaNacimiento, posicion, equipo.getNombre());
    }
    
    public static int calcularEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }
    

}

