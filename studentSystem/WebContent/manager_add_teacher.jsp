<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
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
            <span class="float-right">
                <a class="button button-little bg-yellow" href="login.jsp">注销登录</a>
            </span>
            <ul class="nav nav-inline admin-nav">
           		 <li class="active"><a href="manager_add_student.jsp" > 信息添加</a>
            		<ul><li><a href="manager_add_student.jsp">添加学生</a></li>
            		<li class="active"><a href="manager_add_teacher.jsp">添加教师</a></li>
            		<li><a href="manager_add_class.jsp">添加班级</a></li>
            		<li><a href="manager_add_course.jsp">添加课程</a></li></ul>
            	</li>
            	<li><a href="manager_delete_student.jsp" >信息删除</a>
            	    <ul><li class="active"><a href="manager_delete_student.jsp">删除学生</a></li>
            	    <li><a href="manager_delete_teacher.jsp">删除教师</a></li>
            	    <li><a href="manager_delete_class.jsp">删除班级</a></li>
            	    <li><a href="manager_delete_course.jsp">删除课程</a></li></ul>
            	</li>
            	<li><a href="search_student_area.jsp">查询学生信息</a></li>
            	<li><a href="search_techer.jsp" >查询老师信息</a></li>
            	<li  ><a href="search_class.jsp" >查询班级信息</a></li>
            	<li ><a href="search_course.jsp" class="icon-search">课程查询</a></li>
            	<li><a href="manager_password.jsp" >修改密码</a></li>
            </ul> 				
        </div>
        <div class="admin">

		<div class="tab">
			<div class="tab-head">
				<strong>添加教师信息</strong>
			</div>
			<div class="tab-body">
				<br />
				<div class="tab-panel active" id="tab-set">
					<form action="AddTeacherServlet" method="post" class="form-x" >
						<div class="form-group">
							<div class="label">
								<label for="tno">教师编号:</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tno"
									name="tno" size="30" style="width: 150px"
									placeholder="教师编号" data-validate="required:请填写教师编号" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="tpassword">密码：</label>
							</div>
							<div class="field">
								<input type="password" class="input" id="tpassword"
									name="tpassword" size="30" style="width: 150px"
									placeholder="密码" data-validate="required:请填写密码" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="tname">姓名：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tname"
									name="tname" size="30" style="width: 150px"
									placeholder="姓名" data-validate="required:请填写姓名" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="tsex">性别：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tsex"
									name="tsex" size="30" style="width: 150px"
									placeholder="男或女" data-validate="required:请填写性别" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="tage">年龄：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tage"
									name="tage" size="30" style="width: 150px"
									placeholder="年龄" data-validate="required:请填写年龄" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="ttitle">职称：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="ttitle"
									name="ttitle" size="30" style="width: 150px"
									placeholder="职称" data-validate="required:请填写职称" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="tphone">联系电话：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tphone"
									name="tphone" size="30" style="width: 150px"
									placeholder="联系电话" data-validate="required:请填写联系电话" />
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
</div>
</body>
</html>