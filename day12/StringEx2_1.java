package day12;

public class StringEx2_1 {
	public static void main(String[] args) {
		String str5 = "java";
		String str6 = "java";
		
		if(str6 == str5) {
			System.out.println("str5, 6�� ���� ��ü�� ����Ű�� ����");
		}
		
		String str = "";
		for(int i = 0; i < 100; i++) {	// ���� ���� ���ڰ� �Ǵ� ����
			str += "*";					// ������ 99�� ����� ����;
			System.out.println(str);
		}
		
		
		// new�� �����Ҷ� X ������ ���ο�� ���� ��°�.
		// String str = "aa";
		// �̶��� ���ؼ� �̾߱���.
	}

}
