package day12;

public class StringEx2 {
	public static void main(String[] args) {
		String str = "java oracle";
		
		// 4번째 문자(배열의 인덱스는 0부터)
		char ch = str.charAt(3);
		
		System.out.println(ch);
		
		// 문자열의 연결
		String str2 = "월요일 좋아 ";
		String str3 = "너무나 좋아 ";
		String str4 = str2.concat(str3);
		System.out.println(str4);
		String str5 = "~♩  ~♪ ~♩  ~♪";
		String str6 = str4 + str5;
		System.out.println(str6);
		
		// method chaining		이것이 stream style인가?
		String str7 = "오늘은".concat("워료일")
							.concat("워료")
							.concat("이일")
							.concat("월~요일~");
		
		/*
		int sum = Stream.iterate(0, i -> i < 10, i -> i + 1)
				  .filter(i -> i % 2 == 1)
				  .mapToInt(Integer::intValue)
				  .sum();
				System.out.println("합: " + sum); // 합: 25
				*/
		
		boolean flag = str.contains("jav");
		System.out.println(flag);
		
		
		// String.equals 내용비교
		// String.equalsIgnoreCase() case(대소문자)무시하고 같아?
		
		boolean isSame = str.equalsIgnoreCase("jAvA oRaClE");
		System.out.println("대소문자 무시하고 비교한 isSame "+isSame);
		
		int position = str.indexOf('r');
		System.out.println("r 위치 " + position);
		
		int length = str.length();
		System.out.println("str 길이 " + length);
		
		String str9 = " "+str;
		System.out.println("\nstr9 "+str9);
		String str10 = String.valueOf(20);
		System.out.println("str10 "+str10);
		
		
		//------------------- 역순 출력 해보기-------------------
		System.out.println("--------------------");
		
		String a = "1234567890";
		String b = "";
		
		// 내가 만든 변환기
		for(int i = a.length()-1; i >=0 ; i--) {
			char tmp = a.charAt(i);
			b = b.concat(Character.toString(tmp));
		}
		System.out.println("역순 출력 결과 : "+b+"");
		
		System.out.println("--------------------");
		// 선생님 풀이
		//str.toCharArray(); 이걸로 문자열을 문자배열로 한번에 푱 할 수 있음.
		char[] str8 = str.toCharArray();
		for(int i = 0; i < str8.length; i++)
			System.out.print(" "+str8[i]);
		System.out.println("--------------------");
		
		
		
		//^  ([a-z0-9  .])+@ $         _\ . - 
		///^              .-@$/
		// 내가 푼 풀이 0.0063 ms
		System.out.println("--------------------");
		String email = "dagda@hanafos.com";
		String ems = " ";
		long start = System.nanoTime();
		for(int i = 0; i < email.length()-1; i++) {	// 이 부분 별로네 ㅇㅇ
			if(email.charAt(i) == '@'){
				ems = ems.concat(email.substring(0, i));
				break;
			}
		}
		long end = System.nanoTime();
		
		System.out.println("email ID :"+ems);
		System.out.println("nano time : "+ Math.abs(start-end)/Math.pow(10, 6));
		
		// 선생님 풀이 (식이 이뻐 근데 왜 동작 시간이..?) 0.0298ms
		System.out.println("--------------------");
		String email2 = "dagda@hanafos.com";
		
		start = System.nanoTime();
		System.out.println(email2.substring(0, email2.indexOf('@')));
		end = System.nanoTime();
		
		System.out.println("email ID :"+ems);
		System.out.println("nano time : "+ Math.abs(start-end)/Math.pow(10, 6));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
