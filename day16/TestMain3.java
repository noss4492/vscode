package day16;

import java.util.ArrayList;
import java.util.Iterator;

public class TestMain3 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("����");
		list.add("�ٳ���");
		list.add("����");
		list.add("����");
		list.add("����");
		Integer a = 20;	// ����ښ� ' 3'...
//		list.add(a);
		list.add("����");
		list.add("����");
		list.add("����");
		list.add("����");
		// ������Ʈ Ÿ���� add�ؼ� ������
		// ����Ҷ��� ������.
		// ����� �� str = (String)obj << �̶� obj�� INTEGER��
		// str�� string�̴ϱ� integer�� ����������. ������ ���� �Ұ�����.
		// java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

		// className@hashcode�� ���еǱ� ������ �׷�����.�ؽ��ڵ�� �� �𸣰����� �ؽ��Լ�(������)
		// �ѹ� �׸� �׷����� ' 3'(����ֱ�, 20 �ֱ� -> ���� ���� 20 ����)
		
		// ��Ÿ�Ӽ� ���� -> ���� �߱�
		
		// ArrayList�� String �������� �ϸ� ��½� ���������� �ϰ���
		// �����Ϸ����� ������ ����ֱ� �ϰ���
		// �ٵ� �ڷ��� �ϳ��� �Ǵ°� �� �����ϰڴµ�?
		// ������ ������ �ڷ������� ��������
		
		// �ϳ��� ������ ���
		Iterator it1 = list.iterator();
		while(it1.hasNext())
			System.out.println(it1.next());
		
		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
			
			System.out.println("------------");
//			Object obj = list.get(i);
//			String str = (String)obj;
			String str = list.get(i);			// ������ ������ ������ ��. ' 3';;
			System.out.println(str.substring(0, 1));
			
			
			System.out.println(list.get(i).toString().substring(0, 1));
			System.out.println("------------");
		}
		
		//iteratable ?
//		for(ArrayList list : )
		
	}
}
