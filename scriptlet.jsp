<html>
<head>
    <title>JSP Scriptlet</title>
</head>
<body>
    <h2>Current Time and Server Information</h2>

    <%
        java.util.Date date = new java.util.Date();
        out.println("Current time: " + date);
        out.println("<br>");
        out.println("Remote host: " + request.getRemoteHost());
    %>
    
</body>
</html>
