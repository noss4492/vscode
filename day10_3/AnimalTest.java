package day10_3;
// 3. �߻�ȭ : ��ü���� ��ǵ��� �Ϲ�ȭ ���� ����� ��
// Object : �繰, class : ���赵, abstract : ������
// �߻� Ŭ����
// �߻�޼���� �̱��� �޼����̰�, �̷� �޼��带 1����
// ������ �ִ� Ŭ������ �ݵ�� �߻� Ŭ�������� �Ѵ�.

// ��Ŭ - �ҽ� ���ʷ����ͷ� �ڵ� ���� ������ ���̵�
public class AnimalTest {
	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Dog d = new Dog();
		Whale w = new Whale();
		
		r.eatting();
		r.sleeping();
		r.jumping();
		System.out.println("-----------------");
		d.eatting();
		d.sleeping();
		d.running();
		System.out.println("-----------------");
		w.eatting();
		w.sleeping();
		w.swimming();
		
		System.out.println("-----------------");
		
		// ��� �������� ����� �����ϴ� Ŭ����
		// ���� �ν��Ͻ�ȭ �Ǵ� ������ �߻�
		// (Class ������ �̷��� ��������� ������)
	
		//Animal a = new Animal();	// abstract Ŭ������ �ν��Ͻ�ȭ(��üȭ)�� �Ұ���.
		//a.eatting();
		
		
		Horse h1 = new Horse();
		h1.eatting();
		h1.sleeping();
		h1.running();
		
	}
	

}
