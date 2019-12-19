package __PlayGround__2;

import java.util.LinkedList;

public class HashTableSC {
	// 연결되는 구조가 각 idx배열마다 linkedlist로 chaining되어 있어야함
//	LinkedList<Node>[] data = null;
	LinkedList<Node>[] data;

	HashTableSC(int size) {
//		this.data = new LinkedList<?>[size];
		this.data = new LinkedList[size];
		// <>를 정해줄 수가 없는데? ㅠ.ㅠ.ㅠ.ㅠ.ㅠ.ㅠ.ㅠ.
	}

	// 그냥 문자열의 합으로(hash 중복 가능성 높아서 비추함)
	public int getHashCode1(String key) {
		int hashcode = 0;
		char[] tmpc = key.toCharArray();

		for (int x : tmpc) {
			hashcode += x;
		}
		return hashcode;
	}

	// horner's Method
	public int getHashCode2(String value) {
		int hashcode = 0;
		char[] tmpv = value.toCharArray();

		// ∑ 31*x[i]^(n-1)
		for (int i = 0; i < tmpv.length; i++) {
			hashcode += 31 * hashcode + tmpv[i];
			// hashcode += (hashcode << 5) - hashcode + tmpv[i];
		}
		return hashcode;
	}

	// 해쉬코드 값을 구한 뒤 이 값을 모듈러 해서 배치한다.
	// 이건 좀 맘에 안드는걸?... 다음에 오픈어드레싱으로 바꿀것임.
	public int getIndex(int hashcode) {
		return hashcode % data.length;
	}

	// [보완할 것] 서치 키 좀 헷갈림.
	public Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;
		for (Node x : list) { // 리스트들을 탐색하고
			if (x.key.equals(key)) { // 해당 키에 해당하는 노드를 반환한다.
				return x;
			}
		}
		return null; // 만약 저 for문에서 리턴되지 못하면 이 구문으로 오게됨.
		// 구조가 그렇게 이쁘진 않은듯. 나중에 변경할 수 있는지 생각해볼 것.
	}

	public void put(String key, String value) {
		// dict에 key-value를 입력하면 그에 따른 해쉬코드와 인덱스를 부여해야함.
		int hashcode = getHashCode1(key);
		int index = getIndex(hashcode);
		// int hashcode = getHashcode2(value); //이게 더 좋지만 일단 테스트를 위해 주석

		LinkedList<Node> list = data[index];

		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}

		Node selectedNode = searchKey(list, key);

		if (selectedNode == null) { // 검색해서 해당 키에 대응되는 노드가 선택되지 않았다면
			list.addLast(new Node(key, value)); // 지금 키와 벨류를 그냥 추가~
		} else {
			selectedNode.setValue(value); // 만약에 몬가 있다면 키는 유지하고 밸류만 교체
			System.out.println("키가 중복이어서 밸류를 교체함.");
		}
	}

	public String get(String key) { // 키로 밸류값을 찾아 오는 메서드
		int hashcode = getHashCode1(key);
		int index = getIndex(hashcode);

		LinkedList<Node> list = data[index];
		Node selectedNode = searchKey(list, key);

		if (selectedNode == null) {
			return null;
		} else {
			return selectedNode.getValue();
		}
	}
}