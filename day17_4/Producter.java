package day17_4;
// 요즘에는 wait notify가 자주 사용되는듯

public class Producter extends Thread {
	private Car car;

	public Producter(Car car) {
		this.car = car;
	}

	@Override
	public void run() { // 2초마다 1대 생산
		for (int i = 0; i < 200; i++) {
			try {
				Thread.sleep(200);
				// 차량 이름 얻기
				String carName = car.getCarName();
				// 차 어레이(차고)에 넣기
				car.push(carName);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
