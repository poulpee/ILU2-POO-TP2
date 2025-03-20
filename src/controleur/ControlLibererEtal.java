package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
    private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

    public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
        this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
    }

    public String[] libererEtal(String nomVendeur) {
        Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
        if (etal != null && etal.isEtalOccupe()) {
            String[] donneesEtal = new String[5];
            donneesEtal[0] = "true";
            donneesEtal[1] = etal.getVendeur().getNom();
            donneesEtal[2] = etal.getProduit();
            donneesEtal[3] = String.valueOf(etal.getQuantiteDebutMarche());
            donneesEtal[4] = String.valueOf(etal.getQuantiteDebutMarche() - etal.getQuantite());
            etal.libererEtal();
            return donneesEtal;
        }
        return new String[]{"false"};
    }
}