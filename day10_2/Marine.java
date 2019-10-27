package day10_2;

import day11.Flyable;

public class Marine extends Terran implements Flyable{
	int atk, atkspd;
	
	public Marine(){	//init generator, no parameter
		this.atk = 6;
		this.armor = 0;
		this.hp = 200;
		this.range = 5;
		this.atkspd = 3;
		this.x = 0;
		this.y = 0;
	}
	public Marine(int hp) {
		this.hp = hp;
	}
	void attack(Terran b) {
		b.hp = b.hp - ((this.atk - b.armor) * this.atkspd);
		System.out.printf("attack %2d*%2d\n",(this.atk - b.armor), this.atkspd);
	}

	public void flying() {
		System.out.println("사심? ? ㅅ??? 머라고?");
	}
	void steamPack() {
		if(hp>3) {
			this.hp -= 3;
			this.atkspd += 2;
			this.spd += 2;
			System.out.printf("hp-3 spd+2 atkspd+2\n");
		}
	}

}
