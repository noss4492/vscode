package day11hw;

public class Dog extends Animal implements Barkable {
	String kind;
	
	@Override
	public void eating(String food) {
		System.out.println(this.getName()+": 港港冈扁"+food);
	}
	@Override
	public void sleeping() {
		System.out.println("港zzz");
	}
	
	public void barksound() {
		System.out.println("港港");
	}
}
