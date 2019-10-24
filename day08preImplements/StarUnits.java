package day08preImplements;

public class StarUnits implements ImplUnit{
	// ���������� ������ �ִ� �͵��� ����.
	public int hp = 0, mp = 0, armor = 0;
	public int spd = 0, range = 0, atk = 0, atkspd = 0;
	public int x = 0, y = 0;	// ��ġ ��ǥ
	
	// �޼��嵵 �� ��ӹ޴� �ֵ��� �ٽ� �����ؼ� �ٸ� ������� �ٲ� �� ������(�޼ҵ� �������̵�) �� ��κ��� �ᵵ..
	
	// this �Ƚᵵ ������ �������� ���ƺ����� ���� this�� ����ξ���. �̰� ���� �������� �𸣰�����..
	public void attack(StarUnits u) {
		u.hp = u.hp - ((this.atk - u.armor) * this.atkspd);
		System.out.printf("attack %2d*%2d\n",(this.atk - u.armor), this.atkspd);
	}
	public void move(int x, int y) {
		System.out.println("[��� �̱���]");
		System.out.printf("[x,y] now coordinate : [%2d,%2d]\n", this.x, this.y);
		this.x = x;
		this.y = y;
		System.out.printf("[x,y]  go to : [%2d,%2d]\n", x, y);
	}
	public void stop() {
		System.out.println("[��� �̱���]");
		System.out.println("stop ");
	}
	public void hold() {
		System.out.println("[��� �̱���]");
		System.out.println("hold , ["+this.x+","+this.y+"]");
	}
	public void status() {
		System.out.printf(" ------------ (status) ---------------\n");
		System.out.printf("[ü��:%2d][����:%2d]\t", this.hp, this.mp);
		System.out.printf("[spd:%2d]\n", this.spd);
		System.out.printf("[��ǥ  x:%3d.y:%3d]\t", this.x, this.y);
		System.out.printf("[atk:%2d][/s:%2d]", this.atk, this.atkspd);
		System.out.printf("[dps:%3d]\n",this.atk*this.atkspd);
	}
	
	// ���⿡ abstractŬ������ �����ع����� ��ӹ޴� �ֵ��� ��� �����. 

}
