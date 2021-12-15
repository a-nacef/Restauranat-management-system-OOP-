package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

public class Commande {
// attributs
				private static int code ;
				private Table table;
				private LocalDate date_commande ;
				private LocalTime heure_commande ;
				private String mode_pay;
				private boolean qi_client ;
				private ArrayList<Ligne_commande> ltc = new ArrayList<Ligne_commande>(); // arrayList store all the commands of a table 
 // constructeur
	Scanner sc = new Scanner(System.in);
	  public Commande(Table table, LocalDate date_commande, LocalTime heure_commande, String mode_pay)
	  {
		  String codeplat;
          System.out.println("creation d'une commande  : ");
		this.code = code +1 ; // code incr
		this.table = table;
		this.date_commande = date_commande;
		this.heure_commande = heure_commande;
		this.mode_pay = mode_pay;
		this.qi_client = qi_client;
		  int nb = 0;
		  Plat p;
		  int q =0;
		//Créer les lignes commandes
        System.out.println("Nombre de lignes commande:");
           nb = Integer.parseInt(sc.nextLine());
          for (int i =0; i < nb ; i++) {
			  while(true) {
				  System.out.println("Saisir un code plat");
					  codeplat = sc.nextLine();
				  if (Gestionnaire.rech_plat(codeplat) == null) {
					  System.out.println("Le plat n'existe pas");
					  continue;
				  }
				  break;
			  }
              this.ltc.add(new Ligne_commande(Gestionnaire.rech_plat(codeplat),getplatequantity()));
          }
	  }

	  public int getplatequantity(){
		  System.out.println("Quantité?");
		   return Integer.parseInt(sc.nextLine());
	  }
//getters and setterss
	public static int getCode() {
		return code;
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

    @Override
    public String toString() {
          String result = null;
          for (Ligne_commande lc: ltc){
              result+=lc.toString();
          }
        return "Commande{\n" +
                "\n date_commande=" + date_commande +
                "\n heure_commande=" + heure_commande +
                "\n mode_pay='" + mode_pay + '\'' +
                "\n qi_client=" + qi_client +
                "\n ltc=" +  result+"}\n";
    }
}
