package com.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.Course;
import com.javabeans.Score;
import com.javabeans.StudentCourse;

@WebServlet("/DeletStudentCourseServlet")
public class DeletStudentCourseServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao dao = new UserDao();
		Course course = new Course();
		String message=null;
		String cno = request.getParameter("cno");
		String scno = request.getParameter("scno");
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ccno = request.getParameter("ccno");
		String ccname = request.getParameter("ccname");
		String term = request.getParameter("term");
		String tno = request.getParameter("tno");
		String tname = request.getParameter("tname");
	
		
		Score score = new Score();
		StudentCourse studentCourse = new StudentCourse();
		
		try{
			studentCourse.setClassno(cno);
			studentCourse.setCno(ccno);
			studentCourse.setSno(sno);
			studentCourse.setChecked(1);
			
			score.setCname(ccname);
			score.setCno(ccno);
			score.setSname(sname);
			score.setSno(sno);
			score.setTerm(term);
			score.setTname(tname);
			score.setTno(tno);
			score.setChecked(0);
			
			boolean success=dao.deleteStudentCourse(studentCourse);
			boolean success2 =dao.deleteStuScore(score);
			if(success && success2)
			{
				message = "<li>退课成功</li>";
			}else{
				if(success == false){
					message = "<li>退课失败，联系管理员</li>";        
				}else {
					message = "<li>退课失败，联系管理员</li>";   
				}
				                
			}	
			
		}catch(Exception e){
			e.printStackTrace();
			message = "<li>插入课程信息错误！</li>";
		}
		request.setAttribute("result", message);
		RequestDispatcher rd=request.getRequestDispatcher("/stu_search_course.jsp");
		rd.forward(request, response);
	}
}
