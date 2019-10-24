package day10_3;

public class Rabbit extends Mammal implements shore{
	String name;
	Rabbit(){
		super();
		this.varity = "¾Ó°ñ¶ó";
		this.name = "Åä¼ö´Ï";
	}

	@Override
	public void eatting() {
		System.out.println("Ç®¶â¸Ô±â");
	}
	
	public void jumping() {
		System.out.println("JUMPING");
	}
}
