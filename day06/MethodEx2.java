package day06;

public class MethodEx2 {
	// ' 3'...
	// method signature : 메서드명/매개변수(갯수, 순서 , 타입)
	// method body : '3'...
	
	public static int maxEx2(int a, int b){
		return (a>b)?a:b;
	}
	public static float maxEx2(int a, float b) {
		return ((float)a>b)?(float)a:b;
	//	if((float)a>b)			// return의 특성을 이 예로 설명하심
	//		return (float)a;
	//	return b;
	}
	public static int manEx2(int a, int b, int c) {
		return a+b+c;
	}
	
	
	
	static int sum(int x1, int x2, int x3, int x4) {
		x1 = x1 + 1;
		return x1+x2+x3+x4;
	}
	// 실습 메모
	// 메인 메서드 에서는 x1, x2, x3, x4 는 스택 영역에 할당되어 있음
	// 이를 위에서 메서드로 호출하여 사용할 때는 그 scope에서만 유효하다.
	// 이때 x1, x2, x3, x4는 메모리 다른 영역에 저장되고 호출이 끝나면 사라진다.
	
	// 이때의 x1, x2, x3, x4는 매개변수, 지역 변수
	// <반> 전역 변수

	// 지역변수 설명하려고 그러신 거엿슴.. 레지스터 설명하시는 줄' 3'
	
	// 다형성 ? ㅅ?
	// max(0,0) max(0,0,0) .... -> 메서드 Overloading  " 3";;
	// overloading = 다중정의(뭐 이름이 같아도 시그니쳐가 다르니깐)
	// why? -> 쓰기 편하니까
	
	// 자바는 연산자 오버로딩 지원하지 않지만
	// 예외로 '+'는 연결/산술 연산자로 오버로딩을 지원함.
	
	// 킹갓파이썬은 연산자 오버로딩 매우 많이 지원함.
	
	public static void main(String[] args) {
		System.out.println(maxEx2(100,200));
		System.out.println(maxEx2(100, 200.f));
		System.out.println(manEx2(100, 200, 300));
		System.out.println(sum(100,200,400,600));
		int a = sum(100, 200, 400, 600);
		System.out.println(a);
	}
}
