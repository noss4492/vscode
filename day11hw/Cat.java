package day11hw;

public class Cat extends Animal implements Barkable {
	String kind;
	
	@Override
	public void eating(String food) {
		System.out.println(this.getName()+": �ɳɸԱ�"+food);
	}
	@Override
	public void sleeping() {
		System.out.println("��zzz");
	}
	
	public void barksound() {
		System.out.println("�ɳ�?");
	}
}
