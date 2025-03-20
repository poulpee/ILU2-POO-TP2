package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
    private ControlAfficherMarche controlAfficherMarche;

    public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
        this.controlAfficherMarche = controlAfficherMarche;
    }

    public void afficherMarche(String nomAcheteur) {
        System.out.println(nomAcheteur + ", voici l'état du marché :");
        String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
        
        for (String info : infosMarche) {
            System.out.println("- " + info);
        }
    }
}
