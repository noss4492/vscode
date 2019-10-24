package day10_3;

public class Dog extends Mammal implements shore{
	String name;
	Dog(){
		super();
		this.varity = "¸»¶ó¹ÂÆ®";
		this.name = "Âý½Ò¶±";
	}
	
	@Override
	public void eatting() {
		System.out.println("»ç·á¸ÔÀ½");
	}
	
	@Override
	public void sleeping() {
		System.out.println("°³²Þ");
	}
	
	public void running() {
		System.out.println("R U N");
	}
}
