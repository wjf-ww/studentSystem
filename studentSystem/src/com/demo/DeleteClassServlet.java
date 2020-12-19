package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteClassServlet")
public class DeleteClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=null;
		try {
			String cno=request.getParameter("cno");
			UserDao ud=new UserDao();
			ud.deleteClass(cno);
			boolean success=ud.deleteClass(cno);
		   if(success){
			message="<li>³É¹¦É¾³ýÒ»Ìõ¼ÇÂ¼!</li>";
			}else{
			message="<li>É¾³ýÊ§°Ü!</li>";
			}
		}catch(Exception e) {
			message="<li>É¾³ýÊ§°Ü£¡</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/manager_delete_class.jsp");
		rd.forward(request, response);
	}
}
