package __PlayGround__.HashTable;

import java.util.LinkedList;


//���� ��忡 ��� ���� key-value


public class TestMainHTSC { // SeparateChaining���� ������.
	// make hashtable
	public static void main(String[] args) {
		// make init hash table
		HashTableSC h1 = new HashTableSC(3);
		h1.put("key1", "�Ϲ��Ϲ����\t");
		h1.put("key2", "�̹�����Ӵ�\t");
		h1.put("key3", "����������ֿ�\t");
		h1.put("key4", "�׹�°���̿���\t");
		h1.put("key5", "�ټ���°���̷δ�\t");
		h1.put("key6", "��������°��������\t");
		//
		h1.put("key1", "�Ϲ��Ϲ����\t");
		h1.put("key2", "�̹�����Ӵ�\t");
		h1.put("key3", "����������ֿ�\t");
		h1.put("key4", "�׹�°���̿���\t");
		h1.put("key5", "�ټ���°���̷δ�\t");
		h1.put("key6", "��������°��������\t");
		//
		
		System.out.println(h1.get("key1")+"[hash:"+h1.getHashCode1("key1")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key1"))+"]");
		System.out.println(h1.get("key2")+"[hash:"+h1.getHashCode1("key2")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key2"))+"]");
		System.out.println(h1.get("key3")+"[hash:"+h1.getHashCode1("key3")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key3"))+"]");
		System.out.println(h1.get("key4")+"[hash:"+h1.getHashCode1("key4")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key4"))+"]");
		System.out.println(h1.get("key5")+"[hash:"+h1.getHashCode1("key5")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key5"))+"]");
		System.out.println(h1.get("key6")+"[hash:"+h1.getHashCode1("key6")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key6"))+"]");
                                                                                                                             

	}
}

// hash�Լ� �ۼ�

// �ε��� �����ϴ� ���

// ����Ű, �����ؽ��� �ߺ��� ó���� �������

// putter
