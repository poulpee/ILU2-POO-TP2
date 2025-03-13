package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
        System.out.print("Quelle est votre force ? ");
        int force = Clavier.entrerEntier(nomVisiteur);
        System.out.print("Quelle est la force de potion la plus faible que vous produisez ? ");
        int forceMin = Clavier.entrerEntier(nomVisiteur);
        System.out.print("Quelle est la force de potion la plus forte que vous produisez ? ");
        int forceMax = Clavier.entrerEntier(nomVisiteur);
        
        controlEmmenager.ajouterDruide(nomVisiteur, force, forceMin, forceMax);
        System.out.println("Le druide " + nomVisiteur + " : \"Bonjour, je suis le druide " + nomVisiteur + " et ma potion peut aller d'une force " + forceMin + " à " + forceMax + ".\"");
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		 System.out.println("Bienvenue villageois " + nomVisiteur);
	     System.out.print("Quelle est votre force ? ");
	     int force = Clavier.entrerEntier(nomVisiteur);
	        
	     controlEmmenager.ajouterGaulois(nomVisiteur, force);
	     System.out.println("Le villageois " + nomVisiteur + " a une force de " + force);
	}
}
