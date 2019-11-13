package day23;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

// �̸� ���� �Ǿ� �ִ� �������̽� ��� : ���ٽ�
// java.util.function �ؿ� �ִ� �̸� ���ǵǾ� �ִ� �Լ��� �������̽�

// Supplier : �Ű����� ����

public class LamdaEx9 {	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Supplier<Integer> spr = () -> {
											Random rnd = new Random();
											return rnd.nextInt(100)+1;
		};
		
		for(int i=0; i<10; i++) {
			list.add(spr.get());
		}
		System.out.println(list);
	}
}
