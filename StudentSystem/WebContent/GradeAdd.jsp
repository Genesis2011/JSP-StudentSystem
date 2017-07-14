<%@page import="sdut.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加年级信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" /> 
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
							<a href="GradeSelect.jsp">班级管理系统</a>
						</h1>
					</div>
					<div id="navigation" align="right">
						<a href="StudentSelect.jsp">学生管理</a>
						<a href="StudentScoreSelect.jsp">成绩管理</a> 
						<a href="UserSelect.jsp">用户管理</a>
						<a href="LogoutControl">注销</a>					
						<span style="font-family: '微软雅黑'; font-size: 14px">
							<div id="userfont">当前用户: <%=name %> </div>
						</span>
						<span id="admin_name" style="font-family: '微软雅黑'; font-size: 14px"；font-color:white;>
						</span>
					</div>
				</div>
				
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加年级：
					</h1>
					<form action="GradeAddControl" method="post" id="content">
						<p id="whereami"></p>
							<table cellpadding="0" cellspacing="0" border="0"
								class="form_table">
								<tr>
									<td  valign="middle" align="right">
										年级编号:
									</td>
									<td valign="middle" align="left">
										<input id="bnum" type="text" class="inputgri" name="id" />
									</td>
								</tr>
								<tr>
									<td valign="middle" align="right">
										年级名称:
									</td>
									<td valign="middle" align="left">
										<input id="bname" type="text" class="inputgri" name="name" />
									</td>
								</tr>		
							</table>
							<p>
								<input id="addbook" type="submit" class="button" value="确定" />
								<a href="GradeSelect.jsp">
									<input type="button" class="button" value="取消"
									onclick="window.location.href('GradeSelect.jsp')">
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
