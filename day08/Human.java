package day08;

public class Human {
	// Ŭ���� �������� : � �޼��忡���� �� ������ ����� �� �ִ�.
	String name;
	int age;
	String gender;
	String job;
	
	// ������ overloading ����
	Human(){
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
	Human(String name, int age, String gender, String job){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.job = job;
	}
	// ��� �⺻������ �����. 
	// (������ ��� JVM�� �Ѱ��� �����ڴ� �ִٰ� �⺻ �����ڸ� ��������)
	
	void eating() {
		System.out.println("eat");
	}
	void talking() {
		System.out.println("talk");
	}
	void breathing() {
		System.out.println("breath");
	}
	void status() {
		System.out.println("�̸� : "+this.name);
		System.out.println("���� : "+this.age);
		System.out.println("���� : "+this.gender);
		System.out.println("���� : "+this.job);
	}
	
	
	public static void main(String[] args) {
		Human h1 = new Human("ȫ�浿", 20, "��", "010-1234-5678");
		h1.eating();
		h1.breathing();
		h1.talking();
		h1.status();
		
		System.out.println();
		
		Human h3 = new Human("¯��", 7, "��");
		
		h3.status();
	}
	
	
}
