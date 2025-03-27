package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

class ControlAfficherMarcheTest {

	private Village village;
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche() {
		Gaulois asterix = new Gaulois("Astérix", 10);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "potion", 5);

		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		assertNotNull(infosMarche);
		assertEquals(3, infosMarche.length);
		assertEquals("Astérix", infosMarche[0]);
		assertEquals("5", infosMarche[1]);
		assertEquals("potion", infosMarche[2]);
	}
}