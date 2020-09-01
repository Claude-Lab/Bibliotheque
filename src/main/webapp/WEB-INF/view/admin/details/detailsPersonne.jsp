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
				<a href="gestionPersonnes" class="btn btn-primary" role="button" aria-pressed="true">Retour à la gestion des comptes</a> <br>
				<br>
				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Compte de ${pers.prenom} ${pers.nom}</h1>

				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4"></div>
				<!-- /.container-fluid -->

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard1" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCard1">
						<h6 class="m-1 font-weight-bold text-primary">Detail du compte</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse show" id="collapseCard1">
						<div class="card-body">
							<h4>Identité</h4>
							<h6>Nom : ${pers.nom}</h6>
							<h6>Prenom : ${pers.prenom}</h6>
							<h6>Login : ${pers.username}</h6>
							<h6>Date d'inscription : ${pers.dateInscription}</h6>
							<br>
							<h4>Coordonnées</h4>
							<h6>${pers.coordonnee.rue}</h6>
							<h6>${pers.coordonnee.cp}</h6>
							<h6>${pers.coordonnee.ville}</h6>
							<h6><span class="fas fa-mobile-alt"></span>    ${pers.coordonnee.mobile}</h6>
							<h6><span class="fas fa-phone-alt"></span>    ${pers.coordonnee.fixe}</h6>
							<h6><span class="fas fa-at"></span>  <a href="mailto:${pers.coordonnee.email}">  ${pers.coordonnee.email}</a></h6>
							<br>
							<h4>Caution versée</h4>
							<h6>${pers.caution.valeur}€</h6>
							<h6>Capacité d'emprunt : ${pers.caution.nbLivres} livre(s)</h6>
							<br>
							<h4>Role de l'entité</h4>
							<h6>${pers.role.libelle}</h6>

						</div>
					</div>
				</div>

				<div class="card shadow mb-4"></div>

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard2" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCard2">
						<h6 class="m-1 font-weight-bold text-primary">Emprunts du compte</h6>
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
