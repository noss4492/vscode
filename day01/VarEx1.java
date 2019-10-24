package day01;

// primitive type
//byte short int   long
//float double
//char
//boolean(1byte or 1bit)

/*
 * 내 생각 정리 
 * 
 * 변수란? 노이만 구조 방식의 컴퓨팅에서 자료 처리를 하기 위해서 이름을 부여한 메모리 영역
 * 
 변수 : 자료처리를 위한 이름이 부여된 메모리 영역
1byte <= 8bit
primitive type => 정수형 : 1byte
byte(8bit), short(16bit), int(32bit), long(64bit)

byte -128~127 까지 표현 마찬가지로 각각 -2^n-1 ~ 2^n-1 -1

ctrl+space 단축 조아
	sysout 개꿀스!
소스코드에 주석달기 왜 쓰는지에 대해서 뭐 항상 하던대로 마구마구 달면 됨

ctrl + shift + / 블럭주석
ctrl + shift + \ 블럭주석 해제
ctrl + /         드래그영역 라인마다 주석


* floating point 부동소수점 방식
지수부와 가수부를 저장해서 커다란 수와 작은 수를 표현하자는 개념인데
컴퓨터 내부의 연산방식상 연산시 오차가 발생할 수 있다.
정밀도 보장 범위가 한정되어있다. float는 6~7자리 double은 15~16자리.


자바는 double형이 실수형의 기본이구나
*/

public class VarEx1 {
	//main method
	public static void main(String[] args) {
		//자료형 변수명;
		//50이라는 숫자를 저장
		byte b1;	// 변수를 선언
		short k;
		// b1이라는 변수에 10의 값을 넣어요 , 대입연산자
		b1 = -128;	// 대입(할당)
		System.out.println(b1);
		k = 5000;
		System.out.println(k);
		int i = 10000;		//initialized variable i
		System.out.println(i);
		
		// 자료형 변수명 = 상수
		// 상수는 항상 동일한 값을 갖는 수
		// 상수의 형은 변수의 형과 동일함 
		// int 이하의 자료의 경우엔 int 타입
		
		long t = 300L;
		System.out.println(t);
		
		float f1 = 3.14f;
		float f2 = 3.1415921f;
		
		System.out.println(f1*f2);
		
		double d1 = 3.25d;
		//실수형의 기본은 double
		double d2 = 3.25;
		
		System.out.println("주말이다"+f1);
		// 문자열을 연결하는 연결 연산자
		
		// 연산자 오버로딩을 지원하지 않음
		// 메서드 오버로딩은 지원하지만 
		// + 연산자의 경우엔 산술연산자와 연결연산자의 의미를 갖도록 오버로딩 되어있음.
		
	}
}



