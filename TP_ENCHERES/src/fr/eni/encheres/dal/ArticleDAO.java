package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {
	public void insert(Article article);
	public List<Article> selectAll();
	public List<Article> selectByCategory(int noCategorie);
	public List<Article> selectByName(String nomArticle);
	public List<Article> selectNomCategorie(int noCategorie, String nomArticle);
}
