package day11;

public class TestMain_Weapon {
	public static void main(String[] args) {
		Gun g;
		Police p1 = new Police();
		
		System.out.println(p1.name);
		System.out.println(p1.w1);
		System.out.println("------------");

		AK47 ak = new AK47();
		p1.setG(ak);
		System.out.println("ak"+ ak);
		System.out.println("pw"+p1.w1);
		System.out.println("------------");
		
		Slingshot ss = new Slingshot();
		
		System.out.println("ss"+ss);
		p1.setG(ss); // �������̽��� �θ�ó�� ���� ���� ���� �޾� �� �� ����.
		p1.use();
		
		
		
	}
}
