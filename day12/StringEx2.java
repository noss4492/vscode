package day12;

public class StringEx2 {
	public static void main(String[] args) {
		String str = "java oracle";
		
		// 4��° ����(�迭�� �ε����� 0����)
		char ch = str.charAt(3);
		
		System.out.println(ch);
		
		// ���ڿ��� ����
		String str2 = "������ ���� ";
		String str3 = "�ʹ��� ���� ";
		String str4 = str2.concat(str3);
		System.out.println(str4);
		String str5 = "~��  ~�� ~��  ~��";
		String str6 = str4 + str5;
		System.out.println(str6);
		
		// method chaining		�̰��� stream style�ΰ�?
		String str7 = "������".concat("������")
							.concat("����")
							.concat("����")
							.concat("��~����~");
		
		/*
		int sum = Stream.iterate(0, i -> i < 10, i -> i + 1)
				  .filter(i -> i % 2 == 1)
				  .mapToInt(Integer::intValue)
				  .sum();
				System.out.println("��: " + sum); // ��: 25
				*/
		
		boolean flag = str.contains("jav");
		System.out.println(flag);
		
		
		// String.equals �����
		// String.equalsIgnoreCase() case(��ҹ���)�����ϰ� ����?
		
		boolean isSame = str.equalsIgnoreCase("jAvA oRaClE");
		System.out.println("��ҹ��� �����ϰ� ���� isSame "+isSame);
		
		int position = str.indexOf('r');
		System.out.println("r ��ġ " + position);
		
		int length = str.length();
		System.out.println("str ���� " + length);
		
		String str9 = " "+str;
		System.out.println("\nstr9 "+str9);
		String str10 = String.valueOf(20);
		System.out.println("str10 "+str10);
		
		
		//------------------- ���� ��� �غ���-------------------
		System.out.println("--------------------");
		
		String a = "1234567890";
		String b = "";
		
		// ���� ���� ��ȯ��
		for(int i = a.length()-1; i >=0 ; i--) {
			char tmp = a.charAt(i);
			b = b.concat(Character.toString(tmp));
		}
		System.out.println("���� ��� ��� : "+b+"");
		
		System.out.println("--------------------");
		// ������ Ǯ��
		//str.toCharArray(); �̰ɷ� ���ڿ��� ���ڹ迭�� �ѹ��� �y �� �� ����.
		char[] str8 = str.toCharArray();
		for(int i = 0; i < str8.length; i++)
			System.out.print(" "+str8[i]);
		System.out.println("--------------------");
		
		
		
		//^  ([a-z0-9  .])+@ $         _\ . - 
		///^              .-@$/
		// ���� Ǭ Ǯ�� 0.0063 ms
		System.out.println("--------------------");
		String email = "dagda@hanafos.com";
		String ems = " ";
		long start = System.nanoTime();
		for(int i = 0; i < email.length()-1; i++) {	// �� �κ� ���γ� ����
			if(email.charAt(i) == '@'){
				ems = ems.concat(email.substring(0, i));
				break;
			}
		}
		long end = System.nanoTime();
		
		System.out.println("email ID :"+ems);
		System.out.println("nano time : "+ Math.abs(start-end)/Math.pow(10, 6));
		
		// ������ Ǯ�� (���� �̻� �ٵ� �� ���� �ð���..?) 0.0298ms
		System.out.println("--------------------");
		String email2 = "dagda@hanafos.com";
		
		start = System.nanoTime();
		System.out.println(email2.substring(0, email2.indexOf('@')));
		end = System.nanoTime();
		
		System.out.println("email ID :"+ems);
		System.out.println("nano time : "+ Math.abs(start-end)/Math.pow(10, 6));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
