package day15_2;

import java.util.Calendar;
import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		int[] m = new int[3];
		System.out.println(m.length);

		// 오브젝트형 배열같은 애(JCF)에 포함된 애임.
		// 벡터는 오브젝트를 저장함.
		Vector v = new Vector();
//		Calendar cal = Calendar.getInstance();
//		v.add(cal);
		v.add("딸긔");
		v.add("폴도");
		v.add("췌릐");
		v.add("배애");
		v.add("쑤밬");
		v.add("췌릐");

		System.out.println("V : " + v);
		System.out.println(v.capacity()); // 10
		v.add("쑤밬");
		v.add("쑤밬");
		v.add("쑤밬");
		v.add("쑤밬");
		v.add("쑤밬");
		v.add("쑤밬");
		String furit1 = "두리안";
		v.add(furit1);
		
		System.out.println("V : " + v);
		System.out.println(v.capacity()); // 20
		System.out.println(v.size());
		
		System.out.println("----------------");
		
		Object[] obj1 = new Object[v.size()];

		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i).toString().substring(0, 1));
		}
		for(int i = 0 ; i < v.size(); i++) {
			obj1[i] = v.get(i);
			System.out.println("||"+obj1[i].toString().toString().toString());
			System.out.println(i+":"+obj1[i].toString().substring(0, 1));
		}
		
		
		System.out.println("----------------");
		// ' 3'
		for(int i = 0; i < v.size(); i++) {
			Object obj2 = v.get(i);					 // v. i 포인트 가져옴
			System.out.println(">>"+obj2.toString());//요기 obj2의 포인트(참조값)을 가르킴
			String str = (String)obj2;
			System.out.println(str.substring(0, 1));
		}
		// obj2는 참조값 v.get(i)
		// obj2.toString() -> typename+@+hash
		//클래스 이름@해쉬 코드값
		
		//----------------------------------
		// if 0번에 과일을 넣었다 가정했을때 생각
		// String fruit = "금귤"
		// 1. fruit에 참조값이, 힙에 문자열이 생성됨
		
		// v.add(fruit)
		// 벡터클래스의 배열안에 fruit의 참조값이 들어감.
		
		// Object obj = v.get( fruit가 있는 idx )
		// 2. obj2는 super class이므로 참조값을 받을 수 있음.
		
		// 들어갈 str배열 생성 후 
		// str의 참조값에 obj2의 참조값을 형변환하여 넣어줌 -> 클래스 이름@해쉬 코드값 클래스 이름 변경
		// 그러면 str이 가리키는 값은 obj의 참조값으로 넣어줌
		// 그러면 str은 String타입으로 fruit의 해시값을 가질 수 있음.
		// 그러믄 substr 하면 댐
		
		//----------------------------------------
		
		
		
		System.out.println("----------------");
	}
}
		
		
		
//		System.out.println();
//		for(int i = 0 ; i < v.size(); i++)
//			System.out.println(v.get(i));	//get은 객체를 리턴함.
//		
//		for (int i = 0; i < 99; i++) {
//			v.add("^3^");
//		}
//		System.out.println("V : " + v);
//		System.out.println(v.capacity()); // 20
//		System.out.println(v.size());

/*
 * Vector() Vector(Collection<? extends E> c) Vector(int initialCapacity)
 * Vector(int initialCapacity, int capacityIncrement)
 */