package day11;

public class FlameThrower implements Weapon{

	@Override
	public void use() {
		System.out.println("(FlameThrower sound) : 화르륵");
	}

	@Override
	public void reuse() {
		System.out.println("(FlameThrower sound) : 연료충전");
	}

}
