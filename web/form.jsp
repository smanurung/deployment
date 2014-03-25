<%-- 
    Document   : form
    Created on : Mar 19, 2014, 1:20:09 AM
    Author     : damiann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form Trial</title>
    </head>
    <body>
        <h1>This is still alpha</h1>
        <form action="/form" method="POST">
            Enter a string!
            <input type="text" name="str">
            <input type="submit" value="submit">
        </form>
    </body>
</html>