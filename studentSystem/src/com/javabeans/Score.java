package com.javabeans;
import java.io.Serializable;

public class Score implements Serializable{
	private String sno;//ѧ��
	private String sname;//ѧ������
	private String term;//ѧ��
	private String cno;//�γ̱��
	private String cname;//�γ�����
	private String score;//�ɼ�
	private String tno;//��ʦ���
	private String tname;//��ʦ����
	private int checked;//�Ƿ� �Ѿ���ӳɼ�
	
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
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	
	public int getChecked() {
		return checked;
	}
	
	public void setChecked(int checked) {
		this.checked = checked;
	}
	
	
}
