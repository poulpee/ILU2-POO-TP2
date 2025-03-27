package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlAcheterProduitTest {

	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlAcheterProduit controlAcheterProduit;

	@BeforeEach
	void setUp() {
		village = new Village("Le village des irréductibles", 10, 5);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit);
	}

	@Test
	void testVerifierIdentite() {
		Gaulois asterix = new Gaulois("Astérix", 10);
		village.ajouterHabitant(asterix);

		assertTrue(controlAcheterProduit.verifierIdentite("Astérix"));
		assertFalse(controlAcheterProduit.verifierIdentite("Inconnu"));
	}

	@Test
	void testChercherVendeursProduit() {
		Gaulois vendeur1 = new Gaulois("Ordralfabetix", 10);
		Gaulois vendeur2 = new Gaulois("Unhygienix", 10);
		village.ajouterHabitant(vendeur1);
		village.ajouterHabitant(vendeur2);
		village.installerVendeur(vendeur1, "poisson", 10);
		village.installerVendeur(vendeur2, "poisson", 5);

		String[] vendeurs = controlAcheterProduit.chercherVendeursProduit("poisson");
		assertArrayEquals(new String[]{"Ordralfabetix", "Unhygienix"}, vendeurs);
	}

	@Test
	void testAcheterProduit() {
		Gaulois asterix = new Gaulois("Astérix", 10);
		Gaulois vendeur = new Gaulois("Ordralfabetix", 10);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(vendeur);
		int etalIndex = village.installerVendeur(vendeur, "poisson", 5);
		Etal etal = village.rechercherEtal(vendeur);

		String resultat = controlAcheterProduit.acheterProduit("Astérix", "Ordralfabetix", 3);
		assertEquals("Astérix achète 3 poisson à Ordralfabetix.", resultat);
		assertEquals(2, etal.getQuantite());

		resultat = controlAcheterProduit.acheterProduit("Astérix", "Ordralfabetix", 5);
		assertEquals("Astérix veut acheter 5 poisson, malheureusement Ordralfabetix n’en a plus que 2. Astérix achète tout le stock de Ordralfabetix.", resultat);
		assertEquals(0, etal.getQuantite());
	}
}