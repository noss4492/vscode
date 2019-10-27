package day11_3;


// 인스턴스와 상관없이 method area에 먼저 할당되는 변수

// 그냥 추가로 적는 생각
// 모든 쓰레드들은 힙과 메서드 에어리어를 공유하고있다.

// 선생님이 적은 주석임.
// 클래스 메모리 로딩중에 할당되는 변수, method
// new 연산자로 객체가 생성되기 전에 사용할수있는특별한변수
// 아직 참조변수가 없으므로 참조변수명 대신 클래스명으로 사용해서 접근가능



// Per-Thread (쓰레드마다 ' 3'...;; 이래서 recursive한 메서드 생성시 취약한 부분이 있을수도)
// Program Counter Register
// JVM Stacks
// Native Method Stacks

// Common Area
// Heap( MethodArea( Run-time Constant Pool) )

// JVM
// 가비지 컬렉터 // Excution Engine // Class Loader(<-.class<-Compiler<-.java)
//        ↑           ↑                ↑
//        ↓           ↓                ↓
//               runtime data area
//  method area/heap area/stack area/PC register/NativeMethodStack

// Heap
// Eden survivor1 survivor2 Old Permanent(Metaspace)

// 걍 생각 : 메소드 영역이랑 힙 영역을 모든 쓰레드가 공유함
// 스택영역/PC레지스터/NativeMethodStack은 각각의 쓰레드마다 생성되고 공유하지 않음



public class TestMain5 {
	public static void main(String[] args) {
		SmartPhone.pCompany = "oneApple";
		System.out.println(SmartPhone.pCompany);
		// new 안했는데도 호출이 가능.
		
		SmartPhone sp1 = new SmartPhone(
				"redriceNote", "차이나요", "01012345678", "小米");
		SmartPhone sp2 = new SmartPhone(
				"redNote", "차이나", "01012345678", "小");
		SmartPhone sp3 = new SmartPhone(
				"rNote", "차이", "01012345678", "小");
		
		SmartPhone.pCompany = "oneApple";
		System.out.println(sp1.pCompany);
		System.out.println(sp2.pCompany);
		System.out.println(sp3.pCompany);
	}
}
