package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Score;
import com.javabeans.Student;
import com.javabeans.Teacher;

@WebServlet("/AddScoreServlet")
public class AddScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Teacher teacher = (Teacher) request.getSession()
				.getAttribute("teacher");
		UserDao dao = new UserDao();
		String message = null;
		try {
			Score score = new Score();
			score.setSno(request.getParameter("sno"));
			score.setCno(request.getParameter("cno"));
			score.setTerm(request.getParameter("term"));
			score.setScore(request.getParameter("score"));
			score.setTno(request.getParameter("tno"));
			
			score.setSname(request.getParameter("sname"));
			score.setCname(request.getParameter("cname"));
			score.setTname(request.getParameter("tname"));
			score.setChecked(1);
//			boolean success = dao.addScore(score);
			//添加学生成绩
			boolean success = dao.updateScore(score);
			if(success)
			{
				message = "<li>输入成绩成功！</li>";
			}else{
				message = "<li>>输入成绩失败！</li>";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "<li>>输入成绩错误！</li>";
		}
		
		//查询学生学分
		int StudentCredit = dao.findStudentCredit(request.getParameter("sno"));
		//查询课程学分
		int CourseCredit = dao.findCourseCreditByCno(request.getParameter("sno"));
		//修改学生学分
		dao.updateCredit(request.getParameter("sno"), StudentCredit + CourseCredit );
		
		request.setAttribute("result", message);
		Student student = dao.findBySno(request.getParameter("sno"));
		request.getSession().setAttribute("student", student);

		//返回未添加成绩的学生
		ArrayList<Score> scoreList = dao.findScore(request.getParameter("term"), request.getParameter("tno") , request.getParameter("cname"));
		request.getSession().setAttribute("scoreList", scoreList);
		//返回修改了 学分之后的学生信息
		ArrayList<Student> studentList = dao.findStudent(request.getParameter("cname"),request.getParameter("term"));
		request.getSession().setAttribute("studentList", studentList);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/input_student_score.jsp");
		rd.forward(request, response);
	}
}
