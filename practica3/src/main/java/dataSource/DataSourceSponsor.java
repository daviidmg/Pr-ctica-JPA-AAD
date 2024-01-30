package dataSource;

import entidades.Sponsor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Esta clase proporciona datos de patrocinadores para la aplicación.
 * Permite obtener un conjunto de patrocinadores por cada equipo.
 *
 *@author David
 */
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