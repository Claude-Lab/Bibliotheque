<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Cautions</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">



					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter une caution</h6>
						</div>
						<div class="card-body">


							<form:form action="validCaution" method="POST" cssClass="form-horizontal" modelAttribute="caution">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="valeur"> Indiquez la valeur de la nouvelle caution : </form:label>
										<form:input path="valeur" type="number" pattern="[0-9]{5}" class="form-control form-control-user" placeholder="Valeur"></form:input>
										<form:errors path="valeur" cssClass="erreur"></form:errors>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="nbLivres"> Indiquez le nombre de livres pouvant être empruntés : </form:label>
										<form:input path="nbLivres" type="number" pattern="[0-9]{5}" class="form-control form-control-user" placeholder="Nombre de livre"></form:input>
										<form:errors path="nbLivres" cssClass="erreur"></form:errors>
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
