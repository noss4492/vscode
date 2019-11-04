package day17_3;

import java.util.Random;

//���ÿ� �ϳ��� ���¿��� �Աݰ� ��ݱ����
//������ �� �ֵ��� ��Ƽ ������ ó��
//�������� : ATM3
public class ATMThread extends Thread {
	ATM3 atm;
	Random rnd = new Random();

	public ATMThread(ATM3 atm) {
		this.atm = atm;
	}

	@Override
	public void run() {
		// �Ա�/���  5ȸ/5ȸ
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
