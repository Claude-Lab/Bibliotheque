<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
					<h1 class="h3 mb-2 text-gray-800">Caution</h1>
					<p class="mb-4">
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Liste des Cautions</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th><a href="trier?par=tA"></a>ID<a href="trier?par=tD"></a></th>
											<th><a href="trier?par=vD"></a>Valeurs<a href="trier?par=vD"></a></th>
											<th><a href="trier?par=lD"></a>Nombre de livre(s)<a href="trier?par=lD"></a></th>
										</tr>
									</thead>
									
									<tbody>
										<c:forEach items="${listeC}" var="caution" varStatus="cStatus">
											<tr>
												<td>${caution.idCaution}</td>
												<td><b>${caution.valeur} €</b></td>
												<td><b>${caution.nbLivres} livre(s)</b></td>
							
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