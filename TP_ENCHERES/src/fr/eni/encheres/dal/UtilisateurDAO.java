package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.exception.BusinessException;


public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws BusinessException;
	public Utilisateur selectById(int id);
	public Utilisateur selectByPseudo(String pseudo);
}
