package tn.esprit.spring.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EtatTrainTest {

    @Test
    public void testEnumValues() {
        etatTrain[] values = etatTrain.values();
        Assertions.assertEquals(4, values.length);
        Assertions.assertArrayEquals(new etatTrain[]{etatTrain.prevu, etatTrain.en_gare, etatTrain.en_route, etatTrain.annule}, values);
    }

    @Test
    public void testEnumToString() {
        Assertions.assertEquals("prevu", etatTrain.prevu.toString());
        Assertions.assertEquals("en_gare", etatTrain.en_gare.toString());
        Assertions.assertEquals("en_route", etatTrain.en_route.toString());
        Assertions.assertEquals("annule", etatTrain.annule.toString());
    }

}

