package day17_3;

public class ATM3 {
	String acccount;
	int balance;

	// setter, getter
	// ���ڰ� �ִ� ������
	public ATM3(String acccount, int balance) {
		super();
		this.acccount = acccount;
		this.balance = balance;
	}
	public synchronized void deposit(int money) { // �����ڿ� lock
		this.balance += money;
		System.out.println(">>"+money + "�� �Ա��մϴ�.");
		System.out.println("���� �ܾ� : " + balance);
	}
	
	public synchronized void withDraw(int money) {
		if (balance >= money) {
			balance -= money;
			System.out.println("<<"+money + "�� ����մϴ�.");
			System.out.println("���� �ܾ� : " + balance);
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
