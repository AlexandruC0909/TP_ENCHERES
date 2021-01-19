package fr.eni.encheres.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Categories implements Serializable {
	private int no_categorie;
	private String libelle;
	List<Article> articles;
	
	public int getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Categories() {
		articles = new ArrayList<Article>();
	}
	public Categories(String libelle) {
		super();
		this.libelle = libelle;
	}
	public Categories(String libelle, List<Article> articles) {
		this(libelle);
		this.articles = articles;
	}
	public void addArticle(Article article) {
		articles.add(article);
	}

	
}
