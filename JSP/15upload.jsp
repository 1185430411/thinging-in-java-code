<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form enctype="multipart/form-data"
		action="${pageContext.request.contextPath }/upload" method="post">
		<input type="file" name="photo" /><br /> <input type="submit"
			value="上传" /><br />
	</form>
</body>
</html>
