<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>你好</title>
</head>
<body>
	<%
		pageContext.setAttribute("sayhello", "HelloWorld");
	%>
	${sayhello }
	<c:out value="${ sayhello}"></c:out>
	<br>

	<c:catch var="e">
${name }
</c:catch>
	${e.message }

	<%
		pageContext.setAttribute("job", "teacher");
	%>
	<c:if test="${job=='teacher' }">
	你是一個老師
	</c:if>


	<%
		pageContext.setAttribute("hobby", "basketball");
	%>

	<c:choose>
		<c:when test="${hobby=='basketball' }">
	你喜歡打籃球
	</c:when>
		<c:when test="${hobby=='football' }">
	你喜歡踢足球
	</c:when>
		<c:when test="${hobby=='volleyball' }">
	你喜歡打排球
	</c:when>
		<c:otherwise>
	你沒什麽喜歡的
	</c:otherwise>
	</c:choose>
	
	<%Object[] country={"中國","美國","日本"};
	pageContext.setAttribute("country", country);
	%>
	<c:forEach items="${country }" var="c">
	${c }
	<br>
	</c:forEach>
	
	<%Set<Integer> s=new HashSet<Integer>();
	s.add(1);
	s.add(2);
	s.add(6);
	pageContext.setAttribute("set", s);
	%>
	<c:forEach items="${set }" var="s">
	${s }
	</c:forEach>
	
	<%Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	map.put(1, 1);
	map.put(2, 2);
	map.put(3, 3);
	pageContext.setAttribute("map", map);
	%>
	
	<c:forEach items="${map }" var="m">
	${m }
	<br>
	</c:forEach>
	<br>

</body>
</html>
