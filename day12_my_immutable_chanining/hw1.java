package day12_my_immutable_chanining;

import java.util.Scanner;
import java.util.regex.Pattern;
//import java.util.regex.Matcher;

public class hw1 {
	// method 1 : 1304200ns T.T....
	// method 2 : 186900ns
	public static void mymy() {
		String userInput = new String();
		String pattern = "(^[0-9]{6}\\-[1-4]{1}[0-9]{6}$)";
		boolean pFlag = false;
		
		// 문제에서 입력 제한조건이 없으므로 강제하는 구문 생성.
		do {
			System.out.println("다음과 같이 주민번호를 입력해주세요. \n ex.[123456-1234567]");
			Scanner sc = new Scanner(System.in);
			userInput = sc.nextLine();
			pFlag = Pattern.matches(pattern, userInput);
			if(pFlag==true)
				break;
			System.out.println("양식에 맞게 입력해주세요.");
		}while(pFlag==false);
		long start = System.nanoTime();
		
		String gender = null;//7번 인덱스에 따른 성별 구분.
		
		switch(userInput.charAt(7)){
		case '4':
			gender = "여";
			break;
		case '3':
			gender = "남";
			break;
		case '2':
			gender = "여";
			break;
		case '1':
			gender = "남";
			break;
		default:
			gender = "외국인";
			break;
		}
		StringBuffer reverse = new StringBuffer(userInput);
		userInput = reverse.reverse().toString();
		System.out.printf("%02d년%02d월%02d일 성별:%s\n", 
				((int)userInput.charAt(13)-'0')*10+((int)userInput.charAt(12)-'0'),
				((int)userInput.charAt(11)-'0')*10+((int)userInput.charAt(10)-'0'),
				((int)userInput.charAt(9)-'0')*10+((int)userInput.charAt(8)-'0'),
				gender);
		long end = System.nanoTime();
		System.out.println(Math.abs(start-end)+"ns");
	}
	
	public static void notmy() {		// 선생님 풀이
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 (숫자만 13자리로 연속입력) : \n ex.[1234561234567]\n");
		String data = sc.next();
		
		long start = System.nanoTime();
		
		String year = data.substring(0, 2);
		String month = data.substring(2, 4);
		String day = data.substring(4, 6);
		String type = data.substring(6, 7);
		System.out.println(type);
		String gender = "";
		if(type.equals("1") || type.equals("3")) 
			gender = "남성";
		else if(type.equals("3") || type.equals("4")) 
			gender = "여성";
		else 
			gender = "외국인"; //띠용
		System.out.println(gender);
		System.out.println(year+"|"+month+"|"+day+"|"+gender);
		
		long end = System.nanoTime();
		System.out.println(Math.abs(start-end)+"ns");
	}
	

	public static void main(String[] args) {	// 삽질
		// 주민번호 입력받아 몇년 몇월 몇일생인지 출력
		// 00년 00월 00일 남성이네용 1 2 3 4
		mymy();
		notmy();
	}
}
/*---------------------------------------*/
//Pattern p1 = Pattern.compile(pattern);	
//Matcher m = p1.matcher(sb);
/*---------------------------------------*/
//^ $  [0-9] \d
//\d{6} \- [1-4]\d{6}
//Pattern p = Pattern.compile("(^[0-9]{6})\s\-\s([0-9]{7}$)");
//Pattern p = Pattern.compile("(^[0-9]{6} \- [1-4]\d{6}$)");
//String pattern1 = "(^[0-9]{6} \- [1-4]\d{6}$)";
//		String ps1 = "(^\\d{6}\\s \\- \\s[1-4]\\d{6}$)";
//		String ps1 = "(^[0-9]{6}.\\-.[1-4]{0}[0-9]{6}$)";

//System.out.println("UserInput value : "+userInput);

//			if(m.find()) {
//				break;
//			}
//				Integer.parseInt(userInput.substring(12, 12), 10),
//				Integer.parseInt(userInput.substring(10, 11), 10),
//				Integer.parseInt(userInput.substring(8, 9), 10),			
//		System.out.println(sb);
// 000000 - 1(234)000000 14자리 입력

//			if(pFlag == true) {
//				break;
//			}




// 선생님 풀이

/*
== 는 참조값을 비교하여 동일 객체인지 판단.
if(data == "hello")

데이터값 비교 하려면
if(data.equals("Hello"))

*/
