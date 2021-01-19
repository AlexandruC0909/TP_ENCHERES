<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<body>
<div class="container py-5">
    <div class="row">
        <div class="col-md-10 mx-auto">
        <c:if test="${!empty listeMessagesErreur}">
			<div class="alert alert-danger" role="alert">
			  <strong>Erreur!</strong>
			  <ul>
			  	<c:forEach var="message" items="${listeMessagesErreur}">
			  		<li>${message}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
            <form method="post" action="${pageContext.request.contextPath}/ajouter/utilisateur" >
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputPseudo">Pseudo</label>
                        <input type="text" class="form-control" id="inputPseudo" name ="inputPseudo" placeholder="Pseudo">
                    </div>
                    <div class="col-sm-6">
                        <label for="inputNom">Nom</label>
                        <input type="text" class="form-control" id="inputNom" name ="inputNom" placeholder="nom">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputPrenom">Prenom</label>
                        <input type="text" class="form-control" id="inputPrenom" name ="inputPrenom" placeholder="Prenom">
                    </div>
                    <div class="col-sm-6">
                        <label for="inputAddressLine2">Email</label>
                        <input type="email" class="form-control" id="inputEmail" name ="inputEmail" placeholder="Email">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputTel">Teléphone</label>
                        <input type="number" class="form-control" id="inputTel" name ="inputTel" placeholder="Teléphone">
                    </div>
                    <div class="col-sm-6">
                        <label for="inputRue">Rue</label>
                        <input type="text" class="form-control" id="inputRue" name ="inputRue" placeholder="Rue">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputCodePostal">Cod postal</label>
                        <input type="number" class="form-control" id="inputCodePostal" name ="inputCodePostal"placeholder="Cod Postal">
                    </div>
                    <div class="col-sm-6">
                        <label for="inputVille">Ville</label>
                        <input type="text" class="form-control" id="inputVille" name ="inputVille" placeholder="Ville">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="inputMotDePasse">Mot de Passe</label>
                        <input type="text" class="form-control" id="inputMotDePasse" name ="inputMotDePasse"placeholder="Mot de passe">
                    </div>
                    <div class="col-sm-6">
                        <label for="inputMotDePasse">Confirmation Mot de Passe</label>
                        <input type="text" class="form-control" id="inputMotDePasse" name ="inputMotDePasseConfirmation"placeholder="Confirmation Mot de passe">
                    </div>
                    
                </div>
                <div class="row">
                <div class="col-sm-6">
                 	<input type="submit" class="btn btn-primary"></input>
						<a  class="btn btn-primary" href="<%=request.getContextPath()%>/accueil">Annuler</a>
 					</div>
                </div>
               
                
            </form>
            
        </div>
    </div>
</div>
</body>
</html>