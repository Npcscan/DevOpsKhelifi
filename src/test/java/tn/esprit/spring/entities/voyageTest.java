package tn.esprit.spring.entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class voyageTest {

    @Test
    public void testGettersAndSetters() {
        Voyage voyage = new Voyage();

        voyage.setIdVoyage(1L);
        voyage.setCodeVoyage(123456);
        voyage.setGareDepart(Ville.tunis);
        voyage.setGareArrivee(Ville.SOUSSE);

        Date dateDepart = new Date();
        voyage.setDateDepart(dateDepart);

        Date dateArrivee = new Date();
        voyage.setDateArrivee(dateArrivee);

        voyage.setHeureDepart(7.45);
        voyage.setHeureArrivee(10.30);

        Train train = new Train();
        voyage.setTrain(train);

        List<Voyageur> voyageurs = new ArrayList<>();
        voyage.setMesVoyageurs(voyageurs);

        Assertions.assertEquals(1L, voyage.getIdVoyage());
        Assertions.assertEquals(123456, voyage.getCodeVoyage());
        Assertions.assertEquals(Ville.tunis, voyage.getGareDepart());
        Assertions.assertEquals(Ville.SOUSSE, voyage.getGareArrivee());
        Assertions.assertEquals(dateDepart, voyage.getDateDepart());
        Assertions.assertEquals(dateArrivee, voyage.getDateArrivee());
        Assertions.assertEquals(7.45, voyage.getHeureDepart());
        Assertions.assertEquals(10.30, voyage.getHeureArrivee());
        Assertions.assertEquals(train, voyage.getTrain());
        Assertions.assertEquals(voyageurs, voyage.getMesVoyageurs());
    }


}
