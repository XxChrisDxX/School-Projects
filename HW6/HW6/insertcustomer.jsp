<%-- 
    Document   : insertcustomer
    Created on : 
    Author     : 
Complete the include file= in Ln7 to include the content of the Connection.jsp file in the Connection folder.
--%>
<%@ include file= "Connection/Connection.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
        <%
        try{
          // open a connection
          Connection con = null; 
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
	  // Complete the con = in Ln17 (below) to open a connection.
          con = DriverManager.getConnection(ConnString);
           //
           // get the parameters from the html form
           String UID = (String) session.getAttribute("UID");
           
           if(UID != null)
           {
           // get the parameters from the html form
           String CName = request.getParameter("CName");
           String BA1 = request.getParameter("BA1");
           String BA2 = request.getParameter("BA2");
           String BCity = request.getParameter("BCity");
           String BState = request.getParameter("BState");
           String BPCode = request.getParameter("BPCode");
           String BCountry = request.getParameter("BCountry");
           String SA1 = request.getParameter("SA1");
           String SA2 = request.getParameter("SA2");
           String SCity = request.getParameter("SCity");
           String SState = request.getParameter("SState");
           String SPCode = request.getParameter("SPCode");
           String SCountry = request.getParameter("SCountry");
           String PMethodID = request.getParameter("PMethodID");
           if(CName != null)
          	 {
            	// create a prepared sql statement
                // Complete PreparedStatement prep =  and prep.setString();in Ln45 through Ln60 to 
	        // execute sp5EYourAccountNameTran with 15 parameters "CName", "BA1", "BA2", "BCity", "BState", "BPCode", "BCountry".
	        // "SA1", "SA2", "SCity", "SState", "SPCode", "SCountry", "PMethodID", and "UID".
            	PreparedStatement prep = con.prepareStatement("EXECUTE sp5EF14ctdecker2727TRAN ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
           	prep.setString(1, CName);
            	prep.setString(2, BA1);
           	prep.setString(3, BA2);
            	prep.setString(4, BCity);
            	prep.setString(5, BState);
            	prep.setString(6, BPCode);
            	prep.setString(7, BCountry);
            	prep.setString(8, SA1);
            	prep.setString(9, SA2);
            	prep.setString(10, SCity);
            	prep.setString(11, SState);
            	prep.setString(12, SPCode);
            	prep.setString(13, SCountry);
            	prep.setString(14, PMethodID);
            	prep.setString(15, UID);
            	// execute the query
            	ResultSet rs = prep.executeQuery();
            	// display the results in an html table
            	prep.close();    // close the prepared statement                  
          	 }
           con.close(); // close the connection
           response.sendRedirect("actwelcome.jsp");  
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
