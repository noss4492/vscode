package day09_03;

public class Person {
//�̸������������̸�����Ű
//�Ա����ڱ⴯��
	String name;
	String job;
	String gender;
	int age;
	float weight;	//init 0.0f
	float height;
	
	Person(){
		this.name = "���Է�";
		this.job = "���Է�";
		this.gender = "���Է�";
		this.age = 999;
		this.weight = 999.0f;
		this.height = 999.0f;
		System.out.println("��� ������");
	}
	Person(String name, String job, String gender, int age, float weight, float height){
		this();
		this.name = name;
		this.job = job;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	Person(String name, String job, int age, float weight, float height){
		this();
		this.name = name;
		this.job = job;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}
	// ������
	public Person(String name, String job, float weight, float height) {
		//super();
		this();
		this.name = name;
		this.job = job;
		this.weight = weight;
		this.height = height;
	}
	public Person(String name) {
		//super();
		this();
		this.name = name;
	}
	void eating() {
		System.out.println("��");
	}
	void sleeping() {
		System.out.println("zzz");
	}
	void noop() {	//?����?
		System.out.println("ǫ");
	}
	void status() {
		System.out.printf("%s %d�� %s %s %.2fkg %.2fcm\n", 
				this.name, this.age, this.gender, this.job, this.weight, this.height);
	}
}
