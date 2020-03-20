<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<input type="button" value="添加" onclick="add()">
<form action="${pageContext.request.contextPath}/list" method="post">
	类型：<select id="tid" name="tid">
		<option value="0"></option>
		<option value="1">测试</option>
		<option value="2">试驾</option>
		<option value="3">购买</option>
	</select>
	视频日期：<input type="date" value="${carVo.startDate }" name="startDate">到
	<input type="date" value="${carVo.endDate }" name="endDate">
	标题：<input type="text" value="${carVo.title }" name="title" id="title">
	
	<button>搜索</button>
</form>
<body>
<table>
	<tr>
		<td>编号</td>
		<td>日期</td>
		<td>标题</td>
		<td>类型</td>
		<td>视频</td>
		<td>修改</td>
	</tr>
	<c:forEach items="${info.list }" var="c">
		<tr>
			<td>${c.id }</td>
			<td>${c.vdate }</td>
			<td>${c.title }</td>
			<td>${c.tname }</td>
			<td>${c.url }</td>
			<td><input type="button" value="修改" onclick="upd(${c.id})"></td>
		</tr>
	</c:forEach>
	<tr>
		<td>
		<jsp:include page="/WEB-INF/view/pages2.jsp"></jsp:include>
		<td>
	</tr>
</table>
</body>
<script type="text/javascript">
	function goPage(page) {
		location="${pageContext.request.contextPath}/list?pageNum="+page
	}
	function add() {
		location="${pageContext.request.contextPath}/add";
	}
</script>
</html>