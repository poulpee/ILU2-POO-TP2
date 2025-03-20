package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
    private Village village;

    public ControlAfficherMarche(Village village) {
        this.village = village;
    }

    public String[] donnerInfosMarche() {
        String[] donneesMarche = village.donnerEtatMarche();
        
        if (donneesMarche.length == 0) {
            return new String[]{"Le marché est vide."};
        }

        int nbEtals = donneesMarche.length / 3;
        String[] infosMarche = new String[nbEtals];

        for (int i = 0, j = 0; i < nbEtals; i++, j += 3) {
            infosMarche[i] = donneesMarche[j] + " vend " + donneesMarche[j + 1] + " " + donneesMarche[j + 2];
        }

        return infosMarche;
    }
}
