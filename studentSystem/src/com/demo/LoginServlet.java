package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javabeans.*;
import com.util.DBUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 5465400451245565416L;
	Connection dbconn = null;
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	DBUtil dbUtil = new DBUtil();
	UserDao userDao = new UserDao();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		connection = dbUtil.getConnection();
		
		String peopletype = request.getParameter("peopletype");
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String location = "/login.jsp";
		UserDao dao = new UserDao();
		if (peopletype.equals("student")) {
			try {
				String sql = "SELECT * FROM a_student WHERE sname = ? ";
//				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, username);
				rst = pstmt.executeQuery();
				if (rst.next()) {
					if (password.equals(rst.getString("spassword").trim())) {
						location = "/student_infomation.jsp";
						Student student = new Student();
						student.setSno(rst.getString("sno"));
						student.setSpassword(rst.getString("spassword"));
						student.setSname(rst.getString("sname"));
						student.setSsex(rst.getString("ssex"));
						student.setSage(rst.getInt("sage"));
						student.setSorigin(rst.getString("sorigin"));
						student.setScredit(rst.getInt("scredit"));
						student.setScno(rst.getString("scno"));
						request.getSession().setAttribute("student", student);
					}
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				dbUtil.close(rst,pstmt,connection);
			}
			
			ArrayList<String> termList = dao.search_course_term();
			request.getSession().setAttribute("courseTermList", termList);
		}
		
				
		else if (peopletype.equals("teacher")) {
			try {
				String sql = "SELECT * FROM a_teacher WHERE tname = ?";
//				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, username);
				rst = pstmt.executeQuery();
				if (rst.next()) {
					if (password.equals(rst.getString("tpassword").trim())) {
						location = "/teacher_infomation.jsp";
						Teacher teacher = new Teacher();
						teacher.setTno(rst.getString("tno"));
						teacher.setTpassword(rst.getString("tpassword"));
						teacher.setTname(rst.getString("tname"));
						teacher.setTsex(rst.getString("tsex"));
						teacher.setTage(rst.getInt("tage"));
						teacher.setTtitle(rst.getString("ttitle"));
						teacher.setTphone(rst.getString("tphone"));
						request.getSession().setAttribute("teacher", teacher);
					}
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				dbUtil.close(rst,pstmt,connection);
			}
			
			ArrayList<String> termList = dao.search_course_term();
			request.getSession().setAttribute("courseTermList", termList);
			ArrayList<Course> courseList = userDao.getCourses();
			request.getSession().setAttribute("courseList", courseList);
		}
		
		else if (peopletype.equals("manager")) {
			try {
				String sql = "SELECT * FROM a_manager  WHERE mname = ?";
//				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, username);
				rst = pstmt.executeQuery();
				if (rst.next()) {
					if (password.equals(rst.getString("mpassword").trim())) {
						location = "/manager_add_student.jsp";
						Manager manager = new Manager();
						manager.setMname(rst.getString("mname"));
						manager.setMpassword(rst.getString("mpassword"));
						request.getSession().setAttribute("manager", manager);
					}
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				dbUtil.close(rst,pstmt,connection);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(location);
		rd.forward(request, response);
	}
}

