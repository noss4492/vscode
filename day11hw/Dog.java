package day11hw;

public class Dog extends Animal implements Barkable {
	String kind;
	
	@Override
	public void eating(String food) {
		System.out.println(this.getName()+": �۸۸Ա�"+food);
	}
	@Override
	public void sleeping() {
		System.out.println("��zzz");
	}
	
	public void barksound() {
		System.out.println("�۸�");
	}
}
