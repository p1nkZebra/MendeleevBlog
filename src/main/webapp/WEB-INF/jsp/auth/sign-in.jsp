<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
    <head>
        <title>Mendeleev Blog</title>
    </head>

    <body>
        <h2>Please enter you login and password.</h2>
        <form:form modelAttribute="userLoginPass" action="/auth-check" method="POST">
            <table>
                <tr>
                    <td><form:label path="login">User login</form:label></td>
                    <td><form:input path="login"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">User Password</form:label></td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Sing in"/></td>
                </tr>
            </table>
        </form:form>

    </body>

</html>
