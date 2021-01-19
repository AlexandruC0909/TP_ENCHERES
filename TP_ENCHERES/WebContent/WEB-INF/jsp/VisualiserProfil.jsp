<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<body>
<div class="container py-5">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <form method="post" class="form-horizontal" action="${pageContext.request.contextPath}/ajouter/utilisateur" >
            <%
				Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
		
			%>
                
            	
                     <label for="inputPseudo">Pseudo</label>
                    
                        <input type="text" class="form-control" id="inputPseudo" name ="inputPseudo" placeholder="<%=utilisateur.getPseudo()%>">
                 
             
                     <label for="inputPseudo">Nom</label>
                    
                     <input type="text" class="form-control" id="inputNom" name ="inputNom" value = "<%=utilisateur.getNom()%>">
           
              
               
                        <label for="inputPrenom">Prenom</label>
                        <input type="text" class="form-control" id="inputPrenom" name ="inputPrenom" value = "<%=utilisateur.getPrenom()%>">
                 
                        <label for="inputAddressLine2">Email</label>
                        <input type="email" class="form-control" id="inputEmail" name ="inputEmail" value = "<%=utilisateur.getEmail()%>">
                   
              
                        <label for="inputTel">Teléphone</label>
                        <input type="number" class="form-control" id="inputTel" name ="inputTel" value = "<%=utilisateur.getTelephone()%>">
                    
            
                        <label for="inputRue">Rue</label>
                        <input type="text" class="form-control" id="inputRue" name ="inputRue" value = "<%=utilisateur.getRue()%>">
  
                        <label for="inputCodePostal">Cod postal</label>
                        <input type="number" class="form-control" id="inputCodePostal" name ="inputCodePostal" value = "<%=utilisateur.getCodePostal()%>">
               
         
                        <label for="inputVille">Ville</label>
                        <input type="text" class="form-control" id="inputVille" name ="inputVille" value = "<%=utilisateur.getVille()%>">
                     
 
						<a class="btn btn-primary mt-5" href="<%=request.getContextPath()%>/accueil">Revenir</a>

           
            </form>
            
        </div>
    </div>
</div>
</body>
</html>