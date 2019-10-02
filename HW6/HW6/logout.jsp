<%
session.setAttribute ("UID", null);
session.invalidate();
response.sendRedirect("login.jsp");
%>
