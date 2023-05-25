package tn.esprit.spring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.services.VoyageServiceImpl;

@SpringBootTest
public class voyageurRepositoryTest {
    @Mock
    private VoyageRepository voyageRepository;

    @InjectMocks
    private VoyageServiceImpl voyageService;

    @Test
    public void testRecupererVoyageParId() {
        long voyageId = 1L;
        Voyage voyage = new Voyage();
        voyage.setIdVoyage(voyageId);
        Mockito.when(voyageRepository.findById(voyageId)).thenReturn(java.util.Optional.of(voyage));

        Voyage result = voyageService.recupererVoyageParId(voyageId);

        assertNotNull(result);
        assertEquals(voyageId, result.getIdVoyage());
    }

    @Test
    public void testRecupererAll() {
        Voyage voyage1 = new Voyage();
        voyage1.setIdVoyage(1L);
        Voyage voyage2 = new Voyage();
        voyage2.setIdVoyage(2L);
        List<Voyage> voyages = Arrays.asList(voyage1, voyage2);
        Mockito.when(voyageRepository.findAll()).thenReturn(voyages);

        List<Voyage> result = voyageService.recupererAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

}
