package day23;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

// ArrayList�� ���ϴ� ������ŭ ������ �ֱ�

//interface ArrListRanIn<ArrayList<T>>{
interface Addint<T>{	// T <- ArrayList<type>
	T add(int rnd);
}
public class LamdaEx7 {	// ���� ���� �ڵ� �޸� ���� ����;
	public static void main(String[] args) {
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		Random rnd = new Random();
		
		Addint<ArrayList<Integer>> addintArrList;
		
		addintArrList = (int a) -> {
			for(int i = 0; i < 10; i ++) {
				al1.add(rnd.nextInt(a)+1);
			}
			return al1;
		};
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2 = addintArrList.add(100);
		for(int i = 0; i < 10; i ++)
			System.out.println(al2.get(i));
		
//		System.out.println(addintArrList.add(rnd.nextInt(100)+1).get(i));
// ������� �ϸ� �Ȱ��� �� ���� ��.�� �и� ���ÿ��� list.add(rnd.nextInt(100)+1) �̷��� �Ǿ��־��µ�
		
		
		
		
	}
}
