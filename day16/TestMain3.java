package day16;

import java.util.ArrayList;
import java.util.Iterator;

public class TestMain3 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("딸기");
		list.add("바나나");
		list.add("포도");
		list.add("포도");
		list.add("포도");
		Integer a = 20;	// 오토박 ' 3'...
//		list.add(a);
		list.add("포도");
		list.add("포도");
		list.add("포도");
		list.add("포도");
		// 오브젝트 타입을 add해서 넣지만
		// 출력할때는 불편함.
		// 출력할 때 str = (String)obj << 이때 obj에 INTEGER임
		// str은 string이니까 integer의 형제관계임. 참조값 전달 불가능함.
		// java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

		// className@hashcode로 구분되기 때문에 그런듯함.해쉬코드는 잘 모르겠지만 해쉬함수(참조값)
		// 한번 그림 그려보기 ' 3'(딸기넣기, 20 넣기 -> 딸기 빼기 20 빼기)
		
		// 런타임성 에러 -> 으악 야근
		
		// ArrayList을 String 전용으로 하면 출력시 안전해지긴 하겠지
		// 컴파일러에서 에러도 잡아주긴 하겠지
		// 근데 자료형 하나만 되는건 좀 불편하겠는데?
		// 꺼낼때 지정된 자료형으로 리턴해줌
		
		// 하나씩 꺼내서 출력
		Iterator it1 = list.iterator();
		while(it1.hasNext())
			System.out.println(it1.next());
		
		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
			
			System.out.println("------------");
//			Object obj = list.get(i);
//			String str = (String)obj;
			String str = list.get(i);			// 리턴이 지정된 형으로 됨. ' 3';;
			System.out.println(str.substring(0, 1));
			
			
			System.out.println(list.get(i).toString().substring(0, 1));
			System.out.println("------------");
		}
		
		//iteratable ?
//		for(ArrayList list : )
		
	}
}