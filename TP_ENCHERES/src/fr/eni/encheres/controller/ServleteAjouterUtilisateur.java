package fr.eni.encheres.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exception.BusinessException;
import fr.eni.encheres.tools.Tools;



/**
 * Servlet implementation class ServleteNewProfile
 */
@WebServlet("/ajouter/utilisateur")
public class ServleteAjouterUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServleteAjouterUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/CreationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajouterUtilisateur(request, response);
		doGet(request, response);
		
	}
	private void ajouterUtilisateur(HttpServletRequest request, HttpServletResponse response) {
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String codePostal = null;
		String ville = null;
		String motDePasse = null;
		
		List<Integer> listeCodesErreur=new ArrayList<>();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		pseudo =lireParametrePseudo(request, listeCodesErreur);
		nom = lireParametreNom(request, listeCodesErreur);
		prenom =lireParametrePrenom(request, listeCodesErreur);
		email = lireParametreEmail(request, listeCodesErreur);
		telephone = lireParametreTel(request, listeCodesErreur);
		rue = lireParametreRue(request, listeCodesErreur);
		codePostal = lireParametreCodePostal(request, listeCodesErreur);
		ville = lireParametreVille(request, listeCodesErreur);
		motDePasse = lireParametreMotDePasse(request, listeCodesErreur);
		
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeMessagesErreur",Tools.getMessages(listeCodesErreur));
		}else {
			try {
				utilisateurManager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("listeMessagesErreur", Tools.getMessages(listeCodesErreur));
			}
		}
	}
	private String lireParametrePseudo(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String pseudo;
		pseudo = request.getParameter("inputPseudo");
		if(pseudo==null || pseudo.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.PSEUDO_OBLIGATOIRE);
		}
		return pseudo;
	}
	
	private String lireParametreNom(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String nom;
		nom = request.getParameter("inputNom");
		if(nom==null || nom.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.NOM_OBLIGATOIRE);
		}
		return nom;
	}
	private String lireParametrePrenom(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String prenom;
		prenom = request.getParameter("inputPrenom");
		if(prenom==null || prenom.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.PRENOM_OBLIGATOIRE);
		}
		return prenom;
	}
	private String lireParametreEmail(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String email;
		email = request.getParameter("inputEmail");
		if(email==null || email.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.EMAIL_OBLIGATOIRE);
		}
		return email;
	}
	private String lireParametreTel(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String telephone;
		telephone = request.getParameter("inputTel");
		if(telephone==null || telephone.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.TEL_OBLIGATOIRE);
		}
		return telephone;
	}
	private String lireParametreRue(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String rue;
		rue = request.getParameter("inputRue");
		if(rue==null || rue.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.RUE_OBLIGATOIRE);
		}
		return rue;
	}
	private String lireParametreCodePostal(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String codePostal;
		codePostal = request.getParameter("inputCodePostal");
		if(codePostal==null || codePostal.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.CODE_POSTAL_OBLIGATOIRE);
		}
		return codePostal;
	}
	private String lireParametreVille(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String ville;
		ville = request.getParameter("inputVille");
		if(ville==null || ville.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.VILLE_OBLIGATOIRE);
		}
		return ville;
	}
	private String lireParametreMotDePasse(HttpServletRequest request, List<Integer> listeCodesErreur) {
		String motDePasse;
		String motDePasseConfirmation;
		motDePasse = request.getParameter("inputMotDePasse");
		motDePasseConfirmation = request.getParameter("inputMotDePasseConfirmation");
		if (!motDePasse.equals(motDePasseConfirmation)) {
			listeCodesErreur.add(CodesResultatServlets.MOT_DE_PASSE_IDENTIQUE);
		}
		if(motDePasse==null || motDePasse.trim().equals("") || motDePasseConfirmation == null || motDePasseConfirmation.trim().equals(""))
		{
			listeCodesErreur.add(CodesResultatServlets.MOT_DE_PASSE_OBLIGATOIRE);
		}
		return motDePasse;
	}
}
