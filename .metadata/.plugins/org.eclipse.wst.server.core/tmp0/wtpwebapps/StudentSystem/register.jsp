<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" /> 
<title>注册</title>
<style>
	/* form{
		position: relative;
	    width: 210px;
    	margin: 0px auto;
	} */
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
				<div style="margin: auto 0">
					<form action="RegisterControl" method="post" id="content">
						<p id="whereami"></p>
						<h1>注册学生用户：</h1>
		
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr>
								<td valign="middle" align="right">学生编号:</td>
								<td valign="middle" align="left"><input name="id" type="text"
									class="inputgri" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生姓名:</td>
								<td valign="middle" align="left"><input name="name"
									type="text" class="inputgri" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生密码:</td>
								<td valign="middle" align="left"><input name="password"
									type="text" class="inputgri" /> 
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生年龄:</td>
								<td valign="middle" align="left"><input name="age"
									type="text" class="inputgri" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生籍贯:</td>
								<td valign="middle" align="left"><input name="place"
									type="text" class="inputgri" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生电话:</td>
								<td valign="middle" align="left"><input name="phone"
									type="text" class="inputgri" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生QQ:</td>
								<td valign="middle" align="left"><input name="qq" type="text"
									class="inputgri" /></td>
							</tr>
							<tr>
								<td valign="middle" align="right">学生年级:</td>
								<td valign="middle" align="left"><input name="grade"
									type="text" class="inputgri" /></td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定" /> 
							<a href="register.jsp">
								<input type="button" id="back" class="button" value="取消" onclick="window.location.href('register.jsp')">
							</a> 
						</p>
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