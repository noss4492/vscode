package day12;

public class TestMain2_equal {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println("obj1 : "+obj1);
		System.out.println("obj1 : "+obj2);
		
		System.out.println(obj1.equals(obj2));
		
		
		obj1 = obj2;
		
		if(obj1 == obj2)
			System.out.println("a 같은 객체");
		else
			System.out.println("a 다른 객체");
		
		if(obj1.equals(obj2))
			System.out.println("b 같은 객체");
		else
			System.out.println("b 다른 객체");
		
		System.out.println("-------------------------");
		System.out.println("obj1 : " + obj1);
		System.out.println("obj1 : "+ obj1.toString());
		// 사실 참조값은 obj.toString()이었음!
		// 객체를 대표하는(repersentation) 하는 문자
		
		// Returns a string representation of the object.
		// getClass().getName() + '@' + Integer.toHexString(hashCode())
		// 클래스의이름                      + '@' + hasCode값을 16진수로 바꾼 값
		// hashcode는 메모리에서 어디 가야할지 알려주는 알고리즘이 들어있는 코드
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		/*
		 * finalize
		 * 가비지컬렉터 콜
		 * getClass
		 * 실행되고 있는 객체,클래스를 리턴
		 * 
		 */
	}

}
