<%@page import="sdut.entity.Student"%>
<%@page import="sdut.entity.User"%>
<%@page import="sdut.bin.ScoreBin"%>
<%@page import="sdut.entity.Score"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>成绩查询</title>
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
					request.setCharacterEncoding("UTF-8");
					String type = (String) request.getSession().getAttribute("type");
					String name = "";
					boolean ud=true;
					if (session.getAttribute("who") == null) {
						response.sendRedirect("login.jsp");
					} else {
						if (type == "user") {
							name = ((User) session.getAttribute("who")).getName();
				%>
				<div id="navigation" align="right">
					<a href="StudentSelect.jsp">学生管理</a> <a href="UserSelect.jsp">用户管理</a>
					<a href="GradeSelect.jsp">班级管理</a>
					<a href="LogoutControl">注销</a>
					<span style="font-family: '微软雅黑'; font-size: 14px">
							<div id="userfont">当前用户: <%=name %> </div></span> <span id="admin_name"
							style="font-family: '微软雅黑'; font-size: 14px"；font-color:white;>
						</span>
				</div>
					<%
						} else {
								name = ((Student) session.getAttribute("who")).getName();
								ud=false;
					%>
				<div id="navigation" align="right">
					<a href="LogoutControl">注销</a>
					<span style="font-family: '微软雅黑'; font-size: 14px">
							<div id="userfont">当前学生: <%=name %>
					</span>
					<span id="admin_name" style="font-family: '微软雅黑'; font-size: 14px"；font-color:white;>
					</span>
				</div>
				<%
						}
					}
				%>
				</div>

				<form action="StudentScoreSelect.jsp" method="post" id="content">
					<p id="whereami"></p>
					<table cellpadding="0" cellspacing="0" border="0"
						class="form_table">
						<tr>
							<td valign="middle" align="right">成绩查询：</td>
							<td valign="middle" align="left">
								<input type="text" class="inputgri" name="info" />
								<input type="submit" id="select" class="button" value="查询" /> 
								<%if(ud==true){ %>
								<a
									href="StudentScoreAdd.jsp"> <input type="button"
									class="button" value="添加"
									onclick="window.location.href('StudentScoreAdd.jsp')">
								</a>
								<%} %>
							</td>
						</tr>
					</table>
					<br>
					<table id="findbook_result" class="table">
						<tr class="table_header">
						<%if(ud==true) {%>
							<td>选项</td>
							<%} %>
							<td>编号</td>
							<td>成绩</td>
							<td>科目</td>
							<td>考试时间</td>
							<td>学号</td>
						</tr>
						<%
							List<Score> list = null;
							ScoreBin scb = new ScoreBin();
							String info = null;
							info = request.getParameter("info");
							if (info == null || info.trim() == "") {
								list = scb.search();
							} else {
								list = scb.search(new Integer(info));
							}
							for (Score s : list) {
						%>
						<tr>
								<%if(ud==true){ %>
								<td>
									<a href="javascript:void(0);" onclick="del(<%=s.getId()%>)">删除</a>&nbsp
										<script>
										 	function del(id){
										 		if(confirm("是否真的删除？")){
										 			alert("Student?id="+id);
										 			location.href="StudentScoreDeleteControl?id="+id;
										 		}
										 	}
							 			</script>
							 		<a href="StudentScoreUpdateConnection?id=<%=s.getId()%>">修改</a>
								</td>
								<%} %>
							<td><%=s.getId()%></td>
							<td><%=s.getScore()%></td>
							<td><%=s.getCourse()%></td>
							<td><%=s.getTime()%></td>
							<td><%=s.getStudentid()%></td>
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