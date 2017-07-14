<%@page import="sdut.entity.User"%>
<%@page import="sdut.bin.GradeBin"%>
<%@page import="sdut.entity.Grade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>年级查询</title>
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
		}else{
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
						<div id="userfont">当前用户: <%=name %> 
						</div>
					</span>
					<span id="admin_name" style="font-family: '微软雅黑'; font-size: 14px"；font-color:white;>
					</span>
				</div>
			</div>

			<form action="GradeSelect.jsp" method="post" id="content">
				<p id="whereami"></p>
				<table cellpadding="0" cellspacing="0" border="0" class="form_table">
					<tr>
						<td valign="middle" align="right">年级信息查询：</td>
						<td valign="middle" align="left">
						<input type="text" class="inputgri" name="id" />
						<input type="submit" id="select" class="button" value="查询" />
							<a href="GradeAdd.jsp">
								<input type="button" class="button" value="添加" onclick="window.location.href('GradeAdd.jsp')">
							</a>
						</td>
					</tr>
				</table>
				<br>
				<table id="findbook_result" class="table">
					<tr class="table_header">
						<td>选项</td>
						<td>年级编号</td>
						<td>年级名称</td>
					</tr>
					<%
						request.setCharacterEncoding("utf-8");
						List<Grade> list = null;
						GradeBin gb = new GradeBin();
						String info = null;
						info = request.getParameter("id");
						if (info == null || info.trim() == "")
							list = gb.search();
						else {
							list = gb.search(new Integer(info));
						}
						for (Grade g : list) {
					%>
					<tr class="row2">
						<td><a href="GradeUpdateConnection?id=<%=g.getId()%>">修改</a></td>
						<td><%=g.getId()%></td>
						<td><%=g.getName()%></td>
					</tr>
					<%
						}
					%>
				</table>
				<br>
			</form>

		</div>
		<div id="footer" align="center">
			<div id="footer_bg">
				版权所有 © 山东理工大学<br> SDUT 数学与统计学院 信息与计算科学 实训五组
			</div>
		</div>
	</div>
</body>
</html>