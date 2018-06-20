<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>


	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
<%-- 	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="index.jsp"/>
	</c:if>
 --%>
<p>これでよろしいですか？</p>

<form action="insertConfirm" method="post">
  <fieldset class="label-110">

      <div>
      <label>id</label><input type="text" name="tel" value="${newid} "readonly>
    </div>

    <div>
      <label>名前</label><input type="text" name="name" value="${newname}" readonly>
    </div>

    <div>
      <label>PASS（再入力）</label><input type="password" name="rePass">
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="登録">
    <input type="submit" name="button" value="戻る" onclick="location.href='insert.jsp'; return false;">
  </div>

  	<c:if test="${not empty msg}">
		<p class = "error">${msg}</p>
		</c:if>

</form>
<div>
  <a href="index.jsp">メニューに戻る</a>
</div>
</body>
</html>
