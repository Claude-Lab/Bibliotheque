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
				<h1 class="h3 mb-2 text-gray-800">Bibliothèque</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">



					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter une bibliothèque</h6>
						</div>
						<div class="card-body">


							<form:form action="validBibliotheque" method="POST" cssClass="form-horizontal" modelAttribute="bibliotheque" >
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="nom"> Nom : </form:label>
										<form:input path="nom" type="text" pattern="[-[:alpha:] ]{2,30}" class="form-control form-control-user" placeholder="Nom" required="required"></form:input>
										<form:errors path="nom" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.email"> eMail : </form:label>
										<form:input path="coordonnee.email" type="email" class="form-control form-control-user" placeholder="eMail" required="required"></form:input>
										<form:errors path="coordonnee.email" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.rue"> Adresse (n°, rue, etc.) : </form:label>
										<form:input path="coordonnee.rue" type="text" pattern="[-[:alpha:][:digit:] ]{2,35}" title="carractères spéciaux interdits" class="form-control form-control-user" placeholder="Adresse" required="required"></form:input>
										<form:errors path="coordonnee.rue" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.cp"> Code postal : </form:label>
										<form:input path="coordonnee.cp" type="text" pattern="[0-9]{5}" class="form-control form-control-user" title="5 chiffres" placeholder="Code postal" required="required"></form:input>
										<form:errors path="coordonnee.cp" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.ville"> Ville : </form:label>
										<form:input path="coordonnee.ville" type="text" pattern="[-[:alpha:] ]{2,40}" title="chiffre et signe spéciaux interdit" class="form-control form-control-user" placeholder="Ville" required="required"></form:input>
										<form:errors path="coordonnee.ville" cssClass="erreur"></form:errors>
									</div>
								</div>

								
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.fixe"> Téléphone Fixe : </form:label>
										<form:input path="coordonnee.fixe" type="text" pattern="[0-9]{10}" title="10 chiffres" class="form-control form-control-user" placeholder="Téléphone Fixe"></form:input>
										<form:errors path="coordonnee.fixe" cssClass="erreur"></form:errors>
									</div>
								</div>
						

								<input type="submit" value="VALIDER" class="btn btn-primary btn-user " />
								<a href="gestionBibliotheques" class="btn btn-secondary" role="button" aria-pressed="true">ANNULER</a> <br>

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
