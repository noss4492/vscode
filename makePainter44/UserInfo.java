package makePainter44;

import java.io.Serializable;

public class UserInfo implements Serializable{
	static final long serialVersionUID = 9999L;	// 역직렬화시 문제될까봐 수동 설정해줌
	int seq;	// 유저 순서, 유저에게 부여된 번호(1~8)
	boolean examiner; // 지금 이사람이 출제자 인지
//	Socket client;	// 해당 유저 소켓 // 응 소켓 직렬화 안돼
	
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
