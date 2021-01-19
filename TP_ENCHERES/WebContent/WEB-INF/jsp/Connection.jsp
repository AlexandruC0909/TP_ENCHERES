<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/fragments/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/fragments/navigation.jsp"></jsp:include>	
<body>
<%String msg = String.valueOf(request.getAttribute("statut")); %>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Connection</h5>
            <h5> <%=msg %></h5>
            <form method="post" action="${pageContext.request.contextPath}/connection">
              <div class="form-label-group">
            	<label for="inputPseudo">Pseudo</label>
                <input type="text" id="inputEmail" class="form-control" placeholder="Pseudo" name="inputPseudo" required autofocus>
                
              </div>

              <div class="form-label-group">
              	<label for="inputMotDePasse">Mot de pass</label>
                <input type="password" id="inputMotDePasse" class="form-control" placeholder="Mot de Passe" name="inputMotDePasse" required> 
              </div>

              <div class="form-label-group">
                <input type="checkbox" id="memoriser" name="memoriser">
  				<label for="memoriser">Se souvenir</label>            
  			  </div>
              <div class="form-group">
					<input type="submit" class="btn btn-primary " value="Connection"></input>
				
					<a class="btn btn-primary" href="<%=request.getContextPath()%>/ajouter/utilisateur">Créer un compte</a>
 				
				</div>
              	
              
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>