package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;


public class ArticleDAOJdbcImpl implements ArticleDAO{
	private static final String INSERT_ARTICLE = "insert into ARTICLES_VENDUS(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial,"
			+ "no_utilisateur,no_categorie,etat_vente) values(?,?,?,?,?,?,?,?)";
	private static final String SELECT_ALL = "select * from ARTICLES_VENDUS ";
	private static final String SELECT_BY_CATEGORIE = "select * from ARTICLES_VENDUS where no_categorie=?; ";
	private static final String SELECT_BY_NAME = "SELECT * FROM ARTICLES_VENDUS WHERE nom_article LIKE ?;";
	private static final String SELECT_NOM_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie=? AND nom_article LIKE ?;";
	
	@Override
	public void insert(Article article) {
		Connection cnx;
		try {
			cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setObject(3, article.getDateDebut());
			pstmt.setObject(4, article.getDateFin());
			pstmt.setInt(5, article.getPrixInitial());
			pstmt.setInt(6, 5);
			pstmt.setInt(7, article.getNo_categorie());
			pstmt.setString(8, "ec");
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next())
			{
				article.setNoArticle(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public List<Article> selectAll(){
		List<Article> articles = new ArrayList<Article>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				articles.add(articleBuilder(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	@Override
	public List<Article> selectByCategory(int noCategorie){
		List<Article> articles = new ArrayList<Article>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
			pstmt.setInt(1, noCategorie);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				articles.add(articleBuilder(rs));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	
	@Override
	public List<Article> selectNomCategorie(int noCategorie,String nomArticle){
		List<Article> articles = new ArrayList<Article>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(SELECT_NOM_CATEGORIE);
			pstmt.setInt(1, noCategorie);
			pstmt.setString(2, nomArticle + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				articles.add(articleBuilder(rs));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	public List<Article> selectByName(String nomArticle){
		List<Article> articles = new ArrayList<Article>();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt;
			ResultSet rs;
			pstmt = cnx.prepareStatement(SELECT_BY_NAME);
			pstmt.setString(1, nomArticle + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				articles.add(articleBuilder(rs));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
	
	
	private Article articleBuilder(ResultSet rs) throws SQLException {
		Article article = new Article();
		article.setNoArticle(rs.getInt("no_article"));
		article.setNom(rs.getString("nom_article"));
		article.setDescription(rs.getString("description"));
		article.setDateDebut(rs.getDate("date_debut_enchere").toLocalDate());
		article.setDateFin(rs.getDate("date_fin_enchere").toLocalDate());
		article.setPrixInitial(rs.getInt("prix_initial"));
		article.setPrixVente(rs.getInt("prix_vente"));
		article.setNo_utilisateur(rs.getInt("no_utilisateur"));
		article.setNo_categorie(rs.getInt("no_categorie"));
		article.setEtat(rs.getString("etat_vente"));
		return article;
	}
		
		

}
