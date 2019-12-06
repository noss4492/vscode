package __PlayGround__;

public class BackTracking_nQueen2 {
	// �� �࿡ �ϳ��� ���� �����Ѵٴ� ������ �ɾ��� ��
	// flag�� �� �࿡ ���� �����ϴ����� üũ (0~7��)
	static boolean[] flag = new boolean[4];
	static int[] pos = new int[4];

	static void print() {
		System.out.print("pos : ");
		for (int i = 0; i < 4; i++) {
			System.out.printf("%2d", pos[i]);
		}
		System.out.println();

	}

	static void set(int x) {
//		System.out.println("��͹� ȣ���");
		for (int j = 0; j < 4; j++) {
			System.out.print("j : " + j + " flag :");
			for (int i = 0; i < 4; i++) {
				System.out.printf("%2d", flag[i] == true ? 1 : 0);
			}
			System.out.println();

			if (flag[j] == false) { // j�࿡ ���� ���ٸ�
				pos[x] = j; // j�࿡ ��ġ
				if (x == 3) // ��� ���� ��ġ���� �� ���
					print();
				else { // ��ġ�ϰ� flag on
					flag[j] = true;
					System.out.println("set(" + (x + 1) + ")");
					set(x + 1);
//					System.out.println("flag["+j+"]:"+flag[j]+"�ǵ��ƿԴ�!!");
					flag[j] = false; // ��� �� �ٽ� ���ƿ��� �κ����� ���� �Ӹ�����
					System.out.println("flag[" + j + "]:" + flag[j] + "flag off");
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
