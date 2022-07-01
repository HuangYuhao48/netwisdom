<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>用戶註冊信息</title>

</head> 


<body>
	<form action = "userSearch" method = "get">
		<label for = "username">姓名:</label>
		<input id="username" name="username">
		<br>
		<label for = "password">性别:</label>
		<input type="radio" name="sex" checked  id="sex1" value="0">男
		<input type="radio"  name="sex" id="sex2"  value="1">女
		<br>
		<br>
		<label for = "major">專業:</label>
		<select id="major" name= "major">
			<option value="0">-</option>
			<option value="1">軟件工程</option>
			<option value="2" >英語</option>
			<option value="3">數學</option>
		</select>
		<br>
		<input type="submit" value="檢索"> 
		<br><br>
		檢索一覽
		<hr>
	</form>
</body>
</html>