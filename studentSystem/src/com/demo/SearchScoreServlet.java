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

@WebServlet("/SearchScoreServlet")
public class SearchScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 5755500161884969047L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		String term = request.getParameter("term"); 
		String sno = request.getParameter("sno");
		ArrayList<Score> scoreList=new ArrayList<Score>();
		term = term.trim();
		scoreList = dao.findByterm(term,sno);
		request.getSession().setAttribute("scoreList", scoreList);
		System.out.println(scoreList);
		RequestDispatcher rd=request.getRequestDispatcher("/student_search_score.jsp");
		rd.forward(request, response);
	}
}