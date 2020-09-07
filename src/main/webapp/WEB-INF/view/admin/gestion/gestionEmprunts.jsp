<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<%@include file="../includes/header.html"%>
<%@include file="../includes/taglibs.jsp"%>



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

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Emprunts</h1>
				<p class="mb-4"></p>
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<a href="ajoutEmprunt" class="btn btn-warning"  role="button" aria-pressed="true">Ajouter un emprunt</a>
					</div>
				</div>
				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Liste de tout les emprunts</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th><a href="trier?par=iA"></a>ID<a href="trier?par=iD"></a></th>
										<th><a href="trier?par=tD"></a>LIVRES<a href="trier?par=tD"></a></th>
										<th><a href="trier?par=tD"></a>EMPRUNTEURS<a href="trier?par=tD"></a></th>
										<th><a href="trier?par=tD"></a>Date du retrait<a href="trier?par=tD"></a></th>
										<th><a href="trier?par=tD"></a>Date du retour<a href="trier?par=tD"></a></th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${liste}" var="emprunt" varStatus="mStatus">
										<tr>
											<td>${emprunt.idEmprunt}</td>
											<td>${emprunt.livre.titre}</td>
											<td>${emprunt.personne.prenom} ${emprunt.personne.nom}</td>
											<td>${dateRetrait}</td>
											<td>${dateRetour}</td>
											<td class="centre" title="Details"><a href="detailsEmprunt?index=s${emprunt.idEmprunt}"><span class="detail fas fa-binoculars"></span></a></td>
											<td class="centre" title="Modifier"><a href="modifierEmprunt?index=s${emprunt.idEmprunt}"><span class="modif fas fa-edit vert"></span></a></td>
											<td class="centre" title="Supprimer"><a href="supprimerEmprunt?index=s${emprunt.idEmprunt}"><span class="supp far fa-trash-alt rouge"></span></a></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Main Content -->

		<!-- Footer -->
		<%@include file="../includes/footer.html"%>
</body>

</html>
