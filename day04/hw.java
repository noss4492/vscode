package day04;

import java.util.Scanner;

public class hw {
	public static void Hw1() {	// 나누어 떨어지는지 검사
			Scanner stdIn = new Scanner(System.in);
			System.out.print("검사할 숫자를 입력해주세요 : ");
			int num = stdIn.nextInt();
			System.out.print("몇의 배수인지? 입력 : ");
			int div = stdIn.nextInt();
					
			for(int i = 1; i < num; i++) {
				if(num % div == 0) {
					System.out.println("["+num+"]은 ["+div+"]의 배수임다.");
					break;
				}
				else {
					System.out.println("["+num+"]은 ["+div+"]의 배수가 아님다.");
					break;
				}
			}
		}


		public static void Hw2() {	//2or3배수 아닌 100까지의 수 합
			int sum = 0;
			for(int i = 1; i <= 100; i++) {
				if((i%2!=0) && (i%3!=0)) {
					sum += i;
				}
					
			}
			System.out.println(sum);
		}


		public static void Hw3() {	//주사위 두개 던져서 합이 4가 되는 모든 경우의 수
			for(int i = 0; i <= 6; i++) {
				for(int j = 0; j <= 6; j++) {
					if(i+j == 4)
						System.out.println("i :"+i+" j :"+j);
				}
			}
		}

	public static void Hw4() {	//윤년 4년마다, 100년단위로는 아님, 400년 단위로는 윤년임
			Scanner stdIn = new Scanner(System.in);
			System.out.print("검색할 범위 입력 [시작 년도] :");
			int p = stdIn.nextInt();
			System.out.print("\n검색할 범위 입력 [끝 년도] :");
			int n = stdIn.nextInt();
			int i = 0;
			for(i = p; i <= n; i++) {	//여러줄로 ' 3'
				if(i%400==0)
					System.out.printf("%-4d년도는 윤년\n", i);
				else if(i%100==0)
					System.out.printf("%-4d년도는 윤년아님\n", i);
				else if(i%4==0)
					System.out.printf("%-4d년도는 윤년\n", i);
				else
					System.out.printf("%-4d년도는 윤년아님\n", i);
			}
			System.out.println("**************************");
			
			for(i=p; i<=n; i++) {	// 도댁체 왜 한줄로...
				if(((i%4==0)&&(i%100!=0))||(i%400==0)) 
					System.out.printf("%-4d년도는 윤년\n", i);
				else
					System.out.printf("%-4d년도는 윤년아님\n", i);
			}
			/* 현기증 ㅠ.ㅠ
			for(int i = p; i <= n; i++) {
				if(i%400==0)
					System.out.println(i+"년도는 윤년이 이에요");
				else
					if(i%100==0) {
							System.out.println(i+"년도는 윤년이 아니에요");
							if(i%4==0)
								System.out.println(i+"년도는 윤년이에요");
							else
								System.out.println(i+"년도는 윤년이 아니에요");
						System.out.println(i+"년도는 윤년이 아니에요");
			}
			*/
		}



	public static void main(String[] args) {
		//Hw1();
		//Hw2();
		//Hw3();
		Hw4();
	}
}

