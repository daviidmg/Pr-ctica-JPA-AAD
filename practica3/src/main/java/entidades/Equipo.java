package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
    @Column(name = "name")
    private String nombre;
    
    @Column(name = "win")
    private int victorias;

    @Column(name = "lose")
    private int derrotas;
    
    @Column(name = "matches")
    private String jornadasJugadas;

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

	public String getJornadasJugadas() {
		return jornadasJugadas;
	}

	public void setJornadasJugadas(String jornadasJugadas) {
		this.jornadasJugadas = jornadasJugadas;
	}


    // Constructores
    public Equipo() {

    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }
}

