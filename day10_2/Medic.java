package day10_2;

public class Medic extends Terran {
	//hp x y mp ���� ȸ���� ��Ÿ� �̵��ӵ� ����
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
	//class:��������� �ڷ���
	//������ �ָ� �������� ���� x
	//���� Ŭ������ �������� �޾��ִ� ���� X
	void heal(Marine x) {	//��� x ġ��
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
}
