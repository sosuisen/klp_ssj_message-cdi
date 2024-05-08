<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メッセージアプリ</title>
</head>
<body>
	<form action="./" method="post">
		メッセージ: <input type="text" name="body">
		<button name="action" value="add">送信</button><br>
		<button name="action" value="clear">クリア</button>
	</form>
	<hr>
	<h1>メッセージ一覧</h1>
	<br>
	<c:forEach var="mes" items="${ historyDTO }">
	  ${ mes.body } (${ mes.createdDate })<br />
	</c:forEach>
</body>
</html>
