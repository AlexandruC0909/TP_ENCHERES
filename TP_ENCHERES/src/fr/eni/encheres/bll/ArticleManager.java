package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.exception.BusinessException;

public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	public void ajouterArticle(String nom,String description, LocalDate dateDebut,LocalDate dateFin,int prixInitial,
			int noUtilisateur,int noCategorie,String etat) {
		Article article = new Article(nom, description, dateDebut, dateFin, prixInitial, noUtilisateur, noCategorie, etat);
		BusinessException businessException = new BusinessException();
		if (!businessException.hasErreurs()) {
			this.articleDAO.insert(article);
		}
	}
	
	public List<Article> selectionerArticles() {
		return this.articleDAO.selectAll();
	}
	public List<Article> selectionerArticlesByCategorie(int noCategorie) {
		return this.articleDAO.selectByCategory(noCategorie);
	}
	public List<Article> selectionerArticleNom(String name){
		return this.articleDAO.selectByName(name);
	}
	public List<Article> selectionerNomCategorie(int noCategorie,String nomArticle){
		return this.articleDAO.selectNomCategorie(noCategorie, nomArticle);
	}
}
