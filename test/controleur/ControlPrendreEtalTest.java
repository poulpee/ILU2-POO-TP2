package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlPrendreEtalTest {

    private Village village;
    private Chef abraracourcix;
    private ControlVerifierIdentite controlVerifierIdentite;
    private ControlPrendreEtal controlPrendreEtal;

    @BeforeEach
    void initialiserSituation() {
        // Initialisation du village et de son chef
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);

        // Initialisation du contrôleur d'identité
        controlVerifierIdentite = new ControlVerifierIdentite(village);

        // Initialisation du contrôleur pour prendre un étal
        controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
    }

    @Test
    void testControlPrendreEtal() {
        assertNotNull(controlPrendreEtal, "Le contrôleur ne doit pas être null.");
    }

    @Test
    void testResteEtals() {
        // Vérifier qu'il reste des étals libres
        boolean resteEtals = controlPrendreEtal.resteEtals();
        assertTrue(resteEtals, "Il devrait y avoir des étals disponibles.");
    }

    @Test
    void testPrendreEtal() {
        // Ajouter un habitant au village
        Gaulois bonemine = new Gaulois("Bonemine", 10);
        village.ajouterHabitant(bonemine);

        // Vérifier que l'étal est pris correctement
        int etalId = controlPrendreEtal.prendreEtal("Bonemine", "Potion magique", 10);
        assertNotEquals(-1, etalId, "L'étal devrait être attribué avec succès.");

        // Vérifier que le nom du vendeur est bien celui attendu
        assertTrue(village.rechercherVendeursProduit("Potion magique")[0].getNom().equals("Bonemine"), "Le vendeur devrait être Bonemine.");
    }

    @Test
    void testVerifierIdentite() {
        // Vérifier que l'identité de Bonemine est correctement validée
        boolean identiteVerifiee = controlPrendreEtal.verifierIdentite("Bonemine");
        assertTrue(identiteVerifiee, "L'identité de Bonemine devrait être vérifiée.");
    }
}
