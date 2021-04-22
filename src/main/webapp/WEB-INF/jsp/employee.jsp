<%@include file="includes/header.jsp" %>
<%@include file="includes/navbar.jsp" %>

<c:url value="/static/js/employee.js" var="employee" />
<script src="/static/js/employee.js"></script>

<script>
    // this javascript code executes when the page has loaded
    $(document).ready(function() {
        buildTable();
        deleteModal();
    })
</script>

<div class="container">

    <h2>Employee List</h2>

    <button onclick="insertEmployee()" class="btn btn-default">Add New Employee</button>

    <table id="employee-table" class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Background</th>
                <th>Projects</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>

    <%--        jquery will append our data here...--%>
        </tbody>
    </table>

    <div id="employeeModal" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Employee Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <form>

                        <hidden id="employeeId" />
                        <hidden id="employeeVersion" />

                        <div class="form-group">
                            <label for="inputFirstName">First Name</label>
                            <input type="email" class="form-control" id="inputFirstName" placeholder="First Name">
                        </div>

                        <div class="form-group">
                            <label for="inputLastName">Last Name</label>
                            <input type="email" class="form-control" id="inputLastName" placeholder="Last Name">
                        </div>

                        <div class="form-group">
                            <label for="textAreaBackground">Background</label>
                            <textarea class="form-control" id="textAreaBackground" rows="3"></textarea>
                        </div>
                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="saveEmployee()">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <div id="confirmDeleteModal" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Confirm Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                   <p>Are you sure you want to delete? This cannot be undone!</p>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger btn-ok" data-dismiss="modal" id="confirmDelete">Delete</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp" %>