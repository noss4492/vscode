package day09;

public class Medic {
	//hp x y mp ���� ȸ���� ��Ÿ� �̵��ӵ� ����
	int spd, hp, mp, hpower, armor, range, hspd;
	int x, y;
	
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
	//class:��������� �ڷ���
	//������ �ָ� �������� ���� x
	//���� Ŭ������ �������� �޾��ִ� ���� X
	void heal(Marin x) {	//��� x ġ��
		x.hp = x.hp + this.hpower * this.hspd;
		this.mp -= 2;
		System.out.printf("heal %2d*%2d\n",this.hpower, this.hspd);
		System.out.println("����� Ȱ�⸦ ��ã�Ҵ�.");
	}
	void heal(Medic x) {	//��� x ġ��
		x.hp = x.hp + this.hpower * this.hspd;
		this.mp -= 2;
		System.out.printf("heal %2d*%2d\n",this.hpower, this.hspd);
		System.out.println("����� Ȱ�⸦ ��ã�Ҵ�.");
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

	void patrol(int x, int y) {
		System.out.printf("[x,y] patrol : [%2d,%2d] ", this.x, this.y);
		this.x = x;
		this.y = y;
		System.out.printf("~ [%2d,%2d]\n", x, y);
	}
	void status() {
		System.out.println("status ���");
		System.out.printf("[ü�� : %2d]\n",hp);
		System.out.println("x :"+ x);
		System.out.println("y :"+ y);
		System.out.println("hspd :"+ hspd);
	}
}
