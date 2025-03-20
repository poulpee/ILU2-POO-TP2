package frontiere;

import controleur.ControlAcheterProduit;
import java.util.Scanner;

public class BoundaryAcheterProduit {
    private ControlAcheterProduit controlAcheterProduit;
    private Scanner scanner = new Scanner(System.in);

    public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
        this.controlAcheterProduit = controlAcheterProduit;
    }

    public void acheterProduit(String nomAcheteur) {
        if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
            System.out.println("Je suis désolé " + nomAcheteur + ", mais il faut être un habitant de notre village pour commercer ici.");
            return;
        }

        System.out.print("Quel produit voulez-vous acheter ? ");
        String produit = scanner.nextLine();

        String[] vendeurs = controlAcheterProduit.chercherVendeursProduit(produit);
        if (vendeurs == null) {
            System.out.println("Désolé, personne ne vend ce produit au marché.");
            return;
        }

        System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
        for (int i = 0; i < vendeurs.length; i++) {
            System.out.println((i + 1) + " - " + vendeurs[i]);
        }

        int choixVendeur = scanner.nextInt();
        scanner.nextLine();  // Consommer la ligne restante

        if (choixVendeur < 1 || choixVendeur > vendeurs.length) {
            System.out.println("Choix invalide.");
            return;
        }

        String vendeurChoisi = vendeurs[choixVendeur - 1];

        System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurChoisi);
        System.out.println("Bonjour " + nomAcheteur + ", combien de " + produit + " voulez-vous acheter ?");
        int quantiteAchetee = scanner.nextInt();
        scanner.nextLine();  // Consommer la ligne restante

        String resultatAchat = controlAcheterProduit.acheterProduit(nomAcheteur, vendeurChoisi, quantiteAchetee);
        System.out.println(resultatAchat);
    }
}
