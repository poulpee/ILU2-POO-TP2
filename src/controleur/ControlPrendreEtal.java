package controleur;

import villagegaulois.Village;
import personnages.Gaulois;

public class ControlPrendreEtal {
    private Village village;
    private ControlVerifierIdentite controlVerifierIdentite;

    public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite, Village village) {
        this.controlVerifierIdentite = controlVerifierIdentite;
        this.village = village;
    }

    public boolean resteEtals() {
        return village.rechercherEtalVide();
    }

    public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
        Gaulois vendeur = village.trouverHabitant(nomVendeur);
        if (vendeur != null) {
            return village.installerVendeur(vendeur, produit, nbProduit);
        }
        return -1;
    }

    public boolean verifierIdentite(String nomVendeur) {
        return controlVerifierIdentite.verifierIdentite(nomVendeur);
    }
}