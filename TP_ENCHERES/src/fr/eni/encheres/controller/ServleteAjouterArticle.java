package fr.eni.encheres.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.exception.BusinessException;
import fr.eni.encheres.tools.Tools;

/**
 * Servlet implementation class ServleteAjouterArticle
 */
@WebServlet("/ajouter/article")
public class ServleteAjouterArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleteAjouterArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AjouterArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajouterArticle(request, response);
		doGet(request, response);
	}
	
	private void ajouterArticle(HttpServletRequest request,HttpServletResponse response) {
		String nom = null;
		String description = null;
		LocalDate dateDebut = null;
		LocalDate dateFin = null;
		int prixInitial = 0;
		int noUtilisateur = 0;
		int noCategorie = 0;
		String etat = null;
		
		List<Integer> listeCodesErreur=new ArrayList<>();
		ArticleManager articleManager = new ArticleManager();
		
		nom = lireParametreNom(request, listeCodesErreur);
		description = lireParametreDescription(request, listeCodesErreur);
		dateDebut = LocalDate.parse(request.getParameter("inputDateDebut"));
		dateFin = LocalDate.parse(request.getParameter("inputDateFin"));
		prixInitial = lireParametrePrixInitial(request, listeCodesErreur);
		noCategorie = Integer.parseInt(request.getParameter("inputCategories"));
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeMessagesErreur",Tools.getMessages(listeCodesErreur));
		}else {
			articleManager.ajouterArticle(nom, description, dateDebut, dateFin, prixInitial, noUtilisateur, noCategorie, etat);;
		}
	}
	private String lireParametreNom(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String nom;
		nom = request.getParameter("inputNom");
		if (nom==null || nom.trim().equals("")) {
			listeCodesErreur.add(CodesResultatServlets.NOM_ARTICLE_OBLIGATOIRE);
		}
		return nom;
	}
	private String lireParametreDescription(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String description;
		description = request.getParameter("inputDescription");
		if (description == null || description.trim().equals("")) {
			listeCodesErreur.add(CodesResultatServlets.DESCRIPTION_OBLIGATOIRE);
		}
		return description;
	}
	private int lireParametrePrixInitial(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String prixInitial = request.getParameter("inputPrixInitial");
		if (prixInitial == null || prixInitial.trim().equals("")) {
			listeCodesErreur.add(CodesResultatServlets.DESCRIPTION_OBLIGATOIRE);
			return 0;
		}else {
			return Integer.parseInt(request.getParameter("inputPrixInitial"));
		}
		
	}
}
