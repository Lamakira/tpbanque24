<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <jsp:include page="/WEB-INF/views/Header.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/Navigation.jsp"></jsp:include>

    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">Clients de lagence</h1>

        <c:url var="" value=""/>
        <form action=" " method="post">
            <div class="form-group">
                <label for="agency">Sélectionner lagence : </label>
                <select class="form-control form-control-user" name="agency" id="agency">
                    <c:forEach items="${listAgency}" var="agency">
                        <option value="${agency.id}">${agency.nom}</option>
                    </c:forEach>
                </select>
            </div>

            <input class="btn btn-primary btn-user btn-block" type="submit" value="Lister">
        </form>

        <hr>

        <!-- DataTales Agency Clients -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Clients</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                              <th>Numéro</th>
                              <th>Nom</th>
                              <th>Prénom</th>
                              <th>Adresse</th>
                              <th>Nom Conseiller</th>
                              <th>Prénom Conseiller</th>
                            </tr>
                        </thead>

 	   		            <c:forEach var="clientsbyagency" items="${listClientsByAgency}">
				            <tr>
                                <td>${clientsbyagency.numero_client}</td>
                                <td>${clientsbyagency.nom}</td>
                                <td>${clientsbyagency.prenom}</td>
                                <td>${clientsbyagency.adresse}</td>
                                <td>${clientsbyagency.nom_conseiller}</td>
                                <td>${clientsbyagency.prenom_conseiller}</td>
				            </tr>
			            </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- /.container-fluid -->
 </div>

</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"></jsp:include>