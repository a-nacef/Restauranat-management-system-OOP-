package com.company;

import java.util.Scanner;
public class Plat {
	
     static Scanner sc = new Scanner(System.in);
	// les attributs 
	  			private static int ordre_inc ;
				private String code ;
				private String nom ;
				private String catégorie;
				private double prix ;
	//le constructeur para
	public Plat(String code, String nom, double prix, String catégorie) {
				    this.ordre_inc += 1 ;
					this.code = code;
					this.nom = nom;
					this.prix = prix;
					this.catégorie = catégorie;
				}

	// le constructeur non-para
				// for testing 
				public Plat()
				{
					this.ordre_inc+=1;
					System.out.println(" code Plat : ");
					this.code = sc.next();
					System.out.println(" Nom Plat : ");
					this.nom = sc.nextLine();
					System.out.println(" Prix Plat : ");
					this.prix = sc.nextDouble();
					System.out.println(" Catégorie Plat : ");
					this.catégorie = sc.nextLine();
				}

				// getters / setters
				public int getOrdre_inc()
				{
					return  ordre_inc;
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
				public String getCatégorie() {
					return catégorie;
				}

				public void setCatégorie(String catégorie) {
						this.catégorie = catégorie;
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
					return "Plat [code=" + code + ", nom=" + nom + ", prix=" + prix + "]";
				}

}
