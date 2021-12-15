package com.company;

import java.util.Scanner;
public class Plat {
	
     static Scanner sc = new Scanner(System.in);
	// les attributs 
	  			private static int ref ;
				private String code ;
				private String nom ;
				private String categorie;
				private double prix ;
	//le constructeur para
	public Plat(String code, String nom, double prix, String categorie) {
				    this.ref += 1 ;
					this.code = code;
					this.nom = nom;
					this.prix = prix;
					this.categorie = categorie;
				}

	// le constructeur non-para
				// for testing 
				public Plat()
				{
					this.ref+=1;
					System.out.println("code Plat : ");
					this.code = sc.nextLine();
					System.out.println("Nom Plat : ");
					this.nom = sc.nextLine();
					System.out.println("Catégorie Plat : ");
					this.categorie = sc.nextLine();
					System.out.println("Prix Plat : X.Y");
					this.prix = Double.parseDouble(sc.nextLine());
				}

				// getters / setters
				public int getRef()
				{
					return  this.ref;
				}
				public String getCode() {
					return code;
				}

				public void setCode(String code) {
					this.code = code;
				}

				public String getNom() {
					return nom;
				}

				public Plat setNom(String nom) {
					this.nom = nom;
					return this ;
				}
				public String getCategorie() {
					return categorie;
				}

				public void setCategorie(String categorie) {
						this.categorie = categorie;
				}


				public double getPrix() {
					return prix;
				}

				public Plat setPrix(double prix) {
					this.prix = prix;
					return this;
				}
	//ToString
				@Override
				public String toString() {
					return "Plat{\n code=" + code + "\n nom=" + nom + "\n prix=" + prix + "}";
				}

}
