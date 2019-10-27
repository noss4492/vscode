package day11;

public class AK47 implements Weapon{

	@Override
	public void use() {
		System.out.println("(AK47 sound) : Bang");
	}

	@Override
	public void reuse() {
		System.out.println("(AK47 sound) : Reloaded");
	}
	
}
