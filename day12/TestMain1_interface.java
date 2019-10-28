package day12;

import day10_3.Horse;
import day11.Flyable;

public class TestMain1_interface {
	public static void main(String[] args) {
		// reference type : array, class, interface
		Horse h = new Horse();
		
		h.eatting();
		h.running();
		
		h.flying();
		
		//�������̽��� �� ��ȯ�� ���� ��Ⱑ �� ��.
		
		Flyable f;
		f = h;	// �������̽� = ��ü �� �θ� = �ڽ�
		f.flying();
		
		System.out.println("impl's final f.a = "+f.a);
		
		System.out.println(f.equals(h));
	}

}
