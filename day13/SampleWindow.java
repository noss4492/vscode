package day13;

import java.awt.Frame;

public class SampleWindow extends Frame {
	SampleWindow(String title){
		super(title);
		setSize(300, 300);
		setLocation(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		SampleWindow sw = new SampleWindow("â");
	}
}


