package entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.EquipoDAO;
import DAO.JugadorDAO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Esta clase representa un equipo en la competición.
 *
 * @author David
 */
@Entity
@Table(name = "team")
public class Equipo {
    private static EquipoDAO equipoDAO = new EquipoDAO();
    private static JugadorDAO jugadorDAO = new JugadorDAO();
    private static final Logger logger = LogManager.getLogger(Equipo.class);
    						

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    
    @Column(name = "name", unique = true)
    private String nombre;
    
    @Column(name = "win")
    private int victorias;

    @Column(name = "lose")
    private int derrotas;
    
    @Column(name = "matches")
    private int jornadasJugadas;
    
	@OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Jugador> listaJugadores= new HashSet<Jugador>();
	
    // Relación Many-to-Many con la entidad Patrocinador
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    			fetch = FetchType.LAZY)
    @JoinTable(name = "equipo_patrocinador", 
        joinColumns = @JoinColumn(name = "equipo_id"), 
        inverseJoinColumns = @JoinColumn(name = "patrocinador_id"))
    private Set<Sponsor> patrocinadores=new HashSet<Sponsor>();
 
    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Coach coach;

    public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores.addAll(listaJugadores);
	}
    public Set<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	public String getNombre() {
		return nombre;
	}
		
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setListaJugadores(Set<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	public void setPatrocinadores(Set<Sponsor> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getJornadasJugadas() {
		return jornadasJugadas;
	}

	public void setJornadasJugadas(int jornadasJugadas) {
		this.jornadasJugadas = jornadasJugadas;
	}
	
	public Set<Sponsor> getPatrocinadores() {
		return patrocinadores;
	}
	
	public void setPatrocinadores(List<Sponsor> patrocinadores) {
		this.patrocinadores.addAll(patrocinadores);
	}


    // Constructores
    public Equipo() {

    }

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.victorias = 0;
        this.derrotas = 0;
        this.jornadasJugadas = 0;
    }
    
    public void agregarJugador(Jugador jugador) {
        this.listaJugadores.add(jugador);
        jugador.setEquipo(this);
    }
    
    // Métodos para agregar un patrocinador al equipo
    public void agregarPatrocinador(Sponsor patrocinador) {
        this.patrocinadores.add(patrocinador);
        patrocinador.agregarEquipoPatrocinado(this);
    }
    
    public void incrementarVictorias() {
    	this.victorias++;
        logger.info("Incrementada la cantidad de victorias del equipo {}: {}", this.nombre, this.victorias);
    }
    
    public void incrementarDerrotas() {
    	this.derrotas++;
        logger.info("Incrementada la cantidad de derrotas del equipo {}: {}", this.nombre, this.derrotas);
    }
    
    public void incrementarPartidosJugados() {
    	this.jornadasJugadas++;
        logger.info("Incrementada la cantidad de partidos jugados del equipo {}: {}", this.nombre, this.jornadasJugadas);
    }
    
	
    public void altaJugadorNuevo(Jugador jugador) {
    	agregarJugador(jugador);
    	
    	jugador.setEquipo(this);
    	
    	jugador.setNuevaIncorporacion(true);
    	
    	equipoDAO.update(this);
    	jugadorDAO.update(jugador);
    	
        logger.info("El equipo {} ha fichado al jugador {}.", getNombre(), jugador.getNombre());

    }
	
    public void ficharJugador(Jugador jugador) {
        // Agregar al jugador al equipo actual
        agregarJugador(jugador);
        
        // Establecer al equipo como el nuevo equipo del jugador
        jugador.setEquipo(this);
        jugador.setFichaje(true);
        
        // Actualizar en la base de datos
        equipoDAO.update(this);
        jugadorDAO.update(jugador);

        logger.info("El equipo {} ha fichado al jugador {}.", getNombre(), jugador.getNombre());
    }
    
    	public void baja(Jugador jugador) {
        	jugadorDAO.delete(jugador);

    		eliminarJugador(jugador);
        	jugador.setEquipo(null);
        	
        	equipoDAO.update(this);

            logger.info("El equipo {} ha prescindido del jugador {}.", getNombre(), jugador.getNombre());
    	}
       
    	public void eliminarJugador(Jugador jugador) {
            if (listaJugadores != null) {
                listaJugadores.remove(jugador);
                jugador.setEquipo(null); // Desasociar el equipo del jugador
            }
        }
    @Override
    public String toString() {
        return "Equipo{id=" + id + ", nombre='" + nombre + "'}";
    }
    
}