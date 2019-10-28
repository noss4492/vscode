package day12;

public class StringEx1 {
	public static void main(String[] args) {
		// class impl 첫글자 대문자
		String s = "java";
		System.out.println(s);
		
		String str1 = new String("java");	//이게 fm임
		String str2 = new String("java");
		String str3 = new String("java2");
		int[] a = {3};		// immutable 객체 한정 hashcode가 같네. 흠..
		int[] b = {3};	
		int[] c = {6};
		System.out.println("str1 "+str1.getClass().getName() + '@' + Integer.toHexString(str1.hashCode()));
		System.out.println("str2 "+str2.getClass().getName() + '@' + Integer.toHexString(str2.hashCode()));
		System.out.println("str3 "+str3.getClass().getName() + '@' + Integer.toHexString(str3.hashCode()));
		System.out.println("a "+a.getClass().getName() + '@' + Integer.toHexString(a.hashCode()));
		System.out.println("b "+b.getClass().getName() + '@' + Integer.toHexString(b.hashCode()));
		System.out.println("c "+c.getClass().getName() + '@' + Integer.toHexString(c.hashCode()));
		// str1과 str2의 해쉬코드는 같음.
		// new로 생성한 경우에는 str1 str2 다 생성됨. primitive처럼 생성한 경우에는 
		
		if( str1 == str2) {
			System.out.println("동일 참조값");
		}else {
			System.out.println("다름 참조값");
		}
		if( str1.equals(str2)) {
			System.out.println("동읠 내용");
		} else {
			System.out.println("다륨 내용");
		}
		
		// Object 클래스 : equals는 동일객체인지 참조값을 비교하는 애였음
		// String 클래스 : equals는 overrided. 내용 비교
		/* Overrides: equals in class Object */
		// 내용 비교로 바껴잇숨
		
		
		//같은 문자열이면
		//str1 str2가 힙에 같은 문자열 객체를 가르키고 있다가
		str2 = "oracle";		// str2의 힙에 생성되는 객체는 이 때 생성됨.
								// 참조값도 이 때 욜로 바뀜
		// 클래스이지만 Primitive type처럼
		// 사용할 수 이쓴 예외적인 클래스 : String
		// 글자를 저장하겠다고 char[] 쓰기는 불편하고...
		// 메모리는 아깝고...
		
		String str5 = "java";
		String str6 = "java";
		
		if(str6 == str5) {
			System.out.println("str5, 6은 동일 객체를 가르키고 있음");
		}
		
		
		System.out.println("--------------------------");
		System.out.println("str1 : "+str1);
		System.out.println(str1.getClass().getName() + '@' + Integer.toHexString(str1.hashCode()));
		System.out.println(str2.getClass().getName() + '@' + Integer.toHexString(str2.hashCode()));
		System.out.println("str1 : "+str1.toString());
		// Overrides toString in class Object
	}

}
