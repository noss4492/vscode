package day17_3;

import java.util.Random;

//동시에 하나의 계좌에서 입금과 출금기능을
//수행할 수 있도록 멀티 쓰레드 처리
//계정정보 : ATM3
public class ATMThread extends Thread {
	ATM3 atm;
	Random rnd = new Random();

	public ATMThread(ATM3 atm) {
		this.atm = atm;
	}

	@Override
	public void run() {
		// 입금/출금  5회/5회
		boolean flag = true;
		for (int i = 0; i < 10; i++) {
			int money = rnd.nextInt(10)*1000;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (flag)
				atm.deposit(money);
			else
				atm.withDraw(money);
			flag = !flag;
		}
	}
}
