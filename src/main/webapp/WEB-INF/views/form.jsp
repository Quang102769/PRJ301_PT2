<html>
<head>
    <title>Form</title>
</head>
<body>
    <c:choose>
        <c:when test='${not empty sessionScope.userRole && sessionScope.userRole == "ADMIN" }'>
            <h1>Welcome Admin</h1>
        </c:when>
        <c:otherwise>
            <h1>unauthorized</h1>
        </c:otherwise>
    </c:choose>
    <form action="/ContactServlet" method="post">
        <label for="fullname">Full Name:</label><br />
        <input type="text" id="fullname" name="fullname"><br />
        <label for="email">Email:</label><br />
        <input type="email" id="email" name="email"><br />
        <label for="phone">Phone:</label><br />
        <input type="text" id="phone" name="phone"><br />
        <label for="address">Address:</label><br />
        <input type="text" id="address" name="address"><br /><br />
        <input type="submit" value="Submit">
    </form>
</body>
</html>