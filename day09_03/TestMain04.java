package day09_03;

public class TestMain04 {
	public static void main(String[] args) {
		//이름직업성별나이몸무게키
		//Person p1 = new Person();
		//Person p2 = new Person("길동hong","겅물주",180.0f, 600.0f);
		//System.out.println("\n이름:"+p2.name+"\n직업:"+p2.job+"\n나이:"+p2.age);
		/*
		SuperMan sm = new SuperMan();	// 이 생성자 내부에 부모 기본생성자도 호출됨
		
		System.out.println(sm.name);
		
		SuperMan sm2 = new SuperMan("jone");
		System.out.println(sm2.name+sm2.age);
		*/
		SuperMan sm3 = new SuperMan("클라크", "기자", "남", 20, 70.0f, 190.0f);
		sm3.status();    // 슈퍼클래스의 생성자로 생성됨
		
		SuperMan sm4 = new SuperMan("클라큐", "키자", 99.0f, 210.0f);
		sm4.status();	// 나이와 성별은 슈퍼맨 클래스의 생성자로 생성됨 나머지는 슈퍼 클래스의 생성자로 생성됨
		
		sm3.laserBeam();
		sm3.fly();
	}
}

// z z z