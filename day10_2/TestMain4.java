package day10_2;

public class TestMain4 {
	public static void main(String[] args) {
		
		Marine m1 = new Marine();
		Medic d1 = new Medic();
		SiegeTank t1 = new SiegeTank();
		
		m1.attack(t1);
		t1.status();
		
		
		
		
		
		/*
void attack(Terran b) {
b.hp = b.hp - ((this.atk - b.armor) * this.atkspd);
System.out.printf("attack %2d*%2d\n",(this.atk - b.armor), this.atkspd);
}

other thread(Stack)
b = t1	//ok 
		 */
	}
}
