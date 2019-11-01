package day15_2;
import java.util.HashSet;
import java.util.Iterator;

// SET Interface...


public class HashSetEx {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("딸기");
		hs.add("바나나");
		hs.add("섴류");
		hs.add("파파야");
		hs.add("파파야");
		hs.add("파파야");
		hs.add("파파야");
		System.out.println("hs : "+hs);
		// hs.get(0); 순서 없어서안됨
		
		Iterator<String> it = hs.iterator();
		
		while(it.hasNext()) {// 다음값 접근 이걸로 해야됨. 
			System.out.println(it.next());
		}
		
//		boolean data = it.hasNext();
//		if(data)
//			System.out.println("다음값 있음");
//		else
//			System.out.println("다음값 없음");
		
		
		
		
		
	}

}
