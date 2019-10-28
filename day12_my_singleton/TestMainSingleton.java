package day12_my_singleton;

public class TestMainSingleton {
	public static void main(String[] args) {
		Normal n1 = new Normal();
		Normal n2 = new Normal();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if(n1 == n2)
			System.out.println("n1 == n2");
		else
			System.out.println("n1 != n2");
		
		if(s1 == s2)
			System.out.println("s1 == s2");
		else
			System.out.println("s1 != s2");
		
// �̱��� ��� ����
// 1. ������ �޸� ������ ����ϵ��� �� �ѹ� new �����ڷ� �ν��Ͻ��� ���´�. (�޸� ���� ����)
// 2. ���������� ����ǰ� �����޼���� ȣ���ϱ� ������ �ٸ� Ŭ�������� ����ϱ� ����. (���Ǽ�)
// 3. ����� ��ü�� ����Ͽ��� �ϴ� �ڵ����� �Ź� ��ü�� �������� �ʰ� ���� ��ü�� ����ϵ��� �� (���� ����)
		
// �̱��� ����� ���
// 1. private �����ڷ� new ���� ����
// 2. ������ ���� ��ü ��ȯ�� ���� ���� �޼ҵ�
// 3. ������ ���� ��ü�� ������ ���� ��������
	}
}
