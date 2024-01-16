package util;

import java.util.ArrayList;
import java.util.List;

import entidades.Equipo;

public class DataSourceEquipo {
	
	private List<Equipo> equipos = new ArrayList<Equipo>();

	public void agregarEquipo() {
		       
		Equipo caseEsports = new Equipo("Case Esports");
	    equipos.add(caseEsports);
	    Equipo barcaEsports = new Equipo("Barça Esports");
	    equipos.add(barcaEsports);
	    Equipo ramboot = new Equipo("Ramboot");
	    equipos.add(ramboot);
	    Equipo rebels = new Equipo("Rebels");
	    equipos.add(rebels);
	    Equipo guasones = new Equipo("Guasones");
	    equipos.add(guasones);
	    Equipo UCAM = new Equipo("UCAM");
	    equipos.add(UCAM);
	    Equipo losHeretics = new Equipo("Los Heretics");
	    equipos.add(losHeretics);
	    Equipo giantX = new Equipo("GiantX");
	    equipos.add(giantX);
	    Equipo movistarKOI = new Equipo("Movistar KOI");
	    equipos.add(movistarKOI);
	    Equipo ZETA = new Equipo("ZETA");
	    equipos.add(ZETA);                
	}

    public List<Equipo> getEquipos() {
        return equipos;
    }

}
