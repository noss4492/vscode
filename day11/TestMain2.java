package day11;

import day10_2.Marine;
import day10_3.Horse;

// ���� ��� ó���� ���Ͽ�
// �ڹٿ����� ���߻�� ������ ���� �޼��� ���� �̰� ������
// 
public class TestMain2 {
	public static void main(String[] args) {
		Horse h1 = new Horse();
		Marine m1 = new Marine();
		
		
		h1.eatting();
		h1.flying();
		
		m1.flying();
		System.out.println("------------------");
		
		Flyable f1;		// �������̽��� �θ� ������ ����. (�׷��� �׷�� ���̶����� ����)
		f1 = h1;
		f1.flying();
		f1 = m1;
		m1.flying();
		// ������
		// ������ ���۹������ ���۽�Ű����
		// ��� ���� �ٸ� �����ϰ� �ϴ� ��
		
		/*
		 * Encapsulation
		 * Inheritance
		 * Abstraction
		 * Polymorphism
		 */
	}
}
