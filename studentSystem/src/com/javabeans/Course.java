package com.javabeans;
import java.io.Serializable;

public class Course {
	private String cno;//�γ̱��
	private String cname;//�γ�����
	private String tno;//��ʦ���
	private String tname;//��ʦ����
	private String term;//ѧ��
	private int ctime;//ѧʱ
	private String exam;//���鷽ʽ
	private int credit;//ѧ��
	private String classNo;//�༶���
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
