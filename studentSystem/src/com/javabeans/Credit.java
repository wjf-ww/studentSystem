package com.javabeans;
import java.io.Serializable;

public class Credit {
	private String sno;//ѧ�����
	private String sname;//ѧ������
	private String term;//ѧ��
	private String cname;//�γ�����
	private int ctime;//ѧʱ
	private int credit;//ѧ��
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
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int i) {
		this.credit = i;
	}
	public int getCtime() {
		return ctime;
	}
	public void setCtime(int ctime) {
		this.ctime = ctime;
	}
	
}
