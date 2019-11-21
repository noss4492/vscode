package makePainter18;

import java.io.Serializable;
import java.util.ArrayList;

public class DisplayInfoPacket implements Serializable{
	private static final long serialVersionUID = 390945020L;
	ArrayList<UserInfo> userinfo;

	public DisplayInfoPacket(ArrayList<UserInfo> userinfo) {
		super();
		this.userinfo = userinfo;
	}

	public ArrayList<UserInfo> getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(ArrayList<UserInfo> userinfo) {
		this.userinfo = userinfo;
	}
}
