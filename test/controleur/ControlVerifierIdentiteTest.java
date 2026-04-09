package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	void init() {
		System.out.println("init");
		village = new Village("Le village des irréductibles", 10, 5);
		abraracourcix = new Chef("abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertTrue(controlVerifierIdentite.verifierIdentite("abraracourcix"), "le chef est dans le village");
		assertFalse(controlVerifierIdentite.verifierIdentite("sdfjdhjfgjhsdfjgsd"), "hdsdggjfdgujdsg n'existe pas");

	}

}
