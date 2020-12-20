<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,com.javabeans.*"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>学生管理系统</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script src="js/respond.js"></script>
<script src="js/admin.js"></script>
<link type="image/x-icon" href="/favicon.ico" rel="shortcut icon" />
<link href="/favicon.ico" rel="bookmark icon" />
</head>

<body>
	<div class="lefter">
		<div class="logo">
			<a href="login.jsp" target="_blank"><img src="images/logo.png"
				alt="登录系统" /></a>
		</div>
	</div>
	<div class="righter nav-navicon" id="admin-nav">
		<div class="mainer">
			<div class="admin-navbar">
				<span class="float-right"> <a
					class="button button-little bg-yellow" href="login.jsp">注销登录</a>
				</span>
				<ul class="nav nav-inline admin-nav">
           		  <li><a href="manager_add_student.jsp" > 信息添加</a>
            		<ul><li class="active"><a href="manager_add_student.jsp">添加学生</a></li>
            		<li><a href="manager_add_teacher.jsp">添加教师</a></li>
            		<li><a href="manager_add_class.jsp">添加班级</a></li>
            		<li><a href="manager_add_course.jsp">添加课程</a></li></ul>
            	</li>
            	<li><a href="manager_delete_student.jsp">信息删除</a>
            	    <ul><li class="active"><a href="manager_delete_student.jsp">删除学生</a></li>
            	    <li><a href="manager_delete_teacher.jsp">删除教师</a></li>
            	    <li><a href="manager_delete_class.jsp">删除班级</a></li>
            	    <li><a href="manager_delete_course.jsp">删除课程</a></li></ul>
            	</li>
            	<li ><a href="search_student_area.jsp" >查询学生信息</a></li>
            	<li  ><a href="search_techer.jsp" >查询老师信息</a></li>
            	<li ><a href="search_class.jsp" >查询班级信息</a></li>
            	<li class="active"><a href="search_course.jsp" class="icon-search">课程查询</a></li>
            	<li><a href="manager_password.jsp" class="icon-user">修改密码</a></li>
            </ul> 
			</div>


			<div class="admin">
				<div class="admin-bread">
					<form action="CourseDetailServlet" method="post">
						<div class="panel-foot bg-back border-back" align="left">
							教师编号：<input type="text" name="tno">
							教师名字：<input type="text" name="tname">
							任课班级：<input type="text" name="cno">
							<input type = "hidden" name = "hide" value="course">
							<button class="button bg-main" type="submit">查询</button>
						</div>
					</form>

					<div class="panel">
						<div class="panel-head">
							<strong>教师任课查询</strong>
						</div>
						<table class="table">
							<tr>
								<th>课程编号</th>
								<th>课程名称</th>
								<th>学期</th>
								<th>学时</th>
								<th>考查方式</th>
								<th>学分</th> &nbsp; &nbsp; &nbsp;
								<th>老师职工号</th>
								<th>任课老师</th>

							</tr>
							<%
								ArrayList<Course> courseList = (ArrayList<Course>) session.getAttribute("courseList");
								if (courseList != null) {
									for (Course course:courseList) {
							%>
							<tr>
								<td align="left"><%=course.getCcno()%></td>
								<td align="left"><%=course.getCcname()%></td>
								<td align="left"><%=course.getCterm()%></td>
								<td align="left"><%=course.getCtime()%></td>
								<td align="left"><%=course.getCexam()%></td>
								<td align="left"><%=course.getCcredit()%></td>
								<td align="left"><%=course.getTno()%></td>
								<td align="left"><%=course.getTname()%></td>
							</tr>
							<%
								}
							%>
							<%} %>
						</table>
					</div>
				</div>
			</div>
		</div>
</body>
</html>