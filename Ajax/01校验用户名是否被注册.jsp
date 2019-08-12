<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="java.util.*"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	用户名:
	<input type="text" name="username" id="username">
	<span id="msg"></span>

</body>
<script type="text/javascript">
	window.onload = function() {
		var nameElement = document.getElementById("name");
		//绑定onblur事件
		nameElement.onblur = function() {
			//this等价于nameElement
			var name = this.value;
			//创建XMLHttpRequest对象
			var xhr;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xhr = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
			//注册回调函数
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {//请求一切正常
					if (xhr.status == 200) {//服务器响应一切正常
						var msg = document.getElementById("msg");
						if (xhr.responseText == "true") {
							msg.innerHTML = "<font color='red'>用户名已存在</font>";

						} else {
							msg.innerHTML = "可以使用";
						}
					}
				}
			}

			//创建连接
			xhr.open("get", "${pageContext.request.contextPath }/regist?name="
					+ name);
			//发送请求
			xhr.send(null);
		}

	}
</script>
</html>
