<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Show Data</h1>
        <ul>
        	<li><p><b>First Name: </b> 
        	<%= request.getParameter("first_name") %>
        	</p>
        	</li>
        	<li><p><b>Last Name: </b> 
        	<%= request.getParameter("last_name") %>
        	</p>
        	</li>
        	<li><p><b>Age: </b> 
        	<%= request.getParameter("age") %>
        	</p>
        	</li>
        </ul>
    </body>
</html>
