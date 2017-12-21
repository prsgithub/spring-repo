<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="../common/commonTagLib.jsp" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>


<%@ include file="../common/commonCssLib.jsp" %>
<%@ include file="../common/commonJsLib.jsp" %>
</head>
<body>
 
	<table border="1" width="1365" >
	<thead >
		<tr height="50" valign="top">
			<td><tiles:insertAttribute name="header" /></td>
		</tr>
	</thead>
	<tbody>
		<tr  height="550"  valign="top" >
			<td><tiles:insertAttribute name="content" /></td>
		</tr>
	</tbody>
	<tfoot>
		<tr height="50"  valign="bottom">
			<td><tiles:insertAttribute name="footer" /></td>
		</tr>
	</tfoot>
	</table>
 
</body>
</html>