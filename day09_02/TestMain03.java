package day09_02;

import day09.Marin;

public class TestMain03 {
	public static void main(String[] args) {
		ATM atm = new ATM();	// �� �̷��� �����ϸ� �빮�ڷ� Ŭ������ ���..
				
		System.out.println("���� �ܾ� ��ȸ "+atm.getBalance()+"��"+"\n");
		
		atm.setBalance(90000);
		System.out.println("���� �ܾ� ��ȸ "+atm.getBalance()+"��"+"\n");
		
		atm.setName("����ȫ");
		System.out.println(atm.getName()+"\n");
		
		atm.withDraw(10000);		
		System.out.println(atm.getName()+"\n");
				
		atm.deposit(200);
		System.out.println(atm.getName()+"\n");
		
		System.out.println("atm log");
		atm.getLogATM();
		
		
		
		// �����ϰ� ��ü�� ����� ���
		// ������ ���� �������� ���ϰ�
		// ���� ����� ������ �޼��带 ����
		// ���� ������ �޼���
		// ���� �����ϴ� �޼���
		// �̰��� ĸ��ȭ(encapsulation)
		// private�� ����, setter method, getter method
		
		
		
		
		
		
		
		//Object a = new Marin();
		//day08.Marin a = new Marin();	// �����ڵ� �޼ҵ��̱� ������
										// defalut�� ���� ��Ű���� �ƴ϶�
										// �ȵ�
		
		//day09.Marin aa = new Marin();	// Marin() �����ڸ� public���� ���� ����
		
	}
}
