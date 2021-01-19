<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.encheres.bo.Article"%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>	
		
<div class="container fy">
	<div class="row mt-5">
		<div class="col-md-12">
			<h3 class="text-center">
				Liste des enchères
			</h3>
		</div>
	</div>
		<div class="row mt-5">
        <div class="col-md-12">
            <form method="post" action="${pageContext.request.contextPath}/rechercher" >
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputNom">Nom Article</label>
                        <input type="text" class="form-control" id="inputNom" name ="inputNom" placeholder="Nom Article">
                    </div>
                    <div class="col-sm-6 text-center">
                        <input type="submit" class="btn btn-primary btn-large" value="Rechercher"></input>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputCategories">Categories</label>
    			 		<select class="form-control" id="inputCategories" name="inputCategories">
    			 			<option  value="0"> -- Selectione une categorie -- </option>
    			  			<option  value="1">Informatique</option>
     						<option  value="2">Ameublement</option>
   				   			<option  value="3">Vêtement</option>
   			   				<option  value="4">Sport&Loisirs</option>
    					</select>
                    </div>
                </div>   
            </form>  
        </div>
    </div>
	<%
		List<Article> listeArticles = (List<Article>) request.getAttribute("listeArticles");
		if(listeArticles!=null && listeArticles.size()>0)
			{
	%>
	
	<div class="row mt-2">
	<%
		for(Article article : listeArticles)
			{
		%>
			<div class="col-lg-3 col-md-4 col-sm-6 ">
				<div class="card  mt-5">
					<h5 class="card-header">
							<%=article.getNom()%>
					</h5>
												
					<div class="card-body">
						<p class="card-text">
							Prix :<%=article.getPrixInitial()%>
						</p>
						<p class="card-text">
							Fin de la enchère :<%=article.getDateFin()%>
						</p>
					</div>				
					<div class="card-footer">
					<form action="<%=request.getContextPath()%>/profil" method="get">
					<div class="form-group " style="display:flex;">
    						<input type="hidden" name="utilisateur" value="<%=article.getUtilisateur().getNoUtilisateur()%>" />
  							<p>Vendu par:</p>
  							
  							<input type="submit"  value="<%=article.getUtilisateur().getPseudo()%>">
  							
  							
					</div>
  						
					</form>	
					</div>				
				</div>					
			</div>				
		<%
		}	
		%>
	</div>
	<%
	}
	else
	{
	%>
		<p>Il n'y a aucun article à afficher<P>
	<%
	}
	%>
	
</div>

</body>
</html>