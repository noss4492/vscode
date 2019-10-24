package day08;

public class testMarin {

	public static void main(String[] args) {
		Marin a1 = new Marin();
		Marin a2 = new Marin();	// parameter hp
		// init element : x:0 y:0 hp:50 atk:6 atkspd:5 spd:3
		Medic b1 = new Medic();
		Medic b2 = new Medic();
		
		System.out.println("marin a1 hp:"+a1.hp);
		System.out.println("marin a2 hp:"+a2.hp);
		System.out.println("medic b1 hp:"+b1.hp);
		System.out.println("medic b2 hp:"+b2.hp);
		
		
		// if a1 atk a2 -> a2.hp --
		// if a1 steamPack -> a1.hp-- a1.atkspd++ a1.spd++
		
		
		/*
		System.out.println("--- 1st a1 attack   ---");
		a1.attack(a2);
		System.out.println("--- 1st a2 attacked ---");
		
		a1.status();
		a2.status();
		
		
		System.out.println("- a1 marine boost -");
		for(int i = 0; i < 3; i++)
			a1.steamPack();
		System.out.println("--- 2nd a1 attack   ---");
		a1.attack(a2);
		a1.status();
		a2.status();
		System.out.println("--- 2nd a2 attacked ---");
		System.out.println("---  b1 heal to a2  ---");
		b1.heal(a2);
		a1.status();
		a2.status();
		System.out.println("--- a2 healed ---");
		*/
		
		
		a1.status();
		a2.status();
		
		System.out.println("마린이 마린 공격");
		a1.attack(a2);
		a2.attack(a1);
		
		a1.status();
		a2.status();
		
		System.out.println("메딕이 메딕 치료");
		b1.heal(b2);
		b2.heal(b1);
		
		b1.status();
		b2.status();
		
//		System.out.println("a2 참조값 : "+a2);
		//a1.status();
		//a2.status();
		
		//a1.move(30,  50);
		//a2.move(30,  50);
		
		do {
		}while(a1.hp==0 || a2.hp==0);
		
		//range 5 이하 인 경우에만 공격이 가능
		
		
		//a1.attack();
		//a2.status();
		
		
		
		//a2.move(30, 50);
		//a2.patrol(100, 0);
	
		
		
		
		
	}
}
