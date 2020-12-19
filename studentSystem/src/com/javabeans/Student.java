package com.javabeans;
import java.io.Serializable;
public class Student implements Serializable{
	private String sno;//学号
	private String sname;//姓名
	private String ssex;//性别
	private int sage;//年龄
	private String sorigin;//生源所在地
	private int scredit;//已修学分
	private String scno;//班级编号
	private String spassword;//密码
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSorigin() {
		return sorigin;
	}
	public void setSorigin(String sorigin) {
		this.sorigin = sorigin;
	}
	public int getScredit() {
		return scredit;
	}
	public void setScredit(int scredit) {
		this.scredit = scredit;
	}
	public String getScno() {
		return scno;
	}
	public void setScno(String scno) {
		this.scno = scno;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
}

