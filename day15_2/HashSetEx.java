package day15_2;
import java.util.HashSet;
import java.util.Iterator;

// SET Interface...


public class HashSetEx {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("����");
		hs.add("�ٳ���");
		hs.add("�C��");
		hs.add("���ľ�");
		hs.add("���ľ�");
		hs.add("���ľ�");
		hs.add("���ľ�");
		System.out.println("hs : "+hs);
		// hs.get(0); ���� ����ȵ�
		
		Iterator<String> it = hs.iterator();
		
		while(it.hasNext()) {// ������ ���� �̰ɷ� �ؾߵ�. 
			System.out.println(it.next());
		}
		
//		boolean data = it.hasNext();
//		if(data)
//			System.out.println("������ ����");
//		else
//			System.out.println("������ ����");
		
		
		
		
		
	}

}
