package day02;
public class statementEx5 {
	public static void Hw191014No10() {		//Print1to100
		for(int i = 1; i <= 100; i++) {
			System.out.println(i);
		}
	}
	public static void Hw191014No11() {		//Sum1to100
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	public static void Hw191014No12() {		//PrintStarStair
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++)
				System.out.print("*");
		System.out.println();
		}
	}
	public static void Hw191014No13() {		//PrintNumStair
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= i; j++)
				System.out.print(j);
		System.out.println();
		}
	}
	public static void main(String[] args) {
		Hw191014No10();
		Hw191014No11();
		Hw191014No12();
		Hw191014No13();
	}
}
