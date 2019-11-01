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
	// �ʿ��� �� ���� ����
		// �����ư1, �ؽ�Ʈ �ʵ� 6
			// ��ư �׼� ������ -> �ζ� ���� �� �ؽ�Ʈ�ʵ忡 ��ȯ
	// ��ø Ŭ������ ���� ������ �غ��� ��...
	
	// addActionListener(ActionListener l) -> ������Ʈ ��ü�� �׼Ǹ������߰� �޼ҵ带 ����Ϸ���
	// ActionListener�� ������ �ν��Ͻ���ü(object) l�� �ʿ��ϴ�.
	// �׷��� ���� �и��ǰ� �ٸ� Ŭ������ ���� ����� ������ 
	// Handler(��� �̸���, ���������� �̷��� ����)��� Ŭ������ ���� 
	// ActionListener interface�� �޾Ƽ� Handler��� Ŭ������ �����
	// �� Handler�� ������ Ŭ������ addActionListener(ActionListener l) ���ڷ� �־� �־���.
	// �׷��� nested Ŭ������ ���  �ڱ� �ڽ� Ŭ������ ���� ��� Ŭ������ ��� �Ǹ�
	// (���� �ڱ� �ڽ��� ActionListener �������̽��� �޾Ҵٸ�)
	// ActionListener l ��ü ��� �ڱ� �ڽ��� Ŭ������ �޵��� ��.
	
	// ���� 
	// ���1. �������� ���
	// ActionListener�� �������̽��� �����ϰ� �ִ� Ŭ������ ���� 
	// �� Ŭ�������� �� Ŭ������ �ν��Ͻ�ȭ �ؼ�
	// addActionListener �ż����� ���ڷ� ��Ƽ� ����Ͽ���
	
	// ���2. �ڱ� �ڽ��� ActionListener �������̽��� �޾�
	// ActionListener�� ������ ��ü�� �Ǵ� ���
	// �׷���addActionListener�� ���ڷ� �ڱ� �ڽ��� �� �� �ִ�.
	
	// �� ? -> addActionListener �޼����� ���ڷ� ���Ǵ� ActionListener�� ���� ��ü
	// �� �Ű����ڷ� ��� ActionListener �������̽����� �����ϴ� (���)(�߻�޼���)�� 
	// �����ϱ� ���ؼ���� ������.
	
	final static int WIDTH = 800;
	final static int HEIGHT = 600;
	TextField[] btnLotto = new TextField[6];
	Button btnWin;
	Font f = new Font("lotto font", Font.BOLD, 26);
		Hw6(){
			super("�ູ�ζ�");	//Frame(String title) : initially Frame object with the title.
								//now frame is Top-level Container
			setLayout(null);
			// component�� ����
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
			btnWin = new Button("�ູȸ�� ����!");	
			btnWin.addActionListener(this);			// �� ������ �۵��ؾߵǴϱ�
			btnWin.setSize(200, 100);
			btnWin.setLocation(WIDTH/2-100, 100);
			btnWin.setFont(f);
			add(btnWin);
			
			setSize(WIDTH, HEIGHT);
			setLocation(50, 50);
			setVisible(true);
			// ��� ������ nested�� �� �ſ���. �þ߰� �� ����
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("�ູȸ�� ����!")) {	//btnWin.getLabel()
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
				min = i;	// saved i ( �˻� ���, �ϴ� �̴��Խ� �ڱ� �ڽ��� �Ǿ��ϴϱ�)
				for(int j = i+1; j < arr.length; j++) {
					if(arr[j] < arr[i]) {
						min = j;		//�� ���� ���� ����
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
		 * ���� �̷����̴���
		 * 
		 * 
		 * 
		 * 
		 */
}
