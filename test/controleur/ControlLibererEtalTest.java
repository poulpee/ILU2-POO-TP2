package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Etal;

class ControlLibererEtalTest {

    private Etal etal;
    private Gaulois vendeur;

    @BeforeEach
    void setUp() {
        vendeur = new Gaulois("Asterix", 10);
        etal = new Etal();
        etal.occuperEtal(vendeur, "potion", 5);
    }

    @Test
    void testControlLibererEtal() {
        assertNotNull(etal, "L'étal ne devrait pas être nul");
        assertTrue(etal.isEtalOccupe(), "L'étal devrait être occupé après l'installation du vendeur");
    }

    @Test
    void testLibererEtal() {
        etal.libererEtal();
        assertFalse(etal.isEtalOccupe(), "L'étal devrait être libéré après l'appel à libererEtal");
    }
}
