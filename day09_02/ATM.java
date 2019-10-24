package day09_02;

public class ATM {
	private int balance;
	String name, accountNo;
	String atmLog = "LogBuffer Start";
	String logBuffer="";
	
	public void getLogATM() {
		System.out.println(logBuffer);
	}
	
	public String getName() {
		System.out.println(">>이름을 얻어왔습니다.");
		return this.name;
	}
	
	public void setName(String name) {
		System.out.println(">>이름을 변경했습니다.");
		this.name = name;
	}
	
	//입금
	void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.printf(">>%d원 입금되었습니다.\n", money);
			System.out.printf("현재 잔액은 %d원 입니다.\n", this.balance);
		}
	}
	
	//출금
	void withDraw(int money) {
		// db 접근해서
		// 누가 요청하는지, 권한이 있는 사람인지
		// if(권한있으면)
		// 출금하고 로그(누가 얼마를 언제..)
		if(money<=balance) {
			this.balance -= money;
			System.out.printf(">>%d원 출금되었습니다.\n", money);
			System.out.printf("현재 잔액은 %d원 입니다.\n", this.balance);
			logBuffer = "["+System.currentTimeMillis()/1000+"]"+this.name+"씨가 "
														+money+"원을 출금하셨습니다.\n";
			atmLog += logBuffer;
			System.out.println(logBuffer);
		}
		else {
			System.err.println("잔액이 부족합니다.");
			logBuffer = "["+System.currentTimeMillis()/1000+"]"+this.name+"씨가 "
														+money+"원을 출금하려고 시도함.\n";
			atmLog += logBuffer;
			System.out.printf("현재 잔액은 %d원 입니다.\n", this.balance);
		}
	}
	
	public int getBalance() {
		//권한체크. 기록남기기. 
		System.out.println(">>계좌 잔고를 가져왔습니다.");
		return this.balance;
	}
	public void setBalance(int balance) {
		System.out.println(">>계좌를 수정하였습니다.");
		this.balance = balance;
	}
	
}
