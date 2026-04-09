package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("init");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "Le constructeur ne retourne pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);

		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur("jerome");
		assertNull(etal, "Le vendeur jerome n'existe pas");

		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("jerome", 5);

		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("jerome", "a", 1);

		etal = controlTrouverEtalVendeur.trouverEtalVendeur("jerome");
		assertNotNull(etal, "Jerome est devenu vendeur");
	}

}
