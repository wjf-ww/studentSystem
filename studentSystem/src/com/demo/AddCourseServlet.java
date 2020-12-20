package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Course;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		Course course = new Course();
		String message=null;
		try{
			course.setCcno(request.getParameter("ccno"));
			course.setCcname(request.getParameter("ccname"));
			course.setTname(request.getParameter("tname"));
			course.setTno(request.getParameter("tno"));
			course.setCterm(request.getParameter("cterm"));
			course.setClassNo(request.getParameter("classno"));
			course.setCtime(Integer.parseInt(request.getParameter("ctime")));
			course.setCexam(request.getParameter("cexam"));
			course.setCcredit(Integer.parseInt(request.getParameter("ccredit")));
			boolean success=dao.addCourse(course);
			if(success)
			{
				message = "<li>�ɹ�����γ���Ϣ��</li>";
			}else{
				message = "<li>����ѧ���γ�ʧ�ܣ�</li>";                        
			}	
			
		}catch(Exception e){
			e.printStackTrace();
			message = "<li>����γ���Ϣ����</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=request.getRequestDispatcher("/manager_add_course.jsp");
		rd.forward(request, response);
	}

}
