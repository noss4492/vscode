package Day08HWpreview;

public class TestMain {
	public static void main(String[] args) {
		//Dog d = new Dog();		// 그냥 dog 클래스 만들 때
		//Animal d = new Dog();	// Animal class 상속 받은 애
		//Object d = new Dog();   // 모든 클래스는 Object 클래스를 mother로 삼음

		//d.setName("fluffy");
		//System.out.println(d.name);
		//d.sleep();
		
		HouseDog hd = new HouseDog();
		hd.setName("OP");
		hd.sleep();
		hd.sleep(3);
	}
}



// Animal d = new dog(); << 만들어지긴 하지만 Animal의 클래스만 참조하여 생성됨
// dog d = new Animal(); << dog는 하위 개념이라 이걸로는 Animal클래스를 생성할수없



/*
 * 
 - 혼자 떠들고 혼자 공부하는 영역 

원래 모든 객체는 Object 클래스를 상속받게끔 되어있음.
every object is extends Objects

public class Animal extends Objects{//<ㅡ<ㅡ<ㅡ<ㅡ
	String name;
	
	public void setName(String name){
		this.name = name;
	}
}

따라서 자바에서 만드는 모든 객체는 Object 자료형으로 사요할 수 있다. 즉, 다음과 같이코딩하는것이가능하다.

Object animal = newAnimal();
Object dog = newDog();
Animal d = new Dog(); // 이게 되는 이유도 전체와 부분을 생각해보면 된다. 부분 집합이니까 가능.


자바는 다중 상속을 지원하지 않음

다중 상속을 받았을 시 A클래스의 msg메소드 or B클래스의 msg메소드 이렇게 호출할 메서드가 애매모호한 부분이 생김












 
*/
