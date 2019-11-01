package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("반장", "소현띠?");
		hm.put("오키나와", "슈리성");
		hm.put("국보1호", "숭례문");
		hm.put("임진왜란", "선조");
		
		System.out.println(hm);
		System.out.println(hm.toString().hashCode());
		System.out.println("---------------------");
		
		Object obj = hm.get("반장");
		System.out.println(obj);
		System.out.println("---------------------");
		
		boolean no1 = hm.containsKey("국보1호");
		boolean no2 = hm.containsKey("국보2호");
		
		System.out.println(no1);
		System.out.println(no2);
		System.out.println("---------------------");
		
		// Key의 목록
		Set set = hm.keySet();
		//keySet()의 리턴 타입이 Set<K>라서 Set 인터페이스의 객체 s로 받아야함
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Object obj1 = it.next();
			System.out.println(it.next());
			System.out.println("key : "+obj1+" value : "+hm.get(obj1));
		}
		System.out.println("---------------------");
		
		System.out.println("--------remove-------");
		hm.remove("오키나와");
		hm.remove("임진왜란");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// json의 타입을 구현할 때는 이 해쉬맵을 이용해서 만듬
		
	}
}
