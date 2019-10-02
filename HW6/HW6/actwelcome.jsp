<%-- 
    Document   : actwelcome
    Created on : 
    Author     : 
Complete the include file= in Ln7 (below) to include the content of the Connection.jsp file in the Connection folder.
--%>
<%@ include file= "Connection/Connection.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ISM3212 Fall 2014 HW6: Accounting Manager Welcome and Display Customer Page</title>
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
      <h4 align="center"><font color="#FFFFFF"><b>ISM3212 Fall 2014 HW6: Accounting Manager Welcome and Display Customer Page<br>
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
             out.println(rs.getString("EmployeeFullName"));  // EmployeeFullName
             out.println("</font></TD><TD><font color=#FFFFFF>Job Title: "+rs.getString("JobTitle")+"</font></td></tr>");  // JobTitle
            }
            prep.close();    // close the prepared statement                  
           }
	    else
	    {
	    response.sendRedirect("login.jsp");
	    }
           con.close(); // close the connection
           
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
    <td class="style2"><a href="addcustomer.jsp">Add New Customer</a></td>
    <TD class="style2"></TD>
    <td class="style2"><a href="logout.jsp">Log Out</a></td>
    <TD class="style2"></TD>
  </tr>
</table>
<table width="730" border="0" cellspacing="0" height="52" class="style2">
  <tr>
    <td class="style2" bgcolor="#000080" class="style2"><font color="#FFFFFF">Company ID</font></td>
    <td class="style2" bgcolor="#000080" class="style2"><font color="#FFFFFF">Company Name</font></td>
     <td class="style2" bgcolor="#000080" class="style2"><font color="#FFFFFF">Account No</font></td>
     <td class="style2" bgcolor="#000080" class="style2"><font color="#FFFFFF">Payment Method ID</font></td>
     <td class="style2" bgcolor="#000080" class="style2"><font color="#FFFFFF">Billing Address ID</font></td>
     <td class="style2" bgcolor="#000080" class="style2"><font color="#FFFFFF">Shipping Address ID</font></td>
  </tr>
        <%
        // declare a connection
	Connection con = null; 
        try{
          // open a connection
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
	  // Complete the con = in Ln101 (below) to open a connection.
          con = DriverManager.getConnection(ConnString);
           //
           {
            // create a prepared sql statement
            // Complete PreparedStatement prep =  and prep.setString();in Ln107 to 
	    // execute sp5CYourAccountName with no paramter.
            PreparedStatement prep = con.prepareStatement("EXECUTE sp5CF14ctdecker2727");
            // execute the query
            ResultSet rs = prep.executeQuery();
            // display the results in an html table
            while(rs.next())
            {
             out.println("<tr><td>"+rs.getString("CompanyID")+"</td>");  // CompanyID
             out.println("<td>"+rs.getString("CompanyName")+"</td>");  // CompanyName   
             out.println("<td>"+rs.getString("AccountNo")+"</td>");  // AccountNo  
             out.println("<td>"+rs.getString("PaymentMethodID")+"</td>");  //PaymentMethodID
             out.println("<td>"+rs.getString("BillingAddressID")+"</td>");  // BillingAddressID 
             out.println("<td>"+rs.getString("ShippingAddressID")+"</td></tr>");  // ShippingAddressID
            }
            prep.close();    // close the prepared statement                  
           }
          }
          catch(Exception ex)
          {
           out.println("Sorry, system is not currently available<br/>");
           out.println(ex.toString());
          }
        
        %>
</table>
<p>
</p>
</body>
</html>