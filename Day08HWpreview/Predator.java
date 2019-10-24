package Day08HWpreview;

public interface Predator {
	// 인터페이스에 추가되는 메소드는 어떻게 되는 걸까?
	public String getFood();	//메소드 몸통부분은 없다. 메소드이름, 입출력에 대한 정의만 있고 내용은 없다.
	// 이유는 인터페이스는 규칙이기 때문임. 
	// getFood()라는 메소드는 이 인터페이스를 implements한 클래스들이 구현해야만 하는것 임. 
}
