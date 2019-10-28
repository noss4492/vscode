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
		
		// �������� �Է� ���������� �����Ƿ� �����ϴ� ���� ����.
		do {
			System.out.println("������ ���� �ֹι�ȣ�� �Է����ּ���. \n ex.[123456-1234567]");
			Scanner sc = new Scanner(System.in);
			userInput = sc.nextLine();
			pFlag = Pattern.matches(pattern, userInput);
			if(pFlag==true)
				break;
			System.out.println("��Ŀ� �°� �Է����ּ���.");
		}while(pFlag==false);
		long start = System.nanoTime();
		
		String gender = null;//7�� �ε����� ���� ���� ����.
		
		switch(userInput.charAt(7)){
		case '4':
			gender = "��";
			break;
		case '3':
			gender = "��";
			break;
		case '2':
			gender = "��";
			break;
		case '1':
			gender = "��";
			break;
		default:
			gender = "�ܱ���";
			break;
		}
		StringBuffer reverse = new StringBuffer(userInput);
		userInput = reverse.reverse().toString();
		System.out.printf("%02d��%02d��%02d�� ����:%s\n", 
				((int)userInput.charAt(13)-'0')*10+((int)userInput.charAt(12)-'0'),
				((int)userInput.charAt(11)-'0')*10+((int)userInput.charAt(10)-'0'),
				((int)userInput.charAt(9)-'0')*10+((int)userInput.charAt(8)-'0'),
				gender);
		long end = System.nanoTime();
		System.out.println(Math.abs(start-end)+"ns");
	}
	
	public static void notmy() {		// ������ Ǯ��
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� (���ڸ� 13�ڸ��� �����Է�) : \n ex.[1234561234567]\n");
		String data = sc.next();
		
		long start = System.nanoTime();
		
		String year = data.substring(0, 2);
		String month = data.substring(2, 4);
		String day = data.substring(4, 6);
		String type = data.substring(6, 7);
		System.out.println(type);
		String gender = "";
		if(type.equals("1") || type.equals("3")) 
			gender = "����";
		else if(type.equals("3") || type.equals("4")) 
			gender = "����";
		else 
			gender = "�ܱ���"; //���
		System.out.println(gender);
		System.out.println(year+"|"+month+"|"+day+"|"+gender);
		
		long end = System.nanoTime();
		System.out.println(Math.abs(start-end)+"ns");
	}
	

	public static void main(String[] args) {	// ����
		// �ֹι�ȣ �Է¹޾� ��� ��� ���ϻ����� ���
		// 00�� 00�� 00�� �����̳׿� 1 2 3 4
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
// 000000 - 1(234)000000 14�ڸ� �Է�

//			if(pFlag == true) {
//				break;
//			}




// ������ Ǯ��

/*
== �� �������� ���Ͽ� ���� ��ü���� �Ǵ�.
if(data == "hello")

�����Ͱ� �� �Ϸ���
if(data.equals("Hello"))

*/
