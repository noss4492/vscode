package day09_03;

public class SuperMan extends Person {
	
	SuperMan(){// �����ڵ� �޼���ϱ� �θ����� ������ �־ �̸��� ���� ���Դ� ��
		super();	// �θ��� �⺻ ������ ȣ��. ���� ���� �ʴ���
		// ���� �ʱ�ȭ �آZ super() �θ��� �⺻ �����ڸ� ȣ���Ϲ� �Ǵ±��� 
		// ���� ���� �ʴ��� �̷��� �Ǿ�����.
		// this, super, this(), super()
		this.name="���۸�";
		System.out.println("���� ��� ������");
	}
	public SuperMan(String name, String job, String gender, int age, float weight, float height) {
		super(name, job, gender, age, weight, height);
		System.out.println("���� ��� ������");
	}
	public SuperMan(String name, String job, float weight, float height) {
		super(name, job, weight, height);
		this.age = 32;
		this.gender = "����";
		System.out.println("���� ��� ������");
	}

	
	
	//String name, String job, float weight, float height
	

	SuperMan(String name){	// ���⵵ ����() �Ǿ��ֳ� //�θ� �⺻ ������ ������ error
		this.name=name;
		System.out.println("22222222");
	}
	public void laserBeam() {
		System.out.println("Laser");
	}
	public void fly() {
		System.out.println("Fly");
	}
}
