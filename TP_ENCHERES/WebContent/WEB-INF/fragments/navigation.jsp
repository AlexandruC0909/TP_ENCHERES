<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<div class="container fy">
	<div class="row">
		<div class="col-md-12">
			<ul class="nav nav-tabs justify-content">
				<li class="nav-item ">
					<a class="nav-link " href="<%=request.getContextPath()%>/accueil">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link " href="<%=request.getContextPath()%>/connection">Se Connecter</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/ajouter/utilisateur">Inscription</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<%=request.getContextPath()%>/ajouter/article">Ajouter Article</a>
				</li>
			</ul>
		</div>
	</div>
</div>
</html>