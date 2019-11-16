package makePainter12;

import java.io.Serializable;

// 내부 정보를 아예 userinfo class로 묶어서 쓰려고 하니 조금 불편해서 그냥 변수들도 따로 가지고 있게 만들었다.
// 옛날 같았으면 메모리 낭비한다고 한 소리 들었을듯?
public class UserInfoPacket implements Serializable{
	private static final long serialVersionUID = 72348740L;	// 역직렬화시 문제될까봐 수동 설정해줌
	private int seq;			// 
	private boolean examiner;   // 
	private String nickname;	// 
	private int point; 	  		// 
	private String monsterType;	// 
	private UserInfo info;		// 위는 단순히 인자로 쓰려고 만든애들이고 실제로는 얘가 주 목적 
	
	// UserInfo 단위로 써야할 때
	public UserInfoPacket(UserInfo info) { 
		super();
		this.info = info;
	}
	 // 유저 -> 서버
	public UserInfoPacket(String nickname, String monsterType) {
		super();
		this.nickname = nickname;
		this.monsterType = monsterType;
	}
	// 서버 -> 유저 ,  어차피 info로 꺼낼거라 내부 인자들은 설정 안함
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


