package day11_3;

//상수 얘기 못 들었는데 머엿지
// final int -> 상수 final method -> 오버라이드 final class -> 상속 금지 ' 3'

// static 정적변수 -> 메모리에 한번만 할당됨
// heap 에 할당되는 일반적인 인스턴스 변수와의 차이점?
// static area(method area)에 생김
// 이 영역에 생성되고 한번만 공용으로 생성됨.
// 공유하는 변수로 사용됨.
// 클래스 생성되자마자(참조변수가 없는 시점에도) static인 애들은 
// method area에 생성됨 ㅇㅇ


public class SmartPhone {
	String pName, pNation, pNumber;
	static String pCompany;
	int price;
	public SmartPhone(String pName, String pNation, String pNumber, String pCompany) {
		super();
		this.pName = pName;
		this.pNation = pNation;
		this.pNumber = pNumber;
		this.pCompany = pCompany;
	}
	public void callSend() {
		System.out.println("ring ding dong~♩");
	}
	public void callReceive() {
		System.out.println("여보세요~♩");
	}
	
	public void gaming() {
		System.out.println("운빨망겜");
	}
	
	
}
