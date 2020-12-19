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



@WebServlet("/RankScoreServlet")
public class RankScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		String tno = teacher.getTno();
		System.out.println(tno);
		String cname = request.getParameter("cname");
		System.out.println(cname);
		String term = request.getParameter("term");
		System.out.println(term);
		String sname = request.getParameter("sname");
		ArrayList<Score> scoreList = new ArrayList<Score>();
		scoreList = dao.rank_score(tno, cname, term, sname);
		request.getSession().setAttribute("scoreList", scoreList);
		System.out.println(scoreList);
		RequestDispatcher rd=request.getRequestDispatcher("/teacher_rank_score.jsp");
		rd.forward(request, response);
	}

}
