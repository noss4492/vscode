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
		System.out.println(">>�̸��� ���Խ��ϴ�.");
		return this.name;
	}
	
	public void setName(String name) {
		System.out.println(">>�̸��� �����߽��ϴ�.");
		this.name = name;
	}
	
	//�Ա�
	void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.printf(">>%d�� �ԱݵǾ����ϴ�.\n", money);
			System.out.printf("���� �ܾ��� %d�� �Դϴ�.\n", this.balance);
		}
	}
	
	//���
	void withDraw(int money) {
		// db �����ؼ�
		// ���� ��û�ϴ���, ������ �ִ� �������
		// if(����������)
		// ����ϰ� �α�(���� �󸶸� ����..)
		if(money<=balance) {
			this.balance -= money;
			System.out.printf(">>%d�� ��ݵǾ����ϴ�.\n", money);
			System.out.printf("���� �ܾ��� %d�� �Դϴ�.\n", this.balance);
			logBuffer = "["+System.currentTimeMillis()/1000+"]"+this.name+"���� "
														+money+"���� ����ϼ̽��ϴ�.\n";
			atmLog += logBuffer;
			System.out.println(logBuffer);
		}
		else {
			System.err.println("�ܾ��� �����մϴ�.");
			logBuffer = "["+System.currentTimeMillis()/1000+"]"+this.name+"���� "
														+money+"���� ����Ϸ��� �õ���.\n";
			atmLog += logBuffer;
			System.out.printf("���� �ܾ��� %d�� �Դϴ�.\n", this.balance);
		}
	}
	
	public int getBalance() {
		//����üũ. ��ϳ����. 
		System.out.println(">>���� �ܰ� �����Խ��ϴ�.");
		return this.balance;
	}
	public void setBalance(int balance) {
		System.out.println(">>���¸� �����Ͽ����ϴ�.");
		this.balance = balance;
	}
	
}
