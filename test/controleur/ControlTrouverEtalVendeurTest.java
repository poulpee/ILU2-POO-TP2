package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Etal;
import villagegaulois.Village;
import personnages.Chef;
import personnages.Gaulois;

class ControlTrouverEtalVendeurTest {

    private Village village;
    private Chef abraracourcix;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    @BeforeEach
    void initialiserSituation() {
        // Initialisation du village et du chef
        village = new Village("le village des irréductibles", 10, 5);
        abraracourcix = new Chef("Abraracourcix", 10, village);
        village.setChef(abraracourcix);

        // Initialisation du contrôleur pour trouver un étal de vendeur
        controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
    }

    @Test
    void testControlTrouverEtalVendeur() {
        assertNotNull(controlTrouverEtalVendeur, "Le contrôleur ne doit pas être null.");
    }

    @Test
    void testTrouverEtalVendeur() {
        // Ajouter un villageois au village
        Gaulois bonemine = new Gaulois("Bonemine", 10);
        village.ajouterHabitant(bonemine);

        // Bonemine prend un étal
        village.installerVendeur(bonemine, "Potion magique", 10);

        // Vérifier que l'étal de Bonemine est bien trouvé
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
        assertNotNull(etal, "L'étal de Bonemine devrait être trouvé.");
        assertEquals("Bonemine", etal.getVendeur().getNom(), "Le vendeur de l'étal devrait être Bonemine.");
    }

    @Test
    void testTrouverEtalVendeurVendeurInexistant() {
        // Tenter de trouver un étal pour un vendeur qui n'existe pas
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("Inexistant");
        assertNull(etal, "Il ne devrait pas y avoir d'étal pour un vendeur inexistant.");
    }
}
