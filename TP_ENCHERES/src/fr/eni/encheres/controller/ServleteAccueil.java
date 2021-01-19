package fr.eni.encheres.controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class ServleteAccueil
 */
@WebServlet("/accueil")
public class ServleteAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleteAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afficherArticles(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void afficherArticles(HttpServletRequest request, HttpServletResponse response) {

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		ArticleManager articleManager = new ArticleManager();
		Utilisateur utilisateur = new Utilisateur();
		List<Article> articles = null;
		List<Utilisateur> utilisateurs = null;
		articles = articleManager.selectionerArticles();
		for (Article article : articles) {
			utilisateur = utilisateurManager.selectUtilisateurById(article.getNo_utilisateur());
			article.setUtilisateur(utilisateur);
			
		}
		request.setAttribute("listeArticles", articles);
	
	}

}
