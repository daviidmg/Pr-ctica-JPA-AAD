package entidades;

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
	
	public Competicion(String fechaCreacion) {
		
	}
    
    public Competicion(String nombre, String fechaCreacion, int numeroJornadas, int numeroEquipos) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.numeroJornadas = numeroJornadas;
        this.numeroEquipos = numeroEquipos;
    }
	@Override
	public String toString() {
		return "Competicion [nombre= " + nombre + ", numero de equipos= " + numeroEquipos + " fecha de creacion= " + fechaCreacion
				+ ", numero de jornadas= " + numeroJornadas + "]";
	}
}
