<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<%-- 	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="index.jsp"/>
	</c:if> --%>

	<c:if test="${not empty msg}">
		<p class="error">${msg}</p>
	</c:if>
	<p>
		登録情報を入力してください<br> <span class="required"></span>は必須です
	</p>

	<form action="insert" method="post">
		<fieldset class="label-60">

			<div>
				<label class="required">id</label><input type="text" name="id">
			</div>

			<div>
				<label class="required">名前</label><input type="text" name="name">
			</div>

			<div>
				<label class="required">PASS</label><input type="password"
					name="pass">
			</div>
		</fieldset>
		<input type="submit" value="確認">
	</form>
	<div>
		<a href="index.jsp">戻る</a>
	</div>
</body>
</html>
