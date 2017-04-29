<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Mendeleev Blog</title>
</head>

<body>
<h2>View User Information</h2>

<table>
    <tr>
        <td>Id</td>
        <td>${user.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>Login</td>
        <td>${user.login}</td>
    </tr>
    <tr>
        <td>Password</td>
        <td>${user.password}</td>
    </tr>
</table>
</body>

</html>