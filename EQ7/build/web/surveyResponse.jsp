<%-- 
    Document   : survey
    Created on : Nov 4, 2014, 2:32:03 PM
    Author     : ctdecker2727
--%>

<%@page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Survey Response JSP</title>
        <style>
            body{
                font-size: 14px;
                color: black;
            }
            p{
                font-size: 14px;
                color: black;
            }
            h2{
                font-size: 18px;
                color: black;
            }
        </style>
    </head>
    <body>
            <h2>Survey</h2>
            <p>Here is a summary of your survey inputs.</p>
            <%
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String emailAddress = request.getParameter("emailAddress");
                
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("/WEB-INF/surveyList.txt");
                File file = new File(path);
                PrintWriter output = new PrintWriter(new FileWriter(file, true));
                output.println(firstName + "|" + lastName + "|" + emailAddress);
                output.close();
            %>
            <h2>Your information: </h2>
            <table>
                <tr>
                    <td>First Name: </td>
                    <td><%= firstName%></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><%= lastName%></td>
                </tr>
                <tr>
                    <td>Email Address: </td>
                    <td><%= emailAddress%></td>
                </tr>
            </table>
            <h2>You heard about us from <%= request.getParameter("heardUs")%></h2>
            <%           
                String checkbox = request.getParameter("receiveInfo");
                if(checkbox != null){    
            %>
            <h2>You would like to receive announcements about new CDs.</h2>
            <%
                }
                else{
            %>
            <h2>You would not like to receive announcements about new CDs.
            <%
                }
            %>
            <br /><br />
            We can contact you by <%= request.getParameter("contactMe")%>.
            <br />
            <p>Thank you for taking the survey.</p>
            <form action="survey.html">
                <input type="submit" value="submit"
            </form>
            <br /><br />Click to return to the survey page.
    </body>
</html>

