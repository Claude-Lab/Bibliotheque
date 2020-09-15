<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<a href="javascript:history.go(-1)" class="btn btn-primary"
					role="button" aria-pressed="true">Retour</a> <br> <br>
				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">
					Detail du livre "<b>${livre.titre}</b>"
				</h1>

				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4"></div>
				<!-- /.container-fluid -->

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard1" class="d-block card-header py-3"
						data-toggle="collapse" role="button" aria-expanded="true"
						aria-controls="collapseCard1">
						<h6 class="m-1 font-weight-bold text-primary">Details</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse show" id="collapseCard1">
						<div class="card-body">

							<h6>
								<i>Titre : </i><b>${livre.titre}</b>
							</h6>
							<h6>
								<i>Auteur(s) : </i><b><c:forEach var="listeAuteurs"
										items="${livre.auteurs}"> ${listeAuteurs}</c:forEach></b>
							</h6>

							<h6>
								<i>N° ISBN : </i><b>${livre.isbn}</b>
							</h6>
							<h6>
								<i>Editeur : </i><b><a
									href="detailsEditeur?index=s${livre.editeur.idEditeur}">${livre.editeur.nom}</a></b>
							</h6>
							<h6>
								<i>Bibliotheque : </i><b><a
									href="detailsBibliotheque?index=s${livre.bibliotheque.idBibliotheque}">${livre.bibliotheque.nom}</a></b>
							</h6>
							<h6>
								<i>Etat : </i><b>${livre.etat.libelle}</b>
							</h6>
							<h6>
								<i>Style(s) : </i>
								<c:forEach var="listeStyles" items="${livre.styles}"> - ${listeStyles}</c:forEach>
							</h6>
							<hr>
							<h5>Description</h5>
							<h6>
								<i>${livre.description}</i>
							</h6>
							<br>


						</div>
					</div>
				</div>

				<div class="card shadow mb-4"></div>

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Liste des emprunts en cours ou à venir</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<c:choose>
								<c:when test="${!empty listeEmprunt}">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th><a href="trier?par=tD"></a>EMPRUNTEURS<a
													href="trier?par=tD"></a></th>
												<th><a href="trier?par=tD"></a>Date du retrait<a
													href="trier?par=tD"></a></th>
												<th><a href="trier?par=tD"></a>Date du retour<a
													href="trier?par=tD"></a></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listeEmprunt}" var="listeEmprunt"
												varStatus="mStatus">
												<tr>
													<td><a href="detailsPersonne?index=s${listeEmprunt.personne.idPersonne}">${listeEmprunt.personne.prenom} ${listeEmprunt.personne.nom}</a></td>
													<td>${localDateTimeFormat.format(listeEmprunt.dateRetrait)}</td>
													<td>${localDateTimeFormat.format(listeEmprunt.dateRetour)}</td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:when>
								<c:when test="${empty listeEmprunt}">
									<h3 align= "center" style="color:red">il n'y a aucun emprunt en cours ou à venir.</h3>
								</c:when>
							</c:choose>
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
