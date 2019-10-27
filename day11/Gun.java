package day11;

public class Gun {
	int bullet;
	
	public Gun() {
		this.bullet = 6;
	}
	
	public void setBullet(int n) {
		this.bullet = n;
	}
	public int getBullet() {
		return this.bullet;
	}

	public void fire() {
		System.out.print("try Shoot\t");
		System.out.print("shoot by someone\t");
		if(this.getBullet() >0) {
			if(this.getBullet()>=5)
				System.out.println("Pang");
			else
				System.out.println("Bang");
			this.setBullet(this.getBullet()-1);
		}
		else
			System.out.println("tick");
	}
}
