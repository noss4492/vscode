package day08;

public class testHumanMain {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "홍길동";
		p1.age=20;
		p1.job="도적";
		p1.gender = "남";
		
		System.out.println(p1);
		System.out.println(p1.name);
		System.out.println("직업 : "+p1.job);
		System.out.println("나이 : "+p1.age);
		p1.eating();
		p1.sleeping();
		p1.thinking();
		
		Person p2 = new Person();
		p2.name = "호빵맨";
		p2.age = 20;
		p2.job = "동네백수";
		p2.gender = "중성";
		System.out.println(p2);
		System.out.println(p2.name);
		System.out.println("직업 : "+p2.job);
		System.out.println("나이 : "+p2.age);
		p2.eating();
		p2.sleeping();
		p2.thinking();
	}

}
