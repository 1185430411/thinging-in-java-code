<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>你好</title>
</head>
<body>

	<%
		Date date = new Date();
		pageContext.setAttribute("date", date);
	%>

	<fmt:formatDate value="${date }" pattern="yyyy-MM-dd" />
	<br>
	<fmt:formatDate value="${date }" var="newdate" pattern="yyyy-MM-dd" />
	<br> ${newdate}

	<%
		String time = "2010-08-11";
		pageContext.setAttribute("time", time);
	%>
	<fmt:parseDate value="${time }" pattern="yyyy-MM-dd"></fmt:parseDate>
</body>
</html>
