package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Commande {
// attributs
				private static Integer code ;
				private Table table;
				private LocalDate date_commande ;
				private LocalTime heure_commande ;
				private String mode_pay;
				private boolean qi_client ;
				private ArrayList<Ligne_commande> ltc = new ArrayList<Ligne_commande>(); // arrayList store all the commands of a table 
 // constructeur
	  public Commande(Table table, LocalDate date_commande, LocalTime heure_commande, String mode_pay)
	  {
          int nb;
          Plat p;
          int q;
          Scanner sc = new Scanner(System.in);
		code = code +1 ; // code incr
		this.table = table;
		this.date_commande = date_commande;
		this.heure_commande = heure_commande;
		this.mode_pay = mode_pay;
		this.qi_client = qi_client;

		//Créer les lignes commandes
        System.out.println("Nombre de plats?:");
        nb = sc.nextInt();
          for (int i = 0; i < nb ; i++) {
              System.out.println("Saisir le plat:");
              p = new Plat();
              System.out.println("Saisir la quantité");
              q = sc.nextInt();
              this.ltc.add(new Ligne_commande(p,q));
          }
	  }



//getters and setterss
	public static int getCode() {
		return code;
	}

	public static void setCode(int code) {
		Commande.code = code;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public LocalDate getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(LocalDate date_commande) {
		this.date_commande = date_commande;
	}

	public LocalTime getHeure_commande() {
		return this.heure_commande;
	}

	public void setHeure_commande(LocalTime heure_commande) {
		this.heure_commande = heure_commande;
	}

	public String getMode_pay() {
		return mode_pay;
	}

	public void setMode_pay(String mode_pay) {
		this.mode_pay = mode_pay;
	}

	public boolean isQi_client() {
		return qi_client;
	}

	public void setQi_client(boolean qi_client) {
		this.qi_client = qi_client;
	}

	public ArrayList<Ligne_commande> getLtc() {
		return this.ltc;
	}

	public void setLtc(ArrayList<Ligne_commande> ltc) {
		this.ltc = ltc;
	}

	public double full_sum(){
		  double result = 0;
		  for (Ligne_commande l: ltc){
			  result+=l.sum();
		  }
		  return result;
	}

	public Ligne_commande max_plat(){
		  Ligne_commande temp;
		temp = ltc.stream().reduce(null,(a, b)->{
			 if (a.getQuantity()>=b.getQuantity()){
				 return a;
			 }
			 else{
				 return b;
			 }
		 });
		return temp;
	}
}
