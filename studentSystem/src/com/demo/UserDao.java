package com.demo;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import com.javabeans.*;
import com.util.DBUtil;

public class UserDao{
	DBUtil dbUtil = new DBUtil();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	
	// 添加学生信息
	public boolean addStudent(Student student) {
		String sql = "INSERT INTO a_student"
				+ "(sno,spassword,sname,ssex,sage,sorigin,scredit,scno)VALUES(?,?,?,?,?,?,?,?)";
		try{
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, student.getSno());
			pstmt.setString(2, student.getSpassword());
			pstmt.setString(3, student.getSname());
			pstmt.setString(4, student.getSsex());
			pstmt.setInt(5, student.getSage());
			pstmt.setString(6, student.getSorigin());
			pstmt.setInt(7, student.getScredit());
			pstmt.setString(8, student.getScno());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null, pstmt, conn);
		}

	}
	
	//删除学生信息
	public boolean deleteStudent(String sno) {
		String sql = "DELETE FROM a_student" + " WHERE sno=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//添加教师信息
	public boolean addTeacher(Teacher teacher) {
		String sql = "INSERT INTO a_teacher"
				+ " VALUES(?,?,?,?,?,?,?)";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTno());
			pstmt.setString(2, teacher.getTpassword());
			pstmt.setString(3, teacher.getTname());
			pstmt.setString(4, teacher.getTsex());
			pstmt.setInt(5, teacher.getTage());
			pstmt.setString(6, teacher.getTtitle());
			pstmt.setString(7, teacher.getTphone());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//删除教师信息
	public boolean deleteTeacher(String tno) {
		String sql = "DELETE FROM a_teacher"+ " WHERE tno=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tno);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//添加班级信息
	public boolean addClass(Classes classes) {
		String sql = "INSERT INTO a_class"
				+ " VALUES(?,?,?)";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classes.getClassno());
			pstmt.setString(2, classes.getClassname());
			pstmt.setString(3, classes.getCmajor());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	// 查询课程信息
		public ArrayList<Course> findTeacherCourse(String tno,String tname,String cno) {
			String sql =" SELECT * FROM a_course ";
			
			
			if(tno != null && tno != ""){
				sql = "SELECT * FROM a_course where tno = ?";
			}else if (tno != null && tno != "" && (tname != null && tname != "")){
				sql = "SELECT * FROM a_course where tno = ? and tname = ?";
			}else if (tno != null && tno != "" && (tname != null && tname != "") && (cno != null && cno != "")){
				sql = "SELECT * FROM a_course where tno = ? and tname = ? and classno = ?";
			}else if((tno != null && tno != "") && (cno != null && cno != "")){
				sql = "SELECT * FROM a_course where tno = ?  and classno = ?";
			}else if(tname != null && tname != ""){
				sql = "SELECT * FROM a_course where tname = ?";
			}else if((tname != null && tname != "") && (cno != null && cno != "")){
				sql = "SELECT * FROM a_course where tname = ? and classno = ?";
			}else if(cno != null && cno != ""){
				sql = "SELECT * FROM a_course where classno = ?";
			}
			
			try {
				conn = dbUtil.getConnection();
				pstmt = conn.prepareStatement(sql);

				if(tno != null && tno != ""){
		
					pstmt.setString(1, tno);
				}else if (tno != null && tno != "" && (tname != null && tname != "")){
				
					pstmt.setString(1, tno);
					pstmt.setString(2, tname);
				}else if (tno != null && tno != "" && (tname != null && tname != "") && (cno != null && cno != "")){
					
					pstmt.setString(1, tno);
					pstmt.setString(2,tname);
					pstmt.setString(3, cno);
				}else if((tno != null && tno != "") && (cno != null && cno != "")){
					
					pstmt.setString(1, tno);
					pstmt.setString(2, cno);
				}else if(tname != null && tname != ""){
					
					pstmt.setString(1, tname);
				}else if((tname != null && tname != "") && (cno != null && cno != "")){
					
					pstmt.setString(1, tname);
					pstmt.setString(2, cno);
				}else if(cno != null && cno != ""){
					
					pstmt.setString(1, cno);
				}
				
				
				rst = pstmt.executeQuery();
				
				ArrayList<Course> courseList = new ArrayList<>();
				while (rst.next()) {
					Course course = new Course();
					course.setCcname(rst.getString("cname"));
					course.setCcno(rst.getString("cno"));
					course.setCcredit(rst.getInt("credit"));
					course.setCexam(rst.getString("exam"));
					course.setCterm(rst.getString("term"));
					course.setCtime(rst.getInt("ctime"));
					course.setTno(rst.getString("tno"));
					course.setTname(rst.getString("tname"));
					
					courseList.add(course);
				}
				return courseList;
				
			} catch (SQLException se) {
				se.printStackTrace();
				return null;
			}finally{
				dbUtil.close(rst,pstmt, conn);
			}
		}
		
		//学生报名
		public ArrayList<Course> findStudentCourse(String tno,String tname,String cno) {
			String sql =" SELECT * FROM a_v_student_course ";
			
			if(tno != null && tno != ""){
				sql = "SELECT c.* FROM a_v_student_course where tno = ?";
			}else if (tno != null && tno != "" && (tname != null && tname != "")){
				sql = "SELECT c.* FROM a_v_student_course where tno = ? and tname = ?";
			}else if (tno != null && tno != "" && (tname != null && tname != "") && (cno != null && cno != "")){
				sql = "SELECT c.* FROM a_v_student_course where tno = ? and tname = ? and classno = ?";
			}else if((tno != null && tno != "") && (cno != null && cno != "")){
				sql = "SELECT c.* FROM a_v_student_course where tno = ?  and classno = ?";
			}else if(tname != null && tname != ""){
				sql = "SELECT c.* FROM a_v_student_course where tname = ?";
			}else if((tname != null && tname != "") && (cno != null && cno != "")){
				sql = "SELECT c.* FROM a_v_student_course where tname = ? and classno = ?";
			}else if(cno != null && cno != ""){
				sql = "SELECT c.* FROM a_v_student_course where classno = ?";
			}
			
			try {
				conn = dbUtil.getConnection();
				pstmt = conn.prepareStatement(sql);

				if(tno != null && tno != ""){
		
					pstmt.setString(1, tno);
				}else if (tno != null && tno != "" && (tname != null && tname != "")){
				
					pstmt.setString(1, tno);
					pstmt.setString(2, tname);
				}else if (tno != null && tno != "" && (tname != null && tname != "") && (cno != null && cno != "")){
					
					pstmt.setString(1, tno);
					pstmt.setString(2,tname);
					pstmt.setString(3, cno);
				}else if((tno != null && tno != "") && (cno != null && cno != "")){
					
					pstmt.setString(1, tno);
					pstmt.setString(2, cno);
				}else if(tname != null && tname != ""){
					
					pstmt.setString(1, tname);
				}else if((tname != null && tname != "") && (cno != null && cno != "")){
					
					pstmt.setString(1, tname);
					pstmt.setString(2, cno);
				}else if(cno != null && cno != ""){
					
					pstmt.setString(1, cno);
				}
				
				
				rst = pstmt.executeQuery();
				
				ArrayList<Course> courseList = new ArrayList<>();
				while (rst.next()) {
					Course course = new Course();
					course.setCcname(rst.getString("cname"));
					course.setCcno(rst.getString("cno"));
					course.setCcredit(rst.getInt("credit"));
					course.setCexam(rst.getString("exam"));
					course.setCterm(rst.getString("term"));
					course.setCtime(rst.getInt("ctime"));
					course.setTno(rst.getString("tno"));
					course.setTname(rst.getString("tname"));
					course.setChecked(rst.getInt("checked"));
					course.setClassNo(rst.getString("classno"));
					course.setSno(rst.getString("sno"));
					courseList.add(course);
				}
				return courseList;
				
			} catch (SQLException se) {
				se.printStackTrace();
				return null;
			}finally{
				dbUtil.close(rst,pstmt, conn);
			}
		}
	
	//删除班级信息
	public boolean deleteClass(String cno) {
		String sql = "DELETE FROM a_class"+ " WHERE classno=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cno);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//添加课程信息
	public boolean addCourse(Course course) {
		String sql = "INSERT INTO a_course"
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			conn = dbUtil.getConnection();
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getCcno());
			pstmt.setString(2, course.getCcname());
			pstmt.setString(3, course.getTname());
			pstmt.setString(4, course.getTno());
			pstmt.setString(5, course.getCterm());
			pstmt.setInt(6, course.getCtime());
			pstmt.setString(7, course.getCexam());
			pstmt.setInt(8, course.getCcredit());
			pstmt.setString(9, course.getClassNo());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//添加学生选课信息
		public boolean addStudentCourse(StudentCourse course) {
			String sql = "INSERT INTO a_stu_course"
					+ " VALUES(?,?,?,?)";
			try {
				conn = dbUtil.getConnection();
			    pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, course.getSno());
				pstmt.setString(2, course.getClassno());
				pstmt.setString(3, course.getCno());
				pstmt.setInt(4, course.getChecked());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			}finally{
				dbUtil.close(null,pstmt, conn);
			}
		}
		//删除学生选课信息
				public boolean deleteStudentCourse(StudentCourse course) {
					String sql = "DELETE FROM a_stu_course where sno = ? AND classno =? AND cno =?";
					try {
						conn = dbUtil.getConnection();
					    pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, course.getSno());
						pstmt.setString(2, course.getClassno());
						pstmt.setString(3, course.getCno());
						pstmt.executeUpdate();
						return true;
					} catch (SQLException se) {
						se.printStackTrace();
						return false;
					}finally{
						dbUtil.close(null,pstmt, conn);
					}
				}
		//学生选课后 在成绩表中 添加信息
		public boolean addStuScore(Score score){
			String sql ="INSERT INTO `a_score`(`sno`, `sname`, `term`, `cno`, `cname`,  `tno`, `tname`, `checked`) VALUES (?,?,?,?,?,?,?,?) ";
			try {
				conn = dbUtil.getConnection();
			    pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, score.getSno());
				pstmt.setString(2, score.getSname());
				pstmt.setString(3, score.getTerm());
				pstmt.setString(4, score.getCno());
				pstmt.setString(5, score.getCname());
				pstmt.setString(6, score.getTno());
				pstmt.setString(7, score.getTname());
				pstmt.setInt(8, 0);
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			}finally{
				dbUtil.close(null,pstmt, conn);
			}
		}
		
		//学生退课后 在成绩表中 删除信息
				public boolean deleteStuScore(Score score){
					String sql ="DELETE FROM `a_score` where sno=? AND cno = ? AND term = ?  ";
					try {
						conn = dbUtil.getConnection();
					    pstmt = conn.prepareStatement(sql);
						pstmt.setString(1,score.getSno());
						pstmt.setString(2, score.getCno());
						pstmt.setString(3, score.getTerm());
						pstmt.executeUpdate();
						return true;
					} catch (SQLException se) {
						se.printStackTrace();
						return false;
					}finally{
						dbUtil.close(null,pstmt, conn);
					}
				}
	
	//查询课程信息
	public ArrayList<Course> getCourses(){
		String sql = "SELECT * from a_course ";
		try {
			conn = dbUtil.getConnection();
		    pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			ArrayList<Course> courseList = new ArrayList<>(); 
			while(rst.next()){
				Course course = new Course();
				course.setCcno(rst.getString("cno"));
				course.setCcname(rst.getString("cname"));
				course.setTno(rst.getString("tno"));
				course.setCterm(rst.getString("term"));
				course.setCtime(rst.getInt("ctime"));
				course.setCexam(rst.getString("exam"));
				course.setCcredit(rst.getInt("credit"));
				courseList.add(course);
			}
			return courseList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	//删除课程信息
	public boolean deleteCourse(String ccno) {
		String sql = "DELETE FROM a_course"+ " WHERE cno=? ";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ccno);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	// 查询学生信息
	public Student findBySno(String sno) {
		String sql = "SELECT *" + "FROM a_student " + "WHERE sno = ?";
		Student student = new Student();
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			rst = pstmt.executeQuery();
			
			if (rst.next()) {
				student.setSno(rst.getString("sno"));
				student.setSpassword(rst.getString("spassword"));
				student.setSname(rst.getString("sname"));
				student.setSsex(rst.getString("ssex"));
				student.setSage(rst.getInt("sage"));
				student.setSorigin(rst.getString("sorigin"));
				student.setScredit(rst.getInt("scredit"));
				student.setScno(rst.getString("scno"));
			}
			return student;
			
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	// 按地区查询学生信息
	public ArrayList<Student> findBySbirthplace( String cno) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		String sql = "SELECT * FROM a_student";
		if(cno !=null &&cno!="") {
			sql = "SELECT * FROM a_student where scno = ?";
		}
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(cno !=null &&cno!="") {
				pstmt.setString(1, cno);
			}
			rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setSno(rst.getString("sno"));
				student.setSpassword(rst.getString("spassword"));
				student.setSname(rst.getString("sname"));
				student.setSsex(rst.getString("ssex"));
				student.setSage(rst.getInt("sage"));
				student.setSorigin(rst.getString("sorigin"));
				student.setScredit(rst.getInt("scredit"));
				student.setScno(rst.getString("scno"));
				studentList.add(student);
			}
			return studentList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	
	// 查询所有老师信息
		public ArrayList<Teacher> findAllTeacher() {
			ArrayList<Teacher> teachertList = new ArrayList<Teacher>();
			String sql = "SELECT * FROM a_teacher";
			
			try {
				conn = dbUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
			
				rst = pstmt.executeQuery();
				while (rst.next()) {
					Teacher teacher = new Teacher();
					teacher.setTno(rst.getString("tno"));
					teacher.setTpassword(rst.getString("tpassword"));
					teacher.setTname(rst.getString("tname"));
					teacher.setTsex(rst.getString("tsex"));
					teacher.setTage(rst.getInt("tage"));
					teacher.setTtitle(rst.getString("ttitle"));
					teacher.setTphone(rst.getString("tphone"));
					teachertList.add(teacher);
				}
				return teachertList;
			} catch (SQLException se) {
				se.printStackTrace();
				return null;
			}finally{
				dbUtil.close(rst,pstmt, conn);
			}
		}
		
		
		// 查询所有老师信息
				public ArrayList<Classes> findAllClass() {
					ArrayList<Classes> teachertList = new ArrayList<Classes>();
					String sql = "SELECT * FROM a_class";
					
					try {
						conn = dbUtil.getConnection();
						pstmt = conn.prepareStatement(sql);
					
						rst = pstmt.executeQuery();
						while (rst.next()) {
							Classes teacher = new Classes();
							teacher.setClassno(rst.getString("classno"));
							teacher.setClassname(rst.getString("classname"));
							teacher.setCmajor(rst.getString("cmajor"));
							
							teachertList.add(teacher);
						}
						return teachertList;
					} catch (SQLException se) {
						se.printStackTrace();
						return null;
					}finally{
						dbUtil.close(rst,pstmt, conn);
					}
				}
	
	// 按学期查询学生成绩     
	public ArrayList<Score> findByterm(String term,String sno) {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		String sql = "SELECT *" + " FROM a_v_grade " + "WHERE term = ? and sno = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, term);
			pstmt.setString(2, sno);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				Score score = new Score();
				score.setSno(rst.getString("sno"));
				score.setSname(rst.getString("sname"));
				score.setTerm(rst.getString("term"));
				score.setCname(rst.getString("cname"));
				score.setScore(rst.getString("score"));
				score.setTname(rst.getString("tname"));
				scoreList.add(score);
			}
			return scoreList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
		return null;
	}

	
	
	// 查询全部学生学分
	public ArrayList<Credit> findCredit() {

		ArrayList<Credit> creditList = new ArrayList<Credit>();
		String sql = "SELECT * FROM a_credit";
		try  {
				conn = dbUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				rst = pstmt.executeQuery();
				while (rst.next()) {
					Credit credit = new Credit();
					credit.setSno(rst.getString("sno"));
					credit.setSname(rst.getString("sname"));
					credit.setTerm(rst.getString("term"));
					credit.setCname(rst.getString("cname"));
					credit.setCtime(rst.getInt("ctime"));
					credit.setCredit(rst.getInt("credit"));
					creditList.add(credit);
				}
				return creditList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}

	// 查询教师信息
	public Teacher findByTno(String tno) {
		String sql = "SELECT *" + "FROM a_teacher " + "WHERE tno = ?";

		try  {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tno);
			rst = pstmt.executeQuery();
			Teacher teacher = new Teacher();
			if (rst.next()) {
				teacher.setTno(rst.getString("zj_Tno08"));
				teacher.setTpassword(rst.getString("zj_Tpassword08"));
				teacher.setTname(rst.getString("zj_Tname08"));
				teacher.setTsex(rst.getString("zj_Tsex08"));
				teacher.setTage(rst.getInt("zj_Tage08"));
				teacher.setTtitle(rst.getString("zj_Ttitle08"));
				teacher.setTphone(rst.getString("zj_Tphone08"));
			}
			return teacher;
		
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}

	// 成绩排行
	public ArrayList<Score> rank_score(String tno, String cname,String term,String sname) {

		ArrayList<Score> scoreList = new ArrayList<Score>();
		String sql = "SELECT *" + " FROM a_score " + "WHERE tno = ?"
				+ " AND cname=?"+" AND term=?"+" ORDER BY score DESC";
		if(sname != null && sname != ""){
			sql = "SELECT *" + " FROM a_score " + "WHERE tno = ?"
					+ " AND cname=?"+" AND term=? AND sname = ? "+" ORDER BY score DESC";
		}
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,tno);
			pstmt.setString(2,cname);
			pstmt.setString(3,term);
			if(sname != null && sname != ""){
				pstmt.setString(4, sname);
			}
			rst = pstmt.executeQuery();
			while(rst.next()) {
				Score score = new Score();
				score.setSno(rst.getString("sno"));
				score.setSname(rst.getString("sname"));
				score.setTerm(rst.getString("term"));
				score.setCname(rst.getString("cname"));
				score.setScore(rst.getString("score"));
				score.setTname(rst.getString("tname"));
				score.setTno(rst.getString("tno"));
				scoreList.add(score);
			}
			return scoreList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




	// 课程查询
	public ArrayList<Course> search_course(String tno) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		String sql = "SELECT * FROM a_course WHERE tno=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tno);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				Course course = new Course();
				course.setCcno(rst.getString("cno"));
				course.setCcname(rst.getString("cname"));
				course.setTno(rst.getString("tno"));
				course.setCterm(rst.getString("term"));
				course.setCtime(rst.getInt("ctime"));
				course.setCexam(rst.getString("exam"));
				course.setCcredit(rst.getInt("credit"));
				courseList.add(course);
			}
			return courseList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	public ArrayList<String> search_course_term() {
		ArrayList<String> termList = new ArrayList<String>();
		String sql = "SELECT term FROM a_course GROUP BY term";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				termList.add(rst.getString("term"));
			}
			return termList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	// 课程开设
	public ArrayList<Cc> class_course() {

		ArrayList<Cc> CcList = new ArrayList<Cc>();
		String sql = "SELECT * FROM a_cc";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				Cc cc = new Cc();
				cc.setClassno(rst.getString("classno"));
				cc.setClassname(rst.getString("classname"));
				cc.setCno(rst.getString("cno"));
				cc.setCname(rst.getString("cname"));
				CcList.add(cc);
			}
			return CcList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	//按课程 和 学期获取学生
	public ArrayList<Student> findStudent(String cname,String term){
		ArrayList<Student> studentList = new ArrayList<Student>();
		String sql = "SELECT * FROM a_v_student WHERE term=? AND cname = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, term);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				Student student = new Student();
				student.setSno(rst.getString("sno"));
				student.setSname(rst.getString("sname"));
				student.setSsex(rst.getString("ssex"));
				student.setSage(rst.getInt("age"));
				student.setSorigin(rst.getString("sorigin"));
				student.setScredit(rst.getInt("scredit"));
				student.setScno(rst.getString("scno"));
				studentList.add(student);
			}
			return studentList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	// 获取学生成绩
	public ArrayList<Score> findScore(String term, String tno , String className) {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		String sql = "SELECT * FROM a_score WHERE term=? AND tno=? AND cname = ? AND checked = 0";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, term);
			pstmt.setString(2, tno);
			pstmt.setString(3, className);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				Score score = new Score();
				score.setSno(rst.getString("sno"));
				score.setSname(rst.getString("sname"));
				score.setCno(rst.getString("cno"));
				score.setCname(rst.getString("cname"));
				score.setTerm(rst.getString("term"));
				score.setTno(rst.getString("tno"));
				scoreList.add(score);
			}
			return scoreList;
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	
	
	
	// 教师学生
	public ArrayList<Score> teacher_student(String term, String tno , String className) {
		ArrayList<Score> scoreList = new ArrayList<Score>();
		String sql = "SELECT * FROM a_v_classstudent WHERE term=? AND tno=? AND cname = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, term);
			pstmt.setString(2, tno);
			pstmt.setString(3, className);
			rst = pstmt.executeQuery();
			while (rst.next()) {
				Score score = new Score();
				score.setSno(rst.getString("sno"));
				score.setSname(rst.getString("sname"));
				score.setCno(rst.getString("cno"));
				score.setCname(rst.getString("cname"));
				score.setTerm(rst.getString("term"));
				score.setTno(rst.getString("tno"));
				scoreList.add(score);
			}
			return scoreList;
			
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	}
	
	

	// 添加成绩
	public boolean updateScore(Score Score) {
		String sql = "UPDATE a_score SET  score = ? , checked = 1 "
				+ "WHERE sno = ? AND term = ? AND cname = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(Score.getScore()));
			pstmt.setString(2, Score.getSno());
			pstmt.setString(3, Score.getTerm());
			pstmt.setString(4, Score.getCname());
		
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//查询课程学分
	public int findCourseCreditByCno(String cno){
		String sql = "select credit from a_course c where c.cno =?" ;
		int credit = 0;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cno);
			rst = pstmt.executeQuery();
			while(rst.next()) {
				credit = rst.getInt("credit");
			}
			return credit;
		} catch (SQLException se) {
			se.printStackTrace();
			return credit;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	} 
	//查询学生学分
	public Integer findStudentCredit(String sno){
		String sql = "select scredit from a_student where sno = ?";
		int credit = 0;
		try{
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			
			rst = pstmt.executeQuery();
			
			while(rst.next()){
				credit = rst.getInt("scredit");
			}
			return credit;
		}catch (SQLException se) {
			se.printStackTrace();
			return credit;
		}finally{
			dbUtil.close(rst,pstmt, conn);
		}
	
	}
	
	
	
	// 更新学生学分
	public boolean updateCredit(String sno,int credit ) {
		String sql = "UPDATE a_student SET  scredit = ? "
				+ "WHERE sno = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, credit);
			pstmt.setString(2, sno);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	
	

	// 添加成绩
	public boolean addScore(Score Score) {
		String sql = "INSERT INTO a_score "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Score.getSno());
			pstmt.setString(2, Score.getSname());
			pstmt.setString(3, Score.getTerm());
			pstmt.setString(4,Score.getCno());
			pstmt.setString(5, Score.getCname());
			pstmt.setInt(6, Integer.parseInt(Score.getScore()));
			pstmt.setString(7, Score.getTno());
			pstmt.setString(8, Score.getTname());
			pstmt.setInt(9, Score.getChecked());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}

	//更改管理员密码
	public boolean manager_password(String mpassword, String mname) {
		String sql = "UPDATE a_manager SET mpassword=? WHERE mname=?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mpassword);
			pstmt.setString(2, mname);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt,conn);
		}
	}
	
	// 更改学生密码
	public boolean student_password(String password, String sno ,String sname) {
		String sql = "UPDATE a_student SET spassword=? WHERE sno=?";
		if(sname != null && sname != ""){
			sql = "UPDATE a_student SET spassword=? WHERE sno=? AND sname = ?";
		}
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, sno);
			if(sname != null && sname != ""){
				pstmt.setString(3, sname);
			}
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt,conn);
		}
	}
	
	// 更改教师密码
		public boolean teacher_password(String password, String tno) {
			String sql = "UPDATE a_teacher SET tpassword=? WHERE tno=?";
			try {
				conn = dbUtil.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, password);
				pstmt.setString(2, tno);
				pstmt.executeUpdate();
				return true;
			} catch (SQLException se) {
				se.printStackTrace();
				return false;
			}finally{
				dbUtil.close(null,pstmt,conn);
			}
		}
		

}

