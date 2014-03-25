<%-- 
    Document   : userLogged
    Created on : Mar 18, 2014, 5:48:02 PM
    Author     : sonny
--%>

<%@page
    contentType="text/html"
    pageEncoding="UTF-8"
    language="java"
    import="com.demo.UserBean" %>
    
<%
  if (session.getAttribute("logged") == "success") {
%> 
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Logged Successfully</title>
    </head>
    <body>
        <center>
            <% UserBean currentUser = (UserBean) (session.getAttribute("currentSessionUser"));%>
            
            Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
         </center>
    </body>
</html>

<%
  } else {
    response.sendRedirect("login.jsp");
  }
%>