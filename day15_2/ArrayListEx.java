package day15_2;

import java.util.ArrayList;

public class ArrayListEx {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		// Note that this implementation is not synchronized.
		// �񵿱�ȭ���
		// ���ʹ� ����ȭ ���
		// ������ ���Ŀ� ����Ѵٰ���
		
		// ��̸���Ʈ�� ���ͺ��� ����.
		
		// list �������̽� : ���� ����, �ߺ� ���
		// Vector Stack ArrayList
		
		list.add("����");
		list.add("���ڳ�");
		list.add("�޷ΰ��");
		list.add("���");
		list.add("����");
		list.add("���");

		if(list.contains("���"))
			System.out.println("��� ����");
		
		ArrayList<String> list2 = (ArrayList<String>) list.clone();
		for(int i = 0; i < 6; i++) {
			System.out.println(list.get(i));
			System.out.println("clone : "+list2.get(i));
		}
		
		boolean isOK = list.contains("����");
		System.out.println(isOK);
		
		list2.addAll(list);
		int l2Size = list2.size();
		for(int i = 0; i < l2Size; i++) {
			System.out.println("��ü:"+list2.get(i));
		}
		
	}
}
