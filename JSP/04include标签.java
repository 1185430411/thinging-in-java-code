<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int num=50;%>
1.num=<%=num %>
<jsp:include page="/two.jsp"></jsp:include>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int num=100;%>
2.num=<%=num %>
</body>
</html>


<%--实际上include是生成了两个java文件，所以定义变量可以允许重名。而forward不行-->
