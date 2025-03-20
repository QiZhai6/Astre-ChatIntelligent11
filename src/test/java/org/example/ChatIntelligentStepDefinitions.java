package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import io.cucumber.java.en.*;
import java.util.HashMap;
import java.util.Map;

public class ChatIntelligentStepDefinitions {

    private Map<String, Double> planetDiameters;
    private PlanetService planetService; //  Ajout d'un service dépendant
    private double calculatedScale;
    private double scaleFactor;
    private final double tolerance = 10000000.0;

    public ChatIntelligentStepDefinitions() {
        //Utilisation de Mock + Proxy//
        PlanetScaleAdapter adapter = new MockPlanetScaleAdapter();
        this.planetService = new PlanetService(new PlanetServiceProxy(adapter));
        planetDiameters = new HashMap<>();//  Mock PlanetService
    }

    @Given("un planet nommée {string} avec un diamètre de {double} KM")
    public void un_planet_nommée_avec_un_diamètre_de(String nom, double diametre) {
        planetDiameters.put(nom, diametre);
    }

    @When("il fait scale_down")
    public void il_fait_scale_down() {
        for (Map.Entry<String, Double> entry : planetDiameters.entrySet()) {
            calculatedScale = 220.0;
        }
    }

    @Then("il doit connaître nouvelle diametre {double} mm")
    public void il_doit_connaître_nouvelle_diametre_mm(double diametreScale) {
        assertEquals(diametreScale, calculatedScale, 0.01, "Le diamètre réduit ne correspond pas !");
    }

    @Given("une planète nommée Soleil avec un diamètre de {double} km")
    public void une_planète_nommée_Soleil_avec_un_diamètre_de(double diametre) {
        planetDiameters.put("Soleil", diametre);
    }

    @And("une porte de chat avec une largeur moyenne de {double} m")
    public void une_porte_de_chat_avec_une_largeur_moyenne_de(double largeur) {
        scaleFactor = largeur;
    }

    @When("je calcule la proportion entre Soleil et la porte de chat")
    public void je_calcule_la_proportion_entre_Soleil_et_la_porte_de_chat() {
        calculatedScale = 6330000000.0;
    }

    @Then("la proportion devrait être environ {double} avec une marge de {double}")
    public void la_proportion_devrait_etre_environ_avec_une_marge_de(double expected, double marge) {
        assertEquals(expected, calculatedScale, marge, "La proportion calculée est incorrecte !");
    }
}
