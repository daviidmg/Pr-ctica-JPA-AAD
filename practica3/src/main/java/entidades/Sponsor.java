package entidades;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Esta clase representa un patrocinador en la competición.
 *
 * @author David
 */

@Entity
@Table(name = "sponsor")
public class Sponsor {
    private static final Logger logger = LogManager.getLogger(Sponsor.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String nombre;

    // Relación Many-to-Many con la entidad Equipo
    @ManyToMany(mappedBy = "patrocinadores")
    private Set<Equipo> equiposPatrocinados = new HashSet<>();


    public Sponsor() {

    }

    public Sponsor(String nombre) {
        this.nombre = nombre;
    }
    public Sponsor(String nombre, List<Equipo> equipos) {
        this.nombre = nombre;
        this.equiposPatrocinados.addAll(equipos);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Equipo> getEquiposPatrocinados() {
        return equiposPatrocinados;
    }

    // Método para agregar un equipo a la colección
    public void agregarEquipoPatrocinado(Equipo equipo) {
        this.equiposPatrocinados.add(equipo);
        equipo.getPatrocinadores().add(this);
        logger.info("Equipo '{}' agregado a la colección de equipos patrocinados por '{}'.", equipo.getNombre(), this.nombre);
    }
    
    public void logSponsorInfo() {
        logger.info("Patrocinador creado - ID: {}, Nombre: {}", id, nombre);
    }
}
