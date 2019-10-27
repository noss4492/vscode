package day11;

public class Police implements Shootable{
	String name, rank;
	Gun g;		//setter, 초기값 null
	Weapon w1;
	
	// 상속
	// A is  a B   A ⊂ B
	
	// A has a B   A ⊃  B
	// B를 멤버 변수로 받게 하자.
	
	// 차이점.
	// g.get, g.set 이렇게 안쓰심
	// 
	
	Police(){	
		name = "포순이";
		rank = "순경";
	}
	/// 이 Gun 클래스를 인자로 받아서 NULL이 아니게 해주는 부분이 수업 포인트
	Police(Gun g){
		this.g = g;       //g.bullet = 6;
	}

	public void setG(Weapon w1) {	//얘로 총 줘도 되고
		System.out.println("총기 대여됨");
		//this.g = g;
		this.w1 = w1;
	}
	public void use() {
		//g.fire();
		w1.use();
	}
	public void reload(Gun g) {
		g.setBullet(6);
	}

	public void eatting() {
		System.out.println("donut");
	}
	public void shooting() {
		this.fire();
	}
	public void arresting() {
		System.out.println("U mook b Gukwan Hang sa hal soo..");
	}
	
	
	@Override
	public void fire() {
		System.out.print("try Shoot\t");
		System.out.print("shoot by cap\t");
		if(g.getBullet() >0) {
			if(g.getBullet()>=5)
				System.out.println("Pang");
			else
				System.out.println("Bang");
			g.setBullet(g.getBullet()-1);
		}
		else
			System.out.println("tick");
	}
	
	@Override
	public void reload() {
		System.out.println("reloaded");
		g.bullet = 6;
	}
	
	
}
