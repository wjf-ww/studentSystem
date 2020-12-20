<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="student" class="com.javabeans.Student" scope="session"></jsp:useBean>
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
		
	</div>
	<div class="righter nav-navicon" id="admin-nav">
		<div class="mainer">
			<div class="admin-navbar">
				<span class="float-right"> <a
					class="button button-little bg-yellow" href="login.jsp">注销登录</a>
				</span>
				<ul class="nav nav-inline admin-nav">
					<li><a href="student_infomation.jsp" >
							学生管理</a>
						<ul>
							<li><a href="student_infomation.jsp">学生信息</a></li>
							<li><a href="student_password.jsp">修改密码</a></li>
						</ul></li>
					<li class="active"><a href="student_search_score.jsp"
						> 学生查询</a>
						<ul>
							<li class="active"><a href="student_search_credit.jsp">成绩查询</a></li>
							<li><a href="student_search_credit.jsp">课程和学分查询</a></li>
						</ul></li>
						<li><a href="stu_search_course.jsp" class="icon-search">课程查询</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="admin">
		<%
				
				ArrayList<String> courseTermList = (ArrayList<String>) session.getAttribute("courseTermList");
			%>
					<form action="SearchScoreServlet" method="post">
						<div class="panel-body text-center">
							学期：学期：  <select name="term">
									
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
						</div>
						
						<input name="sno" type="hidden"
									value="<%=student.getSno()%>">
						
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
									<th>课程名称</th>
									<th>任课教师</th>
									<th>成绩</th>
								</tr>
								<%
									ArrayList<Score> scoreList = (ArrayList<Score>) session.getAttribute("scoreList");
									if (scoreList != null) {
										for (Score score : scoreList) {
											{
												if (score.getSno().equals(student.getSno())) {
								%>
								<tr>
									<td align="left"><%=score.getCname()%></td>
									<td align="left"><%=score.getTname()%></td>
									<td align="left"><%=score.getScore()%></td>
								</tr>
								<%
									}
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
	</div>
</body>
</html>