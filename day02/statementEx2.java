package day02;
import java.util.Scanner;	

public class statementEx2 {
	
	public static void print_sum(int n) {
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
			// System.out.print(" "+sum);
		}
		System.out.print("1부터 "+n+"까지의 순차적인 합계는 "+sum);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		statementEx2.print_sum(n);
	}
}
