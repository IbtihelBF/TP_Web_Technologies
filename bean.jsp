
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>JavaBean Result</title>
</head>
<body>

    <h2>Person Information</h2>
    <jsp:useBean id="person" class="isep.lab1.bean.Person" scope="request" />
    <jsp:setProperty name="person" property="*" />

    <p>First Name:
        <jsp:getProperty name="person" property="firstName" />
    </p>

    <p>Last Name:
        <jsp:getProperty name="person" property="lastName" />
    </p>

    <p>Birth Day:
        <jsp:getProperty name="person" property="birthDay" />
    </p>

    <p>Sex:
        <jsp:getProperty name="person" property="sex" />
    </p>

    <br>
    <a href="form-jsp.html">Back to Form</a>

</body>
</html>
