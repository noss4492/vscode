package Day08HWpreview;

public class TestMain {
	public static void main(String[] args) {
		//Dog d = new Dog();		// �׳� dog Ŭ���� ���� ��
		//Animal d = new Dog();	// Animal class ��� ���� ��
		//Object d = new Dog();   // ��� Ŭ������ Object Ŭ������ mother�� ����

		//d.setName("fluffy");
		//System.out.println(d.name);
		//d.sleep();
		
		HouseDog hd = new HouseDog();
		hd.setName("OP");
		hd.sleep();
		hd.sleep(3);
	}
}



// Animal d = new dog(); << ��������� ������ Animal�� Ŭ������ �����Ͽ� ������
// dog d = new Animal(); << dog�� ���� �����̶� �̰ɷδ� AnimalŬ������ �����Ҽ���



/*
 * 
 - ȥ�� ����� ȥ�� �����ϴ� ���� 

���� ��� ��ü�� Object Ŭ������ ��ӹްԲ� �Ǿ�����.
every object is extends Objects

public class Animal extends Objects{//<��<��<��<��
	String name;
	
	public void setName(String name){
		this.name = name;
	}
}

���� �ڹٿ��� ����� ��� ��ü�� Object �ڷ������� ����� �� �ִ�. ��, ������ �����ڵ��ϴ°��̰����ϴ�.

Object animal = newAnimal();
Object dog = newDog();
Animal d = new Dog(); // �̰� �Ǵ� ������ ��ü�� �κ��� �����غ��� �ȴ�. �κ� �����̴ϱ� ����.


�ڹٴ� ���� ����� �������� ����

���� ����� �޾��� �� AŬ������ msg�޼ҵ� or BŬ������ msg�޼ҵ� �̷��� ȣ���� �޼��尡 �ָŸ�ȣ�� �κ��� ����












 
*/
