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
	
	// ���ѧ����Ϣ
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
	
	//ɾ��ѧ����Ϣ
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
	
	//��ӽ�ʦ��Ϣ
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
	
	//ɾ����ʦ��Ϣ
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
	
	//��Ӱ༶��Ϣ
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

	
	//ɾ���༶��Ϣ
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
	
	//��ӿγ���Ϣ
	public boolean addCourse(Course course) {
		String sql = "INSERT INTO a_course"
				+ " VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = dbUtil.getConnection();
		    pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getCcno());
			pstmt.setString(2, course.getCcname());
			pstmt.setString(3, course.getTno());
			pstmt.setString(4, course.getCterm());
			pstmt.setInt(5, course.getCtime());
			pstmt.setString(6, course.getCexam());
			pstmt.setInt(7, course.getCcredit());
			pstmt.setString(8, course.getClassNo());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}finally{
			dbUtil.close(null,pstmt, conn);
		}
	}
	
	//��ѯ�γ���Ϣ
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
	
	//ɾ���γ���Ϣ
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
	
	// ��ѯѧ����Ϣ
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
	
	// ��������ѯѧ����Ϣ
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
	
	
	// ��ѯ������ʦ��Ϣ
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
		
		
		// ��ѯ������ʦ��Ϣ
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
	
	// ��ѧ�ڲ�ѯѧ���ɼ�     
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

	
	
	// ��ѯȫ��ѧ��ѧ��
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

	// ��ѯ��ʦ��Ϣ
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

	// �ɼ�����
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




	// �γ̲�ѯ
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
	
	// �γ̿���
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
	
	//���γ� �� ѧ�ڻ�ȡѧ��
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
	
	// ��ȡѧ���ɼ�
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
	
	
	
	
	// ��ʦѧ��
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
	
	

	// ��ӳɼ�
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
	
	//��ѯ�γ�ѧ��
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
	//��ѯѧ��ѧ��
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
	
	
	
	// ����ѧ��ѧ��
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
	
	
	

	// ��ӳɼ�
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

	//���Ĺ���Ա����
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
	
	// ����ѧ������
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
	
	// ���Ľ�ʦ����
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

