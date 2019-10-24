package day10_2;

public class SiegeTank extends Terran {
	boolean sFlag = false;
	
	public SiegeTank(){
		hp = 400;
		armor = 0;
		range = 7;
		spd = 5;
		atk = 20;
		atkspd = 6;
	}
	
	void attack(Marine x) {
		System.out.println("통");
		x.hp -= atk;
	}
	void attack(Medic x) {
		System.out.println("통");
		x.hp -= atk;
	}

	void attack(SiegeTank x) {
		System.out.println("두두두두");
		x.hp -= atk;
	}
	void seigeMode() {
			System.out.println("위잉~");
		spd = 0;
		atk = 70;
		range = 15;
	}
}
