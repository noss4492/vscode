package day23;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

// ArrayList에 원하는 갯수만큼 랜덤값 넣기

//interface ArrListRanIn<ArrayList<T>>{
interface Addint<T>{	// T <- ArrayList<type>
	T add(int rnd);
}
public class LamdaEx7 {	// 내가 만든 코드 메모리 낭비 오짐;
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
// 문제대로 하면 똑같은 값 나와 ㅠ.ㅠ 분명 예시에서 list.add(rnd.nextInt(100)+1) 이렇게 되어있었는데
		
		
		
		
	}
}
