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
import com.javabeans.Teacher;


@WebServlet("/TeacherDetailServlet")
public class TeacherDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		ArrayList<Teacher> teachertList = new ArrayList<Teacher>();
		teachertList = dao.findAllTeacher();
		request.getSession().setAttribute("teacherList", teachertList);
		RequestDispatcher rd=request.getRequestDispatcher("/search_techer.jsp");
		rd.forward(request, response);
	}

}
