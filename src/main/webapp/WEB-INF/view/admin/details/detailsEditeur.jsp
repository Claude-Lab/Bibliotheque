<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.html"%>


<body id="page-top">

	<%@include file="../includes/sidebarAdmin.html"%>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">

			<!-- Topbar -->
			<%@include file="../includes/topbar.jsp"%>
			<!-- Begin Page Content -->
			<div class="container-fluid">
				<a href="javascript:history.go(-1)" class="btn btn-primary" role="button" aria-pressed="true">Retour</a> <br>
				<br>
				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Fiche de l'editeur "${editeur.nom}"</h1>

				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4"></div>
				<!-- /.container-fluid -->

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard1" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCard1">
						<h6 class="m-1 font-weight-bold text-primary">Detail de l'éditeur</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse show" id="collapseCard1">
						<div class="card-body">
							<h4>Identité</h4>
							<h6>Nom : ${editeur.nom}</h6>
							<br>
							<h4>Adresse</h4>
							<h6>${editeur.coordonnee.rue}</h6>
							<h6>${editeur.coordonnee.cp}</h6>
							<h6>${editeur.coordonnee.ville}</h6>
							<h6><span class="fas fa-phone-alt"></span>    ${editeur.coordonnee.fixe}</h6>
							<h6><span class="fas fa-at"></span>  <a href="mailto:${editeur.coordonnee.email}">  ${editeur.coordonnee.email}</a></h6>
							<br>
							<h4>Livres de l'editeur : </h4>
<%-- 							<h6>${editeur.nbLivres}</h6> --%>

						</div>
					</div>
				</div>

				<div class="card shadow mb-4"></div>

				


			</div>
		</div>
		<!-- End of Main Content -->

		<!-- Footer -->
		<%@include file="../includes/footer.html"%>
</body>

</html>
