package day15_2;

import java.util.Calendar;
import java.util.Vector;

public class VectorEx1 {
	public static void main(String[] args) {
		int[] m = new int[3];
		System.out.println(m.length);

		// ������Ʈ�� �迭���� ��(JCF)�� ���Ե� ����.
		// ���ʹ� ������Ʈ�� ������.
		Vector v = new Vector();
//		Calendar cal = Calendar.getInstance();
//		v.add(cal);
		v.add("����");
		v.add("����");
		v.add("��l");
		v.add("���");
		v.add("���U");
		v.add("��l");

		System.out.println("V : " + v);
		System.out.println(v.capacity()); // 10
		v.add("���U");
		v.add("���U");
		v.add("���U");
		v.add("���U");
		v.add("���U");
		v.add("���U");
		String furit1 = "�θ���";
		v.add(furit1);
		
		System.out.println("V : " + v);
		System.out.println(v.capacity()); // 20
		System.out.println(v.size());
		
		System.out.println("----------------");
		
		Object[] obj1 = new Object[v.size()];

		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i).toString().substring(0, 1));
		}
		for(int i = 0 ; i < v.size(); i++) {
			obj1[i] = v.get(i);
			System.out.println("||"+obj1[i].toString().toString().toString());
			System.out.println(i+":"+obj1[i].toString().substring(0, 1));
		}
		
		
		System.out.println("----------------");
		// ' 3'
		for(int i = 0; i < v.size(); i++) {
			Object obj2 = v.get(i);					 // v. i ����Ʈ ������
			System.out.println(">>"+obj2.toString());//��� obj2�� ����Ʈ(������)�� ����Ŵ
			String str = (String)obj2;
			System.out.println(str.substring(0, 1));
		}
		// obj2�� ������ v.get(i)
		// obj2.toString() -> typename+@+hash
		//Ŭ���� �̸�@�ؽ� �ڵ尪
		
		//----------------------------------
		// if 0���� ������ �־��� ���������� ����
		// String fruit = "�ݱ�"
		// 1. fruit�� ��������, ���� ���ڿ��� ������
		
		// v.add(fruit)
		// ����Ŭ������ �迭�ȿ� fruit�� �������� ��.
		
		// Object obj = v.get( fruit�� �ִ� idx )
		// 2. obj2�� super class�̹Ƿ� �������� ���� �� ����.
		
		// �� str�迭 ���� �� 
		// str�� �������� obj2�� �������� ����ȯ�Ͽ� �־��� -> Ŭ���� �̸�@�ؽ� �ڵ尪 Ŭ���� �̸� ����
		// �׷��� str�� ����Ű�� ���� obj�� ���������� �־���
		// �׷��� str�� StringŸ������ fruit�� �ؽð��� ���� �� ����.
		// �׷��� substr �ϸ� ��
		
		//----------------------------------------
		
		
		
		System.out.println("----------------");
	}
}
		
		
		
//		System.out.println();
//		for(int i = 0 ; i < v.size(); i++)
//			System.out.println(v.get(i));	//get�� ��ü�� ������.
//		
//		for (int i = 0; i < 99; i++) {
//			v.add("^3^");
//		}
//		System.out.println("V : " + v);
//		System.out.println(v.capacity()); // 20
//		System.out.println(v.size());

/*
 * Vector() Vector(Collection<? extends E> c) Vector(int initialCapacity)
 * Vector(int initialCapacity, int capacityIncrement)
 */