package com.company;

public class Ligne_commande {
	private Plat plat;
	private int quantity;
	
    // constructeur 
	public Ligne_commande(Plat plat , int quantity)
	{    
		this.plat = plat ;
		this.quantity = quantity ;
	}
	// getters and setters
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double sum()
	{
		return  this.plat.getPrix() * quantity;
	}

	@Override
	public String toString() {
		return "Ligne_commande{" +
				"plat=" + plat +
				", quantity=" + quantity +
				'}';
	}
}
