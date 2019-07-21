<%-- 
    Document   : error.jsp
    Created on : Feb 27, 2019, 6:01:44 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <%@include file="masterHeader.jsp" %>
        <div id="colorlib-contact">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 animate-box">
                        <h3>You messed up. Sorry.</h3>
                        <font color="red">${requestScope.INVALID}</font><br/>
                        <font color="red">${requestScope.ERROR}</font><br/>
                        <a href="index.jsp">Back to home page</a>	
                    </div>
                </div>
            </div>
        </div>
        <h1></h1>
        
        <%@include file="masterFooter.jsp" %>
    </body>
</html>
