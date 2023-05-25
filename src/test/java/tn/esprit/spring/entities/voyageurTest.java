package tn.esprit.spring.entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class voyageurTest {
    @Test
    public void testGettersAndSetters() {
        Voyageur voyageur = new Voyageur();

        voyageur.setIdVoyageur(1L);
        voyageur.setNomVoyageur("John Doe");

        List<Voyage> voyages = new ArrayList<>();
        voyageur.setMesvoyages(voyages);

        Assertions.assertEquals(1L, voyageur.getIdVoyageur());
        Assertions.assertEquals("John Doe", voyageur.getNomVoyageur());
        Assertions.assertEquals(voyages, voyageur.getMesvoyages());
    }

}

