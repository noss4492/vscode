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
		// System.out.println(num); 치트키
		System.out.println("0부터 100사이의 수를 맞추세요");	//num is 0 ~ 100
		do {
			userInput = DoInNum(lower, higher);
			if(userInput < num && userInput >= lower) {
				System.out.printf("[%2d]번째 검사한 값 : [%3d]보다 큽니다. 다시 입력해주세요.\n", cnt, userInput);
				lower = userInput;
				cnt++;
			}
			else if(userInput > num && userInput <= higher) {
				System.out.printf("[%2d]번째 검사한 값 : [%3d]보다 작습니다. 다시 입력해주세요.\n", cnt, userInput);
				higher = userInput;
				cnt++;
			}
			else if(userInput <= lower || userInput >= higher)
				System.out.println("입력할 수 없는 값입니다. 이미 밝혀진 조건을 벗어납니다. (무효)");
			else if(userInput == num) {
				System.out.printf("정답입니다. 정답은 [%3d] 입니다.\n [%2d]회 만에 맞추셨습니다.", userInput, cnt);
				break;
			}
		}while(true);
	}
	
	public static int DoInNum(int lower, int higher) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("현재 유효한 입력 범위 : %2d ~ %2d, 입력 : ", lower, higher);
		int num = sc.nextInt();
		return num;		
	}
	
	public static void hw02() {	//뭐 변환범위  code('a'~'z'||'A'~'Z'  'x' 'y' 'z'는 문자가 안나오니까
								//
		System.out.printf("변환할 영어 문장을 입력하시오 : ");
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
	
	public static void hw03()  {	//그냥 랜덤 배열로 정렬함.
		mySort.main(null);
	}
	
	public static void hw04() {
		int[][] score = {{80,80,80,0,0},		//int[5][6] -> 총계 추가 int[5][7]
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
		
		for(int i = 0; i < score.length-2; i++) {		// 그냥 추가로
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
		do{									// 중복 방지를 위해 추가됨
			ansNum = mySort.randGen(1000);	// 0~999
			ans[2] = ansNum%10;		// n = 2
			ans[1] = ansNum%100/10; // n = 1
			ans[0] = ansNum/100;	// n = 0
			if(ans[2]==ans[1] || ans[1]==ans[0] || ans[2]==ans[0]) {
			}
			else	//같은거 없어야만 탈출 가능
				break;
		}while(true);
		
		int flag = 0;
		int gcnt = 0;
		int userIn;	//string -> int
		int[] userAns;
		System.out.println(ansNum);
		
		do {
			do {// do do 엌ㅋㅋㅋㅋ 뭐 일단 써놓음;
				System.out.printf("맞춰보세요! 입력양식 [123] : ");
				Scanner sc = new Scanner(System.in);
				userIn = sc.nextInt();
				userAns = new int[3];
				
				userAns[2] = userIn%10;
				userAns[1] = userIn%100/10;
				userAns[0] = userIn/100;
				
				// 에이 멋 없다.
				if(userAns[2]==userAns[1] || //userAns[i]==userAns[j], i!=j
						userAns[1]==userAns[0] || 
						userAns[2] == userAns[0]) {	
					System.out.println("중복된 수를 입력하였습니다.");
				}
				else
					break;
			}while(true);
			/*	//중복 방지 랜덤수 뽑기, 기교가 있다~
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
					if(userAns[i] == ans[j])// 같을때
						if(i==j) {			// strike
							cnt[0]++;
						}
						else {				// ball
							cnt[1]++;
						}
					//궁금하면 내부 출력 ㄱㄱ
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
		//flag를 쓰고 싶은데 do while으로 시작해버려서 flag를 쓰면 한번 더 출력되는 불상사가..
		System.out.println("게임종료 "+gcnt+"번만에 맞추셨습니다.");
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
	//하나의 메소드명에 다중정의를 지원한다는 소리이다.
	//메소드명은 같더라도 시그니쳐가 다르기 때문에 사용 가능하다.
	//시그니쳐는 매개변수의 정보(갯수, 타입, 순서)에 따라서 달라진다.
	// 매개변수가 같지만 리턴 타입이 다른 경우 오버로딩이 성립되지 않음
	// 매개변수만을 보고서는 어떤 메소드가 호출될지 정할 수 없음
	// 자바에서 오퍼레이터 오버로딩은 + 에만 제공됨
	//이를 다형성을 지원한다고도 말한다.
	//사용법 : 메소드이름은 동일, 매개변수 정보는 상이하게
	
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
		//hw07 -> method overloading:시그니처로 구분하기 때문에 다형성을 지닌다.
		//hw08(2, 6);
	}
}
