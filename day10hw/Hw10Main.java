package day10hw;

public class Hw10Main {
	// 5. 사각형 클래스를 생성
	// 6. 원 클래스를 생성
	// 7. 삼각형 클래스를 생성
	public static void main(String[] args) {
		Square s1 = new Square();
		Circle c1 = new Circle();
		Triangle t1 = new Triangle();
		s1.setWidth(4);
		s1.setHeight(3);
		c1.setRadius(7);
		t1.setWidth(16);
		t1.setHeight(9);
		
		System.out.println("----------made by user set-----------------------");
		System.out.printf("s1 w:%.2f h:%.2f area:%.2f \n"
								, s1.getWidth(), s1.getHeight(), s1.getCalArea());
		System.out.printf("c1 r:%.2f 	  area:%.2f \n", c1.getRadius(), c1.getCalArea());
		System.out.printf("t1 w:%.2f h:%.2f area:%.2f \n"
								, t1.getWidth(), t1.getHeight(), t1.getCalArea());
		
		Square s2 = new Square(4, 3);
		Circle c2 = new Circle(7);
		Triangle t2 = new Triangle(16, 9);
		System.out.println("----------made by constructor--------------------");
		System.out.printf("s1 w:%.2f h:%.2f area:%.2f \n"
				, s1.getWidth(), s1.getHeight(), s1.getCalArea());
		System.out.printf("c1 r:%.2f  	 area:%.2f \n", c1.getRadius(), c1.getCalArea());
		System.out.printf("t1 w:%.2f h:%.2f area:%.2f \n"
				, t1.getWidth(), t1.getHeight(), t1.getCalArea());
		
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
/*
1. 추상클래스?
내부에 추상적인것(추상메서드)를 포함하고 있으면 추상클래스로 정의하여 사용하여야한다.
추상클래스는 인스턴스화(실체화) 될 수 없음 (개념적으로만 존재함)

2. 객체지향 언어의 특징?
2-1. 캡슐화
해당 클래스에 private한 변수를 생성하면 다른 클래스에서 접근이 불가능하게 되고
이는 해당 클래스의 내부에 있는 메서드(여기서는 getter/setter)을 이용해서만
이 변수에 접근하여 수정하거나 리턴하여 받을 수 있다. 
가시성을 없애서 직접적인 사용을 제한한다.

2-2. 상속
자식클래스들은 부모클래스를 상속받아 거기서 확장하여 사용한다
자식이 가지고 있는 범위가 부모를 포함하는 관계가 되며 
이로써 부모클래스의 참조변수 공간에 자식클래스의 참조변수를 할당하는 경우
자식클래스를 참조하면 부모클래스보다 넓으므로 참조하여 사용가능하다.

클래스 참조값 전달은 같은 클래스에서만 가능
클래스는 형 변환이 가능
상속받은 메서드는 오버라이드가 가능
등등..

2-3. 추상화
실제로 어떻게 구현되어 있지는 않지만 
구체적인 사실들로부터 올라와 개념적으로 묶은것. 이렇게 하겠다는 것(추상적으로)
비유 : 조감도

3. 접근지정자 나열
private : 자기 자신의 클래스 내부에 있는 애들만 접근 가능
default : 자기가 포함된 패키지 내부에 있는 애들까지 접근 가능
protected : 자기가 상속받은 패키지 내부에 있는 애들까지 접근 가능
public : 모두 접근 가능

4. 생성자와 일반 메서드의 차이점
생성자는 클래스 생성시 존재하지 않으면 기본 생성자가 생성됨
생성자는 객체의 초기화를 목적으로 사용됨
리턴하는게 없음
명명법이 다름(생성자:클래스명과 동일, 메서드:소문자시작, 카멜 케이싱(소문자 공백은 대문자로 구분)
 */
