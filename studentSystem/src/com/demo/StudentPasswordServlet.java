package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.*;


@WebServlet("/StudentPasswordServlet")
public class StudentPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Student student = (Student) request.getSession().getAttribute("student");
		String old_password = request.getParameter("old_password").trim();
		String new_password = request.getParameter("new_password").trim();
		UserDao dao = new UserDao();
		String message = null;
		try {
			if (old_password.equals(student.getSpassword().trim())) {
				boolean success = dao.student_password(new_password,student.getSno(),null);
				if(success)
				{
					message = "<li>ÃÜÂëĞŞ¸Ä³É¹¦</li>";
				}
				else message = "<li>ÃÜÂëĞŞ¸ÄÊ§°Ü</li>";
			}
			else message = "<li>Ô­ÏÈÃÜÂë´íÎó</li>";
		} catch (Exception e) {
			e.printStackTrace();
			message = "<li>ÃÜÂëĞŞ¸Ä´íÎó</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = request
				.getRequestDispatcher("/student_password.jsp");
		rd.forward(request, response);
	}

}
