package day17_4;
// 생산자-소비자 패턴
// syncro    wait / notify
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Car {
	// String 클래스만 담을 수 있는 전용 Object배열
	ArrayList<String> list;
	String[] carNameList = { "붕붕카", "포르쉐", "히트", "코란도" };

	public Car() {
		list = new ArrayList<String>();
	}

	public String getCarName() {
		Random rnd = new Random();
		return carNameList[rnd.nextInt(4)];
	}

	public synchronized void push(String car) {
		System.out.println("현재 차고 상태 : " + list);
		System.out.println("자동차가 생산되었습니다. " + car);
		list.add(car);
		// 기다리던 손놈 일어나
//		this.notify();	// 순서 모름(정책이 왜이래?)
		this.notifyAll();	// 다 깨움, 일반적으로 오래 기다린애가 가져감
		// synchronized 메서드일 때만 가능
	}

	public synchronized String pop() {
		String carName = null;
		System.out.println("현재 차고 상태 : " + list);
		if (list.size() == 0) {
			System.out.println("차고에 차량이 없어요. 기다리세요 손님아");
			// 기다려
			try {
				this.wait();//object의 메서드
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		carName = list.remove(list.size() - 1);
		System.out.println("자동차가 출고되었습니다. 차이름 : " + carName);
		return carName;
	}
}
//		Stack<String> s = new Stack<String>();
//		s.push(getCarName());
//		s.push(getCarName());
//		s.push(getCarName());
//		s.push(getCarName());