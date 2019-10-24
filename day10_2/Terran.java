package day10_2;

public class Terran {
	int hp, armor;
	int atk, spd, range, atkspd;
	int x, y;
	

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
