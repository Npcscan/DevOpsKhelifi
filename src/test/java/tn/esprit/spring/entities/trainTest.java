package tn.esprit.spring.entities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class trainTest {
    @Mock
    private etatTrain mockedEtat;

    @InjectMocks
    private Train train;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSetIdTrain() {
        long idTrain = 1L;
        train.setIdTrain(idTrain);
        Assertions.assertEquals(idTrain, train.getIdTrain());
    }

    @Test
    public void testGetSetEtat() {
        train.setEtat(mockedEtat);
        Assertions.assertEquals(mockedEtat, train.getEtat());
    }

    @Test
    public void testGetSetNbPlaceLibre() {
        int nbPlaceLibre = 10;
        train.setNbPlaceLibre(nbPlaceLibre);
        Assertions.assertEquals(nbPlaceLibre, train.getNbPlaceLibre());
    }


}
