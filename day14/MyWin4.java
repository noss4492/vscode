package day14;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWin4 extends Frame{// implements WindowListener
	MyWin4(){
		super("���ᰡ��â");
		
		
		
		// 1.
//		HandleAdapter ha = new HandleAdapter();
//		WindowAdapter wa = ha;	//wa�� �θ�ϱ� ���� ����
		
		// 2.
		//Parent p = new Child();
//		WindowAdapter wa = new HandleAdapter();	// �ѹ����� ������ �ڵ� �����
		/*
		WindowAdapter wa = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
		addWindowListener(wa);
		*/
		
		// 3. ��¦ ���� ���� ��Ÿ��? �׷��� ���ش� �ϰ� ����
		// �̷��� �ִٰ� �� ....  ��... ?  ��? ??��???
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		//�߻�Ŭ�����ϱ� ��üȭ�Ұ���, WindowListener interface�� �����Ѿֿ���
		
		// �� �̷��� �ϰ� �ִ°�?
		// WindowListener�� ������ �ִ� �޼��尡 �ʹ� ����
		// �ٵ� �������̵��ؼ� ����϶�� �Ǿ� �־ ������
		// �������� ���������Ͷ�� Ŭ������ ��ȸ�Ͽ� ������� ����Ͽ���.
		
		setBounds(100, 100, 300, 300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		MyWin4 mw = new MyWin4();
	}
}

	/*
	 *  �ؿ� �̰� ���� �������� ��� �ذ�����?
	 *  ������� ���� -> Class WindowAdapter -> ������ ��Ŭ���� �ڵ� ���ʷ����� ����.
	 */
	

	/* �������̵� �������� �޼ҵ��*/

//class HandleAdapter extends WindowAdapter{
//	@Override
//	public void windowClosing(WindowEvent e) {
//		System.exit(0);
//	}
//}