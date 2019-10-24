package day09_02;

import day09.Marin;

public class TestMain03 {
	public static void main(String[] args) {
		ATM atm = new ATM();	// 뭐 이렇게 유명하면 대문자로 클래스명 지어도..
				
		System.out.println("현재 잔액 조회 "+atm.getBalance()+"원"+"\n");
		
		atm.setBalance(90000);
		System.out.println("현재 잔액 조회 "+atm.getBalance()+"원"+"\n");
		
		atm.setName("동길홍");
		System.out.println(atm.getName()+"\n");
		
		atm.withDraw(10000);		
		System.out.println(atm.getName()+"\n");
				
		atm.deposit(200);
		System.out.println(atm.getName()+"\n");
		
		System.out.println("atm log");
		atm.getLogATM();
		
		
		
		// 안전하게 객체를 만드는 방법
		// 변수에 직접 접근하지 못하게
		// 로직 사용이 가능한 메서드를 만들어서
		// 값을 얻어오는 메서드
		// 값을 지정하는 메서드
		// 이것이 캡슐화(encapsulation)
		// private한 변수, setter method, getter method
		
		
		
		
		
		
		
		//Object a = new Marin();
		//day08.Marin a = new Marin();	// 생성자도 메소드이기 때문에
										// defalut라서 같은 패키지가 아니라
										// 안됨
		
		//day09.Marin aa = new Marin();	// Marin() 생성자를 public으로 쓰면 가능
		
	}
}
