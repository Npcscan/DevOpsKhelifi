package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.Optional;
import static org.mockito.Mockito.*;

public class voyageServiceTest {

    @Mock
    private VoyageRepository voyageRepository;

    @Mock
    private TrainRepository trainRepository;

    @InjectMocks
    private VoyageServiceImpl voyageService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAffecterTrainAVoyage() {
        Long idTrain = 1L;
        Long idVoyage = 1L;

        Train train = new Train();
        Voyage voyage = new Voyage();

        when(trainRepository.findById(idTrain)).thenReturn(Optional.of(train));
        when(voyageRepository.findById(idVoyage)).thenReturn(Optional.of(voyage));

        voyageService.affecterTrainAVoyage(idTrain, idVoyage);

        verify(voyageRepository, times(1)).save(voyage);
        assert voyage.getTrain() == train : "Unexpected train assignment";
    }
}
