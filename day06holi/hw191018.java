package day06holi;

import java.util.Scanner;

import day06holi.mySort.QuickSort;

public class hw191018 extends mySort {
	
	public static void hw01() {
		int num;
		int userInput;
		int higher = 100;
		int lower = 0;
		int cnt = 0;
		num = mySort.randGen(101);
		// System.out.println(num); ġƮŰ
		System.out.println("0���� 100������ ���� ���߼���");	//num is 0 ~ 100
		do {
			userInput = DoInNum(lower, higher);
			if(userInput < num && userInput >= lower) {
				System.out.printf("[%2d]��° �˻��� �� : [%3d]���� Ů�ϴ�. �ٽ� �Է����ּ���.\n", cnt, userInput);
				lower = userInput;
				cnt++;
			}
			else if(userInput > num && userInput <= higher) {
				System.out.printf("[%2d]��° �˻��� �� : [%3d]���� �۽��ϴ�. �ٽ� �Է����ּ���.\n", cnt, userInput);
				higher = userInput;
				cnt++;
			}
			else if(userInput <= lower || userInput >= higher)
				System.out.println("�Է��� �� ���� ���Դϴ�. �̹� ������ ������ ����ϴ�. (��ȿ)");
			else if(userInput == num) {
				System.out.printf("�����Դϴ�. ������ [%3d] �Դϴ�.\n [%2d]ȸ ���� ���߼̽��ϴ�.", userInput, cnt);
				break;
			}
		}while(true);
	}
	
	public static int DoInNum(int lower, int higher) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("���� ��ȿ�� �Է� ���� : %2d ~ %2d, �Է� : ", lower, higher);
		int num = sc.nextInt();
		return num;		
	}
	
	public static void hw02() {	//�� ��ȯ����  code('a'~'z'||'A'~'Z'  'x' 'y' 'z'�� ���ڰ� �ȳ����ϱ�
								//
		System.out.printf("��ȯ�� ���� ������ �Է��Ͻÿ� : ");
		Scanner sc = new Scanner(System.in);
		String userInStr = sc.nextLine();
		char[] decodedChar = new char[userInStr.length()];
		for(int i = 0; i < userInStr.length(); i++) {	// Decoding +3
//			if((decodedChar[i] >=88 && decodedChar[i]<90) | (decodedChar[i]>=120 && decodedChar[i]<=122))
//				decodedChar[i]-=26;
//			decodedChar[i] = (char) ((int)userInStr.charAt(i)+3);
		}
		System.out.printf("    <Decoded> : ");
		for(int x : decodedChar)
			System.out.printf("%c", x);
		
		for(int i = 0; i < userInStr.length(); i++)	// Demodulation -3
			decodedChar[i] = (char) ((int)decodedChar[i]-3);
		
		System.out.printf("\n<Demodulated> : ");
		for(int x : decodedChar)
			System.out.printf("%c", x);
	}
	
	public static void hw03()  {	//�׳� ���� �迭�� ������.
		mySort.main(null);
	}
	
	public static void hw04() {
		int[][] score = {{80,80,80,0,0},		//int[5][6] -> �Ѱ� �߰� int[5][7]
				{60,50,80,0,0},
				{50,90,90,0,0},
				{40,50,60,0,0},
				{90,90,95,0,0},
				{85,95,100,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}};

		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < 3; j++) {
				score[i][3] += score[i][j];
			}
			score[i][4] = score[i][3]/3;
		}
		
		for(int i = 0; i < score.length-2; i++) {		// �׳� �߰���
			for(int j = 0; j < score[0].length; j++) {
				score[6][j] += score[i][j];
				score[7][j] = score[6][j]/3;
			}
		}
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				System.out.printf("%4d ",score[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void hw05() {
		int ansNum;
		int ans[] = new int[3];	//decimal 10^n
		do{									// �ߺ� ������ ���� �߰���
			ansNum = mySort.randGen(1000);	// 0~999
			ans[2] = ansNum%10;		// n = 2
			ans[1] = ansNum%100/10; // n = 1
			ans[0] = ansNum/100;	// n = 0
			if(ans[2]==ans[1] || ans[1]==ans[0] || ans[2]==ans[0]) {
			}
			else	//������ ����߸� Ż�� ����
				break;
		}while(true);
		
		int flag = 0;
		int gcnt = 0;
		int userIn;	//string -> int
		int[] userAns;
		System.out.println(ansNum);
		
		do {
			do {// do do ���������� �� �ϴ� �����;
				System.out.printf("���纸����! �Է¾�� [123] : ");
				Scanner sc = new Scanner(System.in);
				userIn = sc.nextInt();
				userAns = new int[3];
				
				userAns[2] = userIn%10;
				userAns[1] = userIn%100/10;
				userAns[0] = userIn/100;
				
				// ���� �� ����.
				if(userAns[2]==userAns[1] || //userAns[i]==userAns[j], i!=j
						userAns[1]==userAns[0] || 
						userAns[2] == userAns[0]) {	
					System.out.println("�ߺ��� ���� �Է��Ͽ����ϴ�.");
				}
				else
					break;
			}while(true);
			/*	//�ߺ� ���� ������ �̱�, �ⱳ�� �ִ�~
				for(int i = 0; i < com.length; i++) {
					com[i]=(int)(Math.random()*10);
					for(int j = 0; j < i; j++) {
						if(com[j]==com[i])
							i--;
					}
				}*/
			
			int cnt[] = {0, 0};	//S B

//			for(int i = 2; i >= 0; i--)
//				System.out.println("User "+userAns[i]+"  Ans "+ans[i]);
			
			for(int i = 0; i < 3; i++) {	
				for(int j = 0; j < 3; j++) {
					if(userAns[i] == ans[j])// ������
						if(i==j) {			// strike
							cnt[0]++;
						}
						else {				// ball
							cnt[1]++;
						}
					//�ñ��ϸ� ���� ��� ����
					//System.out.println("s. "+i+"|"+j);
					//System.out.println("b. "+i+"|"+j);
					//System.out.println(".. "+i+"|"+j);
				}
			}			
			System.out.printf("[S:%2d B:%2d]\n", cnt[0], cnt[1]);
			gcnt++;
			if(cnt[0] == 3)
				break;
		}while(true);
		//flag�� ���� ������ do while���� �����ع����� flag�� ���� �ѹ� �� ��µǴ� �һ�簡..
		System.out.println("�������� "+gcnt+"������ ���߼̽��ϴ�.");
	}
	public static void hw06() {
		int result1 = plus(100,400);
		float result2 = plus(100,200.0f, 300);
		double result3 = plus(100,300.0, 200);
		System.out.println(result1+"|"+result2+"|"+result3);
	}
	private static int plus(int a, int b) {
		return a + b;
	}
	private static float plus(int a, float b, int c) {
		return (float)a+b+(float)c;
	}
	private static double plus(int a, double b, int c) {
		return (double)a+b+(double)c;
	}
	//hw07
	//�ϳ��� �޼ҵ�� �������Ǹ� �����Ѵٴ� �Ҹ��̴�.
	//�޼ҵ���� ������ �ñ״��İ� �ٸ��� ������ ��� �����ϴ�.
	//�ñ״��Ĵ� �Ű������� ����(����, Ÿ��, ����)�� ���� �޶�����.
	// �Ű������� ������ ���� Ÿ���� �ٸ� ��� �����ε��� �������� ����
	// �Ű��������� ������ � �޼ҵ尡 ȣ����� ���� �� ����
	// �ڹٿ��� ���۷����� �����ε��� + ���� ������
	//�̸� �������� �����Ѵٰ� ���Ѵ�.
	//���� : �޼ҵ��̸��� ����, �Ű����� ������ �����ϰ�
	
	public static void hw08(int a, int b) {
		for(int i = 1; i <= 9; i++) {
			for(int j = a; j <= b; j++)
				System.out.printf(" %2d *%2d=%2d",j,i,a*b);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		//hw01();
		//hw02();
		//hw03();
		//hw04();
		//hw05();
		//hw06();
		//hw07 -> method overloading:�ñ״�ó�� �����ϱ� ������ �������� ���Ѵ�.
		//hw08(2, 6);
	}
}
