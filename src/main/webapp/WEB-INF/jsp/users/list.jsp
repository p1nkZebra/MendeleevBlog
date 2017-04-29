<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%--<jsp:include page="../fragments/header.jsp" />--%>

<body>

<div class="container">

    <%--<c:if test="${not empty msg}">--%>
        <%--<div class="alert alert-${css} alert-dismissible" role="alert">--%>
            <%--<button type="button" class="close" data-dismiss="alert"--%>
                    <%--aria-label="Close">--%>
                <%--<span aria-hidden="true">×</span>--%>
            <%--</button>--%>
            <%--<strong>${msg}</strong>--%>
        <%--</div>--%>
    <%--</c:if>--%>

    <h1>All Users</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Last Name</th>
            <th>Login</th>
            <th>Password</th>
        </tr>
        </thead>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>
                    <spring:url value="/users/${user.id}"        var="userUrl" />
                    <spring:url value="/users/${user.id}/delete" var="deleteUrl" />
                    <spring:url value="/users/${user.id}/update" var="updateUrl" />

                    <button class="btn btn-info"
                            onclick="location.href='${userUrl}'">Info</button>
                    <button class="btn btn-update"
                            onclick="location.href='${updateUrl}'">Update</button>
                    <button class="btn btn-delete"
                            onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>

<%--<jsp:include page="../fragments/footer.jsp" />--%>

</body>
</html>