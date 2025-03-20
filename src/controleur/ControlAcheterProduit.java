package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
    private Village village;
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
    private ControlVerifierIdentite controlVerifierIdentite;

    public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
                                 ControlTrouverEtalVendeur controlTrouverEtalVendeur,
                                 Village village) {
        this.village = village;
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public boolean verifierIdentite(String nomAcheteur) {
        return controlVerifierIdentite.verifierIdentite(nomAcheteur);
    }

    public String[] chercherVendeursProduit(String produit) {
        Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
        if (vendeurs == null || vendeurs.length == 0) {
            return new String[0]; // Retourne un tableau vide au lieu de null
        }

        String[] nomsVendeurs = new String[vendeurs.length];
        for (int i = 0; i < vendeurs.length; i++) {
            nomsVendeurs[i] = vendeurs[i].getNom();
        }
        return nomsVendeurs;
    }

    public String acheterProduit(String acheteur, String vendeur, int quantiteAchetee) {
        // Vérifier si l’acheteur est un habitant du village
        if (!controlVerifierIdentite.verifierIdentite(acheteur)) {
            return "Je suis désolé " + acheteur + ", mais il faut être un habitant de notre village pour commercer ici.";
        }

        Gaulois vendeurGaulois = village.trouverHabitant(vendeur);
        if (vendeurGaulois == null) {
            return "Erreur : vendeur introuvable.";
        }

        Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
        if (etalVendeur == null || !etalVendeur.isEtalOccupe()) {
            return "Erreur : l'étal du vendeur est introuvable ou inoccupé.";
        }

        int quantiteDisponible = etalVendeur.getQuantite();
        String produit = etalVendeur.getProduit();

        if (quantiteDisponible == 0) {
            return acheteur + " veut acheter " + quantiteAchetee + " " + produit + ", malheureusement il n’y en a plus !";
        } else if (quantiteAchetee > quantiteDisponible) {
            etalVendeur.acheterProduit(quantiteDisponible);
            return acheteur + " veut acheter " + quantiteAchetee + " " + produit + ", malheureusement " + vendeur + " n’en a plus que " + quantiteDisponible + ". " + acheteur + " achète tout le stock de " + vendeur + ".";
        } else {
            etalVendeur.acheterProduit(quantiteAchetee);
            return acheteur + " achète " + quantiteAchetee + " " + produit + " à " + vendeur + ".";
        }
    }
}
