package makePainter12;

import java.io.Serializable;

// ���� ������ �ƿ� userinfo class�� ��� ������ �ϴ� ���� �����ؼ� �׳� �����鵵 ���� ������ �ְ� �������.
// ���� �������� �޸� �����Ѵٰ� �� �Ҹ� �������?
public class UserInfoPacket implements Serializable{
	private static final long serialVersionUID = 72348740L;	// ������ȭ�� �����ɱ�� ���� ��������
	private int seq;			// 
	private boolean examiner;   // 
	private String nickname;	// 
	private int point; 	  		// 
	private String monsterType;	// 
	private UserInfo info;		// ���� �ܼ��� ���ڷ� ������ ����ֵ��̰� �����δ� �갡 �� ���� 
	
	// UserInfo ������ ����� ��
	public UserInfoPacket(UserInfo info) { 
		super();
		this.info = info;
	}
	 // ���� -> ����
	public UserInfoPacket(String nickname, String monsterType) {
		super();
		this.nickname = nickname;
		this.monsterType = monsterType;
	}
	// ���� -> ���� ,  ������ info�� �����Ŷ� ���� ���ڵ��� ���� ����
	public UserInfoPacket(int seq, boolean examiner, String nickname, int point, String monsterType) {
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


