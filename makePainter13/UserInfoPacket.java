package makePainter13;

import java.io.Serializable;

public class UserInfoPacket implements Serializable{
	static final long serialVersionUID = 7234824909L;	// ������ȭ�� �����ɱ�� ���� ��������
	int seq;			// ���� ����, �������� �ο��� ��ȣ(1~8)
	boolean examiner;   // ���� �̻���� ������ ����
	String nickname;	// �� �κ��� ���� �α��ν� �ش� Ŭ���̾�Ʈ���� ��ȸ �� ������Ʈ ��
	int point; 	  		// �� �κ��� �������� �ʱ�ȭ�Ǹ� ���� ����� �������� ������Ʈ ��
	String monsterType;	// ������ �� ���� Ÿ��
	UserInfo infoBox;	// 
	
	public UserInfoPacket(int seq, boolean examiner, String nickname, int point, String monsterType) {
		super();
//		this.seq = seq;
//		this.examiner = examiner;
//		this.nickname = nickname;
//		this.point = point;
//		this.monsterType = monsterType;
		this.infoBox = new UserInfo(seq, examiner, nickname, point, monsterType);
	}
	public UserInfoPacket(UserInfo infoBox) {
		super();
		this.infoBox = infoBox;
	}
	public UserInfo getInfoBox() {
		return infoBox;
	}
	public void setInfoBox(UserInfo infoBox) {
		this.infoBox = infoBox;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}


