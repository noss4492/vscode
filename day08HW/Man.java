package day08HW;

public class Man {
	//�̸� ������ ����(string) �� ���� ���� ���� ��Ư
	String name, gender, job, ability;
	int eye, arm, age;
	
	Man(){	//init Constructor �Ƚᵵ ����
	}
	Man(String name, int eye, String gender, int arm,
			int age, String job, String ability){
		this.name = name;
		this.eye = eye;
		this.gender = gender;
		this.arm = arm;
		this.age = age;
		this.job = job;
		this.ability = ability;
	}
	void steal() {
		System.out.println("�� ������");
	}
	void run() {
		System.out.println("�ֵѼ³�");
	}
	void fastrun() {
		System.out.println("�ٴٴٴ�");
	}
	void chookJiBubb() {
		System.out.println("��½");
	}
}
