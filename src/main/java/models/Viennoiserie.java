package models;

public class Viennoiserie {
	private String nom;
    private int fournisseur;
    private float prix;
    private int ventes;
    
 // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(int fournisseur) {
        this.fournisseur = fournisseur;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getVentes() {
        return ventes;
    }

    public void setVentes(int ventes) {
        this.ventes = ventes;
    }
}
