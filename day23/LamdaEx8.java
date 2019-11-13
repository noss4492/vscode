package day23;

import java.util.ArrayList;
import java.util.Random;

//람다식 사용

interface MakeList<T>{
	public int make(int n);
}
public class LamdaEx8 {	// 선생님의 풀이임.
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		MakeList<Integer> mlist = (n) -> {
											Random rnd = new Random();
											return rnd.nextInt(100)+1;
		};
		
		for(int i=0; i<10; i++) {
			list.add(mlist.make(i));
		}
	}
}
