package day11_javaMemPrac;

public class Study1gc {
	public static void main(String[] args) {
		String url = "https://";
		url += "nosshome.co.kr:4489";
		System.out.println(url);
	}
}

// s		 |		 h
// url            #a  (String) https://

//                #c  (String) https://nosshome.co.kr:4489



// url�� #a�� ���ٰ�

// url�� #c�� ���� �Ǹ� #a�� ������ �� �������Ƿ� 
// (Unreachable Object�� ��), (stack���� ������ �� ���� Heap������ ��ü)

// Mark and Sweep �����̶�� ��.
// Marking : JVM�� G.C�� stack�� ��� ������ ��ĵ�ϸ鼭 ���� � Object�� reference�ϰ� �ִ��� ã�� ����
// ù �ܰ��� marking �۾��� ���� ��� �����尡 �ߴܵǴµ� �̸� stop the world
// (���� ���� System.gc()�� ȣ���ϸ� �ȵǴ� ������.

// Sweeping : �׷��� ���� mark�Ǿ����� ���� ��� Object���� ������ �����ϴ� ������ sweep

// ���� : garbage�� �ƴ� ���� mark�ϰ� �� ���� ��� ���� ����� ��.