package day08preImplements;

public class Medic extends StarUnits implements 
						ImplUnit, Implmedicalable, ImplSkillable{
	public int healPower, healSpeed;
	
	// 어택 무브 스탑 홀드는 상속 받아와있음.
	
	public Medic(){	//init generator, no parameter
		this.atk = 0;
		this.healPower = 1;
		this.armor = 1;
		this.hp = 750;
		this.range = 2;
		this.atkspd = 0;
		this.healSpeed = 10;
		this.x = 0;
		this.y = 0;
	}
	
	public Medic(int hp) {
		this.hp = hp;
	}
	
	public void attack(StarUnits u) {	// 어택 메소드 바꾸기
		System.out.printf("Medic can't attack\n");
	}
	/*
	void heal(Implmedicalable u) {	// 어케 처리?
		u.hp = u.hp + this.healPower * this.healSpeed;
	}
	*/
	public void heal(StarUnits u) {	// 어케 처리?
		if(u instanceof Implunmedicalable) {
			System.out.println("치료 불가능한 유닛입니다.");
		}
		else {
			u.hp = u.hp + this.healPower * this.healSpeed;
		}
	}
	/*
	void heal(Implunmedicalable u) {
		System.out.println("치료불가능");
	}
	*/

}
