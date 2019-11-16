package makePainter11;

import java.io.Serializable;

public class UserInitializePacket implements Serializable {
	String nickname;
	String monsterType;
	
	public UserInitializePacket(String nickname, String monsterType) {
		super();
		this.nickname = nickname;
		this.monsterType = monsterType;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMonsterType() {
		return monsterType;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}
	
}
