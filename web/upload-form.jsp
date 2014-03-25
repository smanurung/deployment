<%-- 
    Document   : form
    Created on : Mar 14, 2014, 11:40:55 PM
    Author     : msmaromi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Secure Indonesia</title>
    </head>
    <body>
        <h1>Upload</h1>
        <form enctype="multipart/form-data" action="/SecureWebProject/upload" method="POST">
            <input name="file" type="file">
            <input type="submit" value="Upload">
        </form>    
    </body>
</html>
