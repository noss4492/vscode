package day11;

public class TestMain3 {

	public static void main(String[] args) {
		Police p1 = new Police();
		Gun g1 = new Gun();
		

		System.out.println(p1.name);
		System.out.println(p1.g);
		//p1.setG(g1); //�� ��
		System.out.println(p1.name);
		System.out.println(p1.g);
		
		p1.arresting();
		p1.eatting();

		System.out.println("������ ����...");
		p1.use();
		p1.use();
		p1.use();
		p1.use();
		p1.use();
		p1.use();
		p1.use();
		
		p1.reload();
		System.out.println("������ ����...");
		p1.shooting();
		p1.shooting();
		p1.shooting();
		p1.shooting();
		p1.shooting();
		p1.shooting();
		p1.shooting();
		p1.shooting();
	}
}
