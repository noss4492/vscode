package day09hw;

public class Homework {
	public static void main(String[] args) {
		Computer c = new Computer();
		PDA p = new PDA();
		
		c.printInfo();	// �� �� �޼ҵ�� �������̽��� ���� �޼ҵ� �������̵��ؼ�
		p.printInfo();  // �߻�޼ҵ�ȭ �ϸ� �ϳ�ó�� �� �� ����.
		
		System.out.println("\n\n");
		p.callPDA();
		p.powerButton();// ������ư�� ���������� ������ ���������� ������ �Ѵ�.
//		p.comOff();
//		p.comOn();
		p.internetAccessOn();
		p.printInfo();
		
		p.powerButton();
		
	}
}

/*
Hw01.
	Q. 
	class �� ������� 3������ ���� �����ϼ���\
	
	A.
	member field(variable, constant)
	member method
	constructor

Hw02.
	Q.
	this, this(), super, super() ???? 
	
	A.
	this�� ���� Ŭ������ ��Ī�ϴ� ǥ��(��������)
	this()�� ���� Ŭ������ �����ڸ� ��Ī
	super�� �θ� Ŭ������ ��Ī�ϴ� ǥ��
	super()�� �θ� Ŭ������ �����ڸ� ��Ī

Hw03.
	���������� �ڹٿ��� ���������� �̸��� �����ϴ� ��Ģ��? 
	Ŭ������  : �Ǿ� ���� �빮��, �ܾ���� ������ �ܾ� ù ���� ����빮�� (�Ľ�Į���̽�)
	ex.QuickSort
	�����ڸ�  : Ŭ������� ����, ()�� ���������� ��
	ex.QuickSort()
	������     : �Ǿ� ���� �ҹ���, �ܾ�й��� ���� �� (ī�����̽�)
	ex.maxIndexNum
	�����     : �빮��, ���� ������
	ex.INPUT_WIDTH_SIZE
	�޼����  : �Ǿ� ���� �ҹ���, �ܾ� ������ �ܾ� ù ���� ���� �빮��
	ex.partitionAtoB
	��Ű����  : ����ҹ���
	ex.day09, io, scanner....
	
Hw04. 

	�ڵ�1�� �����Ͽ� �پ��� �����ڸ� �߰��غ��ϴ�.

�ڵ�1)
public class HandPhone{
	String productName;
	String productType;
	int price;
	String phoneNumber;
	
}
Hw05. Computer ��ü�� �����Ҽ� �ִ� Ŭ������ �ۼ��ϼ��� 
	��� : �ѱ�(), ����()
	
Hw06. Computer ��ü�� ��ӹ޴� PDA Ŭ������ �ۼ��ϼ��� 

	PDA p = PDA();

	p.��ȭ�ϱ�();
	p.�����ϱ�();
*/