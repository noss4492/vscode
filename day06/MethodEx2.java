package day06;

public class MethodEx2 {
	// ' 3'...
	// method signature : �޼����/�Ű�����(����, ���� , Ÿ��)
	// method body : '3'...
	
	public static int maxEx2(int a, int b){
		return (a>b)?a:b;
	}
	public static float maxEx2(int a, float b) {
		return ((float)a>b)?(float)a:b;
	//	if((float)a>b)			// return�� Ư���� �� ���� �����Ͻ�
	//		return (float)a;
	//	return b;
	}
	public static int manEx2(int a, int b, int c) {
		return a+b+c;
	}
	
	
	
	static int sum(int x1, int x2, int x3, int x4) {
		x1 = x1 + 1;
		return x1+x2+x3+x4;
	}
	// �ǽ� �޸�
	// ���� �޼��� ������ x1, x2, x3, x4 �� ���� ������ �Ҵ�Ǿ� ����
	// �̸� ������ �޼���� ȣ���Ͽ� ����� ���� �� scope������ ��ȿ�ϴ�.
	// �̶� x1, x2, x3, x4�� �޸� �ٸ� ������ ����ǰ� ȣ���� ������ �������.
	
	// �̶��� x1, x2, x3, x4�� �Ű�����, ���� ����
	// <��> ���� ����

	// �������� �����Ϸ��� �׷��� �ſ���.. �������� �����Ͻô� ��' 3'
	
	// ������ ? ��?
	// max(0,0) max(0,0,0) .... -> �޼��� Overloading  " 3";;
	// overloading = ��������(�� �̸��� ���Ƶ� �ñ״��İ� �ٸ��ϱ�)
	// why? -> ���� ���ϴϱ�
	
	// �ڹٴ� ������ �����ε� �������� ������
	// ���ܷ� '+'�� ����/��� �����ڷ� �����ε��� ������.
	
	// ŷ�����̽��� ������ �����ε� �ſ� ���� ������.
	
	public static void main(String[] args) {
		System.out.println(maxEx2(100,200));
		System.out.println(maxEx2(100, 200.f));
		System.out.println(manEx2(100, 200, 300));
		System.out.println(sum(100,200,400,600));
		int a = sum(100, 200, 400, 600);
		System.out.println(a);
	}
}
