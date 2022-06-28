<html>
<head>
<title>课后练习题</title>

</head> 


<body>
	<form action = "useRegister">
		<label for = "username">姓名:</label>
		<input id="username" name="username">
		<br>
		<label for = "password">密码:</label>
		<input type="password" id="password">
		<br>
		<label for = "password">性别:</label>
		<input type="radio" name="sex" checked  id="sex1" value="0">男
		<input type="radio"  name="sex" id="sex2"  value="1">女
		<br>
	       爱好:
		<input type="checkbox" id = "hobby1" name="hobby" value="0">足球
		<label for = "hobby1">足球</label>
		<input type="checkbox" id = "hobby2" name="hobby" value="1">篮球
		<label for = "hobby2">篮球</label>
		<input type="checkbox" id = "hobby3" name="hobby" value="2">网球
		<label for = "hobby3">网球</label>
		<br>
		<label for = "major">专业:</label>
		<select id="major" name= "major">
			<option value="0">软件工程</option>
			<option value="1" >英语</option>
			<option value="2">数学</option>
		</select>
		<br>
		<label for = "intro">简介:</label>
		<br>
		<textarea id="intro" name = "intro">abcd</textarea>
		<br>
		
		<input type="submit" value="注册用户"> 
		<input type="reset" value="重置">
	</form>
</body>
</html>