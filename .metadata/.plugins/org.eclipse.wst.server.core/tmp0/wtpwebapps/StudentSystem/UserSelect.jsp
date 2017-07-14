<%@page import="sdut.bin.UserBin"%>
<%@page import="sdut.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户查询</title>
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
					<a href="LogoutControl">注销</a>
					<span style="font-family: '微软雅黑'; font-size: 14px"> <div id="userfont">当前用户: <%=name %> </div></span>
					<span id="admin_name" style="font-family: '微软雅黑'; font-size: 14px" font-color:white;> </span>
				</div>
			</div>

			<form action="UserSelect.jsp" method="post" id="content">
				<p id="whereami"></p>

				<table cellpadding="0" cellspacing="0" border="0" class="form_table">
					<tr align="center">
						<td valign="middle" align="right">&nbsp;</td>
						<td valign="middle" align="left" style="font-size: 14px"><input
							type="radio" value="bname" name="msg" checked="checked">按用户姓名查询
							<input type="radio" value="bnum" name="msg">按编号查询</td>

					</tr>
					<tr>
						<td valign="middle" align="right">用户信息查询：</td>
						<td valign="middle" align="left">
						<input type="text" class="inputgri" name="info" /> 
						<input type="submit" id="select" class="button" value="查询" />
							<a href="UserAdd.jsp">
							<input type="button" class="button" value="添加" onclick="window.location.href('UserAdd.jsp')">
							</a> 
						</td>
					</tr>
				</table>
				<br>
				<table id="findbook_result" class="table">
					<tr class="table_header">
						<td>选项</td>
						<td>用户编号</td>
						<td>用户姓名</td>
						<td>用户密码</td>
						<td>用户年龄</td>
						<td>用户电话</td>
					</tr>
					<%
						request.setCharacterEncoding("utf-8");
						List<User> list=null;
						UserBin ub=new UserBin();
						String info=null;
						info=request.getParameter("info");
						if(info==null || info.trim()==""){
							list=ub.search();
					 	}
					 	else {
					 		//访问控制
							if("bname".equals(request.getParameter("msg"))){
								list=ub.search(info);
							}
							else{
								list=ub.search(new Integer(info));
							}
					 	}
					 	for(User u: list){
					 %>
					 <tr>
					 <td>
					 <a href="javascript:void(0);" onclick="del(<%=u.getId()%>)">删除</a>&nbsp
						 <script>
						 	function del(id){
						 		if(confirm("是否真的删除？")){
						 			alert("Student?id="+id);
						 			location.href="UserDeleteControl?id="+id;
						 		}
						 	}
						 </script>
					  <a href="UserUpdateConnection?id=<%=u.getId() %>">修改</a></td>
					 <td><%=u.getId() %></td>
					 <td><%=u.getName() %></td>
					 <td><%=u.getPassword() %></td>
					 <td><%=u.getAge() %></td>
					 <td><%=u.getPhone() %></td>
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
				版权所有 © 山东理工大学<br>
					SDUT    数学与统计学院 信息与计算科学 实训五组	</div>
		</div>
	</div>
</body>
</html>