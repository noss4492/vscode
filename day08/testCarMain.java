package day08;

public class testCarMain {

	public static void main(String[] args) {
		Car c;
		// ���� 
		// new : ��ü�Ҵ� ������ 
		c = new Car();
		// �޸𸮿� �Ҵ�� ��ü : instance (������ �����ϴ� ��)
		// �ϳ��� Ŭ�����κ��� �������� �ν��Ͻ��� ������ �� �ִ�.
		
		// class�� ���赵 object�� �� ��(��üȭ�� ��, (�޸𸮿� �Ҵ��)�ν��Ͻ��� ��)
		
		c.����();
		c.����();
		
		System.out.println("c : "+c);
		//������ ����
		// day08.Car@15db9742

		System.out.println(c.������);
		// dot ������
		// ������ ���� ã�ư� (����Ű�� �ִ� �޸𸮿� ���� ������ ������ ����)
		// 
		
		System.out.println(c.����);
		
		// c 4byte(����)
		// new�� ���� �Ҵ�
		// ��(int a int b .. String aa .. method1() .. )
		
		
		Car myCar;
		myCar = new Car();
		myCar.���� = "�غ�";
		myCar.�ӵ� = 30;	//�ִ�ӵ�?
		
		Car myCar2 = new Car();
		myCar2.���� = "Porsche";
		myCar2.�ӵ� = 300;
		
		
	}
}
