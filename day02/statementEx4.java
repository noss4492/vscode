package day02;

public class statementEx4 {
	
	public static void PrintStair() {
		for(int j = 0; j <= 4; j++) {		//0,1,2,3,4
			for(int i = 0; i <= j; i++) {	//0, 01, 012, 0123, 01234
				System.out.print("1");
				// if you make sure of this for sentence, execute next line
				// System.out.print("|[j,i]:"+j+" "+i+"  ");
			}
			System.out.println();
		}
	}
	
	public static void PrintMulTable(int n, int m) {
		for(int i=1; i<=m; i++) {
			for(int j=n; j<=m; j++) {
				System.out.printf("[%1d*%1d=%2d]", j, i, j*i);
			}
			System.out.println();
		}
	}
	
	/* i : 1, j : 2 3 4 5 6 7 8 9
	 * i : 2, j : 2 3 4 5 6 7 8 9
	 * ..........................
	 * ..........................
	 * ..........................
	 * i : 9, j : 2 3 4 5 6 7 8 9
	 */
	
	
	public static void main(String[] args) {
		statementEx4.PrintStair();
		statementEx4.PrintMulTable(2, 9);
		
		/*
		 * statementEx3은 for, while, do while의 설명이었음, 생략함.
		int i = 1;
		while(i <= 9) {
			System.out.print("3 *"+i+" = "+3*i+" | ");
			i++;
		}
		System.out.println();
		
		int j = 1;
		do{
		System.out.print("3 *"+j+" = "+3*(j++)+" | ");
		}while(j <= 9);
		*/
	}
}
