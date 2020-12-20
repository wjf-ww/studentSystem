package com.javabeans;
import java.io.Serializable;

public class Course {
	private String cno;//课程编号
	private String cname;//课程名称
	private String tno;//教师编号
	private String tname;//教师姓名
	private String term;//学期
	private int ctime;//学时
	private String exam;//考查方式
	private int credit;//学分
	private String classNo;//班级编号
	private Integer checked;
	private String sno;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCcno() {
		return cno;
	}
	public void setCcno(String cno) {
		this.cno = cno;
	}
	public String getCcname() {
		return cname;
	}
	public void setCcname(String cname) {
		this.cname = cname;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	
	
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public String getCterm() {
		return term;
	}
	public void setCterm(String term) {
		this.term = term;
	}
	public int getCtime() {
		return ctime;
	}
	public void setCtime(int ctime) {
		this.ctime = ctime;
	}
	public String getCexam() {
		return exam;
	}
	public void setCexam(String exam) {
		this.exam = exam;
	}
	public int getCcredit() {
		return credit;
	}
	public void setCcredit(int credit) {
		this.credit = credit;
	}
	
	public String getClassNo() {
		return classNo;
	}
	public void setClassNo(String  classNo) {
		this.classNo = classNo;
	}
}
