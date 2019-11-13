package makePainter44;

import java.io.Serializable;

public class UserInfo implements Serializable{
	static final long serialVersionUID = 9999L;	// ������ȭ�� �����ɱ�� ���� ��������
	int seq;	// ���� ����, �������� �ο��� ��ȣ(1~8)
	boolean examiner; // ���� �̻���� ������ ����
//	Socket client;	// �ش� ���� ���� // �� ���� ����ȭ �ȵ�
	
	public UserInfo(int seq, boolean examiner) {
		super();
		this.seq = seq;
		this.examiner = examiner;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public boolean isExaminer() {
		return examiner;
	}
	public void setExaminer(boolean examiner) {
		this.examiner = examiner;
	}
}
