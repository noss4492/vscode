package day10PlayGround;

class MyInfo {
	public int grade;
	MyInfo(int grade) {
		this.grade = grade;
	}
}
class OtherInfo {
	public int rank;
	OtherInfo(int rank) {
		this.rank = rank;
	}
}
/*
class Person {// emp stu info -> 공통 조상을 datatype으로 지정해야되는 상황
	public Object info;
	Person(Object info) {
		this.info = info;
	}
}*/
public class GenericPrac {
	public static void main(String[] args) {
		//Person p1 = new Person("에러하나 못 잡냐~");
		//OtherInfo ei = (OtherInfo)p1.info;
		//System.out.println(ei.rank);
		
		// 코드의 중복을 제거하다가 타입이 안전해지지 않는 문제가 발생함.
		
		// myInfo나 otherInfo 클래스가 오길 기대하면서 짰지만
		// 다른게 와버려도 공통 조상 Object라서 에러 검출 안됨.
		
		// 형변환 해도 에러 검출 안됨.
		
		// type이 안전하지 않다고 얘기되는 문제임.
		
		// 인자 받는 부분을 오브젝트로 처리해버렸기 때문에 
		// 어떤게 오더라도 다 받아져버림. (type unsafety)
		
		// 
		
		
		
		
		
//		StudentInfo si = new StudentInfo(2);
//		StudentPerson sp = new StudentPerson(si);
//		System.out.println(sp.info.grade); // 2
//		
//		EmployeeInfo ei = new EmployeeInfo(1);
//		EmployeePerson ep = new EmployeePerson(ei);
//		System.out.println(ep.info.rank); // 1
	}
}
