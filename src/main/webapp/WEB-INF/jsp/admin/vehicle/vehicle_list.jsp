<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id=main-wrapper" class="col-sm-10">
        <div class="col-sm-12">

            <%--LIST OF EXISTING VEHICLE--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Plate #</th>
                    <th>Vin</th>
                    <th>Color</th>
                    <th>Make</th>
                    <th>Model</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <tr>
                        <td>${vehicle.id}</td>
                        <td>${vehicle.vehicleName}</td>
                        <td>${vehicle.vehicleYear}</td>
                        <td>${vehicle.vehicleLicensePlate}</td>
                        <td>${vehicle.vehicleVin}</td>
                        <td>${vehicle.vehicleColor}</td>
                        <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                        <td>${vehicle.vehicleModel.vehicleModelName}</td>
                        <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                        <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>



</div>


<%@include file="../../includes/footer.jsp" %>