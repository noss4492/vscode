package day11hw;

public class TestMain1 {
	public static void main(String[] args) {
		Cat c = new Cat();
		System.out.println(c.kind); 
		c.eating("����");
		c.sleeping();
		
		Dog d = new Dog();
		System.out.println(d.kind); 
		d.eating("���ٱ�");
		d.sleeping();
	}

}
