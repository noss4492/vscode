package day02;
//대입연산座 '3' 
// = += -= *= /= %= &= |= ^= <<= >>= >>>=
public class operatorEx8 {
	public static void main(String[] args) {
		int a = 10;
		
		a+=2;		//얘도 성능 최적화가 되어있는 애 였어? 오우
		System.out.println(a);
	}
}


/*
우선순위

0.  . , () 캐스트연산자
1. 증감
2. 산술
3. shift
4. 비교
5. 비트
6. 논리
7. 삼항
8. 대입

2 8 3 6 5 4
2(아 1번 저거네)

+(2), >>(3), ==(4),|(5), &&(6), +=(8)





*/