package day12;

public class TestMain2_equal {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println("obj1 : "+obj1);
		System.out.println("obj1 : "+obj2);
		
		System.out.println(obj1.equals(obj2));
		
		
		obj1 = obj2;
		
		if(obj1 == obj2)
			System.out.println("a ���� ��ü");
		else
			System.out.println("a �ٸ� ��ü");
		
		if(obj1.equals(obj2))
			System.out.println("b ���� ��ü");
		else
			System.out.println("b �ٸ� ��ü");
		
		System.out.println("-------------------------");
		System.out.println("obj1 : " + obj1);
		System.out.println("obj1 : "+ obj1.toString());
		// ��� �������� obj.toString()�̾���!
		// ��ü�� ��ǥ�ϴ�(repersentation) �ϴ� ����
		
		// Returns a string representation of the object.
		// getClass().getName() + '@' + Integer.toHexString(hashCode())
		// Ŭ�������̸�                      + '@' + hasCode���� 16������ �ٲ� ��
		// hashcode�� �޸𸮿��� ��� �������� �˷��ִ� �˰����� ����ִ� �ڵ�
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		/*
		 * finalize
		 * �������÷��� ��
		 * getClass
		 * ����ǰ� �ִ� ��ü,Ŭ������ ����
		 * 
		 */
	}

}
