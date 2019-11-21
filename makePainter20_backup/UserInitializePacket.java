package makePainter20_backup;

import java.io.Serializable;

public class UserInitializePacket implements Serializable {
	static final long serialVersionUID =7234828909L;
	String nickname;
	String monsterType;
	UserInfo infoBox;	
	
	// ������ ������ �� ����
	public UserInitializePacket(UserInfo infoBox) {
		super();
		this.infoBox = infoBox;
	}

	// ������ �۽��� �� ����
	public UserInitializePacket(String nickname, String monsterType) {
		super();
		this.nickname = nickname;
		this.monsterType = monsterType;
	}
	
	public UserInfo getInfoBox() {
		return infoBox;
	}
	
	public void setInfoBox(UserInfo infoBox) {
		this.infoBox = infoBox;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
