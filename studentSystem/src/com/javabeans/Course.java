package com.javabeans;
import java.io.Serializable;

public class Course {
	private String cno;//�γ̱��
	private String cname;//�γ�����
	private String tno;//��ʦ���
	private String term;//ѧ��
	private int ctime;//ѧʱ
	private String exam;//���鷽ʽ
	private int credit;//ѧ��
	private String classNo;//�༶���
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
