package makePainter12;

public class UserInfo {
	private int seq;			// ���� ����, �������� �ο��� ��ȣ(1~8)
	private boolean examiner;   // ���� �̻���� ������ ����
	private String nickname;	// �� �κ��� ���� �α��ν� �ش� Ŭ���̾�Ʈ���� ��ȸ �� ������Ʈ ��
	private int point; 	  		// �� �κ��� �������� �ʱ�ȭ�Ǹ� ���� ����� �������� ������Ʈ ��
	private String monsterType;	// ������ �� ���� Ÿ��
	
	public UserInfo(int seq, boolean examiner, String nickname, int point, String monsterType) {
		super();
		this.seq = seq;
		this.examiner = examiner;
		this.nickname = nickname;
		this.point = point;
		this.monsterType = monsterType;
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

}
