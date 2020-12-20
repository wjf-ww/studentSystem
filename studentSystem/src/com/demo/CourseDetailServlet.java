package com.demo;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Course;
import com.javabeans.Student;


@WebServlet("/CourseDetailServlet")
public class CourseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String hidden = request.getParameter("hide").trim();
		String tno = request.getParameter("tno").trim();
		String cno = request.getParameter("cno").trim();
		String tname = request.getParameter("tname").trim();
		UserDao dao = new UserDao();
		ArrayList<Course> courseList = new ArrayList<>();
		if (hidden.equals("student")){
			courseList = dao.findStudentCourse(tno,tname,cno);
		}else {
			courseList = dao.findTeacherCourse(tno,tname,cno);
		}
		
		request.getSession().setAttribute("courseList", courseList);
		RequestDispatcher rd=request.getRequestDispatcher("/search_course.jsp");
		if (hidden.equals("student")){
			rd=request.getRequestDispatcher("/stu_search_course.jsp");
		}
		rd.forward(request, response);
	}

}
