<%-- 
    Document   : addcustomer
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
<title>ISM3212 Fall 2014 HW6: Add New Customer Page</title>
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
      <h4 align="center"><font color="#FFFFFF"><b>ISM3212 Fall 2014 HW6: Add New Customer Page<br>
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
    <td class="style2"><a href="logout.jsp">Log Out</a></td>
    <TD class="style2"></TD>
  </tr>
</table>
<form name = "form1" method="POST" action="insertcustomer.jsp">
<table width="729" border="0" cellspacing="0">
  <tr>
    <td class="style2">Company Name: </td>
    <td class="style2"><input type="text" name="CName"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Billing Address Line 1: </td>
    <td class="style2"><input type="text" name="BA1"  size="50"></td>
  </tr>
  <tr>
  <tr>
    <td class="style2">Billing Address Line 2: </td>
    <td class="style2"><input type="text" name="BA2"  size="50"></td>
  </tr>
  <tr>
  <tr>
    <td class="style2">Billing City: </td>
    <td class="style2"><input type="text" name="BCity"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Billing State (Province): </td>
    <td class="style2"><input type="text" name="BState"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Billing Postal Code: </td>
    <td class="style2"><input type="text" name="BPCode"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Billing Country: </td>
    <td class="style2"><input type="text" name="BCountry"  size="50"></td>
  </tr>
  <tr>
    <td class="style2" colspan="2"><b>Leave the shipping address blank if it is the same as the billing address.</b></td>
  </tr>
  <tr>
    <td class="style2">Shipping Address Line 1: </td>
    <td class="style2"><input type="text" name="SA1"  size="50"></td>
  </tr>
  <tr>
  <tr>
    <td class="style2">Shipping Address Line 2: </td>
    <td class="style2"><input type="text" name="SA2"  size="50"></td>
  </tr>
  <tr>
  <tr>
    <td class="style2">Shipping City: </td>
    <td class="style2"><input type="text" name="SCity"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Shipping State (Province): </td>
    <td class="style2"><input type="text" name="SState"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Shipping Postal Code: </td>
    <td class="style2"><input type="text" name="SPCode"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Shipping Country: </td>
    <td class="style2"><input type="text" name="SCountry"  size="50"></td>
  </tr>
  <tr>
    <td class="style2">Payment Method: </td>
    <td class="style2">
      <select size="1" name="PMethodID">
      <option value=99999>--Select Primary Payment Method--</option>
        <%
        // declare a connection
	Connection con = null; 
        try{
          // open a connection
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
	  // Complete the con = in Ln156 (below) to open a connection.
          con = DriverManager.getConnection(ConnString);
           //
           {
            // create a prepared sql statement
            // Complete PreparedStatement prep =  and prep.setString();in Ln162 to 
	    // execute sp5DYourAccountName with no parameter.
            PreparedStatement prep = con.prepareStatement("EXECUTE sp5DF14ctdecker2727");
            // execute the query
            ResultSet rs = prep.executeQuery();
            // display the results in an html table
            while(rs.next())
            {
             out.println("<option value="+rs.getString("PaymentMethodID")+">");  // PaymentMethodID
             out.println(rs.getString("PaymentMethod")+"</option>");  // PaymentMethod          
            }
            prep.close();    // close the prepared statement                  
           }
           con.close(); // close the connection
          }
          catch(Exception ex)
          {
           out.println("Sorry, system is not currently available<br/>");
           out.println(ex.toString());
          }
        %>
     </select>
</td>
  </tr>
</table>
<p>
  <input type="submit" name="Submit" value="Add">
</p>
</form>
</body>
</html>