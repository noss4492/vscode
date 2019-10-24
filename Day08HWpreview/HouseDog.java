package day08HWpreview;

public class HouseDog extends Dog {
	public void sleep() {				// 메소드의 오버라이딩이 가능하다.(상속받아 재정의하여 (다형성을 지닌채) 사용 가능하다는 이야기인듯)
		System.out.println(this.name+" zzz in house");
	}
	public void sleep(int hour) {		// 메소드 오버로딩 예
		System.out.println(this.name+" zzz in house for "+hour+"hours");
	}
	public static void main(String[] args) {
		HouseDog hd = new HouseDog();
		hd.setName("house happy");
		hd.sleep();
	}
}


// 오늘 공부 내용은 점프 투 자바 상속/인터페이스/다형성/추상클래스를 참조하였음
// 절대 숙제 만드는 게 귀찮아서 공부해서 간단하게 쓰려는 것이 아님(사실 맞음)

////// 메소드 오버라이딩(method overriding)
// 생각 Dog 클래스에 이미 sleep()가 정의되어 있다.
// Dog 클래스를 상속받은 HouseDog 클래스에서 sleep()메서드를 상속받아 
// 자기가 재정의하여 (덮어쓰기하듯이) 다르게 사용할 수 있다.
// 이렇게 부모 클래스의 메소드를 자식 클래스가 동일한 형태로 또 다시 구현하는 행위를 메소드 오버라이딩 이라고 함.ㅇ
// (== 메소드 덮어쓰기)

////// 메소드 오버로딩(method overloading)
// 
