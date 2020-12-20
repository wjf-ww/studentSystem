<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="student" class="com.javabeans.Student" scope="session"></jsp:useBean>
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
					<li class="active"><a href="student_infomation.jsp"
						> 学生管理</a>
						<ul>
							<li><a href="student_infomation.jsp">学生信息</a></li>
							<li class="active"><a href="student_password.jsp">修改密码</a></li>
						</ul></li>
					<li><a href="student_search_score.jsp" > 学生查询</a>
						<ul>
							<li class="active"><a href="student_search_score.jsp">成绩查询</a></li>
							<li><a href="student_search_credit.jsp">课程和学分查询</a></li>
						</ul></li>
						<li>
						<a href="stu_search_course.jsp" class="icon-search">课程查询</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="admin">

		<div class="tab">
			<div class="tab-head">
				<strong>密码修改</strong>
			</div>
			<div class="tab-body">
				<br />
				<div class="tab-panel active" id="tab-set">
					<form action="StudentPasswordServlet" method="post" class="form-x" >
						<div class="form-group">
							<div class="label">
								<label for="old_password">旧密码：</label>
							</div>
							<div class="field">
								<input type="password" class="input" id="old_password"
									name="old_password" size="30" style="width: 100px"
									placeholder="原先的密码" data-validate="required:请填写你原先的密码" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="new_password">新密码：</label>
							</div>
							<div class="field">
								<input type="password" class="input" id="new_password"
									name="new_password" size="30" style="width: 100px"
									placeholder="新密码" data-validate="required:请填写你新的密码" />
							</div>
						</div>
						<div class="form-button">
							<button class="button bg-main" type="submit">提交</button>
						</div>
						<font color = red>${result}</font>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>