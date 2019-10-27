package day11hw;

public class Cat extends Animal implements Barkable {
	String kind;
	
	@Override
	public void eating(String food) {
		System.out.println(this.getName()+": 成成冈扁"+food);
	}
	@Override
	public void sleeping() {
		System.out.println("成zzz");
	}
	
	public void barksound() {
		System.out.println("成成?");
	}
}
