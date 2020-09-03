<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<%@include file="../includes/taglibs.jsp"%>
<%@include file="../includes/header.html"%>


<body id="page-top">

	<%@include file="../includes/sidebar.html"%>
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
				<h1 class="h3 mb-2 text-gray-800">Detail du livre "<b>${livre.titre}</b>"</h1>

				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4"></div>
				<!-- /.container-fluid -->

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard1" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCard1">
						<h6 class="m-1 font-weight-bold text-primary">Details</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse show" id="collapseCard1">
						<div class="card-body">
							
							<h6><i>Titre : </i><b>${livre.titre}</b></h6>
							<h6><i>Auteur(s) : </i><b><c:forEach var="listeAuteurs" items="${livre.auteurs}"> ${listeAuteurs}</c:forEach></b></h6>
							
							<h6><i>N° ISBN : </i><b>${livre.isbn}</b></h6>
							<h6><i>Editeur : </i><b><a href="detailsEditeur?index=s${livre.editeur.idEditeur}">${livre.editeur.nom}</a></b></h6>
							<h6><i>Bibliotheque : </i><b><a href="detailsBibliotheque?index=s${livre.bibliotheque.idBibliotheque}">${livre.bibliotheque.nom}</a></b></h6>
							<h6><i>Etat : </i><b>${livre.etat.libelle}</b></h6>
							<h6><i>Style(s) : </i><c:forEach var="listeStyles" items="${livre.styles}"> - ${listeStyles}</c:forEach></h6>
							<hr>
							<h5>Description</h5>
							<h6><i>${livre.description}</i></h6>
							<br>
							

						</div>
					</div>
				</div>

				<div class="card shadow mb-4"></div>

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard2" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCard2">
						<h6 class="m-1 font-weight-bold text-primary">Emprunts du livre en cours et à venir</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse show" id="collapseCard2">
						<div class="card-body">
							<h4></h4>
							<h6></h6>
							<h6></h6>
							<h6></h6>

						</div>
					</div>
				</div>


			</div>
		</div>
		<!-- End of Main Content -->

		<!-- Footer -->
		<%@include file="../includes/footer.html"%>
</body>

</html>
