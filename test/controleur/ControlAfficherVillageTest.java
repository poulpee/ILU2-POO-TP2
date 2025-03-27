package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	private Village village;
	private ControlAfficherVillage controlAfficherVillage;
	private Chef abraracourcix;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	void testDonnerNomsVillageois() {
		Gaulois asterix = new Gaulois("Astérix", 10);
		Druide panoramix = new Druide("Panoramix", 10, 1, 5);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(panoramix);

		String[] noms = controlAfficherVillage.donnerNomsVillageois();
		assertArrayEquals(new String[]{"Abraracourcix", "Astérix", "le druide Panoramix"}, noms);
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("Le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals());
	}
}
