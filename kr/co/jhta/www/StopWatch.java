package kr.co.jhta.www;

public class StopWatch extends Thread {
//	JTextField time;
	public int timer = 7; // ���� �� (+1�� �Է��ؾ���)
	public int timer2 = 4;
	boolean timeFlag = false;

	@Override
	public void run() {
		timeFlag = false;
//		word wd = new word(); // UI�� ���� ���ڸ� �޾ƿ�
//		int length = 0;

			while (true) {
				try {
					showSec();
					sleep(1000); // 1�ʾ�
					if (timer == 0) {// �ð��� 0�ʰ� �Ǹ� ��������
//					System.out.println(wd(length));
						timeFlag = true;
						break;

					} // else ������ ���ڿ� ���� ���ڰ� ������ break

				} catch (InterruptedException e) {

					e.printStackTrace();

				}
			}
			while (true) {
				try {
					showSec2();
					sleep(1000); // 1�ʾ�
					if (timer2 == 0) {// �ð��� 0�ʰ� �Ǹ� ��������
//					System.out.println(wd(length));
						timeFlag = true;
						break;
					} // else ������ ���ڿ� ���� ���ڰ� ������ break

				} catch (InterruptedException e) {

					e.printStackTrace();

				}
			}
		}


	private char[] wd(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	private char[] StopWatch(int length) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {

		this.timer = timer;
	}

	private void showSec() {
		System.out.println((--timer) + "��"); // 1�ʾ� ����

	}

	private void showSec2() {
		System.out.println((--timer2) + "��"); // 1�ʾ� ����

	}

	public static void main(String[] args) {
		new StopWatch().start(); // ���� �޼���

	}

}
