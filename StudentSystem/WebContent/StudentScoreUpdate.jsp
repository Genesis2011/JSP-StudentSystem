<%@page import="sdut.entity.Student"%>
<%@page import="sdut.entity.User"%>
<%@page import="sdut.entity.Score"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>学生成绩修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader"></div>
				<div id="topheader">
					<h1 id="title">
						<a href="StudentScoreSelect.jsp">成绩管理系统</a>
					</h1>
				</div>
				<%
					String type=(String)request.getSession().getAttribute("type");
					String name="";
					if(session.getAttribute("who")==null){
						 response.sendRedirect("login.jsp");
					 }
					 else{
							 name=((User)session.getAttribute("who")).getName();
					 }
				%>
				<div id="navigation" align="right">
					<a href="StudentSelect.jsp">学生管理</a>
					<a href="UserSelect.jsp">用户管理</a>
					<a href="GradeSelect.jsp">班级管理</a>
					<a href="LogoutControl">注销</a>
						<span style="font-family: '微软雅黑'; font-size: 14px">
							<div id="userfont">当前用户: <%=name %> </div>
						</span>
						<span id="admin_name" style="font-family: '微软雅黑'; font-size: 14px"；font-color:white;>
						</span>
				</div>
			</div>
		</div>
			<form action="StudentScoreUpdateControl" method="post" id="content">
				<%
					request.setCharacterEncoding("UTF8");
					List<Score> list = (List<Score>) request.getAttribute("list");
					for (Score s : list) {
				%>
				<p id="whereami"></p>
				<h1>修改成绩信息:</h1>
				<input type="hidden" name="no" value="" />
				<table cellpadding="0" cellspacing="0" border="0" class="form_table">
					<tr>
						<td valign="middle" align="right">编号:</td>
						<td valign="middle" align="left">
							<span> <%=s.getId()%>
									<input type="hidden" value="<%=s.getId()%>" name="id">
							</span>
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">成绩:</td>
						<td valign="middle" align="left">
							<input value=" <%=s.getScore()%> " name="score" type="text" class="inputgri" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">科目:</td>
						<td valign="middle" align="left">
							<input value="<%=s.getCourse()%>" name="course" type="text" class="inputgri" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">考试时间:</td>
						<td valign="middle" align="left">
							<input value="<%=s.getTime()%> " name="time" type="text" class="inputgri" />
						</td>
					</tr>
					<tr>
						<td valign="middle" align="right">学号:</td>
						<td valign="middle" align="left">
							<input value="<%=s.getStudentid()%>" name="studentid" type="text" class="inputgri" />
						</td>
					</tr>
				</table>
				<p>
					<input type="submit" id="updatebook" class="button" value="提交" />
					<a href="StudentScoreSelect.jsp">
						<input type="button" class="button" value="取消" onclick="window.location.href('StudentScoreSelect.jsp')">
					</a>
				</p>
				<%
					}
				%>
			</form>
	</div>

	<div id="footer" align="center">
		<div id="footer_bg">
				版权所有 © 山东理工大学<br> SDUT 数学与统计学院 信息与计算科学 实训五组
		</div>
	</div>
</body>
</html>