package day15_2;

import java.util.Stack;

public class StackEx {
	public static void main(String[] args) {
		Stack<String> s = new Stack();
		// Vector�� �ڽ���. add, get ����� �� ����.
		// Class AbstractList �����Ͽ� ����κ� ����
		s.push("Į����");
		s.push("������");
		s.push("����");
		s.push("���ö�");
		
		System.out.println(s);
		int ss = s.size();
		for(int i = 0; i < ss; i++) {
			System.out.println(s.pop());
		}
	}
}
