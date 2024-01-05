<%@ page contentType="text/html;charset=UTF-8" language="java" %>


 <jsp:include page="/WEB-INF/views/Header.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/Navigation.jsp"></jsp:include>

    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Nouveau client</h1>

        <div class="row justify-content-center">
             <div class="col-xl-7 col-lg-7 col-md-10">
                <div class="card o-hidden border-0 shadow-lg my-5">
                  <div class="card-body p-0">
                    <div class="row">
                      <div class="col-lg-12">
                        <div class="p-5">

                          <c:url var="save_client_url" value="/enregistrer"/>

                          <form:form class="user" action="${save_client_url}" method="post" modelAttribute="client">
                             <div class="form-group">
                                  <label for="numero_client">Numéro client</label>
                                  <input type="text" class="form-control form-control-user" id="numero_client" name="numero_client"/>
                              </div>
                            <div class="form-group">
                                <form:label path="nom">Nom</form:label>
                                <form:input type="text" class="form-control form-control-user" path="nom"/>
                            </div>
                            <div class="form-group">
                                <form:label path="prenom">Prénom</form:label>
                                <form:input type="text" class="form-control form-control-user" path="prenom"/>
                            </div>
                            <div class="form-group">
                                <form:label path="adresse">Adresse</form:label>
                                <form:input type="text" class="form-control form-control-user" path="adresse" />
                            </div>
                            <div class="form-group">
                                <form:label path="nom_conseiller">Nom du conseiller</form:label>
                                <form:input type="text" class="form-control form-control-user" path="nom_conseiller"/>
                            </div>
                            <div class="form-group">
                                <form:label path="prenom_conseiller">Prénom du conseiller</form:label>
                                <form:input type="text" class="form-control form-control-user" path="prenom_conseiller"/>
                            </div>
                            <div class="form-group">
                                <form:select path="nom_agence">
                                    <form:option value="">Sélectionner une agence</form:option>
                                    <form:options items="${agences}" itemValue="id" itemLabel="nom"></form:options>
                                </form:select>
                            </div>

                            <input class="btn btn-primary btn-user btn-block" type="submit" value="Enregistrer"/>
                          </form:form>

                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        </div>

    </div>

 </div>
</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"></jsp:include>