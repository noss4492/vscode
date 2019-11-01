package day13_Hw;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hw5 extends Frame implements ActionListener {
// �ѹ� �Ⱥ��� �ۼ��غ���
// �ʿ��� �� ���� ����
	
	// ��ü���� ������ ���?
	// Frame, super("title string")
	// TextField Label TextField Button TextField
	// tf1 get tf2 get -> button action -> set tf3
	
		// ��ü���� ������ ���?
		// ��ư �׼� ������ 
		// ������ ����鼭 â ����
		// �ʿ��� ��� (TextField 1, 2, 3, Label 1, Button 1)
		// ��� �ʱ�ȭ
		// ����� ������ �߰�
		// �����ʴ� �ش� �����ʷ� �����Ǵ� ��ü�� �����Ͽ��� ��.
		// �������̽��� ����Ͽ� ���� ��ü�� �����ʰ� �䱸�ϴ� ��ü�� ����
		// �����ʰ� �䱸�ϴ� ��ü(���� �� Ŭ����)
final static int WIDTH = 800;
final static int HEIGHT = 600;
TextField tfFactor1, tfFactor2, tfResult;
Button btnEqual;
Label lbOperator;
//Font f = new Font("MyFont", Font.BOLD+Font.ITALIC, 26);
Font f = new Font("MyFont", Font.BOLD, 26);

	Hw5(){
		super("���ϱ�");	//Frame(String title) : initially Frame object with the title.
						//now frame is Top-level Container
		setLayout(null);
		
		// component�� ����
		tfFactor1 = new TextField();
		tfFactor2 = new TextField();
		tfResult = new TextField();	//not-editable�� ������
		
		btnEqual = new Button("=");
		lbOperator = new Label();
		
// ������ ����+��� (������ü�� ���� ������)
// �ڵ鷯��� �̸��� ��ü l, ActionListener �������̽��� ������
// �� ��ü�� �ʿ������� �ڱ� �ڽ��� Ŭ������ ActionListener �������̽��� �����Ǿ��ٸ�
// ������ �ٸ� ��ü�� ���� �� �ʿ䰡 �����ϱ�
// �� �� ���� : �� �ڽ�(Ŭ����)�� ActionListener�� �������̽� �Ҽ� ��ü�� �Ǹ� ��.
		btnEqual.addActionListener(this);
		
// ������Ʈ ��ü ���� ����
		tfFactor1.setSize(100,50);
		tfFactor1.setLocation(50, 100);
		tfFactor1.setFont(f);
		
		lbOperator.setText("+");		//
		lbOperator.setSize(100,50);
		lbOperator.setLocation(150, 100);
		lbOperator.setFont(f);
		
		tfFactor2.setSize(100,50);
		tfFactor2.setLocation(250, 100);
		tfFactor2.setFont(f);

		tfResult.setSize(100,50);
		tfResult.setLocation(350, 100);
		tfResult.setFont(f);
				
		btnEqual.setSize(100,50);
		btnEqual.setLocation(450, 100);
		btnEqual.setFont(f);

		tfResult.setSize(100,50);
		tfResult.setLocation(550, 100);
		tfResult.setFont(f);
		tfResult.setEditable(false);
		
		add(tfFactor1);
		add(lbOperator);
		add(tfFactor2);
		add(btnEqual);
		add(tfResult);
		
		setSize(WIDTH, HEIGHT);
		setLocation(50, 50);
		setVisible(true);
		// ��� ������ nested�� �� �ſ���. �þ߰� �� ����
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("=")) {
			tfResult.setText("11");
			int a = Integer.parseInt(tfFactor1.getText())
					+Integer.parseInt(tfFactor2.getText());
			tfResult.setText(Integer.toString(a));	

		}	// 1��, 2�� �ؽ�Ʈ�ʵ带 ���ڷ� �ٲ㼭 ���� �� �ٽ� ���ڿ��� set
	}
	
	
	public static void main(String[] args) {
		Hw5 hw5 = new Hw5();
	}
}

// addActionListener(ActionListener l)
// adds the specified action listener to receive action events 
// from this (component:button, label, textview....).

// ���� Handler Ŭ������ ���� ActionListener�� Implements�Ͽ� ���������
// -> �� ���� : �׳� ActionListener Interface�� �ڱ� ���� ������ 
// �ڱ� Ŭ������ ���ڷ� ������ �Ǵϱ�


//			tfResult.setText(Integer.toString
//					(Integer.parseInt(tfFactor1.getText())
//					+Integer.parseInt(tfFactor2.getText())));