<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="co.jp.netwisdom.dto.UserInfoAndHobbyDto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html>
<head>
<% UserInfoAndHobbyDto dto = (UserInfoAndHobbyDto)request.getAttribute("dto"); %>
<title>用戶註冊信息</title>

<script>
function changeActionName(actionName){
	document.getElementById("form").action=actionName;
}

function executeAjax(){
	$.ajax({
		url : 'userNameCheck.do?username=' + document.getElementById("username").value, 
		type : 'post', //數據發送方式
		dataType : 'text', //接收數據格式
		error : function(flag){
		},
		async :true,
		success : function(flag){
			if(flag=="0"){
				//未註冊
				document.getElementById("flag").innerHTML="";	
				document.getElementById("regButton").disabled = false;
			}else{
				//已註冊
				document.getElementById("flag").innerHTML="用戶名已經存在!";
				document.getElementById("regButton").disabled = true;
			}
		}
	});
}

</script>
<script src="jquery-3.2.1.min.js">



</script>

</head> 


<body>
	
<%if(dto==null){ %>

	
	<form action="userReg.do" method="get">
		<label for="username"> <bean:message bundle="userResource" key="username"/>:</label>
		<input type="text" id="username" name="username" onblur="executeAjax()"  /><font color="red" id="flag"></font>
		<br>
		<label for="password"> <bean:message bundle="userResource" key="password"/>:</label>
		<input type="password" id="password" name="password" />
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
		<input type="checkbox" id="hobby1" name="hobby" value="0" />
		<label for="hobby1"> <bean:message bundle="userResource" key="soccer"/></label>
		<input type="checkbox" id="hobby2" name="hobby" value="1" />
		<label for="hobby2"> <bean:message bundle="userResource" key="basketball"/></label>
		<input type="checkbox" id="hobby3" name="hobby" value="2" />
		<label for="hobby3"> <bean:message bundle="userResource" key="tennis"/></label>
		<br>
		<textarea name="intro">Tiger</textarea>
		<br>
		<input type="submit" value="Register" id="regButton"/>
		<input type="reset" value="Reset" />
	</form>
	
<%}else{%>

	<form action="update.do" method="get" id="form">
		<label for="username"><bean:message bundle="userResource" key="username"/>:</label>
		<input type="text" id="username1" name="username" readonly value="<%=dto.getUsername() %>" />
		<br>
		<label for="password"> <bean:message bundle="userResource" key="password"/>:</label>
		<input type="password" id="password" name="password" value="<%=dto.getPassword() %>" />
		<br>
		<label for="sex"> <bean:message bundle="userResource" key="sex"/>:</label>
		<input type="radio" id="sex1" name="sex" value="0" <%=dto.getSex().equals("0")?"checked":"" %> />Male
		<input type="radio" id="sex2" name="sex" value="1" <%=dto.getSex().equals("1")?"checked":"" %> />Female
		<br>
		<label for="major"> <bean:message bundle="userResource" key="major"/>:</label>
		<select id="major" name="major">
			<option value="">-</option>
			<option value="0" <%=dto.getMajor().equals("0")?"selected":"" %>> <bean:message bundle="userResource" key="software"/></option>
			<option value="1" <%=dto.getMajor().equals("1")?"selected":"" %>> <bean:message bundle="userResource" key="english"/></option>
			<option value="2" <%=dto.getMajor().equals("2")?"selected":"" %>> <bean:message bundle="userResource" key="math"/></option>
		</select>
		<br>
		<input type="checkbox" id="hobby1" name="hobby" value="0" <%=dto.getHobbyList().contains("0")?"checked":"" %>/>
		<label for="hobby1"> <bean:message bundle="userResource" key="soccer"/></label>
		<input type="checkbox" id="hobby2" name="hobby" value="1" <%=dto.getHobbyList().contains("1")?"checked":"" %>/>
		<label for="hobby2"> <bean:message bundle="userResource" key="basketball"/></label>
		<input type="checkbox" id="hobby3" name="hobby" value="2" <%=dto.getHobbyList().contains("2")?"checked":"" %>/>
		<label for="hobby3"> <bean:message bundle="userResource" key="tennis"/></label>
		<br>
		<textarea name="intro"><%=dto.getIntro() %></textarea>
		<br>
		<input type="submit" value="Update" onclick="changeActionName('update.do')"/>
		<input type="submit" value="Delete" onclick="changeActionName('delete.do')"/>
		<input type="reset" value="Reset" />
	</form>
	
<%} %>

</body>
</html>