package makePainter12;

import java.io.Serializable;

// ���� ������ �ʱ�ȭ�� ������ �������� ������ Ŭ����
// 1. ���� -> ���� (nickname, monstertype)
// 2. ���� -> ���� (seq, examiner, nickname, point, mnsterType)
public class UserInitializePacket implements Serializable {
	private static final long serialVersionUID = 7234878509L;	// ������ȭ�� �����ɱ�� ���� ��������
	private int seq;			// ���� ����, �������� �ο��� ��ȣ(1~8)
	private boolean examiner;   // ���� �̻���� ������ ����
	private String nickname;	// �� �κ��� ���� �α��ν� �ش� Ŭ���̾�Ʈ���� ��ȸ �� ������Ʈ ��
	private int point; 	  		// �� �κ��� �������� �ʱ�ȭ�Ǹ� ���� ����� �������� ������Ʈ ��
	private String monsterType;	// ������ �� ���� Ÿ��
	private UserInfo info;		// ���� �ܼ��� ���ڷ� ������ ����ֵ��̰� �����δ� �갡 �� ���� 
	
	public UserInitializePacket(UserInfo info) {
		super();
		this.info = info;
	}

	public UserInitializePacket(String nickname, String monsterType) {
		super();
		this.nickname = nickname;
		this.monsterType = monsterType;
	}
	
	public UserInitializePacket(int seq, boolean examiner, String nickname, int point, String monsterType) {
		super();
//		this.seq = seq;
//		this.examiner = examiner;
//		this.nickname = nickname;
//		this.point = point;
//		this.monsterType = monsterType;
		this.info.setSeq(seq);
		this.info.setExaminer(examiner);
		this.info.setNickname(nickname);
		this.info.setPoint(point);
		this.info.setMonsterType(monsterType);
	}
	
	public int getSeq() {
		return getSeq();
	}
	public void setSeq(int seq) {
		this.setSeq(seq);
	}
	public boolean isExaminer() {
		return isExaminer();
	}
	public void setExaminer(boolean examiner) {
		this.setExaminer(examiner);
	}
	public String getNickname() {
		return getNickname();
	}
	public void setNickname(String nickname) {
		this.setNickname(nickname);
	}
	public int getPoint() {
		return getPoint();
	}
	public void setPoint(int point) {
		this.setPoint(point);
	}
	public String getMonsterType() {
		return getMonsterType();
	}
	public void setMonsterType(String monsterType) {
		this.setMonsterType(monsterType);
	}
	public UserInfo getInfo() {
		return info;
	}
	public void setInfo(UserInfo info) {
		this.info = info;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
