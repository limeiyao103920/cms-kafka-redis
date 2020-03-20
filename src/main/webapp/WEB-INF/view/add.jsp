<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 引入 css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/bootstrap.css">
<!-- 引入js -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/jquery-3.2.1.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/add" method="post">
	视频日期：<input type="date" name="vdate" id="vdate">
	类型：<select id="tid" name="tid">
		<option value="0"></option>
		<option value="1">测试</option>
		<option value="2">试驾</option>
		<option value="3">购买</option>
	</select><br>
	标题：<input type="text" name="title" id="title"><br>
	视频：<input type="text" name="url" id="url">
	<button>提交</button>
</form>
</body>
</html>