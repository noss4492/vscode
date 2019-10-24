package day03;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
//제어문(반복문for)
//조건분기문

// statement Ex6의 확장임.
public class statementEx6 {		//hw01
	
	public static void Ex6() throws IOException{
		System.out.print("입력해요 :");
		int value = System.in.read();
		value -= 48;
		int result = value % 3;
		
		if(result == 0)
			System.out.println("3의 배수이면 실행됨 : "+value);
		else
			System.out.println("3의 배수가 아니면 실행됨 : "+value);
		
		System.out.println();
	}
	
	public static void Ex7() throws IOException{		//hw02
		System.out.print("입력해 :");
		int value = System.in.read();
		char c = (char)value;
//		char d = (short)value; 이러믄 안대네... 타입을 비교해서 에러라 미리 처리해줌
		
		if(value>=65 && value<=96)
			System.out.println("a to z, ascii: "+value+" 문자 :"+c);
		else if(value>='A' && value<='Z')
			System.out.println("A to Z, ascii: "+value+" 문자 :"+c);
		else if(value>=40 && value<=49)
			System.out.println("0 to 9, ascii: "+value+" 문자 :"+c);
		else
			System.out.println("몰랑 들어있는 값 : "+value);
		
		System.out.println();
	}

	public static void hw03() {
		for(int i = 1; i<=100; i++) {
			if(i%2==0)
				System.out.println(i);
			else
				System.out.println("***");
		}
	}
	
	public static void hw04() {
		int sum = 0;
		/*
		for(int i = 1; i<=100; i++) {
			if(i%2==0)
				sum += i
		}
		*/
		for(int i = 1; i <= 100; i+=2) {
			sum += i;
		}
		
		System.out.println("1to100 짝수sum: "+sum);
	}
	
	public static void hw05() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇층? : ");
		int floor = sc.nextInt();
		sc.close();
		/*
		for(int i = 1; i <= floor; i++) {
			for(int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}*/

		/* 의미없는 아우성
		int cnt = 0;
		for(int i = 1; i <= floor; i++) {
			for(int j = 1; j<=1+10*Math.nextUp(Math.abs(Math.cos(i)*Math.sin(i))); j++) {
				for(int k = 1; k<=10-Math.nextDown((1+Math.exp(Math.cos(i)*Math.sin(i)))); k++)
					for(int n = 1; n<=2.05*Math.nextUp(Math.abs(Math.cos(i)*Math.sin(i))); n++) {
						if(i%2==0)
							System.out.print("\\");
						System.out.print("/");
					}
					System.out.print("-");
				System.out.print("|");//+1*Math.abs(Math.sin(i)));
			}
			System.out.println("_");
		}*/
	}
	public static void Hw10() throws IOException, Exception {
		
		// int flag_p=0; do로 시작해서 flag로 제어하면 동작 논리가 이상함.
		int value;
		try{
			System.out.print("입력(단, 영어 한글자만) : ");
			value = System.in.read();
			
			if(value >= 'a' && value <= 'z') {		// == (value -'a' + 'A')
				System.out.print("Down to Up : ");
				System.out.println((char)(value - 32));
			}
			else if(value >='A' && value <= 'Z') {
				System.out.print("Up to Down : ");
				System.out.println((char)(value + 32));
			}
			else {
				System.out.println("왜그러세요 ㅠㅠ");
				throw new Exception();
			}
		}catch (Exception e) {
			System.out.println("다음번엔 정확히 기입해주세요 ㅠㅠ");
			e.printStackTrace();
			throw e;
		}finally {
			System.out.println("-end");
		}
	}
	
	public static void statementEx9(){
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		
		switch(score) {
		case 10:
		case 9:
			System.out.println("대");
			//break;
		case 8:
			System.out.println("다");
			//break;
		case 7:
			System.out.println("내");
			//break;
		default:
		}
	}
	
	public static void statementEx10() {
		System.out.println("오눌\n축구\t함?");
		
		int year = 2019;
		int month = 10;
		int day = 15;
		String nation = "한쿸";
		
		System.out.println(year+"년  "+month+"월  "+day+"일  ");
		System.out.printf("%5s, %4d년 %2d월 %2d일",nation, year, month, day);
		//
		
	}
	public static void statementEx11() {
		// 무슨 띠니 매서드
		// 자축인묘진사오미신유술해
		// 4 5 6.. 3
		// 태어난 년도
		
		/*
		 * static boolean isYun(int n) { return n??[condition]; }
		 */
		
		System.out.print("태어난 년도 입력스 :");
		
		Scanner sc = new Scanner(System.in);
		int boneYear = sc.nextInt();
		
		System.out.println("입력된 년도 : " + boneYear);
		
		boneYear%=12;
		System.out.println("%"+boneYear);
		
		switch(boneYear) {
		case 4:
			System.out.println("님 쥐띠");
			break;
		case 5:
			System.out.println("님 소띠");
			break;
		case 6:
			System.out.println("님 호랑이띠");
			break;
		case 7:
			System.out.println("님 토끼띠");
			break;
		case 8:
			System.out.println("님 용띠");
			break;
		case 9:
			System.out.println("님 뱀띠");
			break;
		case 10:
			System.out.println("님 말띠");
			break;
		case 11:
			System.out.println("님 양띠");
			break;
		case 0:
			System.out.println("님 원숭이띠");
			break;
		case 1:
			System.out.println("님 닭띠");
			break;
		case 2:
			System.out.println("님 개띠");
			break;
		case 3:
			System.out.println("님 돼지띠");
			break;
		default:
			System.out.println("몬가 이상하다");
			break;
		}
	}
	
	public static void statementEx12() {
		final int tt = 90061;
		int d, h, m, t;
		t=tt%60;
		m=(int)(tt/60%(60));
		h=(int)(tt/(60*60)%(24));
		d=(int)(tt/(60*60*24));
		System.out.printf("%04d일 %02d시간 %02d분 %02d초", d, h, m, t);
	}
	/*
	int a = (int)3.3;
	int b = (int)3.5;
	int c = (int)3.7;
	System.out.printf("%4d, %4d, %4d", a,b,c);
	*/
	// 자동형 변환시 내림하는걸 알 수 있음.
	// Math.nextDown 필요 없음.
	
	/*
	static ArrayList<Integer> cm = new ArrayList<Integer>();
	static ArrayList<Integer> changeMoney(int n, int m, int cnt) {
		int cnt2 = 0;
		if( cnt2 == 0) {
			cm.add(n/50000);
			changeMoney(n, m, cnt++);
		}
		else if( cnt2 % 1 == 0) {
			cm.add(n/m);
			changeMoney(n/5, m/2, cnt++);
		}
		else{ // if( cnt2 % 0 == 0) {
			cm.add(n/m);
			changeMoney(n/2, m/5, cnt++);
		}
		return cm;
	}
	*/
	
//	public static void Hw13() {
		// 잔돈교환기 , 큰 화폐순으로
		// input : 67921
//		final int money = 67921;
		//1	1	1	2	1	4	0	2	0	1
			// # 문제점 발견. (논리가 빈 부분이 있다.)
			// if else 분기를 앞자리의 수로 판단하기에는 잔돈이 없는 경우도 잇으므로 불가능하다.
			// 일단 50000원 단위로 거스름돈을 나눠주면 다음 부터는 변환 순서가 정해져 있으므로
			// 불필요한 연산이 있더라도 일단은 카운트하여 연산하도록 하는게 좋겠다.
			// # 변경점. 
			// 앞의 자릿수로 판단한다는 생각은 오판으로 결론났다.
			// 빠르게 하는 것은 보류하고 정해진 순서대로 하도록 변경
			/*
			int cnt = n;
			for(int i=0; cnt/10!=0; i++) {		// 입력한 수의 자릿 수
				cnt /= 10;
			}
			if(n%(cnt*10)) {	//n의 맨 앞자리 수가 5 이면 n/5, 10000부터 10까지 감소하니까 
				change_money(n/5, m/2);
				cnt--;
			}
			else if(n%(cnt*10)) {		//n의 맨 앞자리 수가 2 이면 n/2
				change_money(n/2, m/5);
				cnt--;
			}*/
		
//		ArrayList<Integer> n = new ArrayList<Integer>();
//		n = changeMoney(50000, 10000, 0);		// 거스름돈 (10000~1)
		
/*
		n.add(money/50000);			// 거스름돈 단위 내림차순, 연산이 int로 반환되므로 명시x	
		n.add(money%50000/10000);	// 규칙이 2분기로 존재함.
		n.add(money%10000/5000);	// recursive식으로 표현 가능함.
		n.add(money%5000/1000);
		n.add(money%1000/500);
		n.add(money%500/100);
		n.add(money%100/50);
		n.add(money%50/10);
		n.add(money%10/5);
		n.add(money%5/1);
*/
		
		/*
		int c1 = 50000;
		for(int i = 0; i < n.size(); i++) {
			// 2개의 분기로 원단위 표현 가능 if문 추가할 것.	
			// 비어있으면 실행 안되게 
			
			if(i%2==0) {
				if(n.get(i)==0)
					break;
				System.out.print(c1+"원 매수 : "+n.get(i)+"\n");	
				c1 = c1/5;
				
			}
			else {
				if(n.get(i)==0)
					break;
				System.out.print(c1+"원 매수 : "+n.get(i)+"\n");	
				c1 = c1/2;
			}
			//System.out.println(n.get(i));
//			System.out.println(n.get(i)*);
		}
	}
*/
	
	
	
	
	
	
//	try{
//	    //에러가 발생할 수 있는 코드
//	    throw new Exception(); //강제 에러 출력 
//	}catch (Exception e){
//	    //에러시 수행
//	     e.printStackTrace(); //오류 출력(방법은 여러가지)
//	     throw e; //최상위 클래스가 아니라면 무조건 던져주자
//	}finally{
//	    //무조건 수행
//	} 
//	
//	System.out.println("영어 문자가 아님 계속? (Y/N)");
//	int yn = System.in.read();
//	if(yn == 'Y' || yn == 'y') {
//		System.out.println("종료함다");
//		flag_p++;
//		break;
//	}
//	else if(yn == 'N' || yn == 'n')
//		System.out.println("다시ㄱㄱ");
//	else
//		System.out.println("왜그래..ㅠㅠ");
	
	

	public static void main(String[] args) throws IOException, Exception {
		
		//statmentEx6.Ex6();
		//statementEx6.Ex7();
		//statementEx6.JudgePri();
		//statementEx6.hw03();
		//statementEx6.hw04();
		//Hw10();
		//statementEx9();
		//statementEx10();
		//statementEx11();
		//statementEx12();
		//Hw13();
	}
}
