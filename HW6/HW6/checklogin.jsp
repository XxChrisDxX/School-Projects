<%-- 
    Document   : checklogin
    Created on : 
    Author     : 
Complete the include file= in Ln7 to include the content of the Connection.jsp file in the Connection folder.
--%>
<%@ include file="Connection/Connection.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
//setMaxInteractiveInterval(int 60);
        try{
          // open a connection
          Connection con = null; 
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
	  // Complete the con = in Ln17 (below) to open a connection.
          con = DriverManager.getConnection(ConnString);
          //
          // get the parameters from the html form
          String UName = request.getParameter("txtUName");
          String UPwd = request.getParameter("txtUPwd");
          if(UName != null && UPwd != null)
           {
            // create a prepared sql statement
            // Complete PreparedStatement prep =  and prep.setString();in Ln27, 28 and 29 to 
	    // execute sp5AYourAccountName with parameters "UName" and "UPwd".
            PreparedStatement prep = con.prepareStatement("EXECUTE sp5AF14ctdecker2727 ?, ?");
            prep.setString(1, UName);
            prep.setString(2, UPwd);
            // execute the query
            ResultSet rs = prep.executeQuery();
	    rs.next();
	    int EID = rs.getInt("EmployeeID");
	    int JID = rs.getInt("JobPositionID");
	    if (EID < 0)
		{
		prep.close();    // close the prepared statement
		con.close(); // close the connection
		response.sendRedirect("forgotpwd.jsp");
		}
	    else
		{
		if (EID > 0 && JID == 2) 
			{
			session.setAttribute ("UID", rs.getString("EmployeeID"));
			prep.close();    // close the prepared statement
			con.close(); // close the connection
			response.sendRedirect("actwelcome.jsp");
			}
		else
			{

			session.setAttribute ("UID", rs.getString("EmployeeID"));
			prep.close();    // close the prepared statement
			con.close(); // close the connection
			response.sendRedirect("otherwelcome.jsp");
			}
		}
	    }
	  }
          catch(Exception ex)
          {
           out.println("Sorry, system is not currently available<br/>");
           out.println(ex.toString());
          }
%>