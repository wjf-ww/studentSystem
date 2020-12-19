package com.javabeans;
import java.io.Serializable;
public class Classes {
	private String classno;//班级编号
	private String classname;//班级名称
	private String cmajor;//专业名称
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getCmajor() {
		return cmajor;
	}
	public void setCmajor(String cmajor) {
		this.cmajor = cmajor;
	}
}