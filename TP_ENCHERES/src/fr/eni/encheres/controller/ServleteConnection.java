package fr.eni.encheres.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class ServleteConnection
 */
@WebServlet("/connection")
public class ServleteConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleteConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Connection.jsp");
		String pseudo = null;
		String motDePasse = null;
		Utilisateur utilisateur = new Utilisateur();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		pseudo = request.getParameter("inputPseudo");
		motDePasse = request.getParameter("inputMotDePasse");
		utilisateur = utilisateurManager.selectUtilisateurByPseudo(pseudo);
		System.out.println(utilisateur.toString());
		if (utilisateur.getMotDePasse().equals(motDePasse)) {
			request.setAttribute("statut", "succes");
		}else {
			request.setAttribute("statut", "fail");
		}
		rd.forward(request, response);
	}

}
