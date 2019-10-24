package day02;

public class operatorEx2 {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		// int이하 끼리 연산하면 int 반환, (byte + byte -> 해도 int꼴로 된다함)
		System.out.println(a+b);
		System.out.println("a--- "+(a+b));
		System.out.println("b--- "+(a%b));
		System.out.println("c--- "+(a/b));//소숫점이하 버림
		System.out.println("dddd "+(a*b));
		// 꿀팁 : ctrl + alt + down (vscode 단축키도 찾아볼 것)
		
		byte c1 = 10;
		byte c2 = 17;
		System.out.println(c1+c2);
		
		// byte c3 = c1+c2; int타입이라 못 담네
		// System.out.println(c3);
	}

}
