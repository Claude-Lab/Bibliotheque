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
				<h1 class="h3 mb-2 text-gray-800">Livres</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">



					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter un livre</h6>
						</div>
						<div class="card-body">


							<form:form action="validLivre" method="POST" cssClass="form-horizontal" modelAttribute="livre">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="titre"> Titre *</form:label>
										<form:input path="titre" type="text" class="form-control form-control-user" placeholder="Titre" required="required"></form:input>
										<form:errors path="titre" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="isbn"> N° ISBN *</form:label>
										<form:input path="isbn" type="text" title="chiffre et signe spéciaux interdit" class="form-control form-control-user" placeholder="N° ISBN" required="required"></form:input>
										<form:errors path="isbn" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="editeur.idEditeur" cssClass="col-xs-2 control-label">Editeur *</form:label>
										<div class="col-xs-10">
											<form:select path="editeur.idEditeur" cssClass="form-control" required="required">
												<option value="" title="Veuillez choisir l'editeur">-- EDITEUR --</option>
												<form:options items="${listeEditeurs}" itemValue="idEditeur" itemLabel="nom" />
											</form:select>
										</div>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="bibliotheque.idBibliotheque" cssClass="col-xs-2 control-label">Bibliotheque *</form:label>
										<div class="col-xs-10">
											<form:select path="bibliotheque.idBibliotheque" cssClass="form-control" required="required">
												<option value="" title="Veuillez choisir la bibliotheque du livre">-- BIBLIOTHEQUE --</option>
												<form:options items="${listeBibliotheques}" itemValue="idBibliotheque" itemLabel="nom" />
											</form:select>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="etat.idEtat" cssClass="col-xs-2 control-label">Etat *</form:label>
										<div class="col-xs-10">
											<form:select path="etat.idEtat" cssClass="form-control" required="required">
												<option value="" title="Veuillez indiquer l'état du livre">-- ETAT --</option>
												<form:options items="${listeEtats}" itemValue="idEtat" itemLabel="libelle" />
											</form:select>
										</div>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="auteurs" cssClass="col-xs-2 control-label">Auteurs *</form:label>
										<div class="col-xs-10">
											<form:select path="auteurs" id="control_1" cssClass="form-control" required="required" multiple="true">
												<option value="auteur.idAuteur" title="Veuillez un premier auteur">-- AUTEUR --</option>
												<form:options items="${listeAuteurs}" itemValue="idAuteur" itemLabel="prenomNom" />
											</form:select>
										</div>
									</div>
<!-- 									<div class="col-sm-6 mb-3 mb-sm-0"> -->
<%-- 										<form:label path="auteurs" cssClass="col-xs-2 control-label">Auteurs</form:label> --%>
<!-- 										<div class="col-xs-10"> -->
<%-- 											<form:select path="auteurs" id="control_1" cssClass="form-control" multiple="false"> --%>
<!-- 												<option value="auteur.idAuteur" title="Veuillez un premier auteur">-- AUTEUR --</option> -->
<%-- 												<form:options items="${listeAuteurs}" itemValue="idAuteur" itemLabel="prenomNom" /> --%>
<%-- 											</form:select> --%>
<!-- 										</div> -->
<!-- 									</div> -->

									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="styles" cssClass="col-xs-2 control-label">Styles *</form:label>
										<div class="col-xs-10">
											<form:select  path="styles" id="control_2" cssClass="form-control" required="required" multiple="true">
												<option value="style.idStyle" title="Veuillez choisir un premier style">-- STYLE --</option>
												<form:options items="${listeStyles}" itemValue="idStyle" itemLabel="libelle" />
											</form:select>
										</div>
									</div>
<!-- 									<div class="col-sm-6 mb-3 mb-sm-0"> -->
<%-- 										<form:label path="styles" cssClass="col-xs-2 control-label">Styles</form:label> --%>
<!-- 										<div class="col-xs-10"> -->
<%-- 											<form:select  path="styles" id="control_2" cssClass="form-control" multiple="false"> --%>
<!-- 												<option value="style.idStyle" title="Veuillez choisir un premier style">-- STYLE --</option> -->
<%-- 												<form:options items="${listeStyles}" itemValue="idStyle" itemLabel="libelle" /> --%>
<%-- 											</form:select> --%>
<!-- 										</div> -->
<!-- 									</div> -->
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="description"> Description * </form:label>
										<form:textarea path="description" type="text" title="chiffre et signe spéciaux interdit" class="form-control form-control-user" placeholder="" required="required"></form:textarea>
										<form:errors path="description" cssClass="erreur"></form:errors>
									</div>
								</div>




								<input type="submit" value="VALIDER" class="btn btn-primary btn-user " />
								<a href="gestionLivres" class="btn btn-secondary" role="button" aria-pressed="true">ANNULER</a>
								<br>

								<hr>
								<h6><i>* Champs obligatoires</i></h6>

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
