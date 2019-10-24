package day08preImplements;

public class Ghost extends StarUnits implements 
						ImplUnit, Implmedicalable, ImplSkillable{
	public Ghost(){	//init generator, no parameter
		this.atk = 10;
		this.armor = 1;
		this.hp = 150;
		this.mp = 100;
		this.range = 9;
		this.atkspd = 2;
		this.x = 0;
		this.y = 0;
	}
	
	public Ghost(int hp) {
		this.hp = hp;
	}
	
	public void nuclearLaunch() {
		// x StarUnits instanceof ImplUnit;
		//존재하는 모든 객체 -3000
		System.out.println("nuclear launch");
	}
}