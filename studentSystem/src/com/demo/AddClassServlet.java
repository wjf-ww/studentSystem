package com.demo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Classes;
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 9066388081872572988L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		Classes classes = new Classes();
		String message=null;
		try{
			classes.setClassno(request.getParameter("cno"));
			classes.setClassname(request.getParameter("cname"));
			classes.setCmajor(request.getParameter("cmajor"));
			boolean success=dao.addClass(classes);
			if(success)
			{
				message = "<li>成功插入班级信息！</li>";
			}else{
				message = "<li>插入班级信息失败！</li>";                        
			}	
			
		}catch(Exception e){
			e.printStackTrace();
			message = "<li>插入班级信息错误！</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=request.getRequestDispatcher("/manager_add_class.jsp");
		rd.forward(request, response);
	}
}
