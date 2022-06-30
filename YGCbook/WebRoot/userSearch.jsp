<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>用戶註冊信息</title>

</head> 


<body>
	<form action = "userReg" method = "get">
		<label for = "username">姓名:</label>
		<input id="username" name="username">
		<br>
		<label for = "password">密码:</label>
		<input type="password" id="password" name="password">
		<br>
		<label for = "password">性别:</label>
		<input type="radio" name="sex" checked  id="sex1" value="0">男
		<input type="radio"  name="sex" id="sex2"  value="1">女
		<br>
	       爱好:
		<input type="checkbox" id = "hobby1" name="hobby" value="0">
		<label for = "hobby1">足球</label>
		<input type="checkbox" id = "hobby2" name="hobby" value="1">
		<label for = "hobby2">篮球</label>
		<input type="checkbox" id = "hobby3" name="hobby" value="2">
		<label for = "hobby3">网球</label>
		<br>
		<label for = "major">专业:</label>
		<select id="major" name= "major">
			<option value="0">-</option>
			<option value="1">软件工程</option>
			<option value="2" >英语</option>
			<option value="3">数学</option>
		</select>
		<br>
		<label for = "intro">简介:</label>
		<br>
		<textarea id="intro" name = "intro">Start</textarea>
		<br>
		
		<input type="submit" value="注册用户"> 
		<input type="reset" value="重置">
	</form>
</body>
</html>