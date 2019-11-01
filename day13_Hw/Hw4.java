package day13_Hw;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hw4 extends Frame implements ActionListener {
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
	
	Hw4(){
		super("Calculator");
		setLayout(null);
		
		// �� ���� ���� ���÷��̰� ���� (�׼� ����. ������ �����ֱ⸸ ��)
		int calcSize = 440;				// clacSize is marginBtnWidth*2
		calcDisplay = new TextField(50);
		calcDisplay.setLocation(WIDTH/2-calcSize/2, HEIGHT/10);
		calcDisplay.setSize(calcSize, 50);
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
	}
	public static void main(String[] args) {
		Hw4 hw4 = new Hw4();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
		btn[13].setLabel("00");
		btn[14].setLabel("=");
		btn[15].setLabel("/");
	}
}

// setbound�� �ص� ��.




// height*3/10 start
// width /2 - lengthOfbutton1/2
// width / 2 - (lob, lob/2, -lob/2, -lob)
// height 