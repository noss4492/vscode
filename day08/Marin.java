package day08;

public class Marin {
	int atk, spd, hp, armor, range, atkspd;
	int x, y;
	
	public Marin(){	//init generator, no parameter
		this.atk = 6;
		this.armor = 0;
		this.hp = 200;
		this.range = 5;
		this.atkspd = 3;
		this.x = 0;
		this.y = 0;
	}
	public Marin(int hp) {
		this.hp = hp;
	}
	void attack(Marin b) {
		b.hp = b.hp - ((this.atk - b.armor) * this.atkspd);
		System.out.printf("attack %2d*%2d\n",(this.atk - b.armor), this.atkspd);
	}
	void attack(Medic b) {
		b.hp = b.hp - ((this.atk - b.armor) * this.atkspd);
		System.out.printf("attack %2d*%2d\n",(this.atk - b.armor), this.atkspd);
	}
	void move(int x, int y) {
		System.out.printf("[x,y] now coordinate : [%2d,%2d]\n", this.x, this.y);
		this.x = x;
		this.y = y;
		System.out.printf("[x,y]  go to : [%2d,%2d]\n", x, y);
	}
	void stop() {
		System.out.println("stop");
	}
	void hold() {
		System.out.println("hold ["+x+","+y+"]");
	}
	void steamPack() {
		if(hp>3) {
			this.hp -= 3;
			this.atkspd += 2;
			this.spd += 2;
			System.out.printf("hp-3 spd+2 atkspd+2\n");
		}
	}
	void patrol(int x, int y) {
		System.out.printf("[x,y] patrol : [%2d,%2d] ", this.x, this.y);
		this.x = x;
		this.y = y;
		System.out.printf("~ [%2d,%2d]\n", x, y);
	}
	void status() {
		System.out.printf("status 출력\n");
		System.out.printf("[체력:%2d]\t", hp);
		System.out.printf("[x:%2d.y:%2d]\n", x, y);
		System.out.printf("[atk:%2d]\t", atk);
		System.out.printf("[spd:%2d]\t", spd);
		System.out.printf("[atkspd:%2d]\n", atkspd);
	}
}
