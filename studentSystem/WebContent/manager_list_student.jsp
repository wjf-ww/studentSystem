<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*,com.javabeans.Student"%>
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
		
	</div>
	<div class="righter nav-navicon" id="admin-nav">
		<div class="mainer">
			<div class="admin-navbar">
				<span class="float-right"> <a
					class="button button-little bg-yellow" href="login.jsp">注销登录</a>
				</span>
				<ul class="nav nav-inline admin-nav">
           		  <li class="active"><a href="manager_list_student.jsp" >学生管理系统</a>
            		<ul><li class="active"><a href="manager_add_student.jsp">学生人员管理</a></li>
            		<li><a href="manager_add_teacher.jsp">学生成绩管理</a></li>
            		<li class="active"><a href="manager_add_class.jsp">添加班级</a></li>
            		<li><a href="manager_add_course.jsp">添加课程</a></li></ul>
            		</li>
            	<li><a href="manager_delete_student.jsp" >教师管理系统</a>
            	    <ul><li class="active"><a href="manager_delete_student.jsp">教师人员管理</a></li>
            	    <li><a href="manager_delete_teacher.jsp">删除教师</a></li>
            	    <li><a href="manager_delete_class.jsp">删除班级</a></li>
            	    <li><a href="manager_delete_course.jsp">删除课程</a></li></ul></li>
            	    
            	 <li><a href="manager_delete_student.jsp" >课程管理系统</a>
            	    <ul><li class="active"><a href="manager_delete_student.jsp">课程管理</a></li>
            	    <li><a href="manager_delete_teacher.jsp">删除教师</a></li>
            	    <li><a href="manager_delete_class.jsp">删除班级</a></li>
            	    <li><a href="manager_delete_course.jsp">删除课程</a></li></ul></li>
            	<li ><a href="search_student_area.jsp" >查询学生信息</a></li>
            	
            	<li><a href="manager_password.jsp" >修改密码</a></li>
            </ul> 
			</div>


			<div class="admin">
				<div class="admin-bread">
					<form action="StudentAreaServlet" method="post">
						<div class="panel-foot bg-back border-back" align="left">
							班级：<input type="text" name="class">
					
							<button class="button bg-main" type="submit">查询</button>
						</div>
					</form>

					<div class="panel">
						<div class="panel-head">
							<strong>学生信息</strong>
							<form >
								<button class="button bg-main" type="submit" window.location.href="manager_add_student.jsp">新增</button>
							</form>
						</div>
						<table class="table">
							<tr>
								<th>学号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>年龄</th>
								<th>班级</th>
								<th>已修学分</th>
								
								<th>删除学生</th>
								<th>更改密码</th>
							</tr>
							<%
								ArrayList<Student> studentList = (ArrayList<Student>) session.getAttribute("studentList");
								if (studentList != null) {
									for (Student stu:studentList) {
							%>
							<tr>
								<td align="left"><%=stu.getSno()%></td>
								<td align="left"><%=stu.getSname()%></td>
								<td align="left"><%=stu.getSsex()%></td>
								<td align="left"><%=stu.getSage()%></td>
								<td align="left"><%=stu.getScno()%></td>
								<td align="left"><%=stu.getClass()%></td>
								<td align="left"><%=stu.getScredit()%></td>
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