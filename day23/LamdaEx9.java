package day23;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

// 미리 정의 되어 있는 인터페이스 사용 : 람다식
// java.util.function 밑에 있는 미리 정의되어 있는 함수적 인터페이스

// Supplier : 매개변수 없음

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
