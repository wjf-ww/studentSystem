package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.*;

@WebServlet("/SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		String tno = teacher.getTno();
		ArrayList<Course> courseList=new ArrayList<Course>();
		courseList = dao.search_course(tno);
		ArrayList<String> termList = new ArrayList<String>();
		
		System.out.print(termList);
		request.getSession().setAttribute("courseList", courseList);
		RequestDispatcher rd=request.getRequestDispatcher("/teacher_search_course.jsp");
		rd.forward(request, response);
	}
}
