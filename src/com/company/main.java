package com.company;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		int choix;
		Gestionnaire g = new Gestionnaire();
		String con = "";
		Scanner sc = new Scanner(System.in);
		do {
			do {
				System.out.println("Saisir votre choix:");
				System.out.println("1. Ajouter un plat \n" +
						"2. Modifier un plat\n" +
						"3. Lister les plats par catégories\n" +
						"4. Ajouter une commande\n" +
						"5. Supprimer une commande\n" +
						"6. Lancer l'interface graphique de gestion des données\n" +
						"7. Quitter \n");
				choix = Integer.parseInt(sc.nextLine());
			} while (choix > 7 && choix < 1);
			switch (choix) {
				case 1:
					g.ajout_p();
					break;
				case 2:
					g.modify_p();
					break;
				case 3:
					g.listcatref();
					break;
				case 4:
					g.ajout_commande();
					break;
				case 5:
					g.sup_commande();
					break;
				case 6:
					MainForm mf = new MainForm();
					break;
				case 7:
					break;
				default:
					System.out.println("Saisir un choix valide");
			}
			do {
				System.out.println("vous voulez continuez ? oui/ non");
				con = sc.nextLine();
			}while(con.compareToIgnoreCase("oui") != 0 && con.compareToIgnoreCase("non") != 0);
		}while(con.compareToIgnoreCase("oui") == 0);
		System.out.println("Bonne Journée ! ");
	}
}