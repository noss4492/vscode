package makePainter12;

import java.io.Serializable;

// 유저 정보의 초기화를 수행할 목적으로 생성된 클래스
// 1. 유저 -> 서버 (nickname, monstertype)
// 2. 서버 -> 유저 (seq, examiner, nickname, point, mnsterType)
public class UserInitializePacket implements Serializable {
	private static final long serialVersionUID = 7234878509L;	// 역직렬화시 문제될까봐 수동 설정해줌
	private int seq;			// 유저 순서, 유저에게 부여된 번호(1~8)
	private boolean examiner;   // 지금 이사람이 출제자 인지
	private String nickname;	// 이 부분은 유저 로그인시 해당 클라이언트에서 조회 후 업데이트 됨
	private int point; 	  		// 이 부분은 서버에서 초기화되며 게임 진행시 서버에서 업데이트 함
	private String monsterType;	// 유저가 고른 몬스터 타입
	private UserInfo info;		// 위는 단순히 인자로 쓰려고 만든애들이고 실제로는 얘가 주 목적 
	
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
