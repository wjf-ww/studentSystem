package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Credit;
import com.javabeans.Score;
import com.javabeans.Student;
import com.javabeans.Teacher;


@WebServlet("/GetStudentServlet")
public class GetStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		String term = request.getParameter("term");
		String className = request.getParameter("classname");
		Teacher teacher=(Teacher) request.getSession().getAttribute("teacher");
		String tno = teacher.getTno();
//		ArrayList<Score> scoreList = dao.teacher_student(term, tno , className);
		ArrayList<Score> scoreList = dao.findScore(term, tno , className);
		
		ArrayList<Student> studentList = new ArrayList<>();
		if(scoreList != null && scoreList.size() != 0){
			for(Score score : scoreList){
				studentList.add(dao.findBySno(score.getSno()));
			}
		}
		
		request.getSession().setAttribute("studentList", studentList);
		request.getSession().setAttribute("scoreList", scoreList);
		request.getSession().setAttribute("teacher", teacher);
		RequestDispatcher rd=request.getRequestDispatcher("/input_student_score.jsp");
		rd.forward(request, response);

	}

}
