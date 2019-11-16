package kr.co.jhta.www;

public class StopWatch extends Thread {
//	JTextField time;
	public int timer = 7; // 시작 초 (+1초 입력해야함)
	public int timer2 = 4;
	boolean timeFlag = false;

	@Override
	public void run() {
		timeFlag = false;
//		word wd = new word(); // UI의 랜덤 문자를 받아옴
//		int length = 0;

			while (true) {
				try {
					showSec();
					sleep(1000); // 1초씩
					if (timer == 0) {// 시간이 0초가 되면 빠져나옴
//					System.out.println(wd(length));
						timeFlag = true;
						break;

					} // else 랜덤한 문자와 같은 문자가 나오면 break

				} catch (InterruptedException e) {

					e.printStackTrace();

				}
			}
			while (true) {
				try {
					showSec2();
					sleep(1000); // 1초씩
					if (timer2 == 0) {// 시간이 0초가 되면 빠져나옴
//					System.out.println(wd(length));
						timeFlag = true;
						break;
					} // else 랜덤한 문자와 같은 문자가 나오면 break

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
		System.out.println((--timer) + "초"); // 1초씩 감소

	}

	private void showSec2() {
		System.out.println((--timer2) + "초"); // 1초씩 감소

	}

	public static void main(String[] args) {
		new StopWatch().start(); // 시작 메서드

	}

}
