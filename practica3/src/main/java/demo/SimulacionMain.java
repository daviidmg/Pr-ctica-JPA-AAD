package demo;

import entidades.Competicion;
import entidades.Equipo;
import entidades.Jugador;
import entidades.Sponsor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SimulacionMain {

	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SuperLiga");
        EntityManager em = emf.createEntityManager();
        
        // Crear y persistir la compe
        em.getTransaction().begin();

        Competicion SuperLiga = new Competicion("SuperLiga", "01/02/2012", 20, 18);
        em.persist(SuperLiga);
        
        // Sponsors comunes
        Sponsor caixaBank = new Sponsor("CaixaBank");
        em.persist(caixaBank);
        Sponsor hummel = new Sponsor("Hummel");
        em.persist(hummel);
        
//--------------------------------Equipo1------------------------------------------------------------

        // Crear y persistir equipos de la SuperLiga uno a uno
        Equipo caseEsports = new Equipo("Case Esports");
        em.persist(caseEsports);

        // Players
        Jugador badlulu = new Jugador("Badlulu", "Francés", "13/09/2002", "Top");
        badlulu.setEquipo(caseEsports);
        em.persist(badlulu);
        Jugador maxi = new Jugador("MAXI", "Danés", "24/06/2000", "Jungla");
        maxi.setEquipo(caseEsports);
        em.persist(maxi);
        Jugador javier = new Jugador("Javier", "Español", "27/04/1999", "Mid");
        javier.setEquipo(caseEsports);
        em.persist(javier);
        Jugador denvoksne = new Jugador("DenVoksne", "Danés", "15/07/2001", "Adc");
        denvoksne.setEquipo(caseEsports);
        em.persist(denvoksne);
        Jugador rhuckz = new Jugador("Rhuckz", "Español", "13/09/2002", "Support");
        rhuckz.setEquipo(caseEsports);
        em.persist(rhuckz);
        
        // Sponsors
        Sponsor sponsor1Case = new Sponsor("Pringgles");
        em.persist(sponsor1Case);
        Sponsor sponsor2Case = new Sponsor("Bybit");
        em.persist(sponsor2Case);
       /* Sponsor sponsor3Case = new Sponsor("Hummel");
        em.persist(sponsor3Case); */
        Sponsor sponsor4Case = new Sponsor("Aloha Poké");
        em.persist(sponsor4Case);
        Sponsor sponsor5Case = new Sponsor("Gbest");
        em.persist(sponsor5Case);
        Sponsor sponsor6Case = new Sponsor("Hisense");
        em.persist(sponsor6Case);
        Sponsor sponsor7Case = new Sponsor("Prozis");
        em.persist(sponsor7Case);
        Sponsor sponsor8Case = new Sponsor("BCD Sports");
        em.persist(sponsor8Case);
        Sponsor sponsor9Case = new Sponsor("ElGato");
        em.persist(sponsor9Case);

        // Asociar equipos y patrocinadores
        caseEsports.agregarPatrocinador(sponsor1Case);
        sponsor1Case.agregarEquipoPatrocinado(caseEsports);
        caseEsports.agregarPatrocinador(sponsor2Case);
        sponsor2Case.agregarEquipoPatrocinado(caseEsports);
     /*   caseEsports.agregarPatrocinador(sponsor3Case);
        sponsor3Case.agregarEquipoPatrocinado(caseEsports); */
        caseEsports.agregarPatrocinador(hummel);
        hummel.agregarEquipoPatrocinado(caseEsports);
        
        caseEsports.agregarPatrocinador(sponsor4Case);
        sponsor4Case.agregarEquipoPatrocinado(caseEsports);
        caseEsports.agregarPatrocinador(sponsor5Case);
        sponsor5Case.agregarEquipoPatrocinado(caseEsports);
        caseEsports.agregarPatrocinador(sponsor6Case);
        sponsor6Case.agregarEquipoPatrocinado(caseEsports);
        caseEsports.agregarPatrocinador(sponsor7Case);
        sponsor7Case.agregarEquipoPatrocinado(caseEsports);
        caseEsports.agregarPatrocinador(sponsor8Case);
        sponsor8Case.agregarEquipoPatrocinado(caseEsports);
        caseEsports.agregarPatrocinador(sponsor9Case);
        sponsor9Case.agregarEquipoPatrocinado(caseEsports);
        
//--------------------------------Equipo2------------------------------------------------------------
        
        Equipo barcaEsports = new Equipo("Barça Esports");
        em.persist(barcaEsports);
        
        Jugador whiteknight = new Jugador("WhiteKnight", "Finés", "16/02/1996", "Top");
        whiteknight.setEquipo(barcaEsports);
        em.persist(whiteknight);
        Jugador sajator = new Jugador("Sajator", "Checo", "11/10/2004", "Jungla");
        sajator.setEquipo(barcaEsports);
        em.persist(sajator);
        Jugador naau = new Jugador("Naau", "Español", "13/04/2001", "Mid");
        naau.setEquipo(barcaEsports);
        em.persist(naau);
        Jugador deadly = new Jugador("Deadly", "Inglés", "04/08/2000", "Adc");
        deadly.setEquipo(barcaEsports);
        em.persist(deadly);
        Jugador xixauxas = new Jugador("Xixauxas", "Español", "16/11/1997", "Support");
        xixauxas.setEquipo(barcaEsports);
        em.persist(xixauxas);
        
        // Sponsors
        Sponsor sponsor1Barca = new Sponsor("Nike");
        em.persist(sponsor1Barca);
        Sponsor sponsor2Barca = new Sponsor("Spotify");
        em.persist(sponsor2Barca);
        Sponsor sponsor3Barca = new Sponsor("AMBILIGHT TV");
        em.persist(sponsor3Barca);
        Sponsor sponsor4Barca = new Sponsor("1XBET");
        em.persist(sponsor4Barca);
        Sponsor sponsor5Barca = new Sponsor("KONAMI");
        em.persist(sponsor5Barca);
        Sponsor sponsor6Barca = new Sponsor("whitebit");
        em.persist(sponsor6Barca);
        Sponsor sponsor7Barca = new Sponsor("ESTRELLA DAMM");
        em.persist(sponsor7Barca);
        Sponsor sponsor8Barca = new Sponsor("CUPRA");
        em.persist(sponsor8Barca);
        Sponsor sponsor9Barca = new Sponsor("BIMBO");
        em.persist(sponsor9Barca);
        Sponsor sponsor10Barca = new Sponsor("Allianz");
        em.persist(sponsor10Barca);
        Sponsor sponsor11Barca = new Sponsor("HERNO");
        em.persist(sponsor11Barca);
        Sponsor sponsor12Barca = new Sponsor("STANLEY");
        em.persist(sponsor12Barca);
        Sponsor sponsor13Barca = new Sponsor("PRIME");
        em.persist(sponsor13Barca);
      /*  Sponsor sponsor14Barca = new Sponsor("CaixaBank");
        em.persist(sponsor14Barca); */
        Sponsor sponsor15Barca = new Sponsor("CocaCola");
        em.persist(sponsor15Barca);
        Sponsor sponsor16Barca = new Sponsor("ZIC");
        em.persist(sponsor16Barca);
        Sponsor sponsor17Barca = new Sponsor("Heüra");
        em.persist(sponsor17Barca);
        Sponsor sponsor18Barca = new Sponsor("Rappi");
        em.persist(sponsor18Barca);
        
        // Asociar equipos y patrocinadores
        barcaEsports.agregarPatrocinador(sponsor1Barca);
        sponsor1Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor2Barca);
        sponsor2Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor3Barca);
        sponsor3Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor4Barca);
        sponsor4Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor5Barca);
        sponsor5Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor6Barca);
        sponsor6Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor7Barca);
        sponsor7Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor8Barca);
        sponsor8Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor9Barca);
        sponsor9Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor10Barca);
        sponsor10Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor11Barca);
        sponsor11Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor12Barca);
        sponsor12Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor13Barca);
        sponsor13Barca.agregarEquipoPatrocinado(barcaEsports);
     /*   barcaEsports.agregarPatrocinador(sponsor14Barca);
        sponsor14Barca.agregarEquipoPatrocinado(barcaEsports);*/
        barcaEsports.agregarPatrocinador(caixaBank);
        caixaBank.agregarEquipoPatrocinado(barcaEsports);
        
        barcaEsports.agregarPatrocinador(sponsor15Barca);
        sponsor15Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor16Barca);
        sponsor16Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor17Barca);
        sponsor17Barca.agregarEquipoPatrocinado(barcaEsports);
        barcaEsports.agregarPatrocinador(sponsor18Barca);
        sponsor18Barca.agregarEquipoPatrocinado(barcaEsports);
        
//--------------------------------Equipo3------------------------------------------------------------
        
        Equipo ramboot = new Equipo("Ramboot");
        em.persist(ramboot);
        
        Jugador ibo = new Jugador("iBo", "Polaco", "08/03/1997", "Top");
        ibo.setEquipo(ramboot);
        em.persist(ibo);
        Jugador lebron = new Jugador("leBron", "Bulgaro", "26/11/1999", "Jungla");
        lebron.setEquipo(ramboot);
        em.persist(lebron);
        Jugador twohoyrz = new Jugador("twohoyrz", "Bulgaro", "27/08/1998", "Mid");
        twohoyrz.setEquipo(ramboot);
        em.persist(twohoyrz);
        Jugador rayito = new Jugador("Rayito", "Español", "08/03/1997", "Adc");
        rayito.setEquipo(ramboot);
        em.persist(rayito);
        Jugador seneca = new Jugador("Seneca", "Sueco", "08/03/1997", "Support");
        seneca.setEquipo(ramboot);
        em.persist(seneca);
        
        // Sponsors
        Sponsor sponsor1Ramboot = new Sponsor("COOLMOD");
        em.persist(sponsor1Ramboot);
        Sponsor sponsor2Ramboot = new Sponsor("DIGI Mobil");
        em.persist(sponsor2Ramboot);
        Sponsor sponsor3Ramboot = new Sponsor("Newskill Gaming");
        em.persist(sponsor3Ramboot);
        Sponsor sponsor4Ramboot = new Sponsor("Lamburguesa");
        em.persist(sponsor4Ramboot);
        Sponsor sponsor5Ramboot = new Sponsor("Red Bull");
        em.persist(sponsor5Ramboot);
        
        // Asociar equipos y patrocinadores
        ramboot.agregarPatrocinador(sponsor1Ramboot);
        sponsor1Ramboot.agregarEquipoPatrocinado(ramboot);
        ramboot.agregarPatrocinador(sponsor2Ramboot);
        sponsor2Ramboot.agregarEquipoPatrocinado(ramboot);
        ramboot.agregarPatrocinador(sponsor3Ramboot);
        sponsor3Ramboot.agregarEquipoPatrocinado(ramboot);
        ramboot.agregarPatrocinador(sponsor4Ramboot);
        sponsor4Ramboot.agregarEquipoPatrocinado(ramboot);
        ramboot.agregarPatrocinador(sponsor5Ramboot);
        sponsor5Ramboot.agregarEquipoPatrocinado(ramboot);
        
//--------------------------------Equipo4------------------------------------------------------------

        Equipo rebels = new Equipo("Rebels");
        em.persist(rebels);
        
        Jugador r4ven = new Jugador("R4VEN", "Polaco", "17/04/2000", "Top");
        r4ven.setEquipo(rebels);
        em.persist(r4ven);
        Jugador ahahacik = new Jugador("AHaHaCiK", "Ruso", "01/04/1999", "Jungla");
        ahahacik.setEquipo(rebels);
        em.persist(ahahacik);
        Jugador special = new Jugador("Special", "Holandés", "27/01/1998", "Mid");
        special.setEquipo(rebels);
        em.persist(special);
        Jugador bean = new Jugador("BEAN", "Aleman", "11/08/2000", "Adc");
        bean.setEquipo(rebels);
        em.persist(bean);
        Jugador lekcyc = new Jugador("Lekcyc", "Ruso", "24/07/1993", "Support");
        lekcyc.setEquipo(rebels);
        em.persist(lekcyc);
        
        // Sponsors
        Sponsor sponsor1Rebels = new Sponsor("KELME");
        em.persist(sponsor1Rebels);
        Sponsor sponsor2Rebels = new Sponsor("N26");
        em.persist(sponsor2Rebels);
        Sponsor sponsor3Rebels = new Sponsor("ZWHEEL");
        em.persist(sponsor3Rebels);
        Sponsor sponsor4Rebels = new Sponsor("Tokio School");
        em.persist(sponsor4Rebels);
        Sponsor sponsor5Rebels = new Sponsor("My Pasta");
        em.persist(sponsor5Rebels);
        
        // Asociar equipos y patrocinadores
        rebels.agregarPatrocinador(sponsor1Rebels);
        sponsor1Rebels.agregarEquipoPatrocinado(rebels);
        rebels.agregarPatrocinador(sponsor2Rebels);
        sponsor2Rebels.agregarEquipoPatrocinado(rebels);
        rebels.agregarPatrocinador(sponsor3Rebels);
        sponsor3Rebels.agregarEquipoPatrocinado(rebels);
        rebels.agregarPatrocinador(sponsor4Rebels);
        sponsor4Rebels.agregarEquipoPatrocinado(rebels);
        rebels.agregarPatrocinador(sponsor5Rebels);
        sponsor5Rebels.agregarEquipoPatrocinado(rebels);
        
//--------------------------------Equipo5------------------------------------------------------------
      
        Equipo guasones = new Equipo("Guasones");
        em.persist(guasones);
        
        Jugador dreedy = new Jugador("Dreedy", "Checo", "09/04/2001", "Top");
        dreedy.setEquipo(guasones);
        em.persist(dreedy);
        Jugador memento = new Jugador("Memento", "Sueco", "24/07/1999", "Jungla");
        memento.setEquipo(guasones);
        em.persist(memento);
        Jugador ronaldo = new Jugador("Ronaldo", "Rumano", "18/12/2000", "Mid");
        ronaldo.setEquipo(guasones);
        em.persist(ronaldo);
        Jugador motroco = new Jugador("Motroco", "Español", "17/04/1992", "Adc");
        motroco.setEquipo(guasones);
        em.persist(motroco);
        Jugador duall = new Jugador("DuaLL", "Español", "25/06/1999", "Support");
        duall.setEquipo(guasones);
        em.persist(duall);
        
        // Sponsors
        Sponsor sponsor1Guasones = new Sponsor("G-SHOCK");
        em.persist(sponsor1Guasones);
        Sponsor sponsor2Guasones = new Sponsor("Mobekip");
        em.persist(sponsor2Guasones);
        
        // Asociar equipos y patrocinadores
        guasones.agregarPatrocinador(sponsor1Guasones);
        sponsor1Guasones.agregarEquipoPatrocinado(guasones);
        guasones.agregarPatrocinador(sponsor2Guasones);
        sponsor2Guasones.agregarEquipoPatrocinado(guasones);

//--------------------------------Equipo6------------------------------------------------------------

        Equipo UCAM = new Equipo("UCAM");
        em.persist(UCAM);
        
        Jugador acd = new Jugador("ACD", "Estonio", "24/06/2000", "Top");
        acd.setEquipo(UCAM);
        em.persist(acd);
        Jugador koldo = new Jugador("Koldo", "Español", "07/11/2000", "Jungla");
        koldo.setEquipo(UCAM);
        em.persist(koldo);
        Jugador baca = new Jugador("Baca", "Portugués", "11/05/2000", "Mid");
        baca.setEquipo(UCAM);
        em.persist(baca);
        Jugador kenal = new Jugador("Kenal", "Ruso", "04/03/2003", "Adc");
        kenal.setEquipo(UCAM);
        em.persist(kenal);
        Jugador obstinatus = new Jugador("Obstinatus", "Portugués", "13/12/2002", "Support");
        obstinatus.setEquipo(UCAM);
        em.persist(obstinatus);
        
        // Sponsors
        Sponsor sponsor1UCAM = new Sponsor("UCAM");
        em.persist(sponsor1UCAM);
        Sponsor sponsor2UCAM = new Sponsor("Fripozo");
        em.persist(sponsor2UCAM);
        Sponsor sponsor3UCAM = new Sponsor("la boca te lía");
        em.persist(sponsor3UCAM);
        Sponsor sponsor4UCAM = new Sponsor("eLPOZZO KingUpp");
        em.persist(sponsor4UCAM);
        Sponsor sponsor5UCAM = new Sponsor("PCBOX");
        em.persist(sponsor5UCAM);
        Sponsor sponsor6UCAM = new Sponsor("HALCÓN viajes");
        em.persist(sponsor6UCAM);
        Sponsor sponsor7UCAM = new Sponsor("JOMA");
        em.persist(sponsor7UCAM);
      /*  Sponsor sponsor8UCAM = new Sponsor("Hummel");
        em.persist(sponsor8UCAM);
        Sponsor sponsor9UCAM = new Sponsor("CaixaBank");
        em.persist(sponsor9UCAM); */

        
        // Asociar equipos y patrocinadores
        UCAM.agregarPatrocinador(sponsor1UCAM);
        sponsor1UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor2UCAM);
        sponsor2UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor3UCAM);
        sponsor3UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor4UCAM);
        sponsor4UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor5UCAM);
        sponsor5UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor6UCAM);
        sponsor6UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor7UCAM);
        sponsor7UCAM.agregarEquipoPatrocinado(UCAM);
       /* UCAM.agregarPatrocinador(sponsor8UCAM);
        sponsor8UCAM.agregarEquipoPatrocinado(UCAM);
        UCAM.agregarPatrocinador(sponsor9UCAM);
        sponsor9UCAM.agregarEquipoPatrocinado(UCAM);*/
        hummel.agregarEquipoPatrocinado(UCAM);
        caixaBank.agregarEquipoPatrocinado(UCAM);

//--------------------------------Equipo7------------------------------------------------------------

        Equipo losHeretics = new Equipo("Los Heretics");
        em.persist(losHeretics);

        Jugador carlsen = new Jugador("Carlsen", "Danés", "15/12/2005", "Top");
        carlsen.setEquipo(losHeretics);
        em.persist(carlsen);
        Jugador xerxe = new Jugador("Xerxe", "Rumano", "05/11/1999", "Jungla");
        xerxe.setEquipo(losHeretics);
        em.persist(xerxe);
        Jugador zwyroo = new Jugador("Zwyroo", "Polaco", "02/04/2004", "Mid");
        zwyroo.setEquipo(losHeretics);
        em.persist(zwyroo);
        Jugador jackspektra = new Jugador("Jackspektra", "Noruego", "05/12/2000", "Adc");
        jackspektra.setEquipo(losHeretics);
        em.persist(jackspektra);
        Jugador whiteinn = new Jugador("whiteinn", "Rumano", "03/10/2000", "Support");
        whiteinn.setEquipo(losHeretics);
        em.persist(whiteinn);

        Equipo giantX = new Equipo("GiantX");
        em.persist(giantX);
        
        Jugador th3antonio = new Jugador("Th3Antonio", "Español", "15/02/1995", "Top");
        th3antonio.setEquipo(giantX);
        em.persist(th3antonio);
        Jugador maxlore = new Jugador("Maxlore", "Inglés", "25/09/1996", "Jungla");
        maxlore.setEquipo(giantX);
        em.persist(maxlore);
        Jugador jiizuke = new Jugador("Jiizuke", "Italiano", "14/01/1997", "Mid");
        jiizuke.setEquipo(giantX);
        em.persist(jiizuke);
        Jugador attila = new Jugador("Attila", "Portugués", "26/02/1996", "Adc");
        attila.setEquipo(giantX);
        em.persist(attila);
        Jugador stend = new Jugador("Stend", "Francés", "13/07/2001", "Support");
        stend.setEquipo(giantX);
        em.persist(stend);
        

        Equipo movistarKOI = new Equipo("Movistar KOI");
        em.persist(movistarKOI);
        
        Jugador marky = new Jugador("Marky", "Español", "23/09/2002", "Top");
        marky.setEquipo(movistarKOI);
        em.persist(marky);
        Jugador noname = new Jugador("NoName", "Inglés", "15/08/2003", "Jungla");
        noname.setEquipo(movistarKOI);
        em.persist(noname);
        Jugador random = new Jugador("Random", "Checo", "30/12/2001", "Mid");
        random.setEquipo(movistarKOI);
        em.persist(random);
        Jugador shyCarry = new Jugador("Shy Carry", "Serbio", "21/04/2004", "Adc");
        shyCarry.setEquipo(movistarKOI);
        em.persist(shyCarry);
        Jugador marlon = new Jugador("marlon", "Polaco", "14/01/2004", "Support");
        marlon.setEquipo(movistarKOI);
        em.persist(marlon);

        Equipo ZETA = new Equipo("ZETA");
        em.persist(ZETA);
        
        Jugador kaylem = new Jugador("Kaylem", "Rumano", "29/03/2004", "Top");
        kaylem.setEquipo(ZETA);
        em.persist(kaylem);
        Jugador nyx = new Jugador("Nyx", "Español", "19/03/2002", "Jungla");
        nyx.setEquipo(ZETA);
        em.persist(nyx);
        Jugador phlaty = new Jugador("Phlaty", "Ruso", "23/07/1997", "Mid");
        phlaty.setEquipo(ZETA);
        em.persist(phlaty);
        Jugador mihai = new Jugador("Mihai", "Rumano", "07/07/2000", "Adc");
        mihai.setEquipo(ZETA);
        em.persist(mihai);
        Jugador bolyy1 = new Jugador("Bolyy1", "Español", "12/12/2000", "Support");
        bolyy1.setEquipo(ZETA);
        em.persist(bolyy1);

        em.getTransaction().commit();
        
        em.close();
        emf.close();    
	}
}


