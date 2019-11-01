package day15_2;

import java.util.Stack;

public class StackEx {
	public static void main(String[] args) {
		Stack<String> s = new Stack();
		// Vector의 자식임. add, get 사용할 수 있음.
		// Class AbstractList 참조하여 공통부분 많음
		s.push("칼국수");
		s.push("떡볶이");
		s.push("△김밥");
		s.push("도시락");
		
		System.out.println(s);
		int ss = s.size();
		for(int i = 0; i < ss; i++) {
			System.out.println(s.pop());
		}
	}
}
