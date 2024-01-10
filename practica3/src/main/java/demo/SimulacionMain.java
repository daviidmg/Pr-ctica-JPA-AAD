package demo;

import java.time.LocalDate;

import entidades.Competicion;
import entidades.Equipo;
import entidades.Jugador;
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
        

        // Crear y persistir equipos de la SuperLiga uno a uno
        Equipo caseEsports = new Equipo("Case Esports");
        em.persist(caseEsports);

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


