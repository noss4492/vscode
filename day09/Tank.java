package day09;

public class Tank extends StarUnits{
	boolean sFlag = false;
	
	public Tank(){	//init generator, no parameter
		this.atk = 20;
		this.armor = 4;
		this.hp = 250;
		this.mp = 0;
		this.range = 5;
		this.atkspd = 2;
		this.x = 0;
		this.y = 0;
	}
	
	public Tank(int hp) {
		this.hp = hp;
	}
	
	public void seigeMode() {
		sFlag = !sFlag;
		if(sFlag == true) {
			this.atk = 40;
			this.range = 15;
			this.armor = 6;
		}
		else {
			this.atk = 20;
			this.range = 5;
			this.armor = 4;
		}
	}
}
