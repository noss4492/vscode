package day14_2;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CalcAWT1 extends Frame implements ActionListener, WindowListener {
	// �ʿ��Ѱ� ����
	
	// ����
	// ��ư 0~9 00 = + - * /
	// textfield
	
	// �̺�Ʈ
	// �̺�Ʈ ������
	// �̺�Ʈ �������� ���� ��ü
	
	// ������Ʈ�� �ʱ�ȭ
	// ������Ʈ�� ���� �� ��ġ
	// ������Ʈ�� ������ �߰�
	// ������Ʈ�� �߰�
	
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	int w = WIDTH;
	int h = HEIGHT;
	Button[] btn = new Button[16];
	TextField calcDisplay; 
	Font f = new Font("MyFont", Font.BOLD, 26);
	int firstNum = 0;
	int secondNum = 0;
	int result;
	String oper = "";
	
	CalcAWT1(){
		super("-  - - Calculator - -  -");
		setLayout(null);
		
		// �� ���� ���� ���÷��̰� ���� (�׼� ����. ������ �����ֱ⸸ ��)
		int calcSize = 440;				// clacSize is marginBtnWidth*2
		calcDisplay = new TextField(50);
		calcDisplay.setLocation(WIDTH/2-calcSize/2, HEIGHT/10);
		calcDisplay.setSize(calcSize, 50);
		calcDisplay.setFont(f);
		add(calcDisplay);
		
		int btnWidth = 100;
		int btnHeight = 100;
		int marginBtnWidth = btnWidth + 120;//120�� �̻�
		int marginBtnHeight = 110;
		int w = WIDTH/2 - marginBtnWidth;		// + (btnWidth/2)*(0~3);
		int h = 150;
	
		// Button ����. if  i + 1 % 4 == 0 -> ?nd row
		for(int i = 0; i < btn.length; i++) {
			// int j = ( (i+1)%4 > 0 ? i%4-1 : i%4+1; �� �̷����� ��..
			btn[i] = new Button();
			btn[i].setLabel(""+i);
			btn[i].setSize(btnWidth, btnHeight);
			btn[i].setFont(f);
			btn[i].addActionListener(this);
			
			// (i+1)%4�� 0 1 2 3 ����������. i �ε����� �ϳ� �� ���� ���ϸ� ��.
			int j = i-1;
			btn[i].setLocation(w + (marginBtnWidth/2)*((j+1)%4), h);
			
			if((i+1)%4==0){
				h += marginBtnHeight;
			}
			add(btn[i]);
		}
		
		btnSetLabel();
		
		setBackground(Color.DARK_GRAY);
		setSize(WIDTH, HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
	});
		
	}
	public static void main(String[] args) {
		CalcAWT1 hw4 = new CalcAWT1();
	}

	public void btnSetLabel() {
		btn[0].setLabel("7");
		btn[1].setLabel("8");
		btn[2].setLabel("9");
		btn[3].setLabel("+");
		btn[4].setLabel("6");
		btn[5].setLabel("5");
		btn[6].setLabel("4");
		btn[7].setLabel("-");
		btn[8].setLabel("1");
		btn[9].setLabel("2");
		btn[10].setLabel("3");
		btn[11].setLabel("*");
		btn[12].setLabel("0");
		btn[13].setLabel("C");	// 00 -> C�� �����
		btn[14].setLabel("=");
		btn[15].setLabel("/");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String cmd = e.getActionCommand();//��ư�� ���� ��������. �ܱ��� ��į?
		String cmd = e.getActionCommand();
		Object obj = e.getSource();	//�� ��� ���� ��������
		
		
		/* 		����     +   *   -  /   =
				�ε���  3  11   7  15  14
		 */
		if(obj == btn[3]) {		// + ��ư ������ ���� �ϳ� ����, + ���
			firstNum = Integer.parseInt(calcDisplay.getText());
			oper = "+";
			calcDisplay.setText("");
		}
		else if(obj == btn[7]) {
			firstNum = Integer.parseInt(calcDisplay.getText());
			oper = "-";
			calcDisplay.setText("");
		}
		else if(obj == btn[11]) {
			firstNum = Integer.parseInt(calcDisplay.getText());
			oper = "*";
			calcDisplay.setText("");
		}
		else if(obj == btn[15]) {
			firstNum = Integer.parseInt(calcDisplay.getText());
			oper = "/";
			calcDisplay.setText("");
		}
		else if(obj == btn[14]) {	// = ��ư�� ������ 1st (oper) 2nd ����
			secondNum = Integer.parseInt(calcDisplay.getText());
			if(oper.equals("+"))
				result = firstNum + secondNum;
			else if(oper.equals("-"))
				result = firstNum - secondNum;
			else if(oper.equals("*"))
				result = firstNum * secondNum;
			else if(oper.equals("/"))
				result = firstNum / secondNum;
			
			calcDisplay.setText(""+result);
		}
		else {
			String data = calcDisplay.getText();
			calcDisplay.setText(data+cmd);
		}
		
	//	String data = calcDisplay.getText();
		
		//calcDisplay.setText(data+cmd);
//		if(obj == btn[3]) {// + ������ ������ ù��° ���� ��������
//			
//		}
		
		
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}










// setbound�� �ص� ��.




// height*3/10 start
// width /2 - lengthOfbutton1/2
// width / 2 - (lob, lob/2, -lob/2, -lob)
// height 