<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head><title> List Customers</title>
    <!-- reference our style sheet -->
    <link type = "text/css"
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id ="wrapper">
    <div id ="header">
        <h2> CRM- Customer Relationship Manager </h2>
    </div>

    <div id = "container">
            <div id ="content">
            <!-- add out html table here -->
            <!-- put a button: Add Customer -->

            <input type = "button" value= "Add Customer"
                        onClick = "window.location.href='showFormForAdd';"
                        class = "add-button"/>

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                <!-- loop over and print out customers -->
                <c:forEach var="tempCustomer" items="${customers}">

                    <!-- construct an "update" link with customer id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name ="customerId" value="${tempCustomer.theId}"/>
                    </c:url>

                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/customer/delete">
                            <c:param name ="customerId" value="${tempCustomer.theId}"/>
                    </c:url>
                    <tr>
                        <td> ${tempCustomer.firstName} </td>
                        <td> ${tempCustomer.lastName} </td>
                        <td> ${tempCustomer.email} </td>
                        <td>
                            <!-- display the update link -->
                            <a href="${updateLink}">Update</a>

                            <a href="${deleteLink}"
                            onClick ="if(!(confirm('Are you sure want to delete this customer? '))) return false">
                            Delete</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
            </div>
    </div>

</div>

</body>
</html>