package day01;

public class VarEx3 {
	public static void main(String[] args) {
		// byte  short int   long  
		// 1byte 2byte 4byte 8byte | 8bit 16bit 32bit 64bit
		//       char
		// US7ANCII KO16KSC5601 KO16MSWIN949 UNICODE
		byte b1 = 10;
		
		byte b2 = 50;
		
		System.out.printf("출력스b1:%d, %d \n", b1, b2);
		
		short sh1 = 10;
		//b1 = sh1;	
		// 대입연산자s 오버플로우s
		// 강제로~ 형변환~ 데이터~ 손실~ 될~ 수도~ 있~ 어~
		b1 = (byte)sh1;
		
		System.out.println(b1+"[비원s]");
		
		sh1 = 128;
		b1 = (byte)sh1;
		System.out.println(b1+"[비원s]");
		//1000 0000이 들어가서 -128임
		//0000 0000 1000 0000이 128임
		//2의 보수로 덧셈해서 뺄셈 구현한거 스킵함, 관심 있으면 찾아보라하심
		
		
		char c = 'a';
		char c2 = 97;
		char c3 = '\u0061';
		//0x41 -> 'A' 0x61 -> 'a' 0x30:'0'
		System.out.printf("%c %c %c\n\n",c,c2,c3);
		
		/////////////////////////////////////////////////////////////////////////////
		//주말ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss//
		//gogoogogogogogogogogogogogogogogogoogogogogogogogogoggoogo//
		///////////////////////////////////////////////////////////////////
	}
}
