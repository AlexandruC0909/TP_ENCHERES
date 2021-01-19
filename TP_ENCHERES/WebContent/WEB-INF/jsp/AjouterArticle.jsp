<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<body>
<div class="container py-5">
	<div class="row">
	
		<div class="col-md-4">
			<img alt="Bootstrap Image Preview" src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
		</div>
		<div class="col-md-8">
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
			<form method="post" action="${pageContext.request.contextPath}/ajouter/article">
				<div class="form-group">
					<label for="inputNom">Nom Article</label>
					<input type="text" class="form-control" id="inputNom" name="inputNom"/>
				</div>
				<div class="form-group">
    				<label for="inputDescription">Description</label>
   					<textarea class="form-control" id="inputDescription" rows="3" name="inputDescription"></textarea>
 				</div>
			  	<div class="form-group">
   					<label for="inputCategories">Categories</label>
    			 	<select class="form-control" id="inputCategories" name="inputCategories">
    			  		<option  value="1">Informatique</option>
     					<option  value="2">Ameublement</option>
   				   		<option  value="3">Vêtement</option>
   			   			<option  value="4">Sport&Loisirs</option>
    				</select>
  				</div>
  				<div class="form-group">
    				<label for="inputPrixDebut">Prix</label>
   					<input type="number" class="form-control" id="inputPrixDebut" name="inputPrixInitial"/>
 				</div>
 				<div class="form-group">
    				<label for="dateDepart">Debut:</label>
  					<input type="date" id="start" name="inputDateDebut" min="2020-01-01" max="2022-12-31" required> 		
  				</div>
  				<div class="form-group">
    				<label for="dateFin">Fin:</label>
  					<input type="date" id="start" name="inputDateFin" min="2020-01-01" max="2022-12-31" required> 		
  				</div>
  				<div class="form-group">
					<label for="inputPhoto">Image</label>
					<input type="file" class="form-control-file" id="exampleInputFile" />
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="ajouter"></input>
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/accueil">Annuler</a>
				</div>
 				
			</form>
		</div>
	</div>
</div>
</body>
</html>