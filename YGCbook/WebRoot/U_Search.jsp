<%@page import="co.jp.netwisdom.dto.UserInfoAndHobbyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="co.jp.netwisdom.dto.UserInfoAndHobbyDto"%>    
 <%@page import="java.util.List"%>   
 <%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script>
function changeToUpdatePage(username){
	window.location="userInit.do?username=" + username;
}
function delUser(username){
	window.location="delete.do?username=" + username;
}

function allChecked(){
	if(document.getElementById("allPicked").checked){
		var checkBox = document.getElementsByName("check");
		for(var i=0 ; i < checkBox.length ; i++){
			checkBox[i].checked = true;
		}
	}
	if(document.getElementById("allPicked").checked==false){
		var checkBox = document.getElementsByName("check");
		for(var i=0 ; i < checkBox.length ; i++){
			checkBox[i].checked = false;
		}
	}
}



function delAll(){
	document.getElementById("form").action = 'delAll.do';
}



/*(function allChecked(){
	
	alert('123');
	if(document.getElementById("allPicked").checked){
		
		var checkBox = document.getElementsByName("checkit");
		
		for(var i=0 ; i<checkBox.length ; i++){
			checkBox[i].checked = true;
			alert('123');
		}
	}else{
		var checkBox = document.getElementsByName("checkit");
		
		for(var i=0 ; i<checkBox.length ; i++){
			checkBox[i].checked = false;
	}
	
}*/
	



</script>

<title>For User Search</title>
<% List<UserInfoAndHobbyDto> dtos = (List<UserInfoAndHobbyDto>)request.getAttribute("dtos"); %>
</head>
<body>
	<form action="search.do" method="get" id="form">
		<label for="username"><bean:message bundle="userResource" key="username"/>:</label>
		<input type="text" id="username" name="username"/>
		<br>
		<label for="sex"> <bean:message bundle="userResource" key="sex"/>:</label>
		<input type="radio" id="sex1" name="sex" value="0" />Male
		<input type="radio" id="sex2" name="sex" value="1" />Female
		<br>
		<label for="major"> <bean:message bundle="userResource" key="major"/>:</label>
		<select id="major" name="major">
			<option value="">-</option>
			<option value="0"> <bean:message bundle="userResource" key="software"/></option>
			<option value="1"> <bean:message bundle="userResource" key="english"/></option>
			<option value="2"> <bean:message bundle="userResource" key="math"/></option>
		</select>
		<br>
		<input type="submit" value="Submit" />
		<input type="reset" value="Reset" />
	
	<hr>
	
	<table border="1">
		<tr style="background-color:yellow">
			<th style="width:5"><input type="checkbox" id="allPicked" onclick="allChecked()"></th>
			<th> <bean:message bundle="userResource" key="username"/></th>
			<th> <bean:message bundle="userResource" key="sex"/></th>
			<th> <bean:message bundle="userResource" key="major"/></th>
			<th> <bean:message bundle="userResource" key="hobby"/></th>
			<th>簡介</th>
			<th style="width:20">更新</th>
			<th style="width:20">刪除</th>
		</tr>
		<% if(dtos!=null){ %>
		 
			<% int i = 0; %>
			<% for(UserInfoAndHobbyDto dto : dtos){ %>
				<% i++; %>
				<tr style="background-color:<%=i%2==1? "lightblue":"pink" %>" >
					<td style="width:5" align="center"><input type="checkbox" name="check" value="<%=dto.getUsername() %>"></td>
					<td><a href="userInit.do?username=<%=dto.getUsername() %>"><%=dto.getUsername() %></a></td>
					<td><%=dto.getSex().replace("0", "男").replace("1", "女") %></td>
					<td><%=dto.getMajor().replace("0", "計算機").replace("1", "英語").replace("2", "數學") %></td>
					<td>
						<%=dto.getHobbyList().contains("0")? "足球":"" %>
						<%=dto.getHobbyList().contains("1")?"籃球":"" %>
						<%=dto.getHobbyList().contains("2")?"網球":"" %>
					</td>
					<td><%=dto.getIntro() %></td>
					<td style="width:20"><input type="button" onClick="changeToUpdatePage('<%=dto.getUsername()%>')" value="更新"></td>
					<td style="width:20"><input type="button" onClick="delUser('<%=dto.getUsername()%>')" value="刪除" ></td>
				</tr>
				
			<%} %>
		<%} %>
				<tr bgcolor="yellow" align="center">
					<td colspan="8"><input type="submit" value="全部刪除" onclick="delAll()" ></td>
				</tr>
	</table>
	</form>
</body>
</html>