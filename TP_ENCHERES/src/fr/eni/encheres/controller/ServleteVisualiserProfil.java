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
 * Servlet implementation class ServleteVisualiserProfil
 */
@WebServlet("/profil")
public class ServleteVisualiserProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleteVisualiserProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = new Utilisateur();
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/VisualiserProfil.jsp");
		
		int noUtilisateur = 0;
		noUtilisateur = Integer.parseInt(request.getParameter("utilisateur"));
		utilisateur = utilisateurManager.selectUtilisateurById(noUtilisateur);
		
		request.setAttribute("utilisateur", utilisateur);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
