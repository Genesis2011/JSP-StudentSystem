<%@page import="sdut.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>用户信息修改</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" /> 
</head>
	<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String type=(String)request.getSession().getAttribute("type");
		String name="";
		if(session.getAttribute("who")==null){
			response.sendRedirect("login.jsp");
		}
		else{
			name=((User)session.getAttribute("who")).getName();
		}
	%>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader"></div>
				<div id="topheader">
					<h1 id="title">
						<a href="UserSelect.jsp">用户管理系统</a>
					</h1>
				</div>
				<div id="navigation" align="right">
					<a href="StudentSelect.jsp">学生管理</a>
					<a href="StudentScoreSelect.jsp">成绩管理</a>
					<a href="GradeSelect.jsp">班级管理</a>
					<a href="LogoutControl">注销</a> <span
						style="font-family: '微软雅黑'; font-size: 14px"> <div id="userfont">当前用户: <%=name %> </div> </span>
					<span id="admin_name" style="font-family: '微软雅黑'; font-size: 14px"
						；font-color:white;> </span>
				</div>
			</div>
			<form action="UserUpdateControl" method="post" id="content">
				<p id="whereami"></p>
				<h1>修改用户信息:</h1>
				<%
						List<User> list =(List<User>)request.getAttribute("list");
						for(User s: list){
				%>
				<input type="hidden" name="no" value="<%-- <%=stu.getNo()%> --%>" />
				<table cellpadding="0" cellspacing="0" border="0" class="form_table">
					<tr>
						<td valign="middle" align="right">用户编号:</td>
						<td valign="middle" align="left"><%=s.getId()%><input name="id" type="hidden"
							class="inputgri"  value="<%=s.getId()%>"/></td>
					</tr>
					<tr>
						<td valign="middle" align="right">用户姓名:</td>
						<td valign="middle" align="left"><input name="name"
							type="text" class="inputgri" value="<%=s.getName()%>"/></td>
					</tr>
					<tr>
						<td valign="middle" align="right">用户密码:</td>
						<td valign="middle" align="left"><input name="password"
							type="text" class="inputgri" value="<%=s.getPassword()%>"/> 
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">用户年龄:</td>
						<td valign="middle" align="left"><input name="age"
							type="text" class="inputgri" value="<%=s.getAge()%>"/></td>
					</tr>
					<tr>
						<td valign="middle" align="right">用户电话:</td>
						<td valign="middle" align="left"><input name="phone"
							type="text" class="inputgri" value="<%=s.getPhone()%>"/></td>
					</tr>
				</table>
				<%} %>
				<p>
					<input type="submit" id="updatebook" class="button" value="提交" />
					<a href="UserSelect.jsp">
						<input type="button" class="button" value="取消" onclick="window.location.href('UserSelect.jsp')">
					</a> 
				</p>
			</form>
		</div>

		<div id="footer" align="center">
			<div id="footer_bg">
				版权所有 © 山东理工大学<br>
					SDUT    数学与统计学院 信息与计算科学 实训五组	</div>
		</div>

	</div>
</body>
</html>