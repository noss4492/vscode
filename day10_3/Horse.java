package day10_3;

public class Horse extends Mammal{
	int footgoop;
	
	Horse(){
		super();
	}
	
	@Override
	public void eatting() {
		System.out.println("´ç±Ù¸Ó°Ï");
	}
	public void running() {
		System.out.println("´Ù±¸´Ú ´Ù±¸´Ú");
	}
}
