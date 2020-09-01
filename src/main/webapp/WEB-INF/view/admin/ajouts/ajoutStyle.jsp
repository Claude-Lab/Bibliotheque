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

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">styles</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">



					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter un style</h6>
						</div>
						<div class="card-body">


							<form:form action="validStyle" method="POST" cssClass="form-horizontal" modelAttribute="style">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="libelle"> Indiquer un libellé pour le nouveau style : </form:label>
										<form:input path="libelle" type="text" pattern="[a-zA-Z]{2,25}" class="form-control form-control-user" placeholder="Nom du style..." title="Espaces et signes spéciaux interdit"></form:input>
										<form:errors path="libelle" cssClass="erreur"></form:errors>
									</div>

								</div>

								<input type="submit" value="VALIDER" class="btn btn-primary btn-user " />

								<hr>

							</form:form>
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
