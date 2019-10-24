package day07;

public class Method4 {
	public static int plus(int a, int b) {
		return a+b;
	}
	public static float plus(float a, int b) {
		return a+(float)b;
	}
	public static String plus(String a, String b) {
		return a+" "+b;
	}

	// 메서드 오버로딩
	// 1. 다중정의
	// 2. 방법 : 메서드 이름이 동일
	//         매개변수의 자료형, 갯수, 순서를 다르게
	// 주의 : return type은 오버로딩에 영향이 없음.
	public static void main(String[] args) {
		System.out.println(plus(100, 200));
		System.out.println(plus(100.0f, 200));
		System.out.println(plus("오늘은", "월요일"));
	}

}
