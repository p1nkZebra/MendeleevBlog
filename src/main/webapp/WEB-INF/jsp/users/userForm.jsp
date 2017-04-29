<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Mendeleev Blog</title>
</head>

    <body>
    <h2>Information for Update</h2>

    <spring:url value="/users" var="userActionUrl" />

    <form:form class="form-horizontal"
               method="POST"
               modelAttribute="userInfo"
               action="${userActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="firstName">
            <div class="form-group ">
                <label class="col-sm-2 control-label">User First Name</label>
                <div class="col-sm-10">
                    <form:input path="firstName"
                                type="text"
                                class="form-control"
                                id="userName"
                                placeholder="Name" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ">
                <label class="col-sm-2 control-label">User Last Name</label>
                <div class="col-sm-10">
                    <form:input path="lastName"
                                type="text"
                                class="form-control"
                                id="userLastName"
                                placeholder="lastName" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="login">
            <div class="form-group ">
                <label class="col-sm-2 control-label">User Login</label>
                <div class="col-sm-10">
                    <form:input path="login"
                                type="text"
                                class="form-control"
                                id="userLogin"
                                placeholder="login" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ">
                <label class="col-sm-2 control-label">User Password</label>
                <div class="col-sm-10">
                    <form:input path="password"
                                type="text"
                                class="form-control"
                                id="userPassword"
                                placeholder="password" />
                </div>
            </div>
        </spring:bind>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-primary">Update</button>
            </div>
        </div>


    </form:form>
    </body>
</html>
