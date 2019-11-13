package HomeCatchMind;

import java.io.Serializable;

import javax.swing.JPanel;

public class PaintPacket extends JPanel implements Serializable{
	JPanel jp;
	
	public PaintPacket(JPanel jp) {
		super();
		this.jp = jp;
	}

	public JPanel getJp() {
		return jp;
	}

	public void setJp(JPanel jp) {
		this.jp = jp;
	}
	
}