<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="co.jp.netwisdom.dto.UserInfoAndHobbyDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<% UserInfoAndHobbyDto dto = (UserInfoAndHobbyDto)request.getAttribute("dto"); %>
<title>用戶註冊信息</title>

</head> 


<body>
	
<%if(dto==null){ %>

	
	<form action="userReg" method="get">
		<label for="username">姓名:</label>
		<input type="text" id="username" name="username"/>
		<br>
		<label for="password">密碼:</label>
		<input type="password" id="password" name="password" />
		<br>
		<label for="sex">性別:</label>
		<input type="radio" id="sex1" name="sex" value="0" />Male
		<input type="radio" id="sex2" name="sex" value="1" />Female
		<br>
		<label for="major">專業:</label>
		<select id="major" name="major">
			<option value="">-</option>
			<option value="0">計算機</option>
			<option value="1">英語</option>
			<option value="2">數學</option>
		</select>
		<br>
		<input type="checkbox" id="hobby1" name="hobby" value="0" />
		<label for="hobby1">足球</label>
		<input type="checkbox" id="hobby2" name="hobby" value="1" />
		<label for="hobby2">籃球</label>
		<input type="checkbox" id="hobby3" name="hobby" value="2" />
		<label for="hobby3">網球</label>
		<br>
		<textarea name="intro">Tiger</textarea>
		<br>
		<input type="submit" value="Submit" />
		<input type="reset" value="Reset" />
	</form>
	
<%}else{%>

	<form action="update" method="get">
		<label for="username">姓名:</label>
		<input type="text" id="username" name="username" readonly value="<%=dto.getUsername() %>" />
		<br>
		<label for="password">密碼:</label>
		<input type="password" id="password" name="password" value="<%=dto.getPassword() %>" />
		<br>
		<label for="sex">性別:</label>
		<input type="radio" id="sex1" name="sex" value="0" <%=dto.getSex().equals("0")?"checked":"" %> />Male
		<input type="radio" id="sex2" name="sex" value="1" <%=dto.getSex().equals("1")?"checked":"" %> />Female
		<br>
		<label for="major">專業:</label>
		<select id="major" name="major">
			<option value="">-</option>
			<option value="0" <%=dto.getMajor().equals("0")?"selected":"" %>>計算機</option>
			<option value="1" <%=dto.getMajor().equals("1")?"selected":"" %>>英語</option>
			<option value="2" <%=dto.getMajor().equals("2")?"selected":"" %>>數學</option>
		</select>
		<br>
		<input type="checkbox" id="hobby1" name="hobby" value="0" <%=dto.getHobbyList().contains("0")?"checked":"" %>/>
		<label for="hobby1">足球</label>
		<input type="checkbox" id="hobby2" name="hobby" value="1" <%=dto.getHobbyList().contains("1")?"checked":"" %>/>
		<label for="hobby2">籃球</label>
		<input type="checkbox" id="hobby3" name="hobby" value="2" <%=dto.getHobbyList().contains("2")?"checked":"" %>/>
		<label for="hobby3">網球</label>
		<br>
		<textarea name="intro"><%=dto.getIntro() %></textarea>
		<br>
		<input type="submit" value="Update" />
		<input type="reset" value="Reset" />
	</form>
	
<%} %>

</body>
</html>