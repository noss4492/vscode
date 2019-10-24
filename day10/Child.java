package day10;

public class Child extends Parent {
	String facebookID;
	
	Child(){
		super();
		System.out.println("child class의 기본 생성자 호출됨");
	}
	Child(String facebookID){
		this();
		this.facebookID = facebookID;
	}
	
	// Annotation @Override
	@Override
	public void singing() {
		System.out.println("좋은 꿈을 꿨어yo");
	}
	public void goClub() {
		System.out.println("go club");
	}
}
