package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Jugador;

public class DataSourceJugador {
	private static Map<String, List<Jugador>> jugadoresMap = new HashMap<>();
	private static List<Jugador> jugadoresCase = new ArrayList<Jugador>(Arrays.asList(
			new Jugador("Badlulu", "Francés", "13/09/2002", "Top"),
	        new Jugador("MAXI", "Danés", "24/06/2000", "Jungla"),
	        new Jugador("Javier", "Español", "27/04/1999", "Mid"),
	        new Jugador("DenVoksne", "Danés", "15/07/2001", "Adc"),
	        new Jugador("Rhuckz", "Español", "13/09/2002", "Support")
			));
	
	private static List<Jugador> jugadoresBarca = new ArrayList<Jugador>(Arrays.asList(
			new Jugador("WhiteKnight", "Finés", "16/02/1996", "Top"),
			new Jugador("Sajator", "Checo", "11/10/2004", "Jungla"),
			new Jugador("Naau", "Español", "13/04/2001", "Mid"),
			new Jugador("Deadly", "Inglés", "04/08/2000", "Adc"),
			new Jugador("Xixauxas", "Español", "16/11/1997", "Support")
			));
	
	private static List<Jugador> jugadoresRamboot = new ArrayList<Jugador>(Arrays.asList(
			new Jugador("iBo", "Polaco", "08/03/1997", "Top"),
			new Jugador("leBron", "Bulgaro", "26/11/1999", "Jungla"),
			new Jugador("twohoyrz", "Bulgaro", "27/08/1998", "Mid"),
			new Jugador("Rayito", "Español", "08/03/1997", "Adc"),
			new Jugador("Seneca", "Sueco", "08/03/1997", "Support")
			));
	
	private static List<Jugador> jugadoresRebels = new ArrayList<Jugador>(Arrays.asList(
			new Jugador("iBo", "Polaco", "08/03/1997", "Top"),
		    new Jugador("leBron", "Bulgaro", "26/11/1999", "Jungla"),
		    new Jugador("twohoyrz", "Bulgaro", "27/08/1998", "Mid"),
		    new Jugador("Rayito", "Español", "08/03/1997", "Adc"),
		    new Jugador("Seneca", "Sueco", "08/03/1997", "Support")		       
			));
	
	private static List<Jugador> jugadoresGuasones = new ArrayList<Jugador>(Arrays.asList(
	        new Jugador("R4VEN", "Polaco", "17/04/2000", "Top"),
	        new Jugador("AHaHaCiK", "Ruso", "01/04/1999", "Jungla"),
	        new Jugador("Special", "Holandés", "27/01/1998", "Mid"),
	        new Jugador("BEAN", "Aleman", "11/08/2000", "Adc"),
	        new Jugador("Lekcyc", "Ruso", "24/07/1993", "Support")
	        ));

	private static List<Jugador> jugadoresUCAM = new ArrayList<Jugador>(Arrays.asList(
	        new Jugador("Dreedy", "Checo", "09/04/2001", "Top"),
	        new Jugador("Memento", "Sueco", "24/07/1999", "Jungla"),
	        new Jugador("Ronaldo", "Rumano", "18/12/2000", "Mid"),
	        new Jugador("Motroco", "Español", "17/04/1992", "Adc"),
	        new Jugador("DuaLL", "Español", "25/06/1999", "Support")

	        ));
	private static List<Jugador> jugadoresLosHeretics = new ArrayList<Jugador>(Arrays.asList(
	        new Jugador("ACD", "Estonio", "24/06/2000", "Top"),
	        new Jugador("Koldo", "Español", "07/11/2000", "Jungla"),
	        new Jugador("Baca", "Portugués", "11/05/2000", "Mid"),
	        new Jugador("Kenal", "Ruso", "04/03/2003", "Adc"),
	        new Jugador("Obstinatus", "Portugués", "13/12/2002", "Support")

			));
	private static List<Jugador> jugadoresGiantX = new ArrayList<Jugador>(Arrays.asList(
		    new Jugador("Carlsen", "Danés", "15/12/2005", "Top"),
		    new Jugador("Xerxe", "Rumano", "05/11/1999", "Jungla"),
		    new Jugador("Zwyroo", "Polaco", "02/04/2004", "Mid"),
		    new Jugador("Jackspektra", "Noruego", "05/12/2000", "Adc"),
		    new Jugador("whiteinn", "Rumano", "03/10/2000", "Support")
			));
	private static List<Jugador> jugadoresMovistarKoi = new ArrayList<Jugador>(Arrays.asList(
	        new Jugador("Th3Antonio", "Español", "15/02/1995", "Top"),
	        new Jugador("Maxlore", "Inglés", "25/09/1996", "Jungla"),
	        new Jugador("Jiizuke", "Italiano", "14/01/1997", "Mid"),
	        new Jugador("Attila", "Portugués", "26/02/1996", "Adc"),
	        new Jugador("Stend", "Francés", "13/07/2001", "Support")
			));
	private static List<Jugador> jugadoresZeta = new ArrayList<Jugador>(Arrays.asList(
			new Jugador("Markyu", "Español", "23/09/2002", "Top"),
	        new Jugador("NoName", "Inglés", "15/08/2003", "Jungla"),
	        new Jugador("Random", "Checo", "30/12/2001", "Mid"),
	        new Jugador("Shy Carry", "Serbio", "21/04/2004", "Adc"),
	        new Jugador("marlon", "Polaco", "14/01/2004", "Support")
			));

		public static Map<String, List<Jugador>> getJugadoresMap() {
			return jugadoresMap;
		}
		public static void setJugadoresMap(Map<String, List<Jugador>> jugadoresMap) {
			DataSourceJugador.jugadoresMap = jugadoresMap;
		}
		public static List<Jugador> getJugadoresCase() {
			return jugadoresCase;
		}
		public static void setJugadoresCase(List<Jugador> jugadoresCase) {
			DataSourceJugador.jugadoresCase = jugadoresCase;
		}
		public static List<Jugador> getJugadoresBarca() {
			return jugadoresBarca;
		}
		public static void setJugadoresBarca(List<Jugador> jugadoresBarca) {
			DataSourceJugador.jugadoresBarca = jugadoresBarca;
		}
		public static List<Jugador> getJugadoresRamboot() {
			return jugadoresRamboot;
		}
		public static void setJugadoresRamboot(List<Jugador> jugadoresRamboot) {
			DataSourceJugador.jugadoresRamboot = jugadoresRamboot;
		}
		public static List<Jugador> getJugadoresRebels() {
			return jugadoresRebels;
		}
		public static void setJugadoresRebels(List<Jugador> jugadoresRebels) {
			DataSourceJugador.jugadoresRebels = jugadoresRebels;
		}
		public static List<Jugador> getJugadoresGuasones() {
			return jugadoresGuasones;
		}
		public static void setJugadoresGuasones(List<Jugador> jugadoresGuasones) {
			DataSourceJugador.jugadoresGuasones = jugadoresGuasones;
		}
		public static List<Jugador> getJugadoresUCAM() {
			return jugadoresUCAM;
		}
		public static void setJugadoresUCAM(List<Jugador> jugadoresUCAM) {
			DataSourceJugador.jugadoresUCAM = jugadoresUCAM;
		}
		public static List<Jugador> getJugadoresLosHeretics() {
			return jugadoresLosHeretics;
		}
		public static void setJugadoresLosHeretics(List<Jugador> jugadoresLosHeretics) {
			DataSourceJugador.jugadoresLosHeretics = jugadoresLosHeretics;
		}
		public static List<Jugador> getJugadoresGiantX() {
			return jugadoresGiantX;
		}
		public static void setJugadoresGiantX(List<Jugador> jugadoresGiantX) {
			DataSourceJugador.jugadoresGiantX = jugadoresGiantX;
		}
		public static List<Jugador> getJugadoresMovistarKoi() {
			return jugadoresMovistarKoi;
		}
		public static void setJugadoresMovistarKoi(List<Jugador> jugadoresMovistarKoi) {
			DataSourceJugador.jugadoresMovistarKoi = jugadoresMovistarKoi;
		}
		public static List<Jugador> getJugadoresZeta() {
			return jugadoresZeta;
		}
		public static void setJugadoresZeta(List<Jugador> jugadoresZeta) {
			DataSourceJugador.jugadoresZeta = jugadoresZeta;
		}

  
	
	


}
