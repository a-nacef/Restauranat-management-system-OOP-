package com.company;

import jdk.jfr.internal.tool.Main;

import java.util.Scanner;

public class main{
	public static void  main(String[] args)
	{
		int choix;
		Gestionnaire g = new Gestionnaire();
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir votre choix:");
		System.out.println("1. Ajouter un plat \n" +
				"2. Modifier un plat\n" +
				"3. Lister les plats par catégories\n" +
				"4. Ajouter une commande\n" +
				"5. Supprimer une commande\n" +
				"6. Lancer l'interface graphique de gestion des données\n"+
				"7. Quitter \n");
		choix = sc.nextInt();
		switch(choix){
			case 1:
				g.ajout_p();
			case 2:
				g.modify_p();
			case 3:
				g.listcatref();
			case 4:
				g.ajout_commande();
			case 5:
				g.sup_commande();
			case 6:
				MainForm mf = new MainForm();
			case 7:
				break;
			default:
				System.out.println("Saisir un choix valide");
		}
	}
}