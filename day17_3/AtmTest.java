package day17_3;

public class AtmTest {

	public static void main(String[] args) {
		// ���� ����
		ATM3 atm = new ATM3("�浿ȫ", 10000);
		
		// ���ÿ� ���� ���� �������� �� ���¿� 
		// �Ա�, ����� ���ÿ� ó���Ѵٰ� ����..
		
		ATMThread at1 = new ATMThread(atm);
		ATMThread at2 = new ATMThread(atm);
		ATMThread at3 = new ATMThread(atm);
		
		
		// �޼��� ���� ���߿� (����ϴ� ���߿� ���� �����ؼ� ����ذ���...)
		// ��������
		at1.start();
		at2.start();
		at3.start();
	}
	
}
