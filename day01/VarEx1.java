package day01;

// primitive type
//byte short int   long
//float double
//char
//boolean(1byte or 1bit)

/*
 * �� ���� ���� 
 * 
 * ������? ���̸� ���� ����� ��ǻ�ÿ��� �ڷ� ó���� �ϱ� ���ؼ� �̸��� �ο��� �޸� ����
 * 
 ���� : �ڷ�ó���� ���� �̸��� �ο��� �޸� ����
1byte <= 8bit
primitive type => ������ : 1byte
byte(8bit), short(16bit), int(32bit), long(64bit)

byte -128~127 ���� ǥ�� ���������� ���� -2^n-1 ~ 2^n-1 -1

ctrl+space ���� ����
	sysout ���ܽ�!
�ҽ��ڵ忡 �ּ��ޱ� �� �������� ���ؼ� �� �׻� �ϴ���� �������� �޸� ��

ctrl + shift + / ���ּ�
ctrl + shift + \ ���ּ� ����
ctrl + /         �巡�׿��� ���θ��� �ּ�


* floating point �ε��Ҽ��� ���
�����ο� �����θ� �����ؼ� Ŀ�ٶ� ���� ���� ���� ǥ�����ڴ� �����ε�
��ǻ�� ������ �����Ļ� ����� ������ �߻��� �� �ִ�.
���е� ���� ������ �����Ǿ��ִ�. float�� 6~7�ڸ� double�� 15~16�ڸ�.


�ڹٴ� double���� �Ǽ����� �⺻�̱���
*/

public class VarEx1 {
	//main method
	public static void main(String[] args) {
		//�ڷ��� ������;
		//50�̶�� ���ڸ� ����
		byte b1;	// ������ ����
		short k;
		// b1�̶�� ������ 10�� ���� �־�� , ���Կ�����
		b1 = -128;	// ����(�Ҵ�)
		System.out.println(b1);
		k = 5000;
		System.out.println(k);
		int i = 10000;		//initialized variable i
		System.out.println(i);
		
		// �ڷ��� ������ = ���
		// ����� �׻� ������ ���� ���� ��
		// ����� ���� ������ ���� ������ 
		// int ������ �ڷ��� ��쿣 int Ÿ��
		
		long t = 300L;
		System.out.println(t);
		
		float f1 = 3.14f;
		float f2 = 3.1415921f;
		
		System.out.println(f1*f2);
		
		double d1 = 3.25d;
		//�Ǽ����� �⺻�� double
		double d2 = 3.25;
		
		System.out.println("�ָ��̴�"+f1);
		// ���ڿ��� �����ϴ� ���� ������
		
		// ������ �����ε��� �������� ����
		// �޼��� �����ε��� ���������� 
		// + �������� ��쿣 ��������ڿ� ���Ῥ������ �ǹ̸� ������ �����ε� �Ǿ�����.
		
	}
}



