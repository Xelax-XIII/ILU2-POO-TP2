package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Tu n'habite pas ce village tu peux pas acheter");
		} else {
			String produit = Clavier.entrerChaine("Que veux tu acheter ?");

			Gaulois[] vendeurs = controlAcheterProduit.trouverVendeur(produit);

			if (vendeurs == null) {
				System.out.println("Personne vend ça");
			} else {
				System.out.println("Chez quel vendeur voulez vous acheter des " + produit);
				for (int i = 0; i < vendeurs.length; i++) {
					System.out.println((i + 1) + " - " + vendeurs[i].getNom());
				}
				int noEtal = -1;
				do {
					noEtal = Clavier.entrerEntier("");
					if (noEtal > vendeurs.length) {
						System.out.println("ce vendeur n'existe pas");
					}
				} while (noEtal > vendeurs.length);

				Gaulois vendeur = vendeurs[noEtal - 1];

				System.out.println(nomAcheteur + " se déplace jusqu'a l'etal de " + vendeur.getNom());

				int qte = -1;
				do {
					qte = Clavier.entrerEntier("Combien de " + produit + " voulez vous acheter ?");
					if (qte <= 0) {
						System.out.println("qte strictement postitive");
					}
				} while (qte <= 0);

				int nbProduits = controlAcheterProduit.acheterProduit(vendeur.getNom(), qte);
				if (nbProduits == 0) {
					System.out.println(nomAcheteur + " veut acheter " + qte + " " + produit
							+ ", malheureusement il n'y en a plus !");
				} else if (nbProduits < qte) {
					System.out.println(nomAcheteur + " veut acheter " + qte + " " + produit + ", malheureusement "
							+ vendeur.getNom() + " n'en a plus que " + nbProduits + ".");
					System.out.println(nomAcheteur + " achète tout le stock de " + vendeur.getNom() + ".");
				} else {
					System.out.println(
							nomAcheteur + " achète " + nbProduits + " " + produit + " à " + vendeur.getNom() + ".");
				}
			}

		}
	}
}
