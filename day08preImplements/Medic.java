package day08preImplements;

public class Medic extends StarUnits implements 
						ImplUnit, Implmedicalable, ImplSkillable{
	public int healPower, healSpeed;
	
	// ���� ���� ��ž Ȧ��� ��� �޾ƿ�����.
	
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
	
	public void attack(StarUnits u) {	// ���� �޼ҵ� �ٲٱ�
		System.out.printf("Medic can't attack\n");
	}
	/*
	void heal(Implmedicalable u) {	// ���� ó��?
		u.hp = u.hp + this.healPower * this.healSpeed;
	}
	*/
	public void heal(StarUnits u) {	// ���� ó��?
		if(u instanceof Implunmedicalable) {
			System.out.println("ġ�� �Ұ����� �����Դϴ�.");
		}
		else {
			u.hp = u.hp + this.healPower * this.healSpeed;
		}
	}
	/*
	void heal(Implunmedicalable u) {
		System.out.println("ġ��Ұ���");
	}
	*/

}
