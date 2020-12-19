package com.demo;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Classes;
import com.javabeans.Student;
import com.javabeans.Teacher;


@WebServlet("/ClassDetailServlet")
public class ClassDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		ArrayList<Classes> teachertList = new ArrayList<Classes>();
		teachertList = dao.findAllClass();
		request.getSession().setAttribute("classList", teachertList);
		RequestDispatcher rd=request.getRequestDispatcher("/search_class.jsp");
		rd.forward(request, response);
	}

}
