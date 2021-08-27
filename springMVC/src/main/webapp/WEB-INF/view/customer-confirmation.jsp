<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title> Customer Confirmation  </title>
</head>
<body>
The Customer is confirmed: ${customer.firstName} ${customer.lastName}
<br>
Free_Passes: ${customer.freePasses}
<br>
Postal_Code: ${customer.postalCode}
<br>
Course_Code: ${customer.courseCode}
</body>
</html>
