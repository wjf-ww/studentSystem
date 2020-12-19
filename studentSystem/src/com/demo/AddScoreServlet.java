package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Score;
import com.javabeans.Student;
import com.javabeans.Teacher;

@WebServlet("/AddScoreServlet")
public class AddScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Teacher teacher = (Teacher) request.getSession()
				.getAttribute("teacher");
		UserDao dao = new UserDao();
		String message = null;
		try {
			Score score = new Score();
			score.setSno(request.getParameter("sno"));
			score.setCno(request.getParameter("cno"));
			score.setTerm(request.getParameter("term"));
			score.setScore(request.getParameter("score"));
			score.setTno(request.getParameter("tno"));
			
			score.setSname(request.getParameter("sname"));
			score.setCname(request.getParameter("cname"));
			score.setTname(request.getParameter("tname"));
			score.setChecked(1);
//			boolean success = dao.addScore(score);
			//���ѧ���ɼ�
			boolean success = dao.updateScore(score);
			if(success)
			{
				message = "<li>����ɼ��ɹ���</li>";
			}else{
				message = "<li>>����ɼ�ʧ�ܣ�</li>";
			}

		} catch (Exception e) {
			e.printStackTrace();
			message = "<li>>����ɼ�����</li>";
		}
		
		//��ѯѧ��ѧ��
		int StudentCredit = dao.findStudentCredit(request.getParameter("sno"));
		//��ѯ�γ�ѧ��
		int CourseCredit = dao.findCourseCreditByCno(request.getParameter("sno"));
		//�޸�ѧ��ѧ��
		dao.updateCredit(request.getParameter("sno"), StudentCredit + CourseCredit );
		
		request.setAttribute("result", message);
		Student student = dao.findBySno(request.getParameter("sno"));
		request.getSession().setAttribute("student", student);

		//����δ��ӳɼ���ѧ��
		ArrayList<Score> scoreList = dao.findScore(request.getParameter("term"), request.getParameter("tno") , request.getParameter("cname"));
		request.getSession().setAttribute("scoreList", scoreList);
		//�����޸��� ѧ��֮���ѧ����Ϣ
		ArrayList<Student> studentList = dao.findStudent(request.getParameter("cname"),request.getParameter("term"));
		request.getSession().setAttribute("studentList", studentList);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/input_student_score.jsp");
		rd.forward(request, response);
	}
}
