package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Teacher;
@WebServlet("/UpdateStudentPassword")
public class UpdateStudentPassword extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String sno = request.getParameter("sno").trim();
		String sname = request.getParameter("sname").trim();
		String new_password = request.getParameter("new_password").trim();
		UserDao dao = new UserDao();
		String message = null;
		try {
				boolean success = dao.student_password(new_password,sno,sname);
				if(success)
				{
					System.out.print("ĞŞ¸ÄÃÜÂë³É¹¦");
					message = "<li>ÃÜÂëĞŞ¸Ä³É¹¦</li>";
				}
				else message = "<li>ÃÜÂëĞŞ¸ÄÊ§°Ü</li>";
		} catch (Exception e) {
			e.printStackTrace();
			message = "<li>ÃÜÂëĞŞ¸Ä´íÎó</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd = request
				.getRequestDispatcher("/update_student_password.jsp");
		rd.forward(request, response);
	}
}
