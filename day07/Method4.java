package day07;

public class Method4 {
	public static int plus(int a, int b) {
		return a+b;
	}
	public static float plus(float a, int b) {
		return a+(float)b;
	}
	public static String plus(String a, String b) {
		return a+" "+b;
	}

	// �޼��� �����ε�
	// 1. ��������
	// 2. ��� : �޼��� �̸��� ����
	//         �Ű������� �ڷ���, ����, ������ �ٸ���
	// ���� : return type�� �����ε��� ������ ����.
	public static void main(String[] args) {
		System.out.println(plus(100, 200));
		System.out.println(plus(100.0f, 200));
		System.out.println(plus("������", "������"));
	}

}
