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


@WebServlet("/ClassCourseServlet")
public class ClassCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		ArrayList<Cc> ccList=new ArrayList<Cc>();
		ccList = dao.class_course();
		request.getSession().setAttribute("ccList", ccList);
		RequestDispatcher rd=request.getRequestDispatcher("/teacher_class_course.jsp");
		rd.forward(request, response);
	}

}
