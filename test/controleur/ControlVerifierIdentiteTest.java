package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Chef abraracourcix;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlVerifierIdentite() {
		assertNotNull(controlVerifierIdentite);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois asterix = new Gaulois("Astérix", 10);
		village.ajouterHabitant(asterix);

		assertTrue(controlVerifierIdentite.verifierIdentite("Astérix"));
		assertTrue(controlVerifierIdentite.verifierIdentite("Abraracourcix"));
		assertFalse(controlVerifierIdentite.verifierIdentite("Obélix"));
	}
}