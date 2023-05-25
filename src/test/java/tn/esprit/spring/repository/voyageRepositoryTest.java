package tn.esprit.spring.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;

import java.util.List;

@DataJpaTest
public class voyageRepositoryTest {

    @Autowired
    private VoyageRepository voyageRepository;

    @Test
    public void testRechercheVoyage() {
        Voyage voyage1 = new Voyage();
        voyage1.setGareDepart(Ville.tunis);
        voyage1.setGareArrivee(Ville.SOUSSE);
        voyage1.setHeureDepart(8.5);
        voyageRepository.save(voyage1);

        Voyage voyage2 = new Voyage();
        voyage2.setGareDepart(Ville.RADES);
        voyage2.setGareArrivee(Ville.tunis);
        voyage2.setHeureDepart(10.0);
        voyageRepository.save(voyage2);

        Voyage voyage3 = new Voyage();
        voyage3.setGareDepart(Ville.SOUSSE);
        voyage3.setGareArrivee(Ville.tunis);
        voyage3.setHeureDepart(14.0);
        voyageRepository.save(voyage3);

        List<Voyage> result = voyageRepository.RechercheVoyage(Ville.tunis, Ville.SOUSSE, 8.5);

        Assertions.assertEquals(1, result.size());
        Voyage foundVoyage = result.get(0);
        Assertions.assertEquals(Ville.tunis, foundVoyage.getGareDepart());
        Assertions.assertEquals(Ville.SOUSSE, foundVoyage.getGareArrivee());
        Assertions.assertEquals(8.5, foundVoyage.getHeureDepart());
    }
}
