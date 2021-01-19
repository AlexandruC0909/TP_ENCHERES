package fr.eni.encheres.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Article;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServleteRechercher
 */
@WebServlet("/rechercher")
public class ServleteRechercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int noCategorie = 0;
	private String nomArticle = null;
	private UtilisateurManager utilisateurManager = new UtilisateurManager();
	private ArticleManager articleManager = new ArticleManager();
	private Utilisateur utilisateur = new Utilisateur();
	private Article article = new Article();
	private List<Article> articles = null;
	private List<Article> articlesFinal = null;
	private List<Utilisateur> utilisateurs = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleteRechercher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		afficherArticlesRecherche(request, response);
		doGet(request, response);
	}
	private void afficherArticlesRecherche(HttpServletRequest request, HttpServletResponse response) {
		
		//Paramethers for searching
		
		noCategorie = Integer.parseInt(request.getParameter("inputCategories"));
		nomArticle = request.getParameter("inputNom");
		
		if (request.getParameter("inputCategories")== null || noCategorie == 0 ) {
			articles = articleManager.selectionerArticleNom(nomArticle);
			ajouterUtilisateurArticle(articles, request);
			
		}else if(request.getParameter("inputNom") == null || nomArticle.trim()=="") {
			articles = articleManager.selectionerArticlesByCategorie(noCategorie);
			ajouterUtilisateurArticle(articles, request);
		}else {
			articles = articleManager.selectionerNomCategorie(noCategorie, nomArticle);
			ajouterUtilisateurArticle(articles, request);
			
		}
		
	}
	
	//Method to add an Utilisateur object to an Article object
	public void ajouterUtilisateurArticle(List<Article> articles,HttpServletRequest request) {
		for (Article article : articles) {
			utilisateur = utilisateurManager.selectUtilisateurById(article.getNo_utilisateur());
			article.setUtilisateur(utilisateur);
			request.setAttribute("listeArticles", articles);
		}
	}
}
