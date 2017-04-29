<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Mendeleev Blog</title>
</head>

<body>
<h2>Welcome to Mendeleev Blog.</h2>

<h4>You can view following pages</h4>
<ul>
    <li>
        <a href="/userInfo">view some user info</a>
    </li>

    <li>
        <a href="/userList">view all users </a>
    </li>

    <li>
        <a href="/addUser">add a new user page</a>
    </li>
    <li>${message}</li>
</ul>

</body>

</html>