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
				<h1 class="h3 mb-2 text-gray-800">Auteurs</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">Liste des auteurs</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
								<thead>
									<tr>
										<th><a href="trier?par=iA"></a>ID<a href="trier?par=iD"></a></th>
										<th><a href="trier?par=nD"></a>AUTEURS<a href="trier?par=nD"></a></th>
										<th></th>
										<th></th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${liste}" var="auteur" varStatus="aStatus">
										<tr>
											<td>${auteur.idAuteur}</td>
											<td>${auteur.prenomNom}</td>
											<td class="centre" title="Modifier"><a href="modifierAuteur?index=s${auteur.idAuteur}"><span class="modif fas fa-edit vert"></span></a></td>
											<td class="centre" title="Supprimer"><a href="supprimerAuteur?index=s${auteur.idAuteur}"><span class="supp far fa-trash-alt rouge"></span></a></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

				</div>
				<div class="card mb-4">
					<div class="card-header py-3">
						<h6 class="m-2 font-weight-bold text-primary">Ajouter un auteur</h6>
					</div>
					<div class="card-body">


						<form:form action="validAuteur" method="POST" cssClass="form-horizontal" modelAttribute="auteur">
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<form:label path="prenom"> Indiquer le Prénom de l'auteur : </form:label>
									<form:input path="prenom" type="text" class="form-control form-control-user" placeholder="Prénom de l'auteur" />
									<form:errors path="prenom" cssClass="erreur" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<form:label path="nom"> Indiquer le Nom de l'auteur : </form:label>
									<form:input path="nom" type="text" class="form-control form-control-user" placeholder="Nom de l'auteur" />
									<form:errors path="nom" cssClass="erreur" />
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
