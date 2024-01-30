package dataSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import entidades.Jugador;
/**
 * Esta clase proporciona datos de jugadores.
 * Permite obtener un conjunto de jugadores por cada equipo.
 * 
 * @author David
 */
public class DataSourceJugador {
	private static Map<String, Set<Jugador>> jugadoresPorEquipo = new HashMap<>();

	static {
		//Jugadores case
        Jugador badlulu = new Jugador("Badlulu", "Francés", LocalDate.of(2002, 9, 13), "Top");
        Jugador maxi = new Jugador("MAXI", "Danés", LocalDate.of(2000, 6, 24), "Jungla");
        Jugador javier = new Jugador("Javier", "Español", LocalDate.of(1999, 4, 27), "Mid");
        Jugador denvoksne = new Jugador("DenVoksne", "Danés", LocalDate.of(2001, 7, 15), "Adc");
        Jugador rhuckz = new Jugador("Rhuckz", "Español", LocalDate.of(2004, 3, 21), "Support");
        
        //añadir jugadores de case a jugadoresporequipo
        jugadoresPorEquipo.put("Case Esports", new HashSet<Jugador>(Arrays.asList(
        		badlulu, maxi, javier, denvoksne, rhuckz)));
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores barça
        Jugador whiteknight = new Jugador("WhiteKnight", "Finés", LocalDate.of(1996, 2, 16), "Top");
        Jugador sajator = new Jugador("Sajator", "Checo", LocalDate.of(2004, 10, 11), "Jungla");
        Jugador naau = new Jugador("Naau", "Español", LocalDate.of(2001, 4, 13), "Mid");
        Jugador deadly = new Jugador("Deadly", "Inglés", LocalDate.of(2000, 8, 4), "Adc");
        Jugador xixauxas = new Jugador("Xixauxas", "Español", LocalDate.of(1997, 11, 16), "Support");
        
        jugadoresPorEquipo.put("Barça Esports", new HashSet<Jugador>(Arrays.asList(
        		whiteknight, sajator, naau, deadly, xixauxas)));
	
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores Ramboot
        Jugador ibo = new Jugador("iBo", "Polaco", LocalDate.of(1997, 3, 8), "Top");
        Jugador lebron = new Jugador("leBron", "Bulgaro", LocalDate.of(1999, 11, 26), "Jungla");
        Jugador twohoyrz = new Jugador("twohoyrz", "Bulgaro", LocalDate.of(1998, 8, 27), "Mid");
        Jugador rayito = new Jugador("Rayito", "Español", LocalDate.of(1997, 3, 8), "Adc");
        Jugador seneca = new Jugador("Seneca", "Sueco", LocalDate.of(1997, 3, 8), "Support");
	
	
        jugadoresPorEquipo.put("Ramboot", new HashSet<Jugador>(Arrays.asList(
        		ibo, lebron, twohoyrz, rayito, seneca)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores Rebels   
        Jugador r4ven = new Jugador("R4VEN", "Polaco", LocalDate.of(2000, 4, 17), "Top");
        Jugador ahahacik = new Jugador("AHaHaCiK", "Ruso", LocalDate.of(1999, 4, 1), "Jungla");
        Jugador special = new Jugador("Special", "Holandés", LocalDate.of(1998, 1, 27), "Mid");
        Jugador bean = new Jugador("BEAN", "Alemán", LocalDate.of(2000, 8, 11), "Adc");
        Jugador lekcyc = new Jugador("Lekcyc", "Ruso", LocalDate.of(1993, 7, 24), "Support");
        
        jugadoresPorEquipo.put("Rebels", new HashSet<Jugador>(Arrays.asList(
        		r4ven, ahahacik, special, bean, lekcyc)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores Guasones
        Jugador dreedy = new Jugador("Dreedy", "Checo", LocalDate.of(2001, 4, 9), "Top");
        Jugador memento = new Jugador("Memento", "Sueco", LocalDate.of(1999, 7, 24), "Jungla");
        Jugador ronaldo = new Jugador("Ronaldo", "Rumano", LocalDate.of(2000, 12, 18), "Mid");
        Jugador motroco = new Jugador("Motroco", "Español", LocalDate.of(1992, 4, 17), "Adc");
        Jugador duall = new Jugador("DuaLL", "Español", LocalDate.of(1999, 6, 25), "Support");
        
        jugadoresPorEquipo.put("Guasones", new HashSet<Jugador>(Arrays.asList(
        		dreedy, memento, ronaldo, motroco, duall)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores UCAM
        Jugador acd = new Jugador("ACD", "Estonio", LocalDate.of(2000, 6, 24), "Top");
        Jugador koldo = new Jugador("Koldo", "Español", LocalDate.of(2000, 11, 7), "Jungla");
        Jugador baca = new Jugador("Baca", "Portugués", LocalDate.of(2000, 5, 11), "Mid");
        Jugador kenal = new Jugador("Kenal", "Ruso", LocalDate.of(2003, 3, 4), "Adc");
        Jugador obstinatus = new Jugador("Obstinatus", "Portugués", LocalDate.of(2002, 12, 13), "Support");
        
        jugadoresPorEquipo.put("UCAM", new HashSet<Jugador>(Arrays.asList(
        		acd, koldo, baca, kenal, obstinatus)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores Los Heretics
        Jugador carlsen = new Jugador("Carlsen", "Danés", LocalDate.of(2005, 12, 15), "Top");
        Jugador xerxe = new Jugador("Xerxe", "Rumano", LocalDate.of(1999, 11, 5), "Jungla");
        Jugador zwyroo = new Jugador("Zwyroo", "Polaco", LocalDate.of(2004, 4, 2), "Mid");
        Jugador jackspektra = new Jugador("Jackspektra", "Noruego", LocalDate.of(2000, 12, 5), "Adc");
        Jugador whiteinn = new Jugador("whiteinn", "Rumano", LocalDate.of(2000, 10, 3), "Support");

        jugadoresPorEquipo.put("Los Heretics", new HashSet<Jugador>(Arrays.asList(
        		carlsen, xerxe, zwyroo, jackspektra, whiteinn)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores GiantX
        Jugador th3antonio = new Jugador("Th3Antonio", "Español", LocalDate.of(1995, 2, 15), "Top");
        Jugador maxlore = new Jugador("Maxlore", "Inglés", LocalDate.of(1996, 9, 25), "Jungla");
        Jugador jiizuke = new Jugador("Jiizuke", "Italiano", LocalDate.of(1997, 1, 14), "Mid");
        Jugador attila = new Jugador("Attila", "Portugués", LocalDate.of(1996, 2, 26), "Adc");
        Jugador stend = new Jugador("Stend", "Francés", LocalDate.of(2001, 7, 13), "Support");
        jugadoresPorEquipo.put("GiantX", new HashSet<Jugador>(Arrays.asList(
        		th3antonio, maxlore, jiizuke, attila, stend)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores Movistar KOI
        Jugador marky = new Jugador("Markyu", "Español", LocalDate.of(2002, 9, 23), "Top");
        Jugador noname = new Jugador("NoName", "Inglés", LocalDate.of(2003, 8, 15), "Jungla");
        Jugador random = new Jugador("Random", "Checo", LocalDate.of(2001, 12, 30), "Mid");
        Jugador shyCarry = new Jugador("Shy Carry", "Serbio", LocalDate.of(2004, 4, 21), "Adc");
        Jugador marlon = new Jugador("marlon", "Polaco", LocalDate.of(2004, 1, 14), "Support");
        
        jugadoresPorEquipo.put("Movistar KOI", new HashSet<Jugador>(Arrays.asList(
        		marky, noname, random, shyCarry, marlon)));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------
        
        //jugadores ZETA
        Jugador kaylem = new Jugador("Kaylem", "Rumano", LocalDate.of(2004, 3, 29), "Top");
        Jugador nyx = new Jugador("Nyx", "Español", LocalDate.of(2002, 3, 19), "Jungla");
        Jugador phlaty = new Jugador("Phlaty", "Ruso", LocalDate.of(1997, 7, 23), "Mid");
        Jugador mihai = new Jugador("Mihai", "Rumano", LocalDate.of(2000, 7, 7), "Adc");
        Jugador bolyy1 = new Jugador("Bolyy1", "Español", LocalDate.of(2000, 12, 12), "Support");

        jugadoresPorEquipo.put("ZETA", new HashSet<Jugador>(Arrays.asList(
        		kaylem, nyx, phlaty, mihai, bolyy1)));
	}

	public static Map<String, Set<Jugador>> getJugadoresPorEquipo() {
		return jugadoresPorEquipo;
	}
	
	
}