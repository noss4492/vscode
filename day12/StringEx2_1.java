package day12;

public class StringEx2_1 {
	public static void main(String[] args) {
		String str5 = "java";
		String str6 = "java";
		
		if(str6 == str5) {
			System.out.println("str5, 6은 동일 객체를 가르키고 있음");
		}
		
		String str = "";
		for(int i = 0; i < 100; i++) {	// 성능 가장 나쁘게 되는 예시
			str += "*";					// 쓰레기 99개 생기네 ㄷㄷ;
			System.out.println(str);
		}
		
		
		// new로 생성할땐 X 언제나 새로운걸 만들어서 담는것.
		// String str = "aa";
		// 이때에 한해서 이야기임.
	}

}
