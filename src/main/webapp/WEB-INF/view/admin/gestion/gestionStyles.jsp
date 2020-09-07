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
				<h1 class="h3 mb-2 text-gray-800">Styles</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Liste des Styles</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th><a href="trier?par=tA"></a>ID<a href="trier?par=tD"></a></th>
										<th><a href="trier?par=tD"></a>LIBELLE<a href="trier?par=tD"></a></th>
										<th>Modifier</th>
										<th>Supprimer</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${listeS}" var="style" varStatus="sStatus">
										<tr>
											<td>${style.idStyle}</td>
											<td>${style.libelle}</td>
											<td class="centre" title="Modifier"><a href="modifierStyle?index=s${style.idStyle}"><span class="modif fas fa-edit vert"></span></a></td>
											<td class="centre" title="Supprimer"><a href="supprimerStyle?index=s${style.idStyle}"><span class="supp far fa-trash-alt rouge"></span></a></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</div>
				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Ajouter un style</h6>
					</div>
					<div class="card-body">


						<form:form action="validStyle" method="POST" cssClass="form-horizontal" modelAttribute="style">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<form:label path="libelle"> Indiquer un libellé pour le nouveau style : </form:label>
									<form:input path="libelle" type="text" class="form-control form-control-user" placeholder="Nom du style..." />
									<form:errors path="libelle" cssClass="erreur" />
								</div>

							</div>

							<input type="submit" value="VALIDER" class="btn btn-primary btn-user " />

							<hr>

						</form:form>

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
