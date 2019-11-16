package makePainter12;

import java.io.Serializable;

public class ChatPacket implements Serializable{
	static final long serialVersionUID = 3333L;
	String msg = null;

	public ChatPacket(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
