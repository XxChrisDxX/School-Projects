<%-- 
    Document   : otherwelcome
    Created on : 
    Author     : 
Complete the include file= in Ln5 to include the content of the Connection.jsp file in the Connection folder.
--%>
<%@ include file= "Connection/Connection.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ISM3212 Fall 2014 HW6: Other Employee Welcome Page</title>
<style type="text/css">
    <!--
.style2 {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
}
-->
</style>
</head>

<body>
<table width="730" border="0" cellspacing="0" height="52" class="style2">
  <tr>
    <td height="32" colspan="2" bgcolor="#000080" class="style2">
      <h4 align="center"><font color="#FFFFFF"><b>ISM3212 Fall2014 HW6: Other Employee Welcome Page<br>
	<!--Replace Your Name in the next line with your name -->
	Created by Chris Decker</b></font></h4></td>
    </td>
  </tr>
  <tr bgcolor="#000080" class="style2">
    <td height="32"><font color="#FFFFFF">Employee Name: 
        <%
        try{
          // open a connection
          Connection con = null; 
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
	  // Complete the con = in Ln42 (below) to open a connection.
          con = DriverManager.getConnection(ConnString);
           //
           // get the parameters from the html form
           String UID = (String) session.getAttribute("UID");
           if(UID != null)
           {
            // create a prepared sql statement
            // Complete PreparedStatement prep =  and prep.setString();in Ln51 and 52 to 
	    // execute sp5BYourAccountName with parameters "UID".
            PreparedStatement prep = con.prepareStatement("EXECUTE sp5BF14ctdecker2727 ?");
            prep.setString(1, UID);
            // execute the query
            ResultSet rs = prep.executeQuery();
            // display the results in an html table
            while(rs.next())
            {
            // Complete out.println() in Ln59 (below) to display "EmployeeFullName" retrieved and stored in recordet called "rs".
             out.println(rs.getString("EmployeeFullName"));  
             out.println("</font></TD><TD><font color=#FFFFFF>Job Title: "+rs.getString("JobTitle")+"</font></td></tr>");  // JobTitle
            }
            prep.close();    // close the prepared statement    
            con.close(); // close the connection              
           }
	    else
	    {
	    response.sendRedirect("login.jsp");
           con.close(); // close the connection
	    }
          }
          catch(Exception ex)
          {
           out.println("Sorry, system is not currently available<br/>");
           out.println(ex.toString());
          }
        
        %>
</table>
<table width="730" border="0">
  <tr>
    <TD class="style2"><a href="logout.jsp">LogOut</a></TD>
  </tr>
</table>
<Table><TR><TD class="style2">
<b>This is the Welcome page for other employees.</font></b>
</TR></TD></table>
</body>
</html>