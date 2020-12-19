<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="teacher" class="com.javabeans.Teacher" scope="session"></jsp:useBean>
<%@ page import="java.util.*,com.javabeans.*"%>
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
		<div class="logo">
			
		</div>
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
					<li class="active"><a href="teacher_rank_score.jsp"
						>教师查询</a>
						<ul>
							<li class="active"><a href="teacher_rank_score.jsp">学生成绩查询</a></li>
							<li><a href="teacher_search_course.jsp">教师任课查询</a></li>
							<li><a href="teacher_class_course.jsp">课程开设查询</a></li>
						</ul></li>
					<li><a href="input_student_score.jsp" >教师管理</a>
						<ul>
							<li><a href="input_student_score.jsp">学生成绩输入</a></li>
						</ul></li>
			</div>



			<%
				ArrayList<Course> courseList = (ArrayList<Course>) session.getAttribute("courseList");
				ArrayList<String> courseTermList = (ArrayList<String>) session.getAttribute("courseTermList");
			
			%>

			<div class="admin">

							<form action="RankScoreServlet" method="post">
								<div class="panel-body text-center">
								
									课程： <select name="cname">
									<%
										if (courseList != null) {
											for (Course course : courseList) {
									%>
									  		<option value=<%=course.getCcname() %>><%=course.getCcname() %></option>
									<%
											}
										}
									%>
										</select>
										 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									学期： <select name="term">
									
									<%
										if(courseTermList != null && courseTermList.size() != 0 ){
											for(String term : courseTermList){	
										
									%>
									
										<option value=<%=term %>><%=term %></option>
									
											
									<%
											}
										}
									%>
											
										</select>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
									姓名： <input type = "text" name="sname" placeholder="学生名字"/>
								</div>
								<div class="panel-foot bg-back border-back" align="center">
									<button class="button bg-main" type="submit">提交</button>
								</div>
							</form>
							<BR>
							<div class="admin-bread">

								<div class="panel">
									<div class="panel-head">
										<strong>查询结果</strong>
									</div>
									<table class="table">
										<tr>
											<th>学号</th>
											<th>学生姓名</th>
											<th>成绩</th>
										</tr>
										<%
											ArrayList<Score> scoreList = (ArrayList<Score>) session.getAttribute("scoreList");
											if (scoreList != null) {
												for (Score score : scoreList) {
													if(score.getTno().equals(teacher.getTno())){
										%>
										<tr>
											<td align="left"><%=score.getSno()%></td>
											<td align="left"><%=score.getSname()%></td>
											<td align="left"><%=score.getScore()%></td>
										</tr>
										<%
											}
											}
											}
										%>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
</body>
</html>