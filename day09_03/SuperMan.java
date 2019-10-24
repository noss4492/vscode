package day09_03;

public class SuperMan extends Person {
	
	SuperMan(){// 생성자도 메서드니까 부모한테 받은게 있어서 이름이 딴게 나왔던 것
		super();	// 부모의 기본 생성자 호출. 내가 쓰지 않더라도
		// 변수 초기화 해줫 super() 부모의 기본 생성자를 호출하믄 되는구만 
		// 내가 쓰지 않더라도 이렇게 되어있음.
		// this, super, this(), super()
		this.name="슈퍼맨";
		System.out.println("슈퍼 사람 생성됨");
	}
	public SuperMan(String name, String job, String gender, int age, float weight, float height) {
		super(name, job, gender, age, weight, height);
		System.out.println("슈퍼 사람 생성됨");
	}
	public SuperMan(String name, String job, float weight, float height) {
		super(name, job, weight, height);
		this.age = 32;
		this.gender = "남자";
		System.out.println("슈퍼 사람 생성됨");
	}

	
	
	//String name, String job, float weight, float height
	

	SuperMan(String name){	// 여기도 슈퍼() 되어있네 //부모에 기본 생성자 없으면 error
		this.name=name;
		System.out.println("22222222");
	}
	public void laserBeam() {
		System.out.println("Laser");
	}
	public void fly() {
		System.out.println("Fly");
	}
}
