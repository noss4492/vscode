package makePainter13;

import java.io.Serializable;

public class UserInfoPacket implements Serializable{
	static final long serialVersionUID = 7234824909L;	// 역직렬화시 문제될까봐 수동 설정해줌
	int seq;			// 유저 순서, 유저에게 부여된 번호(1~8)
	boolean examiner;   // 지금 이사람이 출제자 인지
	String nickname;	// 이 부분은 유저 로그인시 해당 클라이언트에서 조회 후 업데이트 됨
	int point; 	  		// 이 부분은 서버에서 초기화되며 게임 진행시 서버에서 업데이트 함
	String monsterType;	// 유저가 고른 몬스터 타입
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


