package day11_3;

public class TestMain7 {
	public static void main(String[] args) {
		// 클래스 로딩 순간 스태틱이 가장 먼저 실행됨(생성자보다도 먼저)
		// 스태틱 메서드들은 인지(선언같이)만 되고 실행은 되지 않은 상태임.
		
		System.out.println(TestMain6.no);
		//TestMain6.show();
		
		
		TestMain6 t = new TestMain6();
		System.out.println(t.no2);	// 클래스 주석처리 해보면 얘는 뭐 나중에 생성되는 애들인
		t.show2();
	}
}



/*
그냥 주저리 배우는 주석
1. Stack 영역
Heap 영역에 생성된 Object type 데이터들의 참조값이 할당됨.
primitive type 데이터가 값과 함께 할당된다.
local variable들은 scope에 다라서 visibility를 가진다.
각 Thread는 자신만의 stack을 가진다.

함수 종료 순간 데이터들이 stack에 있는 모든 데이터들이 pop 되면서 종료됨.

2. Heap 영역
Heap 영역에는 주로 긴 생명주기를 가지는 데이터들이 저장됨. 
(대부분의 오브젝트는 크기가 크고 서로 다른 코드블럭에서 공유되는 경우가 많음)
어플리케이션의 모든 메모리 중 stack에 있는 데이터를 제외한 부분이라고 볼 수 있음
모든 Object타입(Integer,String,ArrayList,....)는 heap 영역에 생성됨
몇개의 쓰레드가 존재하든 상관없이 단 하나의 heap 영역만 존재한다.
heap영역에 있는 오브젝트들을 가르키는 레퍼런스 변수가 stack에 올라가게 됨.


각 쓰레드에서 다른 쓰레드의 stack 영역에는 접근할 수 없다.




*/