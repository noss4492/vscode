package day09_03;

public class Person {
//이름직업성별나이몸무게키
//먹기잠자기눕기
	String name;
	String job;
	String gender;
	int age;
	float weight;	//init 0.0f
	float height;
	
	Person(){
		this.name = "미입력";
		this.job = "미입력";
		this.gender = "미입력";
		this.age = 999;
		this.weight = 999.0f;
		this.height = 999.0f;
		System.out.println("사람 생성됨");
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
	// 생성됨
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
		System.out.println("먹");
	}
	void sleeping() {
		System.out.println("zzz");
	}
	void noop() {	//?눕다?
		System.out.println("푹");
	}
	void status() {
		System.out.printf("%s %d살 %s %s %.2fkg %.2fcm\n", 
				this.name, this.age, this.gender, this.job, this.weight, this.height);
	}
}
