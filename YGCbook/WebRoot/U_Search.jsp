<%@page import="co.jp.netwisdom.dto.UserInfoAndHobbyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="co.jp.netwisdom.dto.UserInfoAndHobbyDto"%>    
 <%@page import="java.util.List"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>For User Search</title>
<% List<UserInfoAndHobbyDto> dtos = (List<UserInfoAndHobbyDto>)request.getAttribute("dtos"); %>
</head>
<body>
	<form action="search" method="get">
		<label for="username">姓名:</label>
		<input type="text" id="username" name="username"/>
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
		<input type="submit" value="Submit" />
		<input type="reset" value="Reset" />
	</form>
	<hr>
	
	<table border="1">
		<tr style="background-color:yellow">
			<th>姓名</th>
			<th>性別</th>
			<th>專業</th>
			<th>愛好</th>
			<th>簡介</th>
		</tr>
		<% if(dtos!=null){ %>
		
			<% int i = 0; %>
			<% for(UserInfoAndHobbyDto dto : dtos){ %>
				<% i++; %>
				<tr style="background-color:<%=i%2==1? "lightblue":"pink" %>" >
					<td><a href="userInit?username=<%=dto.getUsername() %>"><%=dto.getUsername() %></a></td>
					<td><%=dto.getSex().replace("0", "男").replace("1", "女") %></td>
					<td><%=dto.getMajor().replace("0", "計算機").replace("1", "英語").replace("2", "數學") %></td>
					<td>
						<%=dto.getHobbyList().contains("0")?"足球":"" %>
						<%=dto.getHobbyList().contains("1")?"籃球":"" %>
						<%=dto.getHobbyList().contains("2")?"網球":"" %>
					</td>
					<td><%=dto.getIntro() %></td>
				</tr>
			<%} %>
		<%} %>
	</table>
	
</body>
</html>