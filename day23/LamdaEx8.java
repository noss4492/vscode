package day23;

import java.util.ArrayList;
import java.util.Random;

//���ٽ� ���

interface MakeList<T>{
	public int make(int n);
}
public class LamdaEx8 {	// �������� Ǯ����.
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
