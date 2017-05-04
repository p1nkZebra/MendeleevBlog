<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>Mendeleev Blog</title>
    </head>

    <body>
        <h1>User Info</h1>

        <table class="table">
            <thead>
            <tr>
                <th>User</th>
                <th>Date Created</th>
                <th>Title</th>
            </tr>
            </thead>

            <c:forEach var="post" items="${userPosts}">
                <tr>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>${post.dateTime}</td>
                    <td>${post.title}</td>
                    <td>
                        <spring:url value="/users/${user.id}/posts/${post.id}"
                                    var="userPost" />

                        <button class="btn"
                                onclick="location.href='${userPost}'">Show This Publication</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>