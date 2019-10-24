package day10_3;

public class Whale extends Mammal implements marine{
	
	Whale(){
		super();
		this.varity = "혹등고래";
		//
	}
	
	@Override
	public void eatting() {
		System.out.println("새우먹음");
	}
	
	@Override
	public void sleeping() {
		System.out.println("?? 어떻게 잤음?");
	}
	
	public void swimming() {
		System.out.println("수여어엉");
	}

}
