package com.demo;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Student;


@WebServlet("/StudentAreaServlet")
public class StudentAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	
		String cno = request.getParameter("class").trim();
		UserDao dao = new UserDao();
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList = dao.findBySbirthplace(cno);
		request.getSession().setAttribute("studentList", studentList);
		RequestDispatcher rd=request.getRequestDispatcher("/search_student_area.jsp");
		rd.forward(request, response);
	}

}
