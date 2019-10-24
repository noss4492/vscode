package day09_02;

public class Human {
	// Ŭ���� �������� : � �޼��忡���� �� ������ ����� �� �ִ�.
	String name;
	int age;
	String gender;
	String job;
	String phone;
	
	// ������ overloading ����
	Human(){
		this.name = "ȫ�浿�׸�";
		this.age = 100;
		this.job="����";
		System.out.println("�⺻������");
	}
	Human(String name){
		//name = name  <- error :(
		//this�� ��������� Ȯ�������� ������ �� ����.
		//member ������ ����Ű�� Ű���� this.
		
		// ȥ������ �ʴ´ٸ� �׳� �����ϰ� ��� ����
		// ȥ���ȴٸ� this.�� Ȯ�������� �������� ��.
		this.name = name;
	}
	Human(String name, int age){
		this.name = name;
		this.age = age;
	}
	Human(String name, int age, String job){
		this.name = name;
		this.age = age;
		this.job = job;
	}
	Human(String name, String job, String gender){
		//this.age = 200;
		//�ʱ�ȭ����(�⺻�����ڿ��� �����ؿ� �ڵ�)
		//�̷��� ���� �⺻�����ڸ� ȣ���ؼ� ����.
		this();
		this.name = name;
		this.job = job;
		this.gender = gender;
		System.out.println("parameter : string string string");
	}
	Human(String name, String gender, String job, int age){
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.job = job;
	}
	Human(String name, int age, String gender, String phone){
		//this.age = 200;
		//this();
		this(name, "����", gender);	// �ű���
		//�ʱ�ȭ����
		// or ��Ŭ->�ҽ�->����Ʈ���� ��¡ ���� : ����
		//super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		System.out.println("parameter : string int string string");
	}
	// ��� �⺻������ �����. 
	// (������ ��� JVM�� �Ѱ��� �����ڴ� �ִٰ� �⺻ �����ڸ� ��������)
	
	public void eating() {
		System.out.println("eat");
	}
	public void talking() {
		System.out.println("talk");
	}
	public void breathing() {
		System.out.println("breath");
	}
	public void status() {
		System.out.println("�̸� : "+this.name);
		System.out.println("���� : "+this.age);
		System.out.println("���� : "+this.gender);
		System.out.println("���� : "+this.job);
	}
	
	
	//public static void main(String[] args) {
	/*
		Human h1 = new Human("ȫ�浿", 20, "��", "010-1234-5678");
		h1.eating();
		h1.breathing();
		h1.talking();
		h1.status();
		
		System.out.println();
		
		Human h3 = new Human("¯��", 7, "��");
		
		h3.status();
		*/
	//}
	
	
}
