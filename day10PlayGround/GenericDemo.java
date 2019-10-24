package day10PlayGround;
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
/*/ emp info, stu info -> ���� ������ datatype���� �����ؾߵǴ� ��Ȳ
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
    	//wrapper class�� wrapping�ϸ� 
    	//primitive type�� ������ reference type�� ����ó�� ������ �� ����.
    	Integer id = new Integer(1);
    	//�ϳ��� ��üó�� �ν��Ͻ��� ���� �� ��
    	EmployeeInfo e = new EmployeeInfo(1);
    	Integer i = new Integer(10);
    	 
    	Person<EmployeeInfo, Integer> p1 = 
    			new Person<EmployeeInfo, Integer>(e, i);
    								// �������� �Ű������� ���� JVM�� �Ǵ��ؼ� ���� ������.
//        Person<EmployeeInfo, Integer> p1 = 
//        		new Person<EmployeeInfo, Integer>(new EmployeeInfo(1), 1);
    }
}