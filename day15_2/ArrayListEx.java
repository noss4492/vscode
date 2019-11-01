package day15_2;

import java.util.ArrayList;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		// Note that this implementation is not synchronized.
		// 비동기화방식
		// 벡터는 동기화 방식
		// 쓰레드 이후에 얘기한다고함
		
		// 어레이리스트가 벡터보다 빠름.
		
		// list 인터페이스 : 순서 있음, 중복 허용
		// Vector Stack ArrayList
		
		list.add("레몬");
		list.add("코코넛");
		list.add("메로골드");
		list.add("용과");
		list.add("망고");
		list.add("용과");

		if(list.contains("용과"))
			System.out.println("용과 있음");
		
		ArrayList<String> list2 = (ArrayList<String>) list.clone();
		for(int i = 0; i < 6; i++) {
			System.out.println(list.get(i));
			System.out.println("clone : "+list2.get(i));
		}
		
		boolean isOK = list.contains("딸기");
		System.out.println(isOK);
		
		list2.addAll(list);
		int l2Size = list2.size();
		for(int i = 0; i < l2Size; i++) {
			System.out.println("합체:"+list2.get(i));
		}
		
	}
}
