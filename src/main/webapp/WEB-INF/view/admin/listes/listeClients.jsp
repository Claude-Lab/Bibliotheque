<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<%@include file="../includes/header.html"%>
<%@include file="../includes/taglibs.jsp"%>



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

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Clients</h1>
				<p class="mb-4"></p>
				<div class="card shadow mb-4">
					
				</div>
				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Liste des client.e.s</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th><a href="trier?par=nD"></a>NOM<a href="trier?par=nD"></a></th>
										<th><a href="trier?par=pD"></a>PRENOM<a href="trier?par=pD"></a></th>
										<th>DETAILS</th>
										<th>MODIFIER</th>
										
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listeP}" var="pers" varStatus="pStatus">
										<tr>
											<td>${pers.nom}</td>
											<td>${pers.prenom}</td>
											<td class="centre"><a href="detailsClient?index=s${pers.idPersonne}"><span class="detail fas fa-binoculars"></span></a></td>
											<td class="centre"><a href="modifierClient?index=s${pers.idPersonne}"><span class="modif fas fa-edit vert"></span></a></td>

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
