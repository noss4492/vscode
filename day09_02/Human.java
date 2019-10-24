package day09_02;

public class Human {
	// 클래스 전역변수 : 어떤 메서드에서도 이 변수를 사용할 수 있다.
	String name;
	int age;
	String gender;
	String job;
	String phone;
	
	// 생성자 overloading 간응
	Human(){
		this.name = "홍길동그만";
		this.age = 100;
		this.job="도적";
		System.out.println("기본생성자");
	}
	Human(String name){
		//name = name  <- error :(
		//this로 멤버변수를 확정적으로 지정할 수 있음.
		//member 변수를 가르키는 키워드 this.
		
		// 혼동되지 않는다면 그냥 생략하고 사용 가능
		// 혼동된다면 this.로 확정적으로 지정해줄 것.
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
		//초기화구문(기본생성자에서 복사해온 코드)
		//이러지 말고 기본생성자를 호출해서 쓰자.
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
		this(name, "무직", gender);	// 신기해
		//초기화구문
		// or 우클->소스->컨스트럭터 유징 필즈 : 오우
		//super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		System.out.println("parameter : string int string string");
	}
	// 없어도 기본값으로 실행됨. 
	// (생성자 없어도 JVM이 한개의 생성자는 있다고 기본 생성자를 생성해줌)
	
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
		System.out.println("이름 : "+this.name);
		System.out.println("나이 : "+this.age);
		System.out.println("성별 : "+this.gender);
		System.out.println("직업 : "+this.job);
	}
	
	
	//public static void main(String[] args) {
	/*
		Human h1 = new Human("홍길동", 20, "남", "010-1234-5678");
		h1.eating();
		h1.breathing();
		h1.talking();
		h1.status();
		
		System.out.println();
		
		Human h3 = new Human("짱구", 7, "못");
		
		h3.status();
		*/
	//}
	
	
}
