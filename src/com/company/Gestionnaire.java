package com.company;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Gestionnaire {



	//Attributs
	  static Scanner sc = new Scanner(System.in);
	  static ArrayList<Plat> liste_plat = new ArrayList<Plat>();
	  public static HashMap<Integer, Commande> Liste_Commandes = new HashMap<Integer, Commande>();
	  public static ArrayList<Table> liste_tables = new ArrayList<Table>();

	  //Methodesg
		public static Plat rech_plat(String code) {
			for (Plat p : liste_plat){
				if (p.getCode().compareToIgnoreCase(code) == 0) {
				return p;
				}
		}
		return null;
	}
	 

	//ajouter un plat
	public  void ajout_p() {

		while(true) {
				Plat p = (new Plat());
				if(rech_plat(p.getCode())==null){
					liste_plat.add(p);
				System.out.println("Plat ajouté.");
				break;
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
	public  void modify_p()
	{
		Plat p;
		int choix = 0;
        boolean changed = false ;
		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez entrer le code du plat à changer:");
		p = rech_plat(sc.next());

		if(p!=null){
			while(!changed) {
				System.out.println("Saisir l'attribut à modifier: \n 1.Prix \n 2.Code \n 3.Nom\n");
				choix = sc.nextInt();
				switch (choix) {
					case 1:
						System.out.println("prix ? ");
						p.setPrix(sc.nextDouble()); System.out.println("prix changé avec succes ! ");
						changed = true;
						break;
					case 2:
						System.out.println("code ? ");
						p.setCode(sc.next());System.out.println("code changé avec succes ! ");changed = true ;
						break;
					case 3:
						System.out.println("nom ? ");
						p.setNom(sc.next());System.out.println("NOM  changé avec succes ! ");changed = true ;
						 break;
					default:
						System.out.println("Saisir un choix valide");
						continue;
				}
			}
		}
	}
	/*************************************************************************************************************/

	// afficher liste des plats par categorie et ordonnee par refrence

	public ArrayList<Plat> listcatref()
	{
		ArrayList<Plat> temp = new ArrayList<Plat>();
		System.out.println("Saisir la catégorie à lister");
		String cat = sc.next();

		for(Plat p: liste_plat){
			if (p.getCategorie().compareToIgnoreCase(cat) == 0){
				temp.add(p);
			}
		}
		//Trier par ref
		temp.sort(Comparator.comparing(Plat::getRef));
		System.out.println(temp); // show the list
		return temp;
	}
   /*****************************************************************************************************************/
// check if the table is available or not
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
		int  cd;
		String mode;
		Table tb;
		System.out.println("Code Table?");

		cd = sc.nextInt();
		tb = rech_table(cd);

		System.out.println("Mode paiement?");
		mode = sc.next();

		if(tb != null)
			tb.setReserve(true); // change the table to reserved automatically when we add the command

		if (Liste_Commandes.containsKey(cd)){
			Liste_Commandes.put(cd,new Commande(tb, LocalDate.now(), LocalTime.now(), mode));
			System.out.println(Liste_Commandes.containsKey(cd));
		}
		else{
			liste_tables.add(new Table(cd)); /* add a table */
			cd = liste_tables.get(liste_tables.size()-1).getId();
			Liste_Commandes.put(cd,new Commande(tb, LocalDate.now(), LocalTime.now(), mode));
			System.out.println("commande ajoutee avec succes ! ");
		}
	}

	// afficher details d'une commande
	public Commande rech_commande(int code)
	{
		if(  ! Liste_Commandes.isEmpty()) {
			for (Commande cd : Liste_Commandes.values()) {
				if (code == cd.getCode()) {
					return cd;
				}
			}
			return null ;
		}
		else {
			return null;
		}

	}

	public ArrayList<String> Description_commandes(){
			ArrayList<String> result = new ArrayList<String>();
			for (Commande c: Liste_Commandes.values()){
				result.add(c.toString());
			}
			return result;
	}


	//cloturer une commande
	public void sup_commande()
	{
		int code;
		System.out.println("Saisir le code de la table");
		code = sc.nextInt();
		System.out.println(liste_tables.isEmpty());
		for(Table t: liste_tables){
			System.out.println(t.getId());
			if (t.getId() == code){
				t.setReserve(false);
				Liste_Commandes.remove(code);
				System.out.println("Remove succesful");
			}
		}
	}
	
	// afficher la recette journali�re
	public static double affiche_recette()
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
	public static double affiche_recette_dans_periode(String t1, String t2)
	{
		LocalTime T1;
		LocalTime T2;
		double result = 0;
		do {
			T1 = lire_temps(t1);
			T2 = lire_temps(t2);
		}while (!T1.isBefore(T2));
		for(Commande cmd: Liste_Commandes.values()){
			if (dans_intervalle(T1,T2,cmd.getHeure_commande())){
				result += cmd.full_sum();
			}
		}
		return result;
		
	}

	private static boolean dans_intervalle(LocalTime t1, LocalTime t2, LocalTime date){
			return date.isAfter(t1) && date.isBefore(t2);
	}

	private static LocalTime lire_temps(String time){
		    DateTimeFormatter fmt;
			return LocalTime.parse(time, DateTimeFormatter.ISO_TIME);
	}


	//afficher le plat le plus command�
	public static Plat plat_pref()
	{
		Plat p = null;
		int q = 0;
		Ligne_commande temp = new Ligne_commande(p,q);
		for (Commande c: Liste_Commandes.values()){
			for(Ligne_commande lc: c.getLtc()){
				if(lc.getQuantity()>temp.getQuantity()){
					temp = lc;
				}
			}
		}
		return temp.getPlat();
	}
}
