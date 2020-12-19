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

@WebServlet("/SearchCreditServlet")
public class SearchCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		ArrayList<Credit> creditList=new ArrayList<Credit>();
		creditList = dao.findCredit();
		request.getSession().setAttribute("creditList", creditList);
		RequestDispatcher rd=request.getRequestDispatcher("/student_search_credit.jsp");
		rd.forward(request, response);
	}

}
