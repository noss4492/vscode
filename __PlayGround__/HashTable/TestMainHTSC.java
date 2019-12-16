package __PlayGround__.HashTable;

import java.util.LinkedList;


//내부 노드에 담길 값은 key-value


public class TestMainHTSC { // SeparateChaining으로 구현함.
	// make hashtable
	public static void main(String[] args) {
		// make init hash table
		HashTableSC h1 = new HashTableSC(3);
		h1.put("key1", "일번일번밸류\t");
		h1.put("key2", "이번밸류임다\t");
		h1.put("key3", "삼번밸류에용애용\t");
		h1.put("key4", "네번째값이에오\t");
		h1.put("key5", "다섯번째값이로다\t");
		h1.put("key6", "육육육번째값이임임\t");
		//
		h1.put("key1", "일번일번밸류\t");
		h1.put("key2", "이번밸류임다\t");
		h1.put("key3", "삼번밸류에용애용\t");
		h1.put("key4", "네번째값이에오\t");
		h1.put("key5", "다섯번째값이로다\t");
		h1.put("key6", "육육육번째값이임임\t");
		//
		
		System.out.println(h1.get("key1")+"[hash:"+h1.getHashCode1("key1")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key1"))+"]");
		System.out.println(h1.get("key2")+"[hash:"+h1.getHashCode1("key2")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key2"))+"]");
		System.out.println(h1.get("key3")+"[hash:"+h1.getHashCode1("key3")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key3"))+"]");
		System.out.println(h1.get("key4")+"[hash:"+h1.getHashCode1("key4")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key4"))+"]");
		System.out.println(h1.get("key5")+"[hash:"+h1.getHashCode1("key5")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key5"))+"]");
		System.out.println(h1.get("key6")+"[hash:"+h1.getHashCode1("key6")+"][ArrIdx:"+h1.getIndex(h1.getHashCode1("key6"))+"]");
                                                                                                                             

	}
}

// hash함수 작성

// 인덱스 설정하는 방법

// 같은키, 같은해쉬값 중복시 처리는 어떻게할지

// putter
