package day11hw;

public abstract class Animal {
	private int age;
	private String name;
	
	public void eating(String food) {
		System.out.println(getName()+"�� �Ծ�� "+food+"��");
	}
	public void sleeping() {
		System.out.println("zzz");
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
