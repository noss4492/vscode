package day17_4;
// ���򿡴� wait notify�� ���� ���Ǵµ�

public class Producter extends Thread {
	private Car car;

	public Producter(Car car) {
		this.car = car;
	}

	@Override
	public void run() { // 2�ʸ��� 1�� ����
		for (int i = 0; i < 200; i++) {
			try {
				Thread.sleep(200);
				// ���� �̸� ���
				String carName = car.getCarName();
				// �� ���(����)�� �ֱ�
				car.push(carName);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
