<%-- 
    Document   : showString
    Created on : Mar 20, 2014, 12:27:31 AM
    Author     : msmaromi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Output Form</title>
    </head>
    
    <body>         
         <% 
           String str = session.getAttribute("str").toString();
//           str = "<script>alert('tes')</script>";
           out.print(str);
         %>
    </body>
</html>



