package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;

	@BeforeEach
	void init() {
		System.out.println("init");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		boolean resteEtal = controlPrendreEtal.resteEtals();
		assertTrue(resteEtal, "aucun etal pris");
		for (int i = 0; i < 5; i++) {
			controlPrendreEtal.prendreEtal("" + i, "a", i);
		}
		resteEtal = controlPrendreEtal.resteEtals();
		assertFalse(resteEtal, "tout les etals sont pris");
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("jerome", "a", 8);
		Gaulois gaulois[] = village.rechercherVendeursProduit("a");
		assertNotNull(gaulois, "un etal a été pris");
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		controlPrendreEtal.prendreEtal("jerome", "a", 8);
		controlPrendreEtal.verifierIdentite("jerome");
	}

}
