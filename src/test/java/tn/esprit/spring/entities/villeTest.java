package tn.esprit.spring.entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class villeTest {
    @Test
    public void testEnumValues() {
        Assertions.assertEquals(6, Ville.values().length);

        Assertions.assertEquals(Ville.tunis, Ville.valueOf("tunis"));
        Assertions.assertEquals(Ville.RADES, Ville.valueOf("RADES"));
        Assertions.assertEquals(Ville.EZZAHRA, Ville.valueOf("EZZAHRA"));
        Assertions.assertEquals(Ville.SAKIETEZZIT, Ville.valueOf("SAKIETEZZIT"));
        Assertions.assertEquals(Ville.sfax, Ville.valueOf("sfax"));
        Assertions.assertEquals(Ville.SOUSSE, Ville.valueOf("SOUSSE"));
    }

}
