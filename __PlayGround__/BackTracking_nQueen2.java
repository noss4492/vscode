package __PlayGround__;

public class BackTracking_nQueen2 {
	// 각 행에 하나의 퀸만 존재한다는 조건을 걸었을 때
	// flag로 각 행에 퀸이 존재하는지를 체크 (0~7행)
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
//		System.out.println("재귀문 호출됨");
		for (int j = 0; j < 4; j++) {
			System.out.print("j : " + j + " flag :");
			for (int i = 0; i < 4; i++) {
				System.out.printf("%2d", flag[i] == true ? 1 : 0);
			}
			System.out.println();

			if (flag[j] == false) { // j행에 퀸이 없다면
				pos[x] = j; // j행에 배치
				if (x == 3) // 모든 열에 배치했을 때 출력
					print();
				else { // 배치하고 flag on
					flag[j] = true;
					System.out.println("set(" + (x + 1) + ")");
					set(x + 1);
//					System.out.println("flag["+j+"]:"+flag[j]+"되돌아왔다!!");
					flag[j] = false; // 재귀 후 다시 돌아오는 부분으로 추적 머리아픔
					System.out.println("flag[" + j + "]:" + flag[j] + "flag off");
				}
			}
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
