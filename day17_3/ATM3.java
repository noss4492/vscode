package day17_3;

public class ATM3 {
	String acccount;
	int balance;

	// setter, getter
	// 인자가 있는 생성자
	public ATM3(String acccount, int balance) {
		super();
		this.acccount = acccount;
		this.balance = balance;
	}
	public synchronized void deposit(int money) { // 공유자원 lock
		this.balance += money;
		System.out.println(">>"+money + "원 입금합니다.");
		System.out.println("현재 잔액 : " + balance);
	}
	
	public synchronized void withDraw(int money) {
		if (balance >= money) {
			balance -= money;
			System.out.println("<<"+money + "원 출금합니다.");
			System.out.println("현재 잔액 : " + balance);
		}
	}

	public String getAcccount() {
		return acccount;
	}

	public void setAcccount(String acccount) {
		this.acccount = acccount;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
