package day10;

import day09.Marin;

public class TestMain1001 {
	public static void main(String[] args) {
		
		Parent p1 = new Parent();
		Child c1 = new Child();
		
		p1.jwanSori();
		p1.singing();
		p1.eating();
		
		c1.jwanSori();
		c1.singing();
		c1.goClub();
		
		Marin m1;		//day09.Marin a1 = new Marin();
		Parent p2 = new Parent();
		 
		p2 = p1;
		//서로 다른 클래스 끼리는 참조값을 줄 수 없다.
		//같은 클래스 끼리는 줄 수 있음 ㅇㅋㅇㅋ
		// 자료형이 다른애들 끼리는 참조값을 줄 수 없음
		// 각 클래스가 각 자료형이니까
		
		p2.singing();
/////////////////////////////////////////////////////////////////////
		// 어렵다구 허심 (? ㅅ?)
		// 부모 참조변수에 자식의 참조변수 대입은 가능.
		
		// 예외적으로 부모 자식 관계에서는 됨
		// p1 ⊂ c1 관계니까, p1이 보기에는 c1에 있는 것들을 알고있음
		// c1 참조값을 가지고 찾아가서(힙에 있는 자식 Object에 가서)
		// p1이 모르는 c1의 변수나 메서드는 실행되지 않음. (지가 아는거만 ㅇㅋ)
		System.out.println("**************");
		p1 = c1;
		p1.singing();
		
		/* 에러 나는거 확인해봄.
		c1= p1;
		c1.singing();
		c1.goClub();
		*/
		
		Child c2;
		c2= c1;
		c2.goClub();	// ㅇㅋ 
		
		//c2 = p1;	// 컴파일러 : 이게 되? , 멍청한 컴파일러..
		
		c2 = (Child)p1;	//객체도 강제 형변환 됨.
		c2.goClub();
		
		// 객체 형변환 많이 쓴닥고 함.
		
		
		// 생성 소멸 관계가 어떻게 있을까? 
		// p1은 힙에 생성되었지만 이제 호출되지 않음.
		// 자바는 소멸자가 없어! (free.. 없엉.. 헐..)
		// GC(가비지 컬렉터)가 알아서 소멸시켜줌.
		// 참조되지 않고 있는 힙영역에 할당된 Object들...
		// GC는 스케쥴이 정해져있어서 어케 간섭할 수 없음. 평소 자원 소모가 좀 있음.
		
		
		/*
		 * 
stack     | heap
p1(@a)      @a
            (String name, String job, int age)
            (singing(), eating(), breathing(), jwanSori(), Parent())
            
            
c1(@b)      @b
            (String name, String job, int age, String facebookID)
            (singing(), eating(), breathing(), jwanSori(), Child())
            
>>execute


Parent p1 = new Parent();
p1이라는 참조변수 주소공간 메모리에 
                                     객체 할당(new)후 주소값을 p1에 대입   (JVM이 알맞은 위치를 지정)  
Parent라는 클래스 구조를(기본 생성자로)

Child c1 = new Child();
p1이라는 참조변수 주소 할당받는다(JVM이 알맞은 위치를 지정해서).
p1이라는 참조변수에 대입
메모리 할당(new) Child라는 클래스 구조를 기본 생성자로 만듦 
이 기본 생성자는 부모변수를 참조하고 있으므로
1. child의 기본 생성자 호출됨
2. 그 기본 생성자 안에 있는 부모의 기본생성자(super)를 호출
 2-1. super은 참조변수 이므로 부모의 주소값 @a로 접근
 2-2. 부모의 생성자를 호출 

		 */
		
	}

}
