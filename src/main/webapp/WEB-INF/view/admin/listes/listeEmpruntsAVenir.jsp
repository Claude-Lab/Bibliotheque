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
				<h1 class="h3 mb-2 text-gray-800">Emprunts à venir</h1>
				<p class="mb-4"></p>
				
				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Liste de tout les emprunts à venir</h6>
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
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${liste}" var="emprunt" varStatus="mStatus">
										<tr>
											<td>${emprunt.idEmprunt}</td>
											<td><a href="detailsLivre?index=s${emprunt.livre.idLivre}">${emprunt.livre.titre}</a></td>
											<td><a href="detailsPersonne?index=s${emprunt.personne.idPersonne}">${emprunt.personne.prenom} ${emprunt.personne.nom}</a></td>
											<td>${localDateTimeFormat.format(emprunt.dateRetrait)}</td>
											<td>${localDateTimeFormat.format(emprunt.dateRetour)}</td>

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
