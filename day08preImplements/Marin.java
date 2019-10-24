package day08preImplements;

public class Marin extends StarUnits implements 
							ImplUnit, Implmedicalable, ImplSkillable{
	// atk, spd, hp, mp, armor, range, atkspd, x, y
	// 어택 무브 스탑 홀드는 상속 받아와있음. 0으로 초기화 해두었음.
	
	public Marin(){	//init generator, no parameter
		this.atk = 6;
		this.armor = 0;
		this.hp = 100;
		this.range = 5;
		this.atkspd = 3;
		this.x = 0;
		this.y = 0;
	}
	
	public Marin(int hp) {
		this.hp = hp;
	}
	
	public void steamPack() {
		if(hp>3) {
			this.hp -= 3;
			this.atkspd += 2;
			this.spd += 2;
			System.out.printf("hp-3 spd+2 atkspd+2\n");
		}
	}
}

