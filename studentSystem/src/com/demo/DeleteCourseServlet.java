package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteCourseServlet")
public class DeleteCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=null;
		try {
			String ccno=request.getParameter("Ccno");
			UserDao ud=new UserDao();
			ud.deleteCourse(ccno);
			boolean success=ud.deleteCourse(ccno);
		   if(success){
			message="<li>�ɹ�ɾ��һ����¼!</li>";
			}else{
			message="<li>ɾ��ʧ��!</li>";
			}
		}catch(Exception e) {
			message="<li>ɾ��ʧ�ܣ�</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/manager_delete_course.jsp");
		rd.forward(request, response);
	}

}
