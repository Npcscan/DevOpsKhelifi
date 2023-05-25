package tn.esprit.spring.services;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class voyageurServiceTest {
    @Mock
    private VoyageurRepository voyageurRepository;

    @InjectMocks
    private VoyageurServiceImpl voyageurService;

    @Test
    public void testAjouterVoyageur() {
        Voyageur voyageur = new Voyageur();

        voyageurService.ajouterVoyageur(voyageur);

        verify(voyageurRepository, times(1)).save(voyageur);
    }

    @Test
    public void testModifierVoyageur() {
        Voyageur voyageur = new Voyageur();

        voyageurService.modifierVoyageur(voyageur);

        verify(voyageurRepository, times(1)).save(voyageur);
    }

    @Test
    public void testRecupererAll() {
        List<Voyageur> voyageurList = new ArrayList<>();
        when(voyageurRepository.findAll()).thenReturn(voyageurList);

        voyageurService.recupererAll();

        verify(voyageurRepository, times(1)).findAll();
    }

    @Test
    public void testSupprimerVoyageur() {
        Voyageur voyageur = new Voyageur();

        voyageurService.supprimerVoyageur(voyageur);

        verify(voyageurRepository, times(1)).delete(voyageur);
    }
}
