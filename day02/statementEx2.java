package day02;
import java.util.Scanner;	

public class statementEx2 {
	
	public static void print_sum(int n) {
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
			// System.out.print(" "+sum);
		}
		System.out.print("1���� "+n+"������ �������� �հ�� "+sum);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		statementEx2.print_sum(n);
	}
}
