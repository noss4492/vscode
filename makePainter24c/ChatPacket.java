package makePainter24c;

import java.io.Serializable;

public class ChatPacket implements Serializable{
	private static final long serialVersionUID = 371509L;
	String sender;
	String msg;
	StringBuffer msgBuffer;
	
	public ChatPacket(String sender, String msg) {
		super();
		this.sender = sender;
		this.msg = msg;
	}
	public ChatPacket(String sender, StringBuffer msglog) {
		super();
		this.sender = sender;
		this.msgBuffer = msglog;
	}
	public ChatPacket(String sender, String msg, StringBuffer msglog) {
		super();
		this.sender = sender;
		this.msg = msg;
		this.msgBuffer = msglog;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public StringBuffer getMsgBuffer() {
		return msgBuffer;
	}
	public void setMsgBuffer(StringBuffer msgBuffer) {
		this.msgBuffer = msgBuffer;
	}
}	
