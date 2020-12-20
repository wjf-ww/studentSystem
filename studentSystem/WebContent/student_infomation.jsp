<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="student" class="com.javabeans.Student" scope="session"></jsp:useBean>
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
           		 <li class="active"><a href="student_infomation.jsp" > 学生管理</a>
            		<ul><li class="active"><a href="student_infomation.jsp">学生信息</a></li><li><a href="student_password.jsp">修改密码</a></li></ul>
                </li>
                <li><a href="student_search_score.jsp"> 学生查询</a>
							<ul>
							<li><a href="student_search_score.jsp">成绩查询</a></li>
							<li><a href="student_search_credit.jsp">课程和学分查询</a></li></ul>
							</li>
				<li>
						<a href="stu_search_course.jsp" class="icon-search">课程查询</a>
					</li>
						</ul>
						</div>
						
        </div>
        <div class="admin">
        <div class="admin-bread">
    
            <span>您好,<%=student.getSname() %>,欢迎您的登录！</span>
             <div class="panel">
            	<div class="panel-head"><strong>学生信息</strong></div>
                <table class="table">
                    <tr><td width="110" align="right">学号：</td><td><%=student.getSno() %></td><td width="90" align="right">姓名：</td><td><%=student.getSname() %></td></tr>
                    <tr><td align="right">性别：</td><td><%=student.getSsex() %></td><td align="right">年龄：</td><td><%=student.getSage() %></td></tr>
                    <tr><td align="right">出生地：</td><td><%=student.getSorigin() %></td><td align="right">已修学分：</td><td><%=student.getScredit() %></td></tr>
                    <tr><td align="right">班级编号：</td><td><%=student.getScno() %></td><td align="right"></td><td></td></tr>
                </table>
            </div>
        </div>
    </div> 
</div>
</body>
</html>
