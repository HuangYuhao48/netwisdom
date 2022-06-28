<html>
<head>
<title>课后练习题</title>

</head> 


<body>
	<form action = "useRegister">
		姓名:<input id="username" name="username"><br>
		密码:<input type="password" id="password"><br>
		性别:<input type="radio" name="sex" checked  id="sex1" value="0">男<input type="radio"  name="sex" id="sex2"  value="1">女<br>
		爱好:<input type="checkbox" name="hobby" value="0">足球<input type="checkbox" name="hobby" value="1">篮球<input type="checkbox" name="hobby" value="2">网球<br>
		专业:<select id="major" name= "major">
			<option value="0">软件工程</option>
			<option value="1" >英语</option>
			<option value="2">数学</option>
		</select><br>
		简介:<br><textarea id="intro" name = "intro">abcd</textarea><br>
		
		<input type="submit" value="注册用户"> 
		<input type="button" value="重置">
	</form>
</body>
</html>