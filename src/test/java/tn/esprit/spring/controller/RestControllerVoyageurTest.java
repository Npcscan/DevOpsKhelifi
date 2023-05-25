package tn.esprit.spring.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.services.ITrainService;
import tn.esprit.spring.services.IVoyageService;
import tn.esprit.spring.services.IVoyageurService;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

public class RestControllerVoyageurTest {

    private MockMvc mockMvc;

    @Mock
    private IVoyageService voyageService;

    @Mock
    private ITrainService trainService;

    @Mock
    private IVoyageurService voyageurService;

    @InjectMocks
    private RestControllerVoyageur restController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testAjouterVoyage() throws Exception {
        Voyage voyage = new Voyage();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/ajouterVoyage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(voyage)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(voyageService, times(1)).ajouterVoyage(voyage);
    }

    @Test
    public void testAjouterTrain() throws Exception {
        Train train = new Train();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/ajouterTrain")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(train)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(trainService, times(1)).ajouterTrain(train);
    }

    @Test
    public void testAjouterVoyageur() throws Exception {
        Voyageur voyageur = new Voyageur();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/ajouterVoyageur")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(voyageur)))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(voyageurService, times(1)).ajouterVoyageur(voyageur);
    }

}
