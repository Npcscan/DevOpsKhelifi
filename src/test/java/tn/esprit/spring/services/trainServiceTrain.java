package tn.esprit.spring.services;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;
import tn.esprit.spring.repository.VoyageurRepository;
import tn.esprit.spring.services.TrainServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class trainServiceTrain {
    @Mock
    private VoyageurRepository voyageurRepository;

    @Mock
    private TrainRepository trainRepository;

    @Mock
    private VoyageRepository voyageRepository;

    @InjectMocks
    private TrainServiceImpl trainService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAjouterTrain() {
        Train train = new Train();

        trainService.ajouterTrain(train);

        verify(trainRepository, times(1)).save(train);
    }

    @Test
    public void testTrainPlacesLibres() {
        Ville nomGareDepart = Ville.tunis;

        List<Voyage> voyages = new ArrayList<>();
        voyages.add(new Voyage());
        when(voyageRepository.findAll()).thenReturn(voyages);

        int placesLibres = trainService.TrainPlacesLibres(nomGareDepart);

        Assertions.assertEquals(2, placesLibres);
    }

    @Test
    public void testListerTrainsIndirects() {
        Ville nomGareDepart = Ville.tunis;
        Ville nomGareArrivee = Ville.SOUSSE;

        List<Voyage> voyages = new ArrayList<>();
        Voyage voyage1 = new Voyage();
        Voyage voyage2 = new Voyage();
        Train train1 = new Train();
        Train train2 = new Train();
        voyage1.setTrain(train1);
        voyage2.setTrain(train2);
        voyages.add(voyage1);
        voyages.add(voyage2);
        when(voyageRepository.findAll()).thenReturn(voyages);

        List<Train> trainsIndirects = trainService.ListerTrainsIndirects(nomGareDepart, nomGareArrivee);

        Assertions.assertEquals(2, trainsIndirects.size());
        Assertions.assertTrue(trainsIndirects.contains(train1));
        Assertions.assertTrue(trainsIndirects.contains(train2));
    }

    @Test
    public void testAffecterTainAVoyageur() {
        Long idVoyageur = 1L;
        Ville nomGareDepart = Ville.tunis;
        Ville nomGareArrivee = Ville.SOUSSE;
        double heureDepart = 9.0;

        List<Voyage> voyages = new ArrayList<>();
        Voyage voyage = new Voyage();
        Train train = new Train();
        voyage.setTrain(train);
        voyages.add(voyage);
        when(voyageRepository.RechercheVoyage(nomGareDepart, nomGareDepart, heureDepart)).thenReturn(voyages);

        Voyageur voyageur = new Voyageur();
        when(voyageurRepository.findById(idVoyageur)).thenReturn(Optional.of(voyageur));


        trainService.affecterTainAVoyageur(idVoyageur, nomGareDepart, nomGareArrivee, heureDepart);

        verify(voyageRepository, times(1)).save(voyage);
        verify(trainRepository, times(1)).save(train);
        Assertions.assertTrue(voyage.getMesVoyageurs().contains(voyageur));
        Assertions.assertEquals(2, train.getNbPlaceLibre());
    }

    @Test
    public void testDesaffecterVoyageursTrain() {
        Ville nomGareDepart = Ville.tunis;
        Ville nomGareArrivee = Ville.SOUSSE;
        double heureDepart = 9.0;

        List<Voyage> voyages = new ArrayList<>();
        voyages.add(new Voyage());
        when(voyageRepository.RechercheVoyage(nomGareDepart, nomGareArrivee, heureDepart)).thenReturn(voyages);

        trainService.DesaffecterVoyageursTrain(nomGareDepart, nomGareArrivee, heureDepart);

        verify(voyageRepository, times(1)).save(any(Voyage.class));
        verify(trainRepository, times(1)).save(any(Train.class));
    }

}
