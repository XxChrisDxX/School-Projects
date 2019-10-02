<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>ISM3212 Fall 2014 HW6: Log In Page</title>
<style type="text/css">
<!--
.style1 {
	font-size: 12px;
	font-family: Arial, Helvetica, sans-serif;
}
-->
</style>
</head>

<body>
<form action="checklogin.jsp" method="post" name="form1" class="style1">
  <table width="386" border="0" class="style1">
    <tr>
      <td colspan="2" width="378" bgcolor="#000080" >
        <h4 align="center"><font color="#FFFFFF"><b>ISM3212 Fall2014 HW6: Log In Page<br>
	<!--Replace Your Name in the next line with your name -->
	Created by Chris Decker</b></font></h4></td>
    </tr>
    <tr>
      <td width="109" ><div align="right">User Name:</div></td>
      <td width="263" ><input type="text" name="txtUName"></td>
    </tr>
    <tr>
      <td width="109"><div align="right">Password:</div></td>
      <td width="263"><input type="password" name="txtUPwd"></td>
    </tr>
    <tr>
      <td width="109"><div align="right">
      </div></td>
      <td width="263"><input type="submit" name="submit" value="Log In">
      <input type="reset" name="Reset" value="Clear"></td>
    </tr>
    <tr>
      <td colspan="2" width="378"><div align="center"><a href="forgotpwd.jsp">Did you forget your password? Contact the network adminstrator.</a></div></td>
    </tr>
  </table>
</form>
</body>
</html>
