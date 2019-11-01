package day16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapEx {
	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("����", "������?");
		hm.put("��Ű����", "������");
		hm.put("����1ȣ", "���ʹ�");
		hm.put("�����ֶ�", "����");
		
		System.out.println(hm);
		System.out.println(hm.toString().hashCode());
		System.out.println("---------------------");
		
		Object obj = hm.get("����");
		System.out.println(obj);
		System.out.println("---------------------");
		
		boolean no1 = hm.containsKey("����1ȣ");
		boolean no2 = hm.containsKey("����2ȣ");
		
		System.out.println(no1);
		System.out.println(no2);
		System.out.println("---------------------");
		
		// Key�� ���
		Set set = hm.keySet();
		//keySet()�� ���� Ÿ���� Set<K>�� Set �������̽��� ��ü s�� �޾ƾ���
		
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Object obj1 = it.next();
			System.out.println(it.next());
			System.out.println("key : "+obj1+" value : "+hm.get(obj1));
		}
		System.out.println("---------------------");
		
		System.out.println("--------remove-------");
		hm.remove("��Ű����");
		hm.remove("�����ֶ�");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		// json�� Ÿ���� ������ ���� �� �ؽ����� �̿��ؼ� ����
		
	}
}
