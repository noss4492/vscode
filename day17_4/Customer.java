package day17_4;

import java.util.Random;

public class Customer extends Thread {
	Car car;
	Random rnd = new Random();

	Customer(Car car) {
		this.car = car;
	}

	@Override
	public synchronized void run() {
		// 차량 20대 구매
		for (int i = 0; i < 200; i++) {
			try {
				Thread.sleep(rnd.nextInt(5) * 100);
				String carName = car.pop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
