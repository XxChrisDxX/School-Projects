<%-- 
    Document   : Exception
    Created on : Nov 13, 2014, 2:48:40 PM
    Author     : ctdecker2727
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="ErrorPage.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exception</title>
    </head>
    <body>
        <h2>Web Calculator with Error Page</h2>
        <%
            String xinput = request.getParameter("xfield");
            String yinput = request.getParameter("yfield");
            String function = request.getParameter("function");
            if(xinput!=null && yinput!=null && function!=null)
            {
                double x = Double.parseDouble("xinput");
                double y = Double.parseDouble("yinput");
                double z = 0;
                if(function.equals(" + "))
                    z = x + y;
                else if(function.equals(" - "))
                    z = x - y;
                else if(function.equals(" * "))
                    z = x*y;
                else
                    z = x/y;
        %>
        <h2><%= x + function + y + " = " + z %></h2>
        <%
            }
        %>
    </body>
</html>
