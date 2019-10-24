package day08preImplements;

public class StarUnits implements ImplUnit{
	// 공통적으로 가지고 있는 것들을 쓰자.
	public int hp = 0, mp = 0, armor = 0;
	public int spd = 0, range = 0, atk = 0, atkspd = 0;
	public int x = 0, y = 0;	// 위치 좌표
	
	// 메서드도 뭐 상속받는 애들이 다시 정의해서 다른 기능으로 바꿀 수 있으니(메소드 오버라이딩) 뭐 대부분은 써도..
	
	// this 안써도 되지만 가독성이 좋아보여서 전부 this를 적어두었음. 이게 옳은 일인지는 모르겠지만..
	public void attack(StarUnits u) {
		u.hp = u.hp - ((this.atk - u.armor) * this.atkspd);
		System.out.printf("attack %2d*%2d\n",(this.atk - u.armor), this.atkspd);
	}
	public void move(int x, int y) {
		System.out.println("[기능 미구현]");
		System.out.printf("[x,y] now coordinate : [%2d,%2d]\n", this.x, this.y);
		this.x = x;
		this.y = y;
		System.out.printf("[x,y]  go to : [%2d,%2d]\n", x, y);
	}
	public void stop() {
		System.out.println("[기능 미구현]");
		System.out.println("stop ");
	}
	public void hold() {
		System.out.println("[기능 미구현]");
		System.out.println("hold , ["+this.x+","+this.y+"]");
	}
	public void status() {
		System.out.printf(" ------------ (status) ---------------\n");
		System.out.printf("[체력:%2d][마나:%2d]\t", this.hp, this.mp);
		System.out.printf("[spd:%2d]\n", this.spd);
		System.out.printf("[좌표  x:%3d.y:%3d]\t", this.x, this.y);
		System.out.printf("[atk:%2d][/s:%2d]", this.atk, this.atkspd);
		System.out.printf("[dps:%3d]\n",this.atk*this.atkspd);
	}
	
	// 여기에 abstract클래스를 선언해버리면 상속받는 애들은 모두 써야함. 

}
