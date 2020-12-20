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
           		 	<li ><a href="student_infomation.jsp"> 学生管理</a>
						<ul>
							<li><a href="student_infomation.jsp">学生信息</a></li>
							<li><a href="student_password.jsp">修改密码</a></li>
						</ul>
					</li>
					<li><a href="student_search_score.jsp" > 学生查询</a>
						<ul>
							<li ><a href="student_search_score.jsp">成绩查询</a></li>
							<li><a href="student_search_credit.jsp">课程和学分查询</a></li>
						</ul>
					</li>
					<li class = "active">
						<a href="stu_search_course.jsp" class="icon-search">课程查询</a>
					</li>
           		 </ul> 
			</div>


			<div class="admin">
				<div class="admin-bread">
					<form action="CourseDetailServlet" method="post">
						<div class="panel-foot bg-back border-back" align="left">
							教师编号：<input type="text" name="tno"/>
							教师名字：<input type="text" name="tname"/>
							任课班级：<input type="text" name="cno"/>
							<input type = "hidden" name = "hide" value="student">
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
								<th>操作</th>
							</tr>
							<%
							
							Student student = (Student)session.getAttribute("student");
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
								<td align="left">
								<%
											if( course.getChecked() == 0){
										%>
											<form action="AddStudentCourseServlet" method="post" >
												<input type = "hidden" name="sno" value = "<%=student.getSno() %>">
												<input type = "hidden" name="sname" value = "<%=student.getSname() %>">
												<input type = "hidden" name="scno" value = "<%=student.getScno() %>">
												<input type = "hidden" name="cno" value = "<%=course.getClassNo() %>">
												
												<input type = "hidden" name="ccno" value = "<%=course.getCcno() %>">
												<input type = "hidden" name="ccname" value = "<%=course.getCcname() %>">
												<input type = "hidden" name="term" value = "<%=course.getCterm() %>">
												<input type = "hidden" name="tno" value = "<%=course.getTno() %>">
												<input type = "hidden" name="tname" value = "<%=course.getTname() %>">
												<button class="button bg-main" type="submit">选课</button>
											</form>
										<%} %>
										<%
											if(course.getChecked() != null && course.getChecked()==1 && course.getSno().equals(student.getSno())) {
										%>
											<form action="DeleteStudentCourseServlet" method="post" >
												<input type = "hidden" name="sno" value = "<%=student.getSno() %>">
												<input type = "hidden" name="sname" value = "<%=student.getSname() %>">
												<input type = "hidden" name="scno" value = "<%=student.getScno() %>">
												<input type = "hidden" name="cno" value = "<%=course.getClassNo() %>">
												
												<input type = "hidden" name="ccno" value = "<%=course.getCcno() %>">
												<input type = "hidden" name="ccname" value = "<%=course.getCcname() %>">
												<input type = "hidden" name="term" value = "<%=course.getCterm() %>">
												<input type = "hidden" name="tno" value = "<%=course.getTno() %>">
												<input type = "hidden" name="tname" value = "<%=course.getTname() %>">
												<button class="button bg-main" type="submit">退课</button>
											</form>
										<%} %>
									
								</td>
							</tr>
							<%
									}
								}
							%>
							
						</table>
					</div>
				</div>
			</div>
		</div>
</body>
</html>