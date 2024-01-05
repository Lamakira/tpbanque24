<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <jsp:include page="/WEB-INF/views/Header.jsp"></jsp:include>

    <jsp:include page="/WEB-INF/views/Navigation.jsp"></jsp:include>

        <div class="container-fluid">
            <h1 class="h3 mb-2 text-gray-800">Clients à découvert</h1>

            <!-- DataTales -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Clients</h6>
                </div>

                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                                 <tr>
                                    <th>Numéros</th>
                                    <th>Nom</th>
                                    <th>Prénom</th>
                                    <th>Adresse</th>
                                    <th>Solde</th>
                                    <th>Nom Conseiller</th>
                                    <th>Prénom Conseiller</th>
                                 </tr>
                            </thead>

 	                        <c:forEach var="clients" items="${clients}">
				                <tr>
					                <td></td>
					                <td></td>
                                    <td></td>
				    	            <td></td>
                                    <td></td>
					                <td></td>
                                    <td></td>
				    	            <td></td>
				                </tr>
			                </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/Footer.jsp"></jsp:include>