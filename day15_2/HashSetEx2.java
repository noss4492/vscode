package day15_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
// �ؽ��� ����غ���. ex)�ζ�

// ����. �ߺ��� ����,

// 1. int 6ĭ¥�� �迭 m ����
// 2. HashSet ��ü ����
// 3. �����ϰ� 1���� 45������ �� �̱�
// 4. HashSet�� ���
// 5. HashSet�� ��� ������ 6����� �ߴ�
// 6. �ƴϸ� 3������ ���ư���
// 7. HashSet���� 1���� ���� ���� �迭�� ���
// 8. �����ϱ�
// 9. �迭 ��Ҹ� 1���� ���� ȭ�鿡 ���
public class HashSetEx2 {
	public static void main(String[] args) {
		int[] m = new int[6];
		
		HashSet hs1 = new HashSet();
		Random rnd = new Random();
		
		while(hs1.size() < 6) {	
			int r = rnd.nextInt(45)+1;
			hs1.add(r);
		}
		
		int cnt = 0;
		Iterator it = hs1.iterator();
//		Iterator it = new Iterator(); << X �������̽��� ���� �ȵǴµ�
//		HashSet hs1�� Iterator()�޼����� �������� �θ� �������̽��� it�� ���������� �Ѱ��� ��.
		
		while(it.hasNext())				// ���� �ϳ��� �� ������ �� ��
			m[cnt++] = (int) it.next();	// �ϳ��� ������ ����. return Object
		// Object obj = it.next();
		// m[0] = (int)obj;
		// �׳� for������ ���� ������ ��������
		
		Arrays.sort(m);
		
		for(int x : m)
			System.out.println(x);
	}
}


// ������ ���� �ζǿ��� 6�� �޾� ���°͵� ���� ����ε� ' 3';;

//		���� ����ε�
//		Lotto lt = new Lotto();
//		int[] k = it.get();
		
		
//		while(it.hasNext())
//			System.out.println("|"+it.next());
		
		
//		while(cnt < 6)
//			m[cnt++] = (int) it.next();
		
		
//		while(true){
//			if(hs1.size() == 6)
//				break;
//		}
		
		
		
		
		
