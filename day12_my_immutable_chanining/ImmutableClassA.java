package day12_my_immutable_chanining;

public class ImmutableClassA {
	private final String name;
	
	ImmutableClassA(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}

/*
Immutable Object (불변 객체)	// 도커 컨테이너나 콘다 가상환경과 
장점
1. 생성자의 방어 복사 및 접근 메소드의 방어 복사가 필요 없음.
2. 병렬 프로그래밍을 작성할 때, 동기화 없이 객체를 공유 가능하다.

단점
1. 객체가 가지는 값 마다 새로운 객체가 필요하다.
ex. String s += "*";

불변 클래스를 만드는 방법
1. 객체를 변경하는 setter를 제공하지 않음
2. 모든 필드를 final
3. 가변 객체  참조 필드를 사용자가 얻을 수 없도록 해야함(private)
4. 상속 금지
*/


//장점 : 생성자, 접근메소드에 대한 방어 복사가 필요없습니다. 
//멀티스레드 환경에서 동기화 처리없이 객체를 공유할 수 있습니다.(Thread-safe) 불변이기 때문에 객체가 안전합니다.
//단점 : 객체가 가지는 값마다 새로운 객체가 필요합니다. 
//따라서 메모리 누수와 새로운 객체를 계속 생성해야하기 때문에 성능저하를 발생시킬 수 있습니다.



//
