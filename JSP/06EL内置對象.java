<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${pageContext.request}<br>  <%--org.apache.catalina.connector.RequestFacade@4f36d736 --%>
${pageContext.request.contextPath }<br>  <%--/jsp --%>

<form action="${pageContext.request.contextPath }/login.jsp"></form>  <%--<form action="/jsp/login.jsp"></form> --%>

${param.name }<br>
${paramValues.hobby[0]}<br>
</body>
</html>
