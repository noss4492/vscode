package day10_3;

public class Rabbit extends Mammal implements shore{
	String name;
	Rabbit(){
		super();
		this.varity = "�Ӱ��";
		this.name = "�����";
	}

	@Override
	public void eatting() {
		System.out.println("Ǯ��Ա�");
	}
	
	public void jumping() {
		System.out.println("JUMPING");
	}
}
