package day10PlayGround;
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
/*/ emp info, stu info -> 공통 조상을 datatype으로 지정해야되는 상황
class Person {/
	public Object info;
	Person(Object info) {
		this.info = info;
	}
}*/
class Person<T, S>{
    public T info;	//EmployeeInfo
    public S id;	// int 
    Person(T info, S id){ 
        this.info = info; 
        this.id = id;
    }
}
public class GenericDemo {
    public static void main(String[] args) {
    	//wrapper class로 wrapping하면 
    	//primitive type의 변수를 reference type의 변수처럼 랩핑할 수 있음.
    	Integer id = new Integer(1);
    	//하나의 객체처럼 인스턴스를 만들 었 네
    	EmployeeInfo e = new EmployeeInfo(1);
    	Integer i = new Integer(10);
    	 
    	Person<EmployeeInfo, Integer> p1 = 
    			new Person<EmployeeInfo, Integer>(e, i);
    								// 생성자의 매개변수를 보고 JVM이 판단해서 생략 가능함.
//        Person<EmployeeInfo, Integer> p1 = 
//        		new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), 1);
    }
}