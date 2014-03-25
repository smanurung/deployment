<%-- 
    Document   : login
    Created on : Mar 18, 2014, 5:23:11 PM
    Author     : sonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.isNew()) {
        session.setAttribute("attempt", 0);
    }

    if (session.getAttribute("logged") != "success") {
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>

    <body>
        Login Form
        <form action="/SecureWebProject/login">
            <fieldset title="Login">
                <legend>Login Form</legend>
                Please enter your username      
                <input type="text" name="un"/><br>          
                Please enter your password
                <input type="text" name="pw"/>      
                <input type="submit" value="submit">                
            </fieldset>
        </form>
        Forgot Password Form
        <form action="/SecureWebProject/forgot">
            <fieldset title="Forget Password">
                <legend>Forget Password Form</legend>
                Please enter your username      
                <input type="text" name="un"/>          
                <input type="submit" value="submit">
            </fieldset>
        </form>
        <a href="/SecureWebProject/upload-form.jsp">upload link</a>
    </body>
</html>

<%
    } else {
        response.sendRedirect("userLogged.jsp");
    }
%>

