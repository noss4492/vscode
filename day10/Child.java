package day10;

public class Child extends Parent {
	String facebookID;
	
	Child(){
		super();
		System.out.println("child class�� �⺻ ������ ȣ���");
	}
	Child(String facebookID){
		this();
		this.facebookID = facebookID;
	}
	
	// Annotation @Override
	@Override
	public void singing() {
		System.out.println("���� ���� ���yo");
	}
	public void goClub() {
		System.out.println("go club");
	}
}
