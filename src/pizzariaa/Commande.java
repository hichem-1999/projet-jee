package pizzariaa;

import java.util.List;
import java.util.UUID;

public class Commande {
	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private List<Pizza> pizzas;
	private int prix_total;
	
	public Commande(String nom, String prenom, String adresse, List<Pizza> pizzas, int prix_total) {
		this.id = UUID.randomUUID().toString();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.pizzas = pizzas;
		this.prix_total = prix_total;
	}

	public String getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public List<Pizza> getPizzas() {
		return pizzas;
	}
	
	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public int getPrix_total() {
		return prix_total;
	}
	
	public void setPrix_total(int prix_total) {
		this.prix_total = prix_total;
	}
	
}
