package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
    private ControlPrendreEtal controlPrendreEtal;

    public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
        this.controlPrendreEtal = controlChercherEtal;
    }

    public void prendreEtal(String nomVendeur) {
        if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
            System.out.println("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
        if (!controlPrendreEtal.resteEtals()) {
            System.out.println("Désolé " + nomVendeur + ", il n'y a plus d'étals disponibles.");
            return;
        }else {
        System.out.println("C'est parfait, il me reste un étal pour vous !");
        System.out.println("Il me faudrait quelques renseignements :");
        }
        
        String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
        int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

        int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
        if (numeroEtal != -1) {
            System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numeroEtal + 1));
        }
    }
}


