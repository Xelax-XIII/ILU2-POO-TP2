package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println(
					"Je suis désole " + nomVendeur + " mais il faut être un habitant du village pour commercer ici");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais voir si je peux vous trouver un etal");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Desole " + nomVendeur + "il n'y a plus d'etal disponible");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait il me reste un etal");
		System.out.println("Il me faudrait quelques renseignements");
		String produit = Clavier.entrerChaine("Quel produit souhaite tu vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaite tu en vendre ?");
		int etal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (etal != -1) {
			System.out.println("Le vendeur " + nomVendeur + "s'est installe a l'etal n°" + (etal + 1));

		}
	}
}
