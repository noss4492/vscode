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
class Person {// emp stu info -> ���� ������ datatype���� �����ؾߵǴ� ��Ȳ
	public Object info;
	Person(Object info) {
		this.info = info;
	}
}*/
public class GenericPrac {
	public static void main(String[] args) {
		//Person p1 = new Person("�����ϳ� �� ���~");
		//OtherInfo ei = (OtherInfo)p1.info;
		//System.out.println(ei.rank);
		
		// �ڵ��� �ߺ��� �����ϴٰ� Ÿ���� ���������� �ʴ� ������ �߻���.
		
		// myInfo�� otherInfo Ŭ������ ���� ����ϸ鼭 ®����
		// �ٸ��� �͹����� ���� ���� Object�� ���� ���� �ȵ�.
		
		// ����ȯ �ص� ���� ���� �ȵ�.
		
		// type�� �������� �ʴٰ� ���Ǵ� ������.
		
		// ���� �޴� �κ��� ������Ʈ�� ó���ع��ȱ� ������ 
		// ��� ������ �� �޾�������. (type unsafety)
		
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
