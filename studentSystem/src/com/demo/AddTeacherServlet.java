package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Teacher;


@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		Teacher teacher = new Teacher();
		String message=null;
		try{
			teacher.setTno(request.getParameter("tno"));
			teacher.setTpassword(request.getParameter("tpassword"));
			teacher.setTname(request.getParameter("tname"));
			teacher.setTsex(request.getParameter("tsex"));
			teacher.setTage(Integer.parseInt(request.getParameter("tage")));
			teacher.setTtitle(request.getParameter("ttitle"));
			teacher.setTphone(request.getParameter("tphone"));
			boolean success=dao.addTeacher(teacher);
			if(success)
			{
				message = "<li>成功插入教师信息！</li>";
			}else{
				message = "<li>插入教师信息失败！</li>";                        
			}	
			
		}catch(Exception e){
			e.printStackTrace();
			message = "<li>插入教师信息错误！</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=request.getRequestDispatcher("/manager_add_teacher.jsp");
		rd.forward(request, response);
	}

}
