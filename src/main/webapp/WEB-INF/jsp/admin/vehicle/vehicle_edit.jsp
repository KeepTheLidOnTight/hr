<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>


<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id=main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <c:set var="idx" value="0" scope="page"/>
            <form:form cssClass="form-horizontal" modelAttribute="vehicle" action="/admin/vehicle/update" method="post">
                <form:hidden path="id" />
                <form:hidden path="vehicleModel.id" />
                <form:hidden path="vehicleModel.vehicleMake.id" />
                <form:hidden path="version" />
                <form:hidden path="vehicleModel.version" />
                <form:hidden path="vehicleModel.vehicleMake.version" />

                <div class="row">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label" name="vehicle">Name</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleName" type="text"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label" name="vehicle">Year</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleYear" type="text"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" name="vehicle">License Plate</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleLicensePlate" type="text"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" name="vehicle">Vin</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleVin" type="text"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" name="vehicle">Color</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleColor" type="text"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label" name="vehicle">Make</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleModel.vehicleMake.vehicleMakeName" type="text" cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label" name="vehicle">Model</label>
                        <div class="col-sm-8">
                            <form:input path="vehicleModel.vehicleModelName" type="text"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <button class="btn btn-primary">Update</button>
                </div>


            </form:form>

        </div>

        <div class="col-sm-4">

            <%--SUCCESS ALERT--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Vehicle added successfully to the database!</strong>
                </div>
            </div>

            <%--WARNING ALERT--%>
            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Be Advised!</h4>
                    <p>All fields required. Please enter a Vehicle Name and associated attributes.</p>
                </div>
            </div>

            <%--ERROR ALERT--%>
            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap! Something happened, please try again.</strong>
                </div>
            </div>
        </div>
    </div>



</div>


<%@include file="../../includes/footer.jsp" %>