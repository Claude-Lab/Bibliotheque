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
				<a href="javascript:history.go(-1)" class="btn btn-success"
					role="button" aria-pressed="true">Retour</a> <br> <br>
				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Compte de ${pers.prenom}
					${pers.nom}</h1>

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
						<h6 class="m-1 font-weight-bold text-primary">Detail du
							compte Salarié</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="collapse show" id="collapseCard1">
						<div class="card-body">
							<h4>Identité</h4>
							<h6>Nom : ${pers.nom}</h6>
							<h6>Prenom : ${pers.prenom}</h6>
							<h6>Login : ${pers.username}</h6>
							<h6>Date d'inscription :
								${localDateTimeFormat.format(pers.dateInscription)}</h6>
							<br>
							<h4>Coordonnées</h4>
							<h6>${pers.coordonnee.rue}</h6>
							<h6>${pers.coordonnee.cp}</h6>
							<h6>${pers.coordonnee.ville}</h6>
							<h6>
								<span class="fas fa-mobile-alt"></span>
								${pers.coordonnee.mobile}
							</h6>
							<h6>
								<span class="fas fa-phone-alt"></span> ${pers.coordonnee.fixe}
							</h6>
							<h6>
								<span class="fas fa-at"></span> <a
									href="mailto:${pers.coordonnee.email}">
									${pers.coordonnee.email}</a>
							</h6>
							<br>
							<h4>Caution versée</h4>
							<h6>${pers.caution.valeur}€</h6>
							<h6>Capacité d'emprunt : ${pers.caution.nbLivres} livre(s)</h6>
							<br>
							
							

						</div>
					</div>
				</div>

				<div class="card shadow mb-4"></div>

				<!-- Collapsable Card Example -->
				<div class="card shadow mb-10">
					<!-- Card Header - Accordion -->
					<a href="#collapseCard2" class="d-block card-header py-3"
						data-toggle="collapse" role="button" aria-expanded="true"
						aria-controls="collapseCard2">
						<h6 class="m-1 font-weight-bold text-primary">Emprunts du
							compte</h6>
					</a>
					<!-- Card Content - Collapse -->
					<div class="card-body">
						<div class="table-responsive">
							<c:choose>
								<c:when test="${!empty listeEmprunt}">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th><a href="trier?par=tD"></a>Livres<a
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
													<td><a
														href="detailsLivre?index=s${listeEmprunt.livre.idLivre}">${listeEmprunt.livre.titre}</a></td>
													<td>${localDateFormat.format(listeEmprunt.dateRetrait)}</td>
													<td>${localDateFormat.format(listeEmprunt.dateRetour)}</td>

												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:when>
								<c:when test="${empty listeEmprunt}">
									<h3 align="center" style="color: red">il n'y a aucun
										emprunt en cours ou à venir.</h3>
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
