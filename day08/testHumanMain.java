package day08;

public class testHumanMain {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "ȫ�浿";
		p1.age=20;
		p1.job="����";
		p1.gender = "��";
		
		System.out.println(p1);
		System.out.println(p1.name);
		System.out.println("���� : "+p1.job);
		System.out.println("���� : "+p1.age);
		p1.eating();
		p1.sleeping();
		p1.thinking();
		
		Person p2 = new Person();
		p2.name = "ȣ����";
		p2.age = 20;
		p2.job = "���׹��";
		p2.gender = "�߼�";
		System.out.println(p2);
		System.out.println(p2.name);
		System.out.println("���� : "+p2.job);
		System.out.println("���� : "+p2.age);
		p2.eating();
		p2.sleeping();
		p2.thinking();
	}

}
