<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name1", "JAY");
		application.setAttribute("name", "app");
		pageContext.setAttribute("name", "page");
		session.setAttribute("name", "session");
	%>

	${name1}
	<%--JAY --%>
	${pageScope.name}
	<%--page --%>
	${requestScope.name} ${sessionScope.name}
	<%--session --%>
	${applicationScope.name}
	<%--app --%>

	<%
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(0);
		list.add(6);
		request.setAttribute("list1", list);
	%>

	${list1[2]}
	<%--6 --%>

	<%
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		request.setAttribute("map1", map);
	%>

	${map1.a}
	<%--1 --%>


	${2==2 }
	<%--true --%>
	${2>3 }
	<%--flase --%>

	<%--是否被定义过，被定义过就是非空 --%>
	${empty map1 }
	<%--false --%>
	${empty name }
	<%--false --%>
	${empty num}
	<%--true --%>
</body>
</html>
