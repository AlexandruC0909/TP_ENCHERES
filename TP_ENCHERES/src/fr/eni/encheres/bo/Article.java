package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class Article implements Serializable {
	private int noArticle;
	private String nom;
	private String description;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int prixInitial;
	private int prixVente;
	private int no_utilisateur;
	private int no_categorie;
	private String etat;
	private String image;

	private Utilisateur utilisateur;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public int getPrixInitial() {
		return prixInitial;
	}
	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public int getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Article() {
		super();
	}
	public Article(String nom, String description, LocalDate dateDebut, LocalDate dateFin, int prixInitial,
			int no_categorie) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;

		this.no_categorie = no_categorie;
	}
	public Article(String nom, String description, LocalDate dateDebut, LocalDate dateFin, int prixInitial,
			int no_categorie, String etat) {
		this(nom,description,dateDebut,dateFin,prixInitial,no_categorie);
		this.etat = etat;
	}
	public Article(String nom, String description, LocalDate dateDebut, LocalDate dateFin, int prixInitial,
			int no_utilisateur, int no_categorie, String etat) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixInitial = prixInitial;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Article [noArticle=" + noArticle + ", nom=" + nom + ", description=" + description + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", prixInitial=" + prixInitial + ", prixVente=" + prixVente
				+ ", no_utilisateur=" + no_utilisateur + ", no_categorie=" + no_categorie + ", etat=" + etat
				+ ", image=" + image + ", utilisateur=" + utilisateur + "]";
	}
	
	
	
	
}
