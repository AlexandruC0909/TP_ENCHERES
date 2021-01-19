	package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exception.BusinessException;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public void ajouterUtilisateur(String pseudo,String nom,String prenom,String email,
			String telephone,String rue,String codePostal,String ville,String motDePasse) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,100,false);
		BusinessException businessException = new BusinessException();
		if (!businessException.hasErreurs()) {
			this.utilisateurDAO.insert(utilisateur);
		}
	}
	public Utilisateur selectUtilisateurById(int id) {
		return this.utilisateurDAO.selectById(id);
	}
	public Utilisateur selectUtilisateurByPseudo(String pseudo) {
		return this.utilisateurDAO.selectByPseudo(pseudo);
	}
}
