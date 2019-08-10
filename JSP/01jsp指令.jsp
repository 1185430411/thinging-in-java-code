<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import=" java.util.*,java.lang.*"%>

<%--当页面发生错误时，跳转至该界面，需自己额外书写 --%>
<%@page errorPage="/error.jsp"%>

<%--session默认为可用（true） --%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%--JSP注释不会在网站源码中显示出来 --%>
	<!-- html标签会在网站源码中显示出来 -->
	<%--  <%%>里面不能写方法。因为其本身就是在Servlet中的一个方法内 --%>
	<%
		Date d = new Date();
		out.write(d.toLocaleString());
		int i = 666;
		out.write(i);
	%>


	<%--   <%!%> 标签内的java语句可以书写方法 --%>
	<%!public void print() {
		System.out.println("HelloWorld");
	}%>

	<%--  <%=%> 标签内的常量直接被输出到网页上  --%>
	<%="HelloWorld"%>

	<%=10%>


</body>
</html>
