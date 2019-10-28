package day11;

// 여러 사물들에게 능력/기능 부여할 때
// Horse, Marine

// 다중 상속이 안되니까 인터페이스
// 서로 관계가 없는 물체들이 서로 상호작용하기 위해서
// 사용하는 장치나 시스템

// 상수와 추상메서드로만 이루어져 있다.

public interface Flyable {
	final int a = 10;
	public abstract void flying();
}
