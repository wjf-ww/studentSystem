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
							<li><a href="teacher_infomation.jsp">教师信息</a></li>
							<li class="active"><a href="teacher_password.jsp">修改密码</a></li>
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
<div class="admin">

		<div class="tab">
			<div class="tab-head">
				<strong>密码修改</strong>
			</div>
			<div class="tab-body">
				<br />
				<div class="tab-panel active" id="tab-set">
					<form action="UpdateStudentPassword" method="post" class="form-x" >
						<div class="form-group">
							<div class="label">
								<label for="student_sno">学生学号：</label>
							</div>
							<div class="field">
								<input type="text" class="input" 
									name="sno"  style="width: 100px"
									placeholder="学生学号" data-validate="required:请填写学生学号" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="student_sname">学生姓名：</label>
							</div>
							<div class="field">
								<input type="text" class="input" 
									name="sname"  style="width: 100px"
									placeholder="学生姓名" data-validate="required:请填写学生姓名" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="student_password">新密码：</label>
							</div>
							<div class="field">
								<input type="password" class="input" 
									name="new_password"  style="width: 100px"
									placeholder="新密码" data-validate="required:请填写新密码" />
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
