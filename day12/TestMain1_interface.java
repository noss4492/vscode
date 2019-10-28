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
		
		//인터페이스의 형 변환에 관한 얘기가 될 듯.
		
		Flyable f;
		f = h;	// 인터페이스 = 객체 ≒ 부모 = 자식
		f.flying();
		
		System.out.println("impl's final f.a = "+f.a);
		
		System.out.println(f.equals(h));
	}

}
