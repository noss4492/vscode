package day11;

public class Police implements Shootable{
	String name, rank;
	Gun g;		//setter, �ʱⰪ null
	Weapon w1;
	
	// ���
	// A is  a B   A �� B
	
	// A has a B   A ��  B
	// B�� ��� ������ �ް� ����.
	
	// ������.
	// g.get, g.set �̷��� �Ⱦ���
	// 
	
	Police(){	
		name = "������";
		rank = "����";
	}
	/// �� Gun Ŭ������ ���ڷ� �޾Ƽ� NULL�� �ƴϰ� ���ִ� �κ��� ���� ����Ʈ
	Police(Gun g){
		this.g = g;       //g.bullet = 6;
	}

	public void setG(Weapon w1) {	//��� �� �൵ �ǰ�
		System.out.println("�ѱ� �뿩��");
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
