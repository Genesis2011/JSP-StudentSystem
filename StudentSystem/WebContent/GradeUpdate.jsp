<%@page import="sdut.entity.User"%>
<%@page import="sdut.entity.Grade"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>年级信息修改</title>
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
			<form action="GradeUpdateControl" method="post" id="content">
				<p id="whereami"></p>
				<h1>修改年级信息:</h1>
				<%
					List<Grade> list=(List<Grade>)request.getAttribute("list");
					for(Grade g : list){
				%>
				<input type="hidden" name="id" value="<%=g.getId()%>" />
				<table cellpadding="0" cellspacing="0" border="0" class="form_table">
					<tr>
						<td valign="middle" align="right">年级编号:</td>
						<td valign="middle" align="left"><span id="id">
						<%=g.getId()%>
						</span></td>
					</tr>
					<tr>
						<td valign="middle" align="right">年级名称:</td>
						<td valign="middle" align="left">
							<span id="id">
							<input	value="<%=g.getName()%>" name="name" type="text" class="inputgri" />
							</span>
						</td>
					</tr>
				</table>
				<%
					} 
				%>
				<p>
					<input type="submit" id="updatebook" class="button" value="提交" />
					<a href="GradeSelect.jsp">
						<input type="button" id="back" class="button" value="取消" onclick="window.location.href('GradeSelect.jsp')">
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