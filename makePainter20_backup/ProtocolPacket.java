package makePainter20_backup;

import java.io.Serializable;

public class ProtocolPacket implements Serializable{
	private static final long serialVersionUID = 94959390L;
	int definedCase;	// 999 -> clear screen
	
	public ProtocolPacket(int definedCase) {
		super();
		this.definedCase = definedCase;	// 1 want
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	public int getDefinedCase() {
		return definedCase;
	}
	public void setDefinedCase(int definedCase) {
		this.definedCase = definedCase;
	}
}
