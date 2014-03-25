<%-- 
    Document   : invalidLogin
    Created on : Mar 18, 2014, 5:51:42 PM
    Author     : sonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
  Object logged = session.getAttribute("logged");
  if (logged == "fail") {
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Login</title>
    </head>
    <body>
        <center>
            Sorry, you are not a registered user! Please sign up first
         </center>
    </body>
</html>

<%
  } else if (logged == "success") {
    response.sendRedirect("userLogged.jsp");
  } else {
    response.sendRedirect("login.jsp");
  }
%>