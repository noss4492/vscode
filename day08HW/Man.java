package day08HW;

public class Man {
	//이름 눈갯수 성별(string) 팔 갯수 나이 직업 종특
	String name, gender, job, ability;
	int eye, arm, age;
	
	Man(){	//init Constructor 안써도 무관
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
		System.out.println("다 내꺼임");
	}
	void run() {
		System.out.println("핫둘셋넷");
	}
	void fastrun() {
		System.out.println("다다다다");
	}
	void chookJiBubb() {
		System.out.println("번쩍");
	}
}
