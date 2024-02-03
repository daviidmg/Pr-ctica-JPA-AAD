package entidades;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "surname")
    private String apellido;
    
    @Column(name = "nickName")
    private String nick;
    
    @Column(name = "birth_date")
    private LocalDate fechaNacimiento;
    
    @Column(name = "nationality")
    private String nacionalidad;
    
    @OneToOne
    @JoinColumn(name = "equipo_id_fk")
    private Equipo equipo;


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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
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

	public Coach() {
		
	}
	
	public Coach(String nombre, String apellido, String nickName, String nacionalidad, LocalDate fechaNacimiento) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nick = nickName;
		this.nacionalidad = nacionalidad;
	}
	
	    @Override
    public String toString() {
        return "Coach con ID: " + id + " [Nombre: " + nombre +  ", nacionalidad: " + nacionalidad 
        		+ ", nacido en: " + fechaNacimiento + ", entrena en: " + equipo;
    }
		
    
	
    /*    @Override
    public String toString() {
        return "Coach con ID: " + id + "[Nombre: " + nombre +  "nacionalidad: " + nacionalidad 
        		+ ", nacido en: " + fechaNacimiento + " entrena en: " + equipo;
    }
		*/
}
