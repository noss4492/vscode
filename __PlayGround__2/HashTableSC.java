package __PlayGround__2;

import java.util.LinkedList;

public class HashTableSC {
	// ����Ǵ� ������ �� idx�迭���� linkedlist�� chaining�Ǿ� �־����
//	LinkedList<Node>[] data = null;
	LinkedList<Node>[] data;

	HashTableSC(int size) {
//		this.data = new LinkedList<?>[size];
		this.data = new LinkedList[size];
		// <>�� ������ ���� ���µ�? ��.��.��.��.��.��.��.
	}

	// �׳� ���ڿ��� ������(hash �ߺ� ���ɼ� ���Ƽ� ������)
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

		// �� 31*x[i]^(n-1)
		for (int i = 0; i < tmpv.length; i++) {
			hashcode += 31 * hashcode + tmpv[i];
			// hashcode += (hashcode << 5) - hashcode + tmpv[i];
		}
		return hashcode;
	}

	// �ؽ��ڵ� ���� ���� �� �� ���� ��ⷯ �ؼ� ��ġ�Ѵ�.
	// �̰� �� ���� �ȵ�°�?... ������ ���¾�巹������ �ٲܰ���.
	public int getIndex(int hashcode) {
		return hashcode % data.length;
	}

	// [������ ��] ��ġ Ű �� �򰥸�.
	public Node searchKey(LinkedList<Node> list, String key) {
		if (list == null)
			return null;
		for (Node x : list) { // ����Ʈ���� Ž���ϰ�
			if (x.key.equals(key)) { // �ش� Ű�� �ش��ϴ� ��带 ��ȯ�Ѵ�.
				return x;
			}
		}
		return null; // ���� �� for������ ���ϵ��� ���ϸ� �� �������� ���Ե�.
		// ������ �׷��� �̻��� ������. ���߿� ������ �� �ִ��� �����غ� ��.
	}

	public void put(String key, String value) {
		// dict�� key-value�� �Է��ϸ� �׿� ���� �ؽ��ڵ�� �ε����� �ο��ؾ���.
		int hashcode = getHashCode1(key);
		int index = getIndex(hashcode);
		// int hashcode = getHashcode2(value); //�̰� �� ������ �ϴ� �׽�Ʈ�� ���� �ּ�

		LinkedList<Node> list = data[index];

		if (list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}

		Node selectedNode = searchKey(list, key);

		if (selectedNode == null) { // �˻��ؼ� �ش� Ű�� �����Ǵ� ��尡 ���õ��� �ʾҴٸ�
			list.addLast(new Node(key, value)); // ���� Ű�� ������ �׳� �߰�~
		} else {
			selectedNode.setValue(value); // ���࿡ �� �ִٸ� Ű�� �����ϰ� ����� ��ü
			System.out.println("Ű�� �ߺ��̾ ����� ��ü��.");
		}
	}

	public String get(String key) { // Ű�� ������� ã�� ���� �޼���
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