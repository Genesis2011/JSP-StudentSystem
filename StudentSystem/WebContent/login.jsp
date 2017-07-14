<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" /> 
		<link rel="stylesheet" href="css/loginstyle.css">
<title>登录</title>
<style>
</style>
</head>
<body>
	<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader"></div>
					<div id="topheader">
						<h1 id="title">
							<a href="login.jsp">学生管理系统</a>
						</h1>
					</div>
					<div id="navigation" align="right">
					</div>
				</div>
			</div>
			
			<div class="sky">
					<div class="clouds_one"></div>
					<div class="clouds_two"></div>
					<div class="clouds_three"></div>
					<div style="position: relative;width: 320px;left:38%;top:30%;">
						<form action="LoginControl" method="post">
							<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr align="center">
								<td valign="middle" align="right">
									用户名称:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" value="" placeholder="请输入用户名"/>
								</td>
							</tr>
							<tr align="center">
								<td valign="middle" align="right">
									用户密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd"/>
								</td>
							</tr>
							<tr align="center">
								<td valign="middle" align="right">
									<p><input type="radio" checked value="student" name="type"/>学生
								</td>
								<td valign="middle" align="left">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" value="user" name="type"/>管理员
								</td>
							</tr>
							<tr align="center">
								<td valign="middle" align="left">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="button" value="登录"/>&nbsp;
								</td>
								
								<td valign="middle" align="left">
									&nbsp;&nbsp;&nbsp;&nbsp;
									<a href="register.jsp">
										<input type="button" class="button" value="注册学生用户" onclick="window.location.href('register.jsp')"/>
									</a>
								</td>
							</tr>
								<%
									String message="";
									if(request.getParameter("t")!=null){
										message="注册成功";
									}
								%>
								<%=message %>
							</table>
						</form>
					</div>
			</div>	
			<div id="footer" align="center">
					<div id="footer_bg">
					版权所有 © 山东理工大学<br>
					SDUT    数学与统计学院 信息与计算科学 实训五组	</div>
			</div>
			
	</div>
</body>
</html>