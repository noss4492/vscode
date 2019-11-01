package day13_Hw;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hw5 extends Frame implements ActionListener {
// 한번 안보고 작성해보기
// 필요한 것 부터 생각
	
	// 전체적인 구성은 어떻게?
	// Frame, super("title string")
	// TextField Label TextField Button TextField
	// tf1 get tf2 get -> button action -> set tf3
	
		// 구체적인 구현은 어떻게?
		// 버튼 액션 리스너 
		// 생성자 만들면서 창 구현
		// 필요한 멤버 (TextField 1, 2, 3, Label 1, Button 1)
		// 멤버 초기화
		// 멤버의 리스너 추가
		// 리스너는 해당 리스너로 구현되는 객체를 포함하여야 함.
		// 인터페이스를 사용하여 지금 객체를 리스너가 요구하는 객체로 만듬
		// 리스너가 요구하는 객체(지금 내 클래스)
final static int WIDTH = 800;
final static int HEIGHT = 600;
TextField tfFactor1, tfFactor2, tfResult;
Button btnEqual;
Label lbOperator;
//Font f = new Font("MyFont", Font.BOLD+Font.ITALIC, 26);
Font f = new Font("MyFont", Font.BOLD, 26);

	Hw5(){
		super("더하기");	//Frame(String title) : initially Frame object with the title.
						//now frame is Top-level Container
		setLayout(null);
		
		// component들 정의
		tfFactor1 = new TextField();
		tfFactor2 = new TextField();
		tfResult = new TextField();	//not-editable로 만들어야
		
		btnEqual = new Button("=");
		lbOperator = new Label();
		
// 리스너 생성+등록 (구현객체에 대한 리스너)
// 핸들러라는 이름의 객체 l, ActionListener 인터페이스로 구현된
// 위 객체가 필요하지만 자기 자신의 클래스가 ActionListener 인터페이스로 구현되었다면
// 별도로 다른 객체를 만들어서 쓸 필요가 없으니까
// 걍 내 생각 : 나 자신(클래스)이 ActionListener의 인터페이스 소속 객체가 되면 됨.
		btnEqual.addActionListener(this);
		
// 콤포넌트 객체 정보 정의
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
		// 요거 때문에 nested로 한 거였지. 시야가 안 닿음
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("=")) {
			tfResult.setText("11");
			int a = Integer.parseInt(tfFactor1.getText())
					+Integer.parseInt(tfFactor2.getText());
			tfResult.setText(Integer.toString(a));	

		}	// 1번, 2번 텍스트필드를 숫자로 바꿔서 더한 후 다시 문자열로 set
	}
	
	
	public static void main(String[] args) {
		Hw5 hw5 = new Hw5();
	}
}

// addActionListener(ActionListener l)
// adds the specified action listener to receive action events 
// from this (component:button, label, textview....).

// 원래 Handler 클래스를 만들어서 ActionListener를 Implements하여 사용하지만
// -> 내 생각 : 그냥 ActionListener Interface가 자기 위에 있으면 
// 자기 클래스를 인자로 삼으면 되니까


//			tfResult.setText(Integer.toString
//					(Integer.parseInt(tfFactor1.getText())
//					+Integer.parseInt(tfFactor2.getText())));