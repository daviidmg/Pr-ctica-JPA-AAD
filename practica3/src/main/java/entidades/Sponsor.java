package entidades;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase representa un patrocinador en la competición.
 *
 * @author David
 */

@Entity
@Table(name = "sponsor")
public class Sponsor {

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
        equiposPatrocinados.add(equipo);
        equipo.getPatrocinadores().add(this);
    }
}
