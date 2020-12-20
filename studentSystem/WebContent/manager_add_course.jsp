<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
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
            		<li><a href="manager_add_teacher.jsp">添加教师</a></li>
            		<li><a href="manager_add_class.jsp">添加班级</a></li>
            		<li class="active"><a href="manager_add_course.jsp">添加课程</a></li></ul>
            	</li>
            	<li><a href="manager_delete_student.jsp" >信息删除</a>
            	    <ul><li class="active"><a href="manager_delete_student.jsp">删除学生</a></li>
            	    <li><a href="manager_delete_teacher.jsp">删除教师</a></li>
            	    <li><a href="manager_delete_class.jsp">删除班级</a></li>
            	    <li><a href="manager_delete_course.jsp">删除课程</a></li></ul>
            	</li>
            	<li><a href="search_student_area.jsp" >查询学生信息</a></li>
            	<li><a href="search_techer.jsp" >查询老师信息</a></li>
            	<li  ><a href="search_class.jsp" >查询班级信息</a></li>
            	<li ><a href="search_course.jsp" class="icon-search">课程查询</a></li>
            	<li><a href="manager_password.jsp" >修改密码</a></li>
            </ul> 	   					
        </div>
        </div>
        <div class="admin">

		<div class="tab">
			<div class="tab-head">
				<strong>添加课程信息</strong>
			</div>
			<div class="tab-body">
				<br />
				<div class="tab-panel active" id="tab-set">
					<form action="AddCourseServlet" method="post" class="form-x" >
						<div class="form-group">
							<div class="label">
								<label for="sno">课程编号：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="ccno"
									name="ccno" size="30" style="width: 150px"
									placeholder="课程编号" data-validate="required:请填写课程编号" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="spassword">课程名称：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="ccname"
									name="ccname" size="30" style="width: 150px"
									placeholder="课程名称" data-validate="required:请填写课程名称" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="sname">任课教师编号：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tno"
									name="tno" size="30" style="width: 150px"
									placeholder="任课教师编号" data-validate="required:请填写任课教师编号" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="label">
								<label for="sname">任课教师姓名：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="tname"
									name="tname" size="30" style="width: 150px"
									placeholder="任课教师姓名" data-validate="required:请填写任课教师姓名" />
							</div>
						</div>
						
						<div class="form-group">
							<div class="label">
								<label for="sname">开课班级：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="classname"
									name="classno" size="30" style="width: 150px"
									placeholder="开课班级" data-validate="required:请填写开课班级" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="sname">开课学期：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="cterm"
									name="cterm" size="30" style="width: 150px"
									placeholder="开课学期" data-validate="required:请填写开课学期" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="sname">学时：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="ctime"
									name="ctime" size="30" style="width: 150px"
									placeholder="学时" data-validate="required:请填写学时" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="sname">考试方式：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="cexam"
									name="cexam" size="30" style="width: 150px"
									placeholder="考查/考试" data-validate="required:请填写考试方式" />
							</div>
						</div>
						<div class="form-group">
							<div class="label">
								<label for="sname">学分：</label>
							</div>
							<div class="field">
								<input type="text" class="input" id="ccredit"
									name="ccredit" size="30" style="width: 150px"
									placeholder="学分" data-validate="required:请填写学分" />
							</div>
						</div>
						<div class="form-button">
							<button class="button bg-main" type="submit">确认添加</button>
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
