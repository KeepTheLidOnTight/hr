<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>

    $(document).ready(function() {

        $("#successAlert").delay(8000).fadeOut(2000);
        $("#warningAlert").delay(10000).fadeOut(2000);


    });
</script>


<div class="wrapper">

    <%--SIDEBAR HERE--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id=main-wrapper" class="col-sm-10">
        <div class="col-sm-8">

            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                    <legend>Vehicle Management</legend>
<%--                    Vehicle name--%>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Name</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleName" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle Name"></form:input>
                        </div>
                    </div>
<%--                        Vehicle year--%>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Year</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleYear" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle Year"></form:input>
                        </div>
                    </div>
<%--                            Vehicle License Plate--%>
                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle License Plate</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleLicensePlate" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle License Plate"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle VIN</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleVin" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle VIN"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Color</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleColor" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle Color"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Make</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleMake" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle Make"></form:input>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:input path="newVehicleModel" type="text" cssClass="form-control" id="inputNewVehicle" placeholder="Vehicle Model"></form:input>
                        </div>
                    </div>



                    <div class="form-group">
                        <div class="col-lg-10 col-log-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>

                </fieldset>
            </form:form>

        </div>

        <div class="col-sm-4">

            <%--ALERTS--%>
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