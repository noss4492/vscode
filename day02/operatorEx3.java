package day02;
//빠른 성능 우선 시스템 개발을 위해 사용
// 음... 하드드라이브 CRC복부호화 방식을 하드웨어 관점으로 구현했을때 쉬프트 사용
public class operatorEx3 {
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("wowo");
		byte b = 10;
		System.out.println((b>>2)+"이것은 R쉬프트 2"); //1010 >>2  : 0010
		System.out.println((b<<2)+"이것은 L쉬프트 2"); //1010 <<2  : 10 1000 
		
		System.out.println((b>>>2)+"이것은 R쉬프트 2"); //1010 >>2  : 0010
		// >>   : 오른쪽으로 밀고, 남는 자리를 0으로 채움 x
		// 찾아보니까 부호를 상관하지 않고 밀음
		// >>>  : 오른쪽으로 밀고, 남는 자리를 부호 자리로 채움(부호유지인듯)
	}
}
