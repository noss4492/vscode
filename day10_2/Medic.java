package day10_2;

public class Medic extends Terran {
	//hp x y mp 방어력 회복력 사거리 이동속도 힐속
	int mp, hpower, hspd;
	
	public Medic(){	//init generator, no parameter
		this.hpower = 6;
		this.armor = 0;
		this.hp = 200;
		this.mp = 100;
		this.range = 5;
		this.hspd = 3;
		this.x = 0;
		this.y = 0;
	}
	public Medic(int hp) {
		this.hp = hp;
	}
	//class:사용자정의 자료형
	//참조값 주면 참조값을 같는 x
	//마린 클래스의 참조값을 받아주는 변수 X
	void heal(Marine x) {	//대상 x 치료
		x.hp = x.hp + this.hpower * this.hspd;
		this.mp -= 2;
		System.out.printf("heal %2d*%2d\n",this.hpower, this.hspd);
		System.out.println("당신은 활기를 되찾았다.");
	}
	void heal(Medic x) {	//대상 x 치료
		x.hp = x.hp + this.hpower * this.hspd;
		this.mp -= 2;
		System.out.printf("heal %2d*%2d\n",this.hpower, this.hspd);
		System.out.println("당신은 활기를 되찾았다.");
	}
}
