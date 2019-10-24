package day10;

public class Parent {
	String name, job;
	int age;
	
	Parent(){
		System.out.println("Parent Class의 기본 생성자 호출됨");
	}
	Parent(String name){
		this.name = name;
	}
	
	public void singing() {
		System.out.println("singing");
	}
	public void eating() {
		System.out.println("eating");
	}
	public void breathing() {
		System.out.println("breathing");
	}
	public void jwanSori() {
		System.out.println("jwanSori");
	}

}
