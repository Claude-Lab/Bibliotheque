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

				<!-- Page Heading -->
				<h1 class="h3 mb-2 text-gray-800">Emprunt</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">



					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter un emprunt</h6>
						</div>
						<div class="card-body">


							<form:form action="validEmprunt" method="POST"
								cssClass="form-horizontal" modelAttribute="emprunt">


								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="dateRetrait"> Date Retrait : </form:label>
										<form:input path="dateRetrait" type="date"
											title="chiffre et signe spéciaux interdit"
											class="form-control form-control-user" placeholder="Date Retrait"
											required="required"></form:input>
										<form:errors path="dateRetrait" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="dateRetour"> Date Retour : </form:label>
										<form:input path="dateRetour" type="date"
											class="form-control form-control-user" placeholder="Nom"
											required="required"></form:input>
										<form:errors path="dateRetour" cssClass="erreur"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="livre.idLivre"
											cssClass="col-xs-2 control-label">Livre :</form:label>
										<div class="col-xs-10">
											<form:select path="livre.idLivre" cssClass="form-control"
												required="required">
												<option value="" title="Veuillez choisir le livre">--
													LIVRE --</option>
												<form:options items="${listeLivres}" itemValue="idLivre"
													itemLabel="titre" />
											</form:select>
										</div>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="personne.idPersonne"
											cssClass="col-xs-2 control-label">Personne :</form:label>
										<div class="col-xs-10">
											<form:select path="personne.idPersonne" cssClass="form-control"
												required="required">
												<option value="" title="Veuillez choisir l'emprunteur">--
													PERSONNE --</option>
												<form:options items="${listePersonnes}" itemValue="idPersonne"
													itemLabel="fullName" />
											</form:select>
										</div>
									</div>

								</div>

								<input type="submit" value="VALIDER"
									class="btn btn-primary btn-user " />
								<a href="gestionEmprunts" class="btn btn-secondary"
									role="button" aria-pressed="true">ANNULER</a>
								<br>

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
