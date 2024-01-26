package entidades;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import jakarta.persistence.Table;

/**
 * Esta clase representa un equipo en la competición.
 *
 * @author David
 */
@Entity
@Table(name = "team")
public class Equipo {

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
    
	@OneToMany(mappedBy = "equipo",cascade = CascadeType.ALL)
    private Set<Jugador> listaJugadores= new HashSet<Jugador>();
	
    // Relación Many-to-Many con la entidad Patrocinador
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
    			fetch = FetchType.EAGER)
    @JoinTable(name = "equipo_patrocinador", 
        joinColumns = @JoinColumn(name = "equipo_id"), 
        inverseJoinColumns = @JoinColumn(name = "patrocinador_id"))
    private Set<Sponsor> patrocinadores=new HashSet<Sponsor>();
 
    public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores.addAll(listaJugadores);
	}
    public Set<Jugador> getListaJugadores() {
		return listaJugadores;
	}
	public String getNombre() {
		return nombre;
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
    }
    
    public void incrementarDerrotas() {
    	this.derrotas++;
    }
    
    public void incrementarPartidosJugados() {
    	this.jornadasJugadas++;
    }
    
    /*public void agregarPatrocinadorEspecifico(Sponsor sponsor) {
        this.agregarPatrocinador(sponsor);
    }*/
}

