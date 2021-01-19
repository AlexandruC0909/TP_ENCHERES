package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.exception.*;


public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String INSERT_UTILISATEUR = "insert into UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_BY_ID = "select * from UTILISATEURS where no_utilisateur = ?; ";
	private static final String SELECT_BY_PSEUDO = "select * from UTILISATEURS where pseudo = ?;";
	
	
	@Override
	public void insert(Utilisateur utilisateur)  {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, 50);
			pstmt.setBoolean(11, false);
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
		
		}
		
	}
	@Override
	public Utilisateur selectById(int id) {
		Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				utilisateur = utilisateurBuilder(rs);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utilisateur;	
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pstmt.setString(1, pseudo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				utilisateur = utilisateurBuilder(rs);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return utilisateur;	
	}
	
	private Utilisateur utilisateurBuilder(ResultSet rs) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
		utilisateur.setPseudo(rs.getString("pseudo"));
		utilisateur.setNom(rs.getString("nom"));
		utilisateur.setPrenom(rs.getString("prenom"));
		utilisateur.setEmail(rs.getString("email"));
		utilisateur.setTelephone(rs.getString("telephone"));
		utilisateur.setRue(rs.getString("rue"));
		utilisateur.setCodePostal(rs.getString("code_postal"));
		utilisateur.setVille(rs.getString("ville"));
		utilisateur.setCredit(rs.getInt("credit"));
		utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
		return utilisateur;	
	}
	


}
