package day09_03;

public class TestMain04 {
	public static void main(String[] args) {
		//�̸������������̸�����Ű
		//Person p1 = new Person();
		//Person p2 = new Person("�浿hong","�Ϲ���",180.0f, 600.0f);
		//System.out.println("\n�̸�:"+p2.name+"\n����:"+p2.job+"\n����:"+p2.age);
		/*
		SuperMan sm = new SuperMan();	// �� ������ ���ο� �θ� �⺻�����ڵ� ȣ���
		
		System.out.println(sm.name);
		
		SuperMan sm2 = new SuperMan("jone");
		System.out.println(sm2.name+sm2.age);
		*/
		SuperMan sm3 = new SuperMan("Ŭ��ũ", "����", "��", 20, 70.0f, 190.0f);
		sm3.status();    // ����Ŭ������ �����ڷ� ������
		
		SuperMan sm4 = new SuperMan("Ŭ��ť", "Ű��", 99.0f, 210.0f);
		sm4.status();	// ���̿� ������ ���۸� Ŭ������ �����ڷ� ������ �������� ���� Ŭ������ �����ڷ� ������
		
		sm3.laserBeam();
		sm3.fly();
	}
}

// z z z