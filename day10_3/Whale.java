package day10_3;

public class Whale extends Mammal implements marine{
	
	Whale(){
		super();
		this.varity = "Ȥ���";
		//
	}
	
	@Override
	public void eatting() {
		System.out.println("�������");
	}
	
	@Override
	public void sleeping() {
		System.out.println("?? ��� ����?");
	}
	
	public void swimming() {
		System.out.println("�������");
	}

}
