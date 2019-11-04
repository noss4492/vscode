package day17_3;

public class AtmTest {

	public static void main(String[] args) {
		// 통장 개설
		ATM3 atm = new ATM3("길동홍", 10000);
		
		// 동시에 여러 은행 지점에서 이 계좌에 
		// 입금, 출금을 동시에 처리한다고 가정..
		
		ATMThread at1 = new ATMThread(atm);
		ATMThread at2 = new ATMThread(atm);
		ATMThread at3 = new ATMThread(atm);
		
		
		// 메서드 실행 도중에 (출금하는 도중에 계좌 접근해서 출금해가면...)
		// 엉망엉망
		at1.start();
		at2.start();
		at3.start();
	}
	
}
