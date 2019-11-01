package day13_Hw;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Container
// Component

//Event
//

public class Hw6 extends Frame implements ActionListener{
	// 필요한 것 부터 생각
		// 실행버튼1, 텍스트 필드 6
			// 버튼 액션 리스너 -> 로또 실행 후 텍스트필드에 반환
	// 중첩 클래스에 관한 생각을 해보는 중...
	
	// addActionListener(ActionListener l) -> 콤포넌트 객체에 액션리스너추가 메소드를 사용하려면
	// ActionListener로 구현된 인스턴스객체(object) l이 필요하다.
	// 그래서 따로 분리되게 다른 클래스에 만들어서 사용할 때에는 
	// Handler(라는 이름의, 관용적으로 이렇게 명명된)라는 클래스를 만들어서 
	// ActionListener interface를 받아서 Handler라는 클래스를 만들고
	// 이 Handler로 구현된 클래스를 addActionListener(ActionListener l) 인자로 넣어 주었다.
	// 그러나 nested 클래스로 삼아  자기 자신 클래스의 하위 멤버 클래스로 삼게 되면
	// (만약 자기 자신이 ActionListener 인터페이스를 받았다면)
	// ActionListener l 객체 대신 자기 자신의 클래스를 받도록 함.
	
	// 정리 
	// 방법1. 원시적인 사용
	// ActionListener를 인터페이스로 구현하고 있는 클래스를 만들어서 
	// 원 클래스에서 이 클래스를 인스턴스화 해서
	// addActionListener 매서드의 인자로 삼아서 사용하였음
	
	// 방법2. 자기 자신이 ActionListener 인터페이스를 받아
	// ActionListener를 구현한 객체가 되는 방법
	// 그러면addActionListener의 인자로 자기 자신을 쓸 수 있다.
	
	// 왜 ? -> addActionListener 메서드의 인자로 사용되는 ActionListener의 구현 객체
	// 를 매개인자로 삼아 ActionListener 인터페이스에서 제공하는 (상수)(추상메서드)를 
	// 전달하기 위해서라고 생각함.
	
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	TextField[] btnLotto = new TextField[6];
	Button btnWin;
	Font f = new Font("lotto font", Font.BOLD, 26);
		Hw6(){
			super("행복로또");	//Frame(String title) : initially Frame object with the title.
								//now frame is Top-level Container
			setLayout(null);
			// component들 정의
			for(int i = 0; i < btnLotto.length; i++) {
				btnLotto[i] = new TextField();
				btnLotto[i].addActionListener(this);
				btnLotto[i].setSize(50, 50);
				btnLotto[i].setLocation(WIDTH/2-300+100*i, 500);
				// WIDTH/2-marginBtnCol*(btnLotto.length/2)+marginBtnCol*i, 500;
				btnLotto[i].setFont(f);
				btnLotto[i].setEditable(false);
				add(btnLotto[i]);
			}
			btnWin = new Button("행복회로 가동!");	
			btnWin.addActionListener(this);			// 얘 누르면 작동해야되니까
			btnWin.setSize(200, 100);
			btnWin.setLocation(WIDTH/2-100, 100);
			btnWin.setFont(f);
			add(btnWin);
			
			setSize(WIDTH, HEIGHT);
			setLocation(50, 50);
			setVisible(true);
			// 요거 때문에 nested로 한 거였지. 시야가 안 닿음
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("행복회로 가동!")) {	//btnWin.getLabel()
				int[] resultLotto = lotto();
				for(int i = 0; i < 6; i++)
					btnLotto[i].setText(Integer.toString(resultLotto[i]));
			}
		}
		
		
		public static void main(String[] args) {
			Hw6 hw6 = new Hw6();
			int[] arr3 =lotto();
		}

		public static int[] lotto() {
			int[] arr = new int[45];
			int[] result = new int[6];
			
			for(int i = 0; i < 45; i++)
				arr[i] = i+1;
			
			for(int i = 0 ; i < 1000; i++) {
				int r1 = (int)(Math.random()*45);
				int r2 = (int)(Math.random()*45);
				int tmp = 0;
				tmp = arr[r1];
				arr[r1] = arr[r2];
				arr[r2] = tmp;
				if(r1 == r2)
					continue;
			}
			for(int i = 0; i < 6; i++)
				result[i] = arr[i];
			
			insertionSort(result);
			
			return result;
		}
		
		public static int[] insertionSort(int[] arr) {
			int tmp = 0;
			int min = 0;
			
			for(int i = 0; i < arr.length; i++) {
				min = i;	// saved i ( 검사 대상, 일단 미대입시 자기 자신이 되야하니까)
				for(int j = i+1; j < arr.length; j++) {
					if(arr[j] < arr[i]) {
						min = j;		//젤 작은 지점 선택
					}
				}
				tmp = arr[min];
				arr[min] = arr[i];
				arr[i] = tmp;
			}
			return arr;
		}
		
//		public static int[] quickSort(int[]arr, int l, int r) {
//			int left, right;
//			int pivot; // Value
//			
//		}
//		public static int[] partition(int[]arr, int l, int r) {
//		
//		}
		/*
		 * lotto
		 * 
		 * for(int i = 0; i < 45; i++){
		 * 		for(int j = 0; j < 6; j++){
		 * 			arr[i] = (int)(Math.random()*45)+1;
		 * 			for(int k = 0; k < i; k++)
		 * 				if(arr[i]==arr[j])
		 * 					i--;
		 * 대충 이런식이던가
		 * 
		 * 
		 * 
		 * 
		 */
}
