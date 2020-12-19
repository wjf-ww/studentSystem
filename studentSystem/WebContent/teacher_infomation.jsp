<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="teacher" class="com.javabeans.Teacher" scope="session"></jsp:useBean>
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
					<li class="active"><a href="student_infomation.jsp" > 个人管理</a>
						<ul>
							<li class="active"><a href="teacher_infomation.jsp">教师信息</a></li>
							<li><a href="teacher_password.jsp">修改密码</a></li>
						</ul></li>
					<li><a href="teacher_rank_score.jsp" >教师查询</a>
						<ul>
							<li><a href="teacher_rank_score.jsp">学生成绩查询</a></li>
							<li><a href="teacher_search_course.jsp">教师任课查询</a></li>
							<li><a href="teacher_class_course.jsp">课程开设查询</a></li>
						</ul></li>
					<li><a href="input_student_score.jsp" >教师管理</a>
						<ul>
							<li><a href="input_student_score.jsp">学生成绩输入</a></li>
						</ul></li>
			</div>


		</div>
		<div class="admin">
			<div class="admin-bread">

				<span>您好,<%=teacher.getTname()%>,欢迎您的登录！
				</span>
				<div class="panel">
					<div class="panel-head">
						<strong>教师信息</strong>
					</div>
					<table class="table">
						<tr>
							<td width="110" align="right">教师编号：</td>
							<td><%=teacher.getTno()%></td>
							<td width="90" align="right">姓名：</td>
							<td><%=teacher.getTname()%></td>
						</tr>
						<tr>
							<td align="right">性别：</td>
							<td><%=teacher.getTsex()%></td>
							<td align="right">年龄：</td>
							<td><%=teacher.getTage()%></td>
						</tr>
						<tr>
							<td align="right">职称：</td>
							<td><%=teacher.getTtitle()%></td>
							<td align="right">联系电话：</td>
							<td><%=teacher.getTphone()%></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>