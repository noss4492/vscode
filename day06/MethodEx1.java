package day06;

public class MethodEx1 {

	public static void starstair() {
		for(int i = 0; i < 5; i ++) {
			for(int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
		// string���� ���� ����
	}
	
	public static void starstair3() {		// �߰��� ��
		String str = "";
		for(int i = 0; i < 5; i ++) {
			str += "*";						// ���� �����ڷ� ���� ��
			//System.out.println(str);
		}
	}
	
	public static void starstair2() {		// ������ �ȵ�
		String str = "*****";
		for(int i = 0; i < 5; i ++) {
			//str -= "*";
			//System.out.println(str);
		}
	}
	
	public static void starstair4(int n) {		
		String str = "";
		for(int i = 0; i < n; i++) {
			str += "*";
			System.out.println(str);
		}
	}
	
	public static void starstair5(int n) {
		String str = "";
		System.out.print("call recur n : "+n);
		for(int i = 0; i < n; i++) {
			str += "*";
			System.out.println("  "+(i+1)+"|"+str);
			starstair5(n/2);
		}
	}
	
	public static void multTable(int n, int m) {
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= m; j++)
				System.out.printf("%2d*%2d=%3d\n",j, i, j*i);
	}
	
	public static void printCode(String a) {	//���� String���� �޾Ƶ� �ʤ����ߤ�
		String str = "";
		for(int i = 0; i < 5; i++) {
			str += a;
			System.out.println(str);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		//starstair();
		//starstair2();
		//starstair3();

		//starstair4(3);
		//starstair4(5);
		//starstair4(7);
		
		//starstair5(8);
		multTable(9,9);
		printCode("+");
	}
}
