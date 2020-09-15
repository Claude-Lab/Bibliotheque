<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
				<h1 class="h3 mb-2 text-gray-800">Salarie</h1>
				<p class="mb-4"></p>

				<!-- DataTales Example -->
				<div class="card shadow mb-4">



					<div class="card mb-4">
						<div class="card-header py-3">
							<h6 class="m-2 font-weight-bold text-primary">Ajouter un.e
								salarié.e</h6>
						</div>
						<div class="card-body">


							<form:form action="validSalarie" method="POST"
								cssClass="form-horizontal" modelAttribute="pers">


								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="prenom"> Prénom : </form:label>
										<form:input path="prenom" type="text"
											pattern="[-[:alpha:] ]{2,30}"
											title="chiffre et signe spéciaux interdit"
											class="form-control form-control-user" placeholder="Prénom"
											required="required"></form:input>
										<form:errors path="prenom" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="nom"> Nom : </form:label>
										<form:input path="nom" type="text"
											pattern="[-[:alpha:] ]{2,30}"
											class="form-control form-control-user" placeholder="Nom"
											required="required"></form:input>
										<form:errors path="nom" cssClass="erreur"></form:errors>
									</div>
								</div>

								<form:hidden path="username" />

								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="password"> Mot de pase : </form:label>
										<form:input path="password" type="password"
											pattern="[-[:alpha:]]{8,10}"
											title="chiffre et signe spéciaux interdit"
											class="form-control form-control-user"
											placeholder="Mot de passe" required="required"></form:input>
										<form:errors path="password" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="confirmPassword"> Confirmez le mot de passe : </form:label>
										<form:input path="confirmPassword" type="password"
											pattern="[-[:alpha:]]{8,10}"
											title="chiffre et signe spéciaux interdit"
											class="form-control form-control-user"
											placeholder="Confirmez le mot de passe" required="required"></form:input>
										<form:errors path="confirmPassword" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.email"> eMail : </form:label>
										<form:input path="coordonnee.email" type="email"
											class="form-control form-control-user" placeholder="eMail"
											required="required"></form:input>
										<form:errors path="coordonnee.email" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.rue"> Adresse (n°, rue, etc.) : </form:label>
										<form:input path="coordonnee.rue" type="text"
											pattern="[-[:alpha:][:digit:] ]{2,35}"
											title="carractères spéciaux interdits"
											class="form-control form-control-user" placeholder="Adresse"
											required="required"></form:input>
										<form:errors path="coordonnee.rue" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.cp"> Code postal : </form:label>
										<form:input path="coordonnee.cp" type="text"
											pattern="[0-9]{5}" class="form-control form-control-user"
											title="5 chiffres" placeholder="Code postal"
											required="required"></form:input>
										<form:errors path="coordonnee.cp" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.ville"> Ville : </form:label>
										<form:input path="coordonnee.ville" type="text"
											pattern="[-[:alpha:] ]{2,40}"
											title="chiffre et signe spéciaux interdit"
											class="form-control form-control-user" placeholder="Ville"
											required="required"></form:input>
										<form:errors path="coordonnee.ville" cssClass="erreur"></form:errors>
									</div>
								</div>

								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.mobile"> Téléphone Mobile : </form:label>
										<form:input path="coordonnee.mobile" type="text"
											pattern="[0-9]{10}" title="10 chiffres"
											class="form-control form-control-user"
											placeholder="Téléphone Mobile"></form:input>
										<form:errors path="coordonnee.mobile" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="coordonnee.fixe"> Téléphone Fixe : </form:label>
										<form:input path="coordonnee.fixe" type="text"
											pattern="[0-9]{10}" title="10 chiffres"
											class="form-control form-control-user"
											placeholder="Téléphone Fixe"></form:input>
										<form:errors path="coordonnee.fixe" cssClass="erreur"></form:errors>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="caution.idCaution"
											cssClass="col-xs-2 control-label">Caution :</form:label>
										<div class="col-xs-10">
											<form:select path="caution.idCaution" cssClass="form-control"
												required="required">
												<option value="" title="Veuillez choisir la somme versée">--
													VALEUR CAUTION --</option>
												<form:options items="${listeCautions}" itemValue="idCaution"
													itemLabel="valeur" />
											</form:select>
										</div>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<form:label path="role.idRole"
											cssClass="col-xs-2 control-label">Role :</form:label>
										<div class="col-xs-10">
											<form:select path="role.idRole" cssClass="form-control"
												required="required">
												<option value="" title="Veuillez choisir le role">--
													ROLE --</option>
												<form:options items="${listeRoles}" itemValue="idRole"
													itemLabel="libelle" />
											</form:select>
										</div>
									</div>

								</div>

								<input type="submit" value="VALIDER"
									class="btn btn-primary btn-user " />
								<a href="gestionSalaries" class="btn btn-secondary"
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
