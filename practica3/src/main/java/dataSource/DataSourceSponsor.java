package dataSource;

import entidades.Sponsor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataSourceSponsor {
    private static Map<String, Set<Sponsor>> sponsorsPorEquipo = new HashMap<>();
    
    static {
        // Sponsors comunes
        Sponsor caixaBank = new Sponsor("CaixaBank");
        Sponsor hummel = new Sponsor("Hummel");
        Sponsor redBull = new Sponsor("RedBull");
        Sponsor digi = new Sponsor("DIGI");
        Sponsor movistar = new Sponsor("MOVISTAR");
        Sponsor opel = new Sponsor("OPEL");
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors case
        Sponsor sponsor1Case = new Sponsor("Pringles");
        Sponsor sponsor2Case = new Sponsor("Bybit");        Sponsor sponsor4Case = new Sponsor("Aloha Poké");
        Sponsor sponsor5Case = new Sponsor("Gbest");
        Sponsor sponsor6Case = new Sponsor("Hisense");
        Sponsor sponsor7Case = new Sponsor("Prozis");
        Sponsor sponsor8Case = new Sponsor("BCD Sports");
        Sponsor sponsor9Case = new Sponsor("ElGato");
        
        sponsorsPorEquipo.put("Case Esports", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1Case, sponsor2Case, sponsor4Case, sponsor5Case, sponsor6Case, sponsor7Case, sponsor8Case, sponsor9Case, hummel)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors barça
        Sponsor sponsor1Barca = new Sponsor("Nike");
        Sponsor sponsor2Barca = new Sponsor("Spotify");
        Sponsor sponsor3Barca = new Sponsor("AMBILIGHT TV");
        Sponsor sponsor4Barca = new Sponsor("1XBET");
        Sponsor sponsor5Barca = new Sponsor("KONAMI");
        Sponsor sponsor6Barca = new Sponsor("whitebit");
        Sponsor sponsor7Barca = new Sponsor("ESTRELLA DAMM");
        Sponsor sponsor8Barca = new Sponsor("CUPRA");
        Sponsor sponsor9Barca = new Sponsor("BIMBO");
        Sponsor sponsor10Barca = new Sponsor("Allianz");
        Sponsor sponsor11Barca = new Sponsor("HERNO");
        Sponsor sponsor12Barca = new Sponsor("STANLEY");
        Sponsor sponsor13Barca = new Sponsor("PRIME");
        Sponsor sponsor15Barca = new Sponsor("CocaCola");
        Sponsor sponsor16Barca = new Sponsor("ZIC");
        Sponsor sponsor17Barca = new Sponsor("Heüra");
        Sponsor sponsor18Barca = new Sponsor("Rappi");
        
        sponsorsPorEquipo.put("Barça Esports", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1Barca, sponsor2Barca, sponsor3Barca, sponsor4Barca, sponsor5Barca, sponsor6Barca, sponsor7Barca, sponsor8Barca,
        		sponsor9Barca, sponsor10Barca, sponsor11Barca, sponsor12Barca, sponsor13Barca, sponsor15Barca, sponsor16Barca,
        		sponsor17Barca, sponsor18Barca, caixaBank)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors Ramboot
        Sponsor sponsor1Ramboot = new Sponsor("COOLMOD");
        Sponsor sponsor3Ramboot = new Sponsor("Newskill Gaming");
        Sponsor sponsor4Ramboot = new Sponsor("Lamburguesa");
        
        sponsorsPorEquipo.put("Ramboot", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1Ramboot, sponsor3Ramboot, sponsor4Ramboot, redBull, digi)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors Rebels
        Sponsor sponsor1Rebels = new Sponsor("KELME");
        Sponsor sponsor2Rebels = new Sponsor("N26");
        Sponsor sponsor3Rebels = new Sponsor("ZWHEEL");
        Sponsor sponsor4Rebels = new Sponsor("Tokio School");
        Sponsor sponsor5Rebels = new Sponsor("My Pasta");
    
        sponsorsPorEquipo.put("Rebels", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1Rebels, sponsor2Rebels, sponsor3Rebels, sponsor4Rebels, sponsor5Rebels)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors Guasones
        Sponsor sponsor1Guasones = new Sponsor("G-SHOCK");
        Sponsor sponsor2Guasones = new Sponsor("Mobekip");

        sponsorsPorEquipo.put("Guasones", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1Guasones, sponsor2Guasones, digi, redBull)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors UCAM
        Sponsor sponsor1UCAM = new Sponsor("UCAM");
        Sponsor sponsor2UCAM = new Sponsor("Fripozo");
        Sponsor sponsor3UCAM = new Sponsor("la boca te lía");
        Sponsor sponsor4UCAM = new Sponsor("eLPOZZO KingUpp");
        Sponsor sponsor5UCAM = new Sponsor("PCBOX");
        Sponsor sponsor6UCAM = new Sponsor("HALCÓN viajes");
        Sponsor sponsor7UCAM = new Sponsor("JOMA");
        
        sponsorsPorEquipo.put("UCAM", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1UCAM, sponsor2UCAM, sponsor3UCAM, sponsor4UCAM, sponsor5UCAM, sponsor6UCAM, sponsor7UCAM, caixaBank, hummel)));
     
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors Los Heretics
        Sponsor sponsor1LosHeretics = new Sponsor("SanMiguel");
        Sponsor sponsor2LosHeretics = new Sponsor("logitech");
        Sponsor sponsor3LosHeretics = new Sponsor("SOCIOS.COM");
        Sponsor sponsor5LosHeretics = new Sponsor("HYUNDAI");
        Sponsor sponsor6LosHeretics = new Sponsor("SCARPWORLD");
        Sponsor sponsor7LosHeretics = new Sponsor("noblechairs");

        sponsorsPorEquipo.put("Los Heretics", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1LosHeretics, sponsor2LosHeretics, sponsor3LosHeretics, sponsor5LosHeretics, sponsor6LosHeretics, sponsor7LosHeretics,
        		redBull, movistar)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors GiantX        
        Sponsor sponsor1GiantX = new Sponsor("EE");
        Sponsor sponsor2GiantX = new Sponsor("BURGER KING");
        Sponsor sponsor4GiantX = new Sponsor("KitKat");
        Sponsor sponsor5GiantX = new Sponsor("HSBC");
        Sponsor sponsor6GiantX = new Sponsor("MAGGI FUSIAN");
        Sponsor sponsor8GiantX = new Sponsor("FITCHIN");
        Sponsor sponsor9GiantX = new Sponsor("HOT WHEELS");
        Sponsor sponsor10GiantX = new Sponsor("INZONE");
        Sponsor sponsor11GiantX = new Sponsor("PCSPECIALIST");
        Sponsor sponsor12GiantX = new Sponsor("Sybr");
     
        sponsorsPorEquipo.put("GiantX", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1GiantX, sponsor2GiantX, sponsor4GiantX, sponsor5GiantX, sponsor6GiantX, sponsor8GiantX, sponsor9GiantX, sponsor10GiantX, 
        		sponsor11GiantX, sponsor12GiantX, opel, digi)));
        
//-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors Movistar KOI
        Sponsor sponsor1MovistarKOI = new Sponsor("KAPPA");
        Sponsor sponsor2MovistarKOI = new Sponsor("RISKETOS");
        Sponsor sponsor3MovistarKOI = new Sponsor("Peugeot");
        
        sponsorsPorEquipo.put("Movistar KOI", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1MovistarKOI, sponsor2MovistarKOI, sponsor3MovistarKOI, movistar, opel)));
        
      //-------------------------------------------------------------------------------------------------------------------------------------------------
        //sponsors ZETA
        Sponsor sponsor1Zeta = new Sponsor("iberCaja");
        Sponsor sponsor2Zeta = new Sponsor("ENERYETI");
        Sponsor sponsor3Zeta = new Sponsor("Umbro");

        sponsorsPorEquipo.put("ZETA", new HashSet<Sponsor>(Arrays.asList(
        		sponsor1Zeta, sponsor2Zeta, sponsor3Zeta, digi, opel, hummel)));
    }

	public static Map<String, Set<Sponsor>> getSponsorsPorEquipo() {
		return sponsorsPorEquipo;
	}

	public static void setSponsorsPorEquipo(Map<String, Set<Sponsor>> sponsorsPorEquipo) {
		DataSourceSponsor.sponsorsPorEquipo = sponsorsPorEquipo;
	}
	
}
    
 /*  public static List<Sponsor> sponsorsRepetidos = new ArrayList<Sponsor>(Arrays.asList(
    		new Sponsor("CaixaBank", Arrays.asList(
    				DataSourceEquipo.getEquipos().get(1),
    				DataSourceEquipo.getEquipos().get(5)
    				)), //--> barça y UCAM
    		
            new Sponsor("Hummel", Arrays.asList(
    				DataSourceEquipo.getEquipos().get(0),
    				DataSourceEquipo.getEquipos().get(5)
            		)), //--> Case y UCAM
            
            new Sponsor("RedBull", Arrays.asList(
    				DataSourceEquipo.getEquipos().get(6),
    				DataSourceEquipo.getEquipos().get(2)
            		)), //--> Los Heretics y Ramboot
            
            new Sponsor("DIGI", Arrays.asList(
    				DataSourceEquipo.getEquipos().get(9),
    				DataSourceEquipo.getEquipos().get(7),
    				DataSourceEquipo.getEquipos().get(2)
            		)), //--> ZETA GiantX y Ramboot
            
            new Sponsor("MOVISTAR", Arrays.asList(
    				DataSourceEquipo.getEquipos().get(6),
    				DataSourceEquipo.getEquipos().get(8)
            		)), //--> Los Heretics y Movistar KOI
            
            new Sponsor("OPEL", Arrays.asList(
    				DataSourceEquipo.getEquipos().get(7),
    				DataSourceEquipo.getEquipos().get(8)
            		)) //--> GiantX y Movistar KOI
    ));
	
	private static List<Sponsor> sponsorsCase = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("Pringles"),
	        new Sponsor("Bybit"),
	        new Sponsor("Aloha Poké"),
	        new Sponsor("Gbest"),
	        new Sponsor("Hisense"),
	        new Sponsor("Prozis"),
	        new Sponsor("BCD Sports"),
	        new Sponsor("ElGato")
	        //sponsorsRepetidos.get(1)
			));
	
	private static List<Sponsor> sponsorsBarca = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("Nike"),
	        new Sponsor("Spotify"),
	        new Sponsor("AMBILIGHT TV"),
	        new Sponsor("1XBET"),
	        new Sponsor("KONAMI"),
	        new Sponsor("whitebit"),
	        new Sponsor("ESTRELLA DAMM"),
	        new Sponsor("CUPRA"),
	        new Sponsor("BIMBO"),
	        new Sponsor("Allianz"),
		    new Sponsor("HERNO"),
		    new Sponsor("STANLEY"),
		    new Sponsor("PRIME"),
		    new Sponsor("CocaCola"),
		    new Sponsor("ZIC"),
		    new Sponsor("Heüra"),
		    new Sponsor("Rappi")
		   // sponsorsRepetidos.get(0)
			));
	
	private static List<Sponsor> sponsorsRamboot = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("COOLMOD"),
	        new Sponsor("Newskill Gaming"),
	        new Sponsor("Lamburguesa")
		   // sponsorsRepetidos.get(2),
		  //  sponsorsRepetidos.get(3)
			));
	
	private static List<Sponsor> sponsorsRebels = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("KELME"),
	        new Sponsor("N26"),
	        new Sponsor("ZWHEEL"),
	        new Sponsor("Tokio School"),
	        new Sponsor("My Pasta")
			));
	
	private static List<Sponsor> sponsorsGuasones = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("G-SHOCK"),
	        new Sponsor("Mobekip")
			));
	
	private static List<Sponsor> sponsorsUCAM = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("UCAM"),
	        new Sponsor("Fripozo"),
	        new Sponsor("la boca te lía"),
	        new Sponsor("eLPOZZO KingUpp"),
	        new Sponsor("PCBOX"),
	        new Sponsor("HALCÓN viajes"),
	        new Sponsor("JOMA")
		  //  sponsorsRepetidos.get(0),
		    //sponsorsRepetidos.get(1)
			));
	
	private static List<Sponsor> sponsorsLosHeretics = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("SanMiguel"),
	        new Sponsor("logitech"),
	        new Sponsor("SOCIOS.COM"),
	        new Sponsor("HYUNDAI"),
	        new Sponsor("SCARPWORLD"),
	        new Sponsor("noblechairs")
		   // sponsorsRepetidos.get(2),
		    //sponsorsRepetidos.get(4)
			));
	
	private static List<Sponsor> sponsorsGiantX = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("EE"),
	        new Sponsor("BURGER KING"),
	        new Sponsor("KitKat"),
	        new Sponsor("HSBC"),
	        new Sponsor("MAGGI FUSIAN"),
	        new Sponsor("FITCHIN"),
	        new Sponsor("HOT WHEELS"),
	        new Sponsor("INZONE"),
	        new Sponsor("PCSPECIALIST"),
	        new Sponsor("Sybr")
		 //   sponsorsRepetidos.get(3),
		   // sponsorsRepetidos.get(5)
			));
	
	private static List<Sponsor> sponsorsMovistarKOI = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("KAPPA"),
	        new Sponsor("RISKETOS"),
	        new Sponsor("Peugeot")
		    //sponsorsRepetidos.get(4),
		    //sponsorsRepetidos.get(5)
			));
	
	private static List<Sponsor> sponsorsZETA = new ArrayList<Sponsor>(Arrays.asList(
	        new Sponsor("iberCaja"),
	        new Sponsor("ENERYETI"),
	        new Sponsor("Umbro")
	      //  sponsorsRepetidos.get(3)
			));

	public static Map<String, List<Sponsor>> getSponsorsMap() {
		return sponsorsMap;
	}

	public static List<Sponsor> getSponsorsRepetidos() {
		return sponsorsRepetidos;
	}
	
	public static void setSponsorsRepetidos(List<Sponsor> sponsorsRepetidos) {
		DataSourceSponsor.sponsorsRepetidos = sponsorsRepetidos;
	}
	

	public static void setSponsorsMap(Map<String, List<Sponsor>> sponsorsMap) {
		DataSourceSponsor.sponsorsMap = sponsorsMap;
	}

	public static List<Sponsor> getSponsorsCase() {
		return sponsorsCase;
	}

	public static void setSponsorsCase(List<Sponsor> sponsorsCase) {
		DataSourceSponsor.sponsorsCase = sponsorsCase;
	}

	public static List<Sponsor> getSponsorsBarca() {
		return sponsorsBarca;
	}

	public static void setSponsorsBarca(List<Sponsor> sponsorsBarca) {
		DataSourceSponsor.sponsorsBarca = sponsorsBarca;
	}

	public static List<Sponsor> getSponsorsRamboot() {
		return sponsorsRamboot;
	}

	public static void setSponsorsRamboot(List<Sponsor> sponsorsRamboot) {
		DataSourceSponsor.sponsorsRamboot = sponsorsRamboot;
	}

	public static List<Sponsor> getSponsorsRebels() {
		return sponsorsRebels;
	}

	public static void setSponsorsRebels(List<Sponsor> sponsorsRebels) {
		DataSourceSponsor.sponsorsRebels = sponsorsRebels;
	}

	public static List<Sponsor> getSponsorsGuasones() {
		return sponsorsGuasones;
	}

	public static void setSponsorsGuasones(List<Sponsor> sponsorsGuasones) {
		DataSourceSponsor.sponsorsGuasones = sponsorsGuasones;
	}

	public static List<Sponsor> getSponsorsUCAM() {
		return sponsorsUCAM;
	}

	public static void setSponsorsUCAM(List<Sponsor> sponsorsUCAM) {
		DataSourceSponsor.sponsorsUCAM = sponsorsUCAM;
	}

	public static List<Sponsor> getSponsorsLosHeretics() {
		return sponsorsLosHeretics;
	}

	public static void setSponsorsLosHeretics(List<Sponsor> sponsorsLosHeretics) {
		DataSourceSponsor.sponsorsLosHeretics = sponsorsLosHeretics;
	}

	public static List<Sponsor> getSponsorsGiantX() {
		return sponsorsGiantX;
	}

	public static void setSponsorsGiantX(List<Sponsor> sponsorsGiantX) {
		DataSourceSponsor.sponsorsGiantX = sponsorsGiantX;
	}

	public static List<Sponsor> getSponsorsMovistarKOI() {
		return sponsorsMovistarKOI;
	}

	public static void setSponsorsMovistarKOI(List<Sponsor> sponsorsMovistarKOI) {
		DataSourceSponsor.sponsorsMovistarKOI = sponsorsMovistarKOI;
	}

	public static List<Sponsor> getSponsorsZETA() {
		return sponsorsZETA;
	}

	public static void setSponsorsZETA(List<Sponsor> sponsorsZETA) {
		DataSourceSponsor.sponsorsZETA = sponsorsZETA;
	}*/


	
	
