<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="student" class="com.javabeans.Student" scope="session"/>
<%@ page import="java.util.*,com.javabeans.*,java.lang.*"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>教师管理系统</title>
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
					<li><a href="teacher_infomation.jsp" >
							个人管理</a>
						<ul>
							<li><a href="teacher_infomation.jsp">教师信息</a></li>
							<li><a href="teacher_password.jsp">修改密码</a></li>
						</ul></li>
					<li><a href="teacher_rank_score.jsp" >教师查询</a>
						<ul>
							<li><a href="teacher_rank_score.jsp">学生成绩查询</a></li>
							<li class="active"><a href="teacher_search_course.jsp">教师任课查询</a></li>
							<li><a href="teacher_class_course.jsp">课程开设查询</a></li>
						</ul></li>
					<li class="active"><a href="input_student_score.jsp"
						>教师管理</a>
						<ul>
							<li class="active"><a href="input_student_score.jsp">学生成绩输入</a></li>
							<li class="active"><a href="update_student_password.jsp">学生密码修改</a></li>
						</ul>
					</li>
			</div>
			<%
				ArrayList<Course> courseList = (ArrayList<Course>) session.getAttribute("courseList");
				ArrayList<Student> studentList = (ArrayList<Student>) session.getAttribute("studentList");
				ArrayList<String> courseTermList = (ArrayList<String>) session.getAttribute("courseTermList");
			%>

			<div class="admin">
				<div class="admin-bread">
					<form action="GetStudentServlet" method="post">
						<div class="panel-foot bg-back border-back"  align="center">
							学期：  <select name="term">
									
									<%
										if(courseTermList != null && courseTermList.size() != 0 ){
											for(String term : courseTermList){	
										
									%>
									
										<option value=<%=term %>><%=term %></option>
									
											
									<%
											}
										}
									%>
											
										</select> &nbsp; &nbsp; &nbsp; &nbsp;
							课程： <select name="classname">
								<%
									if (courseList != null) {
										for (Course course : courseList) {
								%>
						        <option value="<%=course.getCcname() %>"><%=course.getCcname() %></option>
								<%
										}
									}
								%>
							 </select>&nbsp; &nbsp; &nbsp; &nbsp;
							 <button class="button bg-main" type="submit">输入成绩</button>
						</div>
						<div  class="panel-foot bg-back border-back"  align="center">
						
							
						</div>
					</form>
					<font color=red>${result}</font>
					<div class="panel">
						<div class="panel-head">
							<strong>输入成绩</strong>
						</div>
						<table class="table">
							<tr>
								<th>学号</th>
								<th>学生姓名</th>
								<th>课程编号</th>
								<th>课程名称</th>
								<th>学期</th>
								<th>成绩</th>
								<th>教师编号</th>
								<th>提交</th>
							</tr>

							<%
								ArrayList<Score> scoreList = (ArrayList<Score>) session.getAttribute("scoreList");
								Teacher teacher = (Teacher) session.getAttribute("teacher");
								if (scoreList != null) {
									for (Score score : scoreList) {
							%>

							<tr>
								<form action="AddScoreServlet" method="post">
								<td align="left"><input name="sno" type="hidden"
									value="<%=score.getSno()%>"><%=score.getSno()%></td>
								<td align="left"><%=score.getSname()%></td>
								<td align="left"><input name="cno" type="hidden"
									value="<%=score.getCno()%>"><%=score.getCno()%></td>
								<td align="left"><%=score.getCname()%></td>
								<td align="left"><input name="term" type="hidden" 
								    value="<%=score.getTerm()%>"><%=score.getTerm()%></td>
								<td align="left"><input type="text" name="score"></td>
								<td align="left"><input name="tno" type="hidden" 
								    value="<%=score.getTno()%>"><%=score.getTno()%></td>
								 
								<td align="left"><input name="sname" type="hidden"
									value="<%=score.getSname()%>"></td>
								<td align="left"><input name="cname" type="hidden"
									value="<%=score.getCname()%>"></td>
								<td align="left"><input name="tname" type="hidden"
									value="<%=teacher.getTname()%>"></td>
								<td align="left"><button class="button bg-main"
										type="submit">确定</button></td>
								</form>
							</tr>
							<%
								}
								}
							%>
						</table>
						<div class="panel-head">
							<strong>已修学分</strong>
						</div>
						<table class="table">
							<tr>
								<th>学号</th>
								<th>学生姓名</th>
								<th>已修学分</th>
								
							</tr>
							<% 
									if(studentList != null) {
										for(Student student1 : studentList){	
									
								%>
							<tr>
								
								<td align="left"><%=student1.getSno()%></td>
								<td align="left"><%=student1.getSname()%></td>
								<td align="left"><%=student1.getScredit()%></td>
							</tr>
							<%
										}
									}
								%>
							</table>



					</div>
				</div>
			</div>
</body>
</html>