package com.javabeans;
import java.io.Serializable;
public class Manager implements Serializable{
	private String mname;//管理员名称
	private String mpassword;//管理员密码
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
}