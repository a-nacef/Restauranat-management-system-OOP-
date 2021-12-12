package com.company;

import javafx.scene.control.Tab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Gestionnaire {
	static Scanner sc = new Scanner(System.in);
	//ArrayList
	  static ArrayList<Plat> liste_plat = new ArrayList<Plat>();
	  public static HashMap<Integer, Commande> Liste_Commandes = new HashMap<Integer, Commande>();
	  public static ArrayList<Table> liste_tables = new ArrayList<Table>();

		public static Plat rech_plat(String code) {
			for (Plat p : liste_plat){
				if (p.getCode() == code) {
				return p;
				}
		}
		return null;
	}
	 

	//ajouter un plat
	public static void ajout_p() {
		while(true) {
			System.out.println("code plat?");
			if(rech_plat(sc.next())== null)
			{
				liste_plat.add(new Plat());
				System.out.println("Plat ajouté.");
			}
			else{
				System.out.println("Le plat éxiste, veuillez entrer un code valide ou bien 'Q' pour quitter ");
				if (sc.nextLine().equals("Q")){
					break;
				}
			}
		}
	}
						
	
	//modifier details plats 
	public static void modify_p()
	{
		Plat p;
		int choix = 0;
		boolean changed = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le code du plat à changer:");
		p = rech_plat(sc.nextLine());
		if(p!=null){
			while(!changed) {
				System.out.println("Saisir l'attribut à modifier: \n 1.Prix \n 2.Code \n 3.Nom\n");
				choix = sc.nextInt();
				switch (choix) {
					case 1:
						p.setPrix(sc.nextDouble());
						changed = true;
					case 2:
						p.setCode(sc.nextLine());
						changed = true;
					case 3:
						p.setNom(sc.nextLine());
						changed = true;
					default:
						System.out.println("Saisir un choix valide");
						continue;
				}
			}
		}


	}
	// afficher liste des plats par categorie et ordonnee par refrence
	
	public void listcatref()
	{
		ArrayList<Plat> temp = new ArrayList<Plat>();
		System.out.println("Saisir la catégorie à lister");
		String cat = sc.nextLine();
		for(Plat p: liste_plat){
			if (p.getCatégorie()==cat){
				temp.add(p);
			}
		}
		temp.sort(Comparator.comparing(Plat::getCatégorie));
		temp.forEach(p->{
			System.out.println(p.toString());
		});
	}

	public Table rech_table(int code){
			for (Table t: liste_tables){
				if (t.getId() == code){
					return t;
				}
			}
			return null;
	}

	//creer une commande 
	public void ajout_commande()
	{
		Integer cd;
		String mode;
		Commande temp_cmd;
		Table tb;
		System.out.println("Code Table?");
		cd = sc.nextInt();
		tb = rech_table(cd);
		System.out.println("Mode paiement?");
		mode = sc.nextLine();
		tb.setReserve(true);
		if (Liste_Commandes.containsKey(cd)){
			temp_cmd = new Commande(tb, LocalDate.now(), LocalTime.now(), mode);
			Liste_Commandes.put(cd, temp_cmd);
		}
		else{
			liste_tables.add(new Table());
			cd = liste_tables.get(liste_tables.size()).getId();
			temp_cmd = new Commande(tb, LocalDate.now(), LocalTime.now(), mode);
			Liste_Commandes.put(cd,temp_cmd);
		}
	}
	
	// afficher details d'une commande 
	
	public Commande rech_commande(int code)
	{
		for(Commande cd: Liste_Commandes.values()){
			if (code==cd.getCode()){
				return cd;
			}
		}
		return null;
		
	}
	//cloturer une commande
	public void sup_commande()
	{
		int code;
		System.out.println("Saisir le code de la table");
		code = sc.nextInt();
		Liste_Commandes.remove(code);
		rech_table(code).setReserve(false);
	}
	
	// afficher la recette journali�re
	public double affiche_recette()
	{
		double result = 0;
		for(Commande cmd: Liste_Commandes.values()){
			if (cmd.getDate_commande().equals(LocalDate.now())){
				result += cmd.full_sum();
			}
		}
		return result;
	}
	
	// afficher la recette journali�re durant une periode (date debut / date fin )
	//puis le chiffre d'affaires de cette periode 
	public double affiche_recette_dans_periode()
	{
		LocalTime t1;
		LocalTime t2;
		double result = 0;
		do {
			System.out.println("Saisir la borne inférieure:");
			t1 = lire_temps();
			System.out.println("Saisir la borne supérieure:");
			t2 = lire_temps();
		}while (!t1.isBefore(t2));
		for(Commande cmd: Liste_Commandes.values()){
			if (dans_intervalle(t1,t2,cmd.getHeure_commande())){
				result += cmd.full_sum();
			}
		}
		return result;
		
	}

	private boolean dans_intervalle(LocalTime t1, LocalTime t2, LocalTime date){
			return date.isAfter(t1) && date.isBefore(t2);
	}

	private LocalTime lire_temps(){
		    DateTimeFormatter fmt;
			String time;
			System.out.println("Saisir l'heure dans le format HH:MM");
			time = sc.nextLine();
			return LocalTime.parse(time+":00", DateTimeFormatter.ISO_TIME);
	}


	//afficher le plat le plus command�
	public Plat plat_pref()
	{
		ArrayList<Ligne_commande>  temp_lc = new ArrayList<Ligne_commande>();
		Ligne_commande max_ligne;
		for (Commande temp: Liste_Commandes.values()){
			temp_lc.add(temp.max_plat());
		}
		max_ligne = temp_lc.stream().reduce(null,(a, b)->{
			if (a.getQuantity()>=b.getQuantity()){
				return a;
			}
			else{
				return b;
			}
		});

       return max_ligne.getPlat();
	}
}
