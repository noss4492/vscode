package day10_3;

public class Dog extends Mammal implements shore{
	String name;
	Dog(){
		super();
		this.varity = "�����Ʈ";
		this.name = "���Ҷ�";
	}
	
	@Override
	public void eatting() {
		System.out.println("������");
	}
	
	@Override
	public void sleeping() {
		System.out.println("����");
	}
	
	public void running() {
		System.out.println("R U N");
	}
}
