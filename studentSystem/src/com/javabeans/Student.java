package com.javabeans;
import java.io.Serializable;
public class Student implements Serializable{
	private String sno;//ѧ��
	private String sname;//����
	private String ssex;//�Ա�
	private int sage;//����
	private String sorigin;//��Դ���ڵ�
	private int scredit;//����ѧ��
	private String scno;//�༶���
	private String spassword;//����
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

