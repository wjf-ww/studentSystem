package com.demo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Student;;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 9066388081872572988L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		Student student = new Student();
		String message=null;
		try{
			student.setSno(request.getParameter("sno"));
			student.setSpassword(request.getParameter("spassword"));
			student.setSname(request.getParameter("sname"));
			student.setSsex(request.getParameter("ssex"));
			student.setSage(Integer.parseInt(request.getParameter("sage")));
			student.setSorigin(request.getParameter("sorigin"));
			student.setScredit(Integer.parseInt(request.getParameter("scredit")));
			student.setScno(request.getParameter("cno"));
			boolean success=dao.addStudent(student);
			if(success)
			{
				message = "<li>�ɹ�����ѧ����Ϣ��</li>";
			}else{
				message = "<li>����ѧ����Ϣʧ�ܣ�</li>";                        
			}	
			
		}catch(Exception e){
			e.printStackTrace();
			message = "<li>����ѧ����Ϣ����</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=request.getRequestDispatcher("/manager_add_student.jsp");
		rd.forward(request, response);
	}

}
