<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="student" class="com.javabeans.Student" scope="session"></jsp:useBean>
<%@ page import="java.util.*,com.javabeans.Credit"%>
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
					<li><a href="student_infomation.jsp">
							学生管理</a>
						<ul>
							<li><a href="student_infomation.jsp">学生信息</a></li>
							<li><a href="student_password.jsp">修改密码</a></li>
						</ul></li>
					<li class="active"><a href="student_search_score.jsp"
						> 学生查询</a>
						<ul>
							<li><a href="student_search_score.jsp">成绩查询</a></li>
							<li class="active"><a href="student_search_credit.jsp">课程和学分查询</a></li>
						</ul></li>
						<li>
						<a href="stu_search_course.jsp" class="icon-search">课程查询</a>
					</li>
				</ul>
			</div>
			
		</div>
	</div>
	

	<div class="admin">
	

		<div class="admin-bread">
		<form action="SearchCreditServlet" method="post">
		<div class="panel-foot bg-back border-back" align="left">
							<button class="button bg-main" type="submit">查询</button></div>
								</form>
		
			<div class="panel">
				<div class="panel-head">
					<strong>查询结果</strong>
				</div>
				<table class="table">
					<tr>
						<th>学期</th>
						<th>课程名称</th>
						<th>学时</th>
						<th>学分</th>

					</tr>
					<%
						ArrayList<Credit> creditList = (ArrayList<Credit>) session.getAttribute("creditList");
						if (creditList != null) {
							for (Credit credit : creditList) {
								{
									if (credit.getSno().equals(student.getSno())) {
					%>
					<tr>
						<td align="left"><%=credit.getTerm()%></td>
						<td align="left"><%=credit.getCname()%></td>
						<td align="left"><%=credit.getCtime()%></td>
						<td align="left"><%=credit.getCredit()%></td>
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
</body>
</html>
</html>