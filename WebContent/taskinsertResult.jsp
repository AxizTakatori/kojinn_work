<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録結果確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
<%-- 	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="index.jsp"/>
	</c:if> --%>


<p>実行者：${loginname}</p>
<p>正常に登録されました</p>
<form action="search">
  <input type="submit" value="タスク一覧に戻る">
</form>

</body>
</html>
