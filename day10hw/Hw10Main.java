package day10hw;

public class Hw10Main {
	// 5. �簢�� Ŭ������ ����
	// 6. �� Ŭ������ ����
	// 7. �ﰢ�� Ŭ������ ����
	public static void main(String[] args) {
		Square s1 = new Square();
		Circle c1 = new Circle();
		Triangle t1 = new Triangle();
		s1.setWidth(4);
		s1.setHeight(3);
		c1.setRadius(7);
		t1.setWidth(16);
		t1.setHeight(9);
		
		System.out.println("----------made by user set-----------------------");
		System.out.printf("s1 w:%.2f h:%.2f area:%.2f \n"
								, s1.getWidth(), s1.getHeight(), s1.getCalArea());
		System.out.printf("c1 r:%.2f 	  area:%.2f \n", c1.getRadius(), c1.getCalArea());
		System.out.printf("t1 w:%.2f h:%.2f area:%.2f \n"
								, t1.getWidth(), t1.getHeight(), t1.getCalArea());
		
		Square s2 = new Square(4, 3);
		Circle c2 = new Circle(7);
		Triangle t2 = new Triangle(16, 9);
		System.out.println("----------made by constructor--------------------");
		System.out.printf("s1 w:%.2f h:%.2f area:%.2f \n"
				, s1.getWidth(), s1.getHeight(), s1.getCalArea());
		System.out.printf("c1 r:%.2f  	 area:%.2f \n", c1.getRadius(), c1.getCalArea());
		System.out.printf("t1 w:%.2f h:%.2f area:%.2f \n"
				, t1.getWidth(), t1.getHeight(), t1.getCalArea());
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
/*
1. �߻�Ŭ����?
���ο� �߻����ΰ�(�߻�޼���)�� �����ϰ� ������ �߻�Ŭ������ �����Ͽ� ����Ͽ����Ѵ�.
�߻�Ŭ������ �ν��Ͻ�ȭ(��üȭ) �� �� ���� (���������θ� ������)

2. ��ü���� ����� Ư¡?
2-1. ĸ��ȭ
�ش� Ŭ������ private�� ������ �����ϸ� �ٸ� Ŭ�������� ������ �Ұ����ϰ� �ǰ�
�̴� �ش� Ŭ������ ���ο� �ִ� �޼���(���⼭�� getter/setter)�� �̿��ؼ���
�� ������ �����Ͽ� �����ϰų� �����Ͽ� ���� �� �ִ�. 
���ü��� ���ּ� �������� ����� �����Ѵ�.

2-2. ���
�ڽ�Ŭ�������� �θ�Ŭ������ ��ӹ޾� �ű⼭ Ȯ���Ͽ� ����Ѵ�
�ڽ��� ������ �ִ� ������ �θ� �����ϴ� ���谡 �Ǹ� 
�̷ν� �θ�Ŭ������ �������� ������ �ڽ�Ŭ������ ���������� �Ҵ��ϴ� ���
�ڽ�Ŭ������ �����ϸ� �θ�Ŭ�������� �����Ƿ� �����Ͽ� ��밡���ϴ�.

Ŭ���� ������ ������ ���� Ŭ���������� ����
Ŭ������ �� ��ȯ�� ����
��ӹ��� �޼���� �������̵尡 ����
���..

2-3. �߻�ȭ
������ ��� �����Ǿ� ������ ������ 
��ü���� ��ǵ�κ��� �ö�� ���������� ������. �̷��� �ϰڴٴ� ��(�߻�������)
���� : ������

3. ���������� ����
private : �ڱ� �ڽ��� Ŭ���� ���ο� �ִ� �ֵ鸸 ���� ����
default : �ڱⰡ ���Ե� ��Ű�� ���ο� �ִ� �ֵ���� ���� ����
protected : �ڱⰡ ��ӹ��� ��Ű�� ���ο� �ִ� �ֵ���� ���� ����
public : ��� ���� ����

4. �����ڿ� �Ϲ� �޼����� ������
�����ڴ� Ŭ���� ������ �������� ������ �⺻ �����ڰ� ������
�����ڴ� ��ü�� �ʱ�ȭ�� �������� ����
�����ϴ°� ����
������ �ٸ�(������:Ŭ������� ����, �޼���:�ҹ��ڽ���, ī�� ���̽�(�ҹ��� ������ �빮�ڷ� ����)
 */
