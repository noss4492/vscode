package makePainter21_backup_load;

import java.io.Serializable;
import java.util.ArrayList;

public class StrokePointPacket implements Serializable{
	
	private static final long serialVersionUID = 25490309825L;
	ArrayList<Integer> pointX;
	ArrayList<Integer> pointY;
	ArrayList<Integer> colorF;	
	//[0~9 -> color : RGB] [10~99 -> function : clsscr] [100~999 -> other : special color]

	public StrokePointPacket(ArrayList<Integer> pointX, ArrayList<Integer> pointY) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
	}
	public StrokePointPacket(ArrayList<Integer> color ,ArrayList<Integer> pointX, ArrayList<Integer> pointY) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
		this.colorF = color;
	}

	public ArrayList<Integer> getPointX() {
		return pointX;
	}

	public void setPointX(ArrayList<Integer> pointX) {
		this.pointX = pointX;
	}

	public ArrayList<Integer> getPointY() {
		return pointY;
	}

	public void setPointY(ArrayList<Integer> pointY) {
		this.pointY = pointY;
	}

	public ArrayList<Integer> getColorF() {
		return colorF;
	}

	public void setColorF(ArrayList<Integer> colorF) {
		this.colorF = colorF;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}