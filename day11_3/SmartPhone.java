package day11_3;

//��� ��� �� ����µ� �ӿ���
// final int -> ��� final method -> �������̵� final class -> ��� ���� ' 3'

// static �������� -> �޸𸮿� �ѹ��� �Ҵ��
// heap �� �Ҵ�Ǵ� �Ϲ����� �ν��Ͻ� �������� ������?
// static area(method area)�� ����
// �� ������ �����ǰ� �ѹ��� �������� ������.
// �����ϴ� ������ ����.
// Ŭ���� �������ڸ���(���������� ���� ��������) static�� �ֵ��� 
// method area�� ������ ����


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
		System.out.println("ring ding dong~��");
	}
	public void callReceive() {
		System.out.println("��������~��");
	}
	
	public void gaming() {
		System.out.println("�����");
	}
	
	
}
