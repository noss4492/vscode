package makePainter3;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;

public class BoxedStrokePoint implements Serializable{
	
	ArrayList<Integer> pointX;
	ArrayList<Integer> pointY;
	
	public BoxedStrokePoint(ArrayList<Integer> pointX, ArrayList<Integer> pointY) {
		super();
		this.pointX = pointX;
		this.pointY = pointY;
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
}